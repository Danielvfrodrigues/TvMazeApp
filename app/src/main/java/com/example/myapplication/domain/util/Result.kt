package com.example.myapplication.domain.util

internal sealed class Result<out A> {

    internal data class Success<A>(
        val value: A
    ) : Result<A>()

    internal data class Failure(
        val throwable: Throwable? = null
    ) : Result<Nothing>()
}
