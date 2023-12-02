package com.scriba.speedtest.service

import com.scriba.speedtest.domain.TestResult
import com.scriba.speedtest.persistence.ResultPersistence
import org.slf4j.LoggerFactory

class ResultService(private val persistence: ResultPersistence) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        logger.info("ResultService started with [${persistence::class.java}]")
    }

    fun newTestResult(testResult: TestResult) {
        logger.info("Received TestResult: ${testResult.networkName}")
        persistence.saveTestResult(testResult)
    }
}