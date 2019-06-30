package com.mickeycj.restcountries.di

import org.koin.android.viewmodel.dsl.viewModel

import com.mickeycj.domain.models.Country

import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.mappers.CountriesStateMapper
import com.mickeycj.restcountries.common.mappers.CountryDetailsStateMapper
import com.mickeycj.restcountries.common.states.CountriesState
import com.mickeycj.restcountries.common.states.CountryDetailsState
import com.mickeycj.restcountries.views.main.countries.CountriesViewModel
import com.mickeycj.restcountries.views.main.countrydetails.CountryDetailsViewModel
import com.mickeycj.restcountries.views.splash.SplashViewModel

/**
 * Presentation dependencies provider.
 */
object Presentation {

    val module = org.koin.dsl.module {
        single<StateMapper<List<Country>, CountriesState>> { CountriesStateMapper() }
        single<StateMapper<Country, CountryDetailsState>> { CountryDetailsStateMapper() }

        viewModel {
            SplashViewModel(get(Schedulers.IoThread), get(Schedulers.MainThread))
        }
        viewModel {
            CountriesViewModel(get(), get(), get(Schedulers.IoThread), get(Schedulers.MainThread))
        }
        viewModel {
            CountryDetailsViewModel(get(), get(), get(Schedulers.IoThread), get(Schedulers.MainThread))
        }
    }
}
