package com.mickeycj.restcountries.main.countries

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

import io.mockk.every
import io.mockk.mockk

import org.assertj.core.api.Assertions.assertThat

import io.reactivex.Scheduler

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.usecases.GetCountriesUseCase

import com.mickeycj.restcountries.MockData
import com.mickeycj.restcountries.RxImmediateSchedulerRule
import com.mickeycj.restcountries.common.StateMapper
import com.mickeycj.restcountries.di.Schedulers
import com.mickeycj.restcountries.states.CountriesState

/**
 * Spec for Countries View Model.
 */
class CountriesViewModelSpec : KoinTest {

    companion object {

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            startKoin {
                modules(listOf(
                    Schedulers.module,
                    module {
                        single { mockk<GetCountriesUseCase>() }
                        single { mockk<StateMapper<List<Country>, CountriesState>>() }
                    }
                ))
            }
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            stopKoin()
        }

        fun CountriesState.isEmpty(): Boolean = regions.isEmpty()
    }

    @Rule
    @JvmField
    val liveDateRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val testSchedulerRule = RxImmediateSchedulerRule()

    private val mockCountriesFromUseCase = MockData.countriesFromUseCase
    private val mockCountries = MockData.countries
    private val mockCountriesState = MockData.countriesState

    private lateinit var countriesViewModel: CountriesViewModel

    @Before
    fun before() {
        val getCountriesUseCase by inject<GetCountriesUseCase>()
        val countriesStateMapper by inject<StateMapper<List<Country>, CountriesState>>()
        val subscribeOnScheduler by inject<Scheduler>(Schedulers.IoThread)
        val observeOnScheduler by inject<Scheduler>(Schedulers.MainThread)

        every { getCountriesUseCase.execute() } returns mockCountriesFromUseCase
        every { countriesStateMapper.toState(mockCountries) } returns mockCountriesState

        countriesViewModel = CountriesViewModel(
            getCountriesUseCase,
            countriesStateMapper,
            subscribeOnScheduler,
            observeOnScheduler
        )
    }

    @Test
    fun `Countries View Model should return false as its initial loading state`() {
        val loadingState = countriesViewModel.loadingState.value

        assertThat(loadingState).isNotNull()
        assertThat(loadingState).isFalse()
    }

    @Test
    fun `Countries View Model should return an empty list as its initial countries state`() {
        val countriesState = countriesViewModel.countriesState.value

        assertThat(countriesState).isNotNull()
        assertThat(countriesState?.isEmpty()).isTrue()
    }

    @Test
    fun `Countries View Model should update the loading state to true after being called`() {
        countriesViewModel.loadCountries()
        val loadingState = countriesViewModel.loadingState.value

        assertThat(loadingState).isNotNull()
        assertThat(loadingState).isTrue()
    }

    @Test
    fun `Countries View Model should update the countries state according to the data after being called`() {
        countriesViewModel.loadCountries()
        val countriesState = countriesViewModel.countriesState.value

        assertThat(countriesState).isNotNull()
        assertThat(countriesState).isEqualTo(mockCountriesState)
    }
}
