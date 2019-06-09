package com.mickeycj.domain.contracts

/**
 * Mapper interface for converting arbitrary objects to domain models.
 */
interface Mapper<O, M> {

    fun toModel(from: O): M
}
