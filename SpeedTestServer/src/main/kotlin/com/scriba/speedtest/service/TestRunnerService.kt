package com.scriba.speedtest.service

import com.scriba.speedtest.domain.TestFrequency
import com.scriba.speedtest.domain.TestResult
import org.slf4j.LoggerFactory

class TestRunnerService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        logger.info("TestRunnerService Started")
    }

    fun runTest(testFrequency: TestFrequency): TestResult {
        return TestResult.default
    }
}