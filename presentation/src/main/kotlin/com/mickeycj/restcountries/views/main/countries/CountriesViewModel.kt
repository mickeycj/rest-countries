package com.mickeycj.restcountries.views.main.countries

import io.reactivex.Scheduler

import androidx.lifecycle.MutableLiveData

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.usecases.GetCountriesUseCase

import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.base.ViewModel
import com.mickeycj.restcountries.common.states.CountriesState

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

    init {
        loadingState.value = false
        countriesState.value = CountriesState()
    }

    fun loadCountries() {
        getCountriesUseCase.execute()
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(
                { country ->
                    run {
                        loadingState.value = true
                        countriesState.value = countriesStateMapper.toState(country)
                    }
                },
                Throwable::printStackTrace
            )
            .dispose()
    }
}
