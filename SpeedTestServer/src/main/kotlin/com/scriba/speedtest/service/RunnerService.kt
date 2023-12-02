package com.scriba.speedtest.service

import com.scriba.speedtest.domain.SpeedTest
import com.scriba.speedtest.domain.TestSettings
import org.slf4j.LoggerFactory

class RunnerService(
    scheduler: SchedulerService,
    resultService: ResultService,
    testRunnerService: TestRunnerService,
    settings: TestSettings
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        scheduler.addScheduledTask( SpeedTest(), settings.testFrequency)
    }
}