package com.gmail.dlykoits.racelogger.tools

import java.util.*


object UnitLocale {
    val IMP_UNIT_COUNTIRES = setOf("US", "LR", "MM")
    val Imperial = UnitLocale
    val Metric = UnitLocale

    val default: UnitLocale
        get() = getFrom(Locale.getDefault())

    fun getFrom(locale: Locale): UnitLocale {
        val countryCode = locale.country
        return if(IMP_UNIT_COUNTIRES.contains(countryCode)) Imperial else Metric
    }
}