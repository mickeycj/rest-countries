package com.mickeycj.restcountries.views.main.countrydetails

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

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import org.assertj.core.api.Assertions.assertThat

import io.reactivex.Scheduler

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.usecases.GetCountryDetailsUseCase

import com.mickeycj.restcountries.MockData
import com.mickeycj.restcountries.RxImmediateSchedulerRule
import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.states.CountryDetailsState
import com.mickeycj.restcountries.di.Schedulers

/**
 * Spec for Country Details View Model.
 */
class CountryDetailsViewModelSpec : KoinTest {

    companion object {

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            startKoin {
                modules(listOf(
                    Schedulers.module,
                    module {
                        single { mockk<GetCountryDetailsUseCase>() }
                        single { mockk<StateMapper<Country, CountryDetailsState>>() }
                    }
                ))
            }
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            stopKoin()
        }

        val emptyCountryDetailsState = CountryDetailsState()
    }

    @Rule
    @JvmField
    val liveDataRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val testSchedulerRule = RxImmediateSchedulerRule()

    private val code = "USA"

    private val mockCountryDetailsFromUseCase = MockData.countryDetailsFromUseCase
    private val mockCountryDetails = MockData.countryDetails
    private val mockCountryDetailsState = MockData.countryDetailsState

    private val getCountryDetailsUseCase by inject<GetCountryDetailsUseCase>()
    private val countryDetailsStateMapper by inject<StateMapper<Country, CountryDetailsState>>()
    private val subscribeOnScheduler by inject<Scheduler>(Schedulers.IoThread)
    private val observeOnScheduler by inject<Scheduler>(Schedulers.MainThread)

    private lateinit var countryDetailsViewModel: CountryDetailsViewModel

    @Before
    fun before() {
        clearMocks(getCountryDetailsUseCase, countryDetailsStateMapper)

        every { getCountryDetailsUseCase.execute(code) } returns mockCountryDetailsFromUseCase
        every { countryDetailsStateMapper.toState(mockCountryDetails) } returns mockCountryDetailsState

        countryDetailsViewModel = CountryDetailsViewModel(
            getCountryDetailsUseCase,
            countryDetailsStateMapper,
            subscribeOnScheduler,
            observeOnScheduler
        )
    }

    @Test
    fun `Country Details View Model should return false as its initial loading state`() {
        val loadingState = countryDetailsViewModel.loadingState.value

        assertThat(loadingState).isNotNull()
        assertThat(loadingState).isFalse()
    }

    @Test
    fun `Country Details View Model should return an empty details as its initial country details state`() {
        val countryDetailsState = countryDetailsViewModel.countryDetailsState.value

        assertThat(countryDetailsState).isNotNull()
        assertThat(countryDetailsState).isEqualTo(emptyCountryDetailsState)
    }

    @Test
    fun `Country Details View Model should update the loading state to true after being called`() {
        countryDetailsViewModel.loadCountryDetails(code)
        val loadingState = countryDetailsViewModel.loadingState.value

        assertThat(loadingState).isNotNull()
        assertThat(loadingState).isTrue()
    }

    @Test
    fun `Country Details View Model should update the country details state according to the data after being called`() {
        countryDetailsViewModel.loadCountryDetails(code)
        val countryDetailsState = countryDetailsViewModel.countryDetailsState.value

        verify(exactly = 1) { getCountryDetailsUseCase.execute(code) }
        verify(exactly = 1) { countryDetailsStateMapper.toState(mockCountryDetails) }

        assertThat(countryDetailsState).isNotNull()
        assertThat(countryDetailsState).isEqualTo(mockCountryDetailsState)
    }
}
