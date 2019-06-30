package com.mickeycj.restcountries.common.base

/**
 * State mapper interface for converting domain models to states.
 */
interface StateMapper<M, S> {

    fun toState(from: M): S
}
