package com.mickeycj.restcountries.views.splash

import io.reactivex.Completable
import io.reactivex.Scheduler

import com.mickeycj.restcountries.common.base.ViewModel

import java.util.concurrent.TimeUnit

/**
 * View Model for Splash screen.
 */
class SplashViewModel(
    subscribeOnScheduler: Scheduler,
    observeOnScheduler: Scheduler
) : ViewModel(subscribeOnScheduler, observeOnScheduler) {

    init {
        loadingState.value = false
    }

    fun delaySplash() {
        Completable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(
                { loadingState.value = true },
                Throwable::printStackTrace
            )
            .dispose()
    }
}
