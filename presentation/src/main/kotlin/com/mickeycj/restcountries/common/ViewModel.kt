package com.mickeycj.restcountries.common

import io.reactivex.Scheduler

import androidx.lifecycle.MutableLiveData

/**
 * Base View Model for REST Countries application.
 */
abstract class ViewModel(
    protected val subscribeOnScheduler: Scheduler,
    protected val observeOnScheduler: Scheduler
) : androidx.lifecycle.ViewModel() {

    val loadingState = MutableLiveData<Boolean>()
}
