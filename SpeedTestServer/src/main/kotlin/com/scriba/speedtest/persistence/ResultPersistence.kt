package com.scriba.speedtest.persistence

import com.scriba.speedtest.domain.TestResult

interface ResultPersistence {
    fun saveTestResult(testResult: TestResult)
    fun getAllTestResults(): List<TestResult>
}