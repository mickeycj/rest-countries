package com.mickeycj.domain.contracts

/**
 * Mapper interface for converting arbitrary objects to/from domain models.
 */
interface Mapper<O, M> {

    fun toModel(from: O): M

    fun fromModel(from: M): O
}
