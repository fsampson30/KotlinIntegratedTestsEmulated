package com.sampson.kotlinintegratedtestsemulated

import android.content.Context
import com.nhaarman.mockitokotlin2.*
import junit.framework.TestCase

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.math.BigInteger

@RunWith(MockitoJUnitRunner::class)
class TextFormatterTest {
    @InjectMocks
    lateinit var textFormatter : TextFormatter
    @Mock
    lateinit var numberAdder: NumberAdder
    @Mock
    lateinit var context: Context
    @Test
    fun getSumResult_success(){
        val n = 10
        val sumResult = BigInteger.TEN
        val expected = "expected"
        whenever(numberAdder.sum(eq(n), any())).thenAnswer {
            (it.arguments[1] as (BigInteger) -> Unit).invoke(sumResult)
        }
        whenever(context.getString(R.string.result,n,sumResult.toString())).thenReturn(expected)
        val callback = mock<(String) -> Unit>()
        textFormatter.getSumResult(n,callback)
        verify(callback).invoke(expected)
    }

}