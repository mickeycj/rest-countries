package com.mickeycj.restcountries.main.countrydetails

import io.reactivex.Scheduler

import androidx.lifecycle.MutableLiveData

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.usecases.GetCountryDetailsUseCase

import com.mickeycj.restcountries.common.StateMapper
import com.mickeycj.restcountries.common.ViewModel
import com.mickeycj.restcountries.states.CountryDetailsState

/**
 * View Model for Country Details screen.
 */
class CountryDetailsViewModel(
    private val getCountryDetailsUseCase: GetCountryDetailsUseCase,
    private val countryDetailsStateMapper: StateMapper<Country, CountryDetailsState>,
    subscribeOnScheduler: Scheduler,
    observeOnScheduler: Scheduler
) : ViewModel(subscribeOnScheduler, observeOnScheduler) {

    val countryDetailsState = MutableLiveData<CountryDetailsState>()

    fun loadCountryDetails(code: String): Unit = TODO()
}
