package com.scriba.speedtest.domain

import java.time.LocalDateTime

data class TestResult (
    val startTime: LocalDateTime,
    val finishTime: LocalDateTime,
    val networkName: String,
    val networkType: NetworkType,
    val upSpeed: Double,
    val downSpeed: Double,
    val ping: Int,
    val testFrequency: TestFrequency,
) {
    companion object {
        val default: TestResult
            get () { return TestResult(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "DEFAULT",
                NetworkType.Unknown,
                0.0,
                0.0,
                0,
                TestFrequency.Daily
            )}
    }
}
