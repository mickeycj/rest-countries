package com.mickeycj.restcountries.main.countries

import io.reactivex.Scheduler

import androidx.lifecycle.MutableLiveData

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.usecases.GetCountriesUseCase

import com.mickeycj.restcountries.common.StateMapper
import com.mickeycj.restcountries.common.ViewModel
import com.mickeycj.restcountries.states.CountriesState

/**
 * View Model for Countries screen.
 */
class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val countriesStateMapper: StateMapper<List<Country>, CountriesState>,
    subscribeOnScheduler: Scheduler,
    observeOnScheduler: Scheduler
) : ViewModel(subscribeOnScheduler, observeOnScheduler) {

    val countriesState = MutableLiveData<CountriesState>()

    fun loadCountries(): Unit = TODO()
}
