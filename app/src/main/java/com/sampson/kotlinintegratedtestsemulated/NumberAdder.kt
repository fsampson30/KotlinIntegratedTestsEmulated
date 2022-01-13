package com.sampson.kotlinintegratedtestsemulated

import java.math.BigInteger
import kotlin.jvm.Throws

class NumberAdder {
    @Throws(InvalidNumberException::class)
    fun sum(n: Int, callback: (BigInteger) -> Unit) {
        if (n < 0) {
            throw InvalidNumberException
        }
        callback(n.toBigInteger().times((n.toLong()+1).toBigInteger()).divide(2.toBigInteger()))
    }
    object InvalidNumberException : Throwable()
}