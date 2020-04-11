package com.raudonikis.core.result

sealed class Result<out T, out Error> {

    inline fun onSuccess(f: (T) -> Unit) =
        when (this) {
            is Success -> {
                f(value)
                this
            }
            is Failure -> this
        }

    inline fun onError(f: (Error) -> Unit) =
        when (this) {
            is Success -> this
            is Failure -> {
                f(error)
                this
            }
        }
}

data class Success<T>(val value: T) : Result<T, Nothing>()
data class Failure<Error>(val error: Error) : Result<Nothing, Error>()
/*
fun <T> Result<T, *>.orElse(other: T) = if (this is Success) value else other
fun <C, T> Result<T, *>.map(f: (T) -> C) = if (this is Success) Success(f(value)) else this
fun <C, T> Result<T, *>.flatMap(f: (T) -> Result<C, *>) = if (this is Success) f(value) else this
fun <E, C> Result<*, E>.mapFailure(f: (E) -> C) = if (this is Failure) Failure(f(error)) else this

fun <T, E> Result<T, E>.orElse(f: (E) -> T) = when (this) {
    is Success -> value
    is Failure -> f(error)
}*/
