package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val amount: Double = 10.0
        val tipPercent: Double = 20.0
        val roundUp: Boolean = false

        val actualTip: String =  calculateTip(amount= amount, tipPercent =  tipPercent, roundUp = roundUp)

        assertEquals(expectedTip, actualTip)

    }


    fun calculateTip_Tests(
        amount: Double,
        tipPercent: Double,
        roundUp: Boolean,
        expectedTipNumber: Double,
        message: String = ""
    ){
        val expectedTip = NumberFormat.getCurrencyInstance().format(expectedTipNumber)

        val actualTip: String =  calculateTip(amount= amount, tipPercent =  tipPercent, roundUp = roundUp)

        assertEquals(message, expectedTip, actualTip)
    }

    @Test
    fun correTests__200_15()
    {
        calculateTip_Tests(200.0, 15.0, false, 30.0, "200/15")
    }

    @Test
    fun correTests__123_10(){
        calculateTip_Tests(123.0, 10.0, false, 12.3)
    }

    @Test
    fun correTests__123_10_up(){
        calculateTip_Tests(123.0, 10.0, true, 13.0)
    }


}