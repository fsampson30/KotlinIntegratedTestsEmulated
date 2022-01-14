package com.sampson.kotlinintegratedtestsemulated

import android.annotation.SuppressLint
import android.content.Context

class TextFormatter(
    private val numberAdder: NumberAdder,
    private val context: Context
) {
    @SuppressLint("StringFormatInvalid")
    fun getSumResult(n: Int, callback: (String) -> Unit) {
        try {
            numberAdder.sum(n) {
                callback(
                    context.getString(R.string.result, n, it.toString())
                )
            }
        } catch (e: NumberAdder.InvalidNumberException) {
            callback(context.getString(R.string.error))
        }
    }
}