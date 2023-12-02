package com.scriba.speedtest.persistence

import com.scriba.speedtest.domain.TestResult

class InMemoryResultPersistence: ResultPersistence {
    private val resultStore: MutableList<TestResult> = mutableListOf()

    override fun saveTestResult(testResult: TestResult) {
        resultStore.add(testResult)
    }

    override fun getAllTestResults(): List<TestResult> {
        return resultStore
    }
}