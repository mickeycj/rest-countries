package com.mickeycj.restcountries.views.splash

import io.reactivex.Scheduler

import com.mickeycj.restcountries.common.base.ViewModel

/**
 * View Model for Splash screen.
 */
class SplashViewModel(
    subscribeOnScheduler: Scheduler,
    observeOnScheduler: Scheduler
) : ViewModel(subscribeOnScheduler, observeOnScheduler) {

    fun delaySplash(): Unit = TODO()
}
