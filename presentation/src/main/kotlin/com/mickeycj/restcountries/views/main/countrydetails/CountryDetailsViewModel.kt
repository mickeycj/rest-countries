package com.mickeycj.restcountries.views.main.countrydetails

import io.reactivex.Scheduler

import androidx.lifecycle.MutableLiveData

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.usecases.GetCountryDetailsUseCase

import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.base.ViewModel
import com.mickeycj.restcountries.common.states.CountryDetailsState

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

    init {
        loadingState.value = false
        countryDetailsState.value = CountryDetailsState()
    }

    fun loadCountryDetails(code: String) {
        getCountryDetailsUseCase.execute(code)
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(
                { countryDetails ->
                    run {
                        loadingState.value = true
                        countryDetailsState.value = countryDetailsStateMapper.toState(countryDetails)
                    }
                },
                Throwable::printStackTrace
            )
            .dispose()
    }
}
