package com.mickeycj.restcountries.di

import org.koin.core.qualifier.Qualifier

/**
 * Schedulers dependencies provider.
 */
object Schedulers {

    object IoThread : Qualifier
    object MainThread : Qualifier

    val module = org.koin.dsl.module {
        single(IoThread) { io.reactivex.schedulers.Schedulers.io() }
        single(MainThread) { io.reactivex.android.schedulers.AndroidSchedulers.mainThread() }
    }
}
