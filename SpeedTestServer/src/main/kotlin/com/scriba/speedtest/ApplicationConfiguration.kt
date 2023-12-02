package com.scriba.speedtest

import com.scriba.speedtest.domain.TestFrequency
import com.scriba.speedtest.domain.TestSettings
import com.scriba.speedtest.persistence.InMemoryResultPersistence
import com.scriba.speedtest.persistence.ResultPersistence
import com.scriba.speedtest.service.ResultService
import com.scriba.speedtest.service.RunnerService
import com.scriba.speedtest.service.SchedulerService
import com.scriba.speedtest.service.TestRunnerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
    @Bean
    fun testSettings() = TestSettings(TestFrequency.EveryMinute)

    @Bean
    fun resultPersistence() = InMemoryResultPersistence()

    @Bean
    fun testRunnerService() = TestRunnerService()

    @Bean
    fun resultService(resultPersistence: ResultPersistence) = ResultService(resultPersistence)

    @Bean
    fun schedulerService() = SchedulerService()

    @Bean
    fun runnerService(
        scheduler: SchedulerService,
        resultService: ResultService,
        testRunnerService: TestRunnerService,
        settings: TestSettings
    ) = RunnerService(scheduler, resultService, testRunnerService, settings)
}