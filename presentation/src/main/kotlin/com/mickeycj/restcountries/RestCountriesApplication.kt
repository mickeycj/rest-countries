package com.mickeycj.restcountries

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

import com.mickeycj.restcountries.di.Api
import com.mickeycj.restcountries.di.Data
import com.mickeycj.restcountries.di.Presentation
import com.mickeycj.restcountries.di.Schedulers

/**
 * REST Countries application.
 */
class RestCountriesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RestCountriesApplication)
            modules(listOf(
                Api.module,
                Data.module,
                Presentation.module,
                Schedulers.module
            ))
        }
    }
}
