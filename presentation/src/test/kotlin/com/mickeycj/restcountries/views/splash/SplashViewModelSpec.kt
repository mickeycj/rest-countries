package com.mickeycj.restcountries.views.splash

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

import io.reactivex.Scheduler

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.mickeycj.restcountries.RxImmediateSchedulerRule
import com.mickeycj.restcountries.di.Schedulers

/**
 * Spec for Splash View Model.
 */
class SplashViewModelSpec : KoinTest {

    companion object {

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            startKoin {
                modules(Schedulers.module)
            }
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            stopKoin()
        }
    }

    @Rule
    @JvmField
    val liveDataRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val testSchedulerRule = RxImmediateSchedulerRule()

    private lateinit var splashViewModel: SplashViewModel

    @Before
    fun before() {
        val subscribeOnScheduler by inject<Scheduler>(Schedulers.IoThread)
        val observeOnScheduler by inject<Scheduler>(Schedulers.MainThread)

        splashViewModel = SplashViewModel(subscribeOnScheduler, observeOnScheduler)
    }

    @Test
    fun `Splash View Model should return false as its initial loading state`() {
        val loadingState = splashViewModel.loadingState.value

        assertThat(loadingState).isNotNull()
        assertThat(loadingState).isFalse()
    }

    @Test
    fun `Splash View Model should update the loading state to true after being called`() {
        splashViewModel.delaySplash()
        val loadingState = splashViewModel.loadingState.value

        assertThat(loadingState).isNotNull()
        assertThat(loadingState).isTrue()
    }
}
