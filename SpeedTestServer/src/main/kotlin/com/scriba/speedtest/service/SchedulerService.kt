package com.scriba.speedtest.service

import com.scriba.speedtest.domain.TestFrequency
import org.slf4j.LoggerFactory
import org.springframework.boot.task.TaskExecutorBuilder
import org.springframework.boot.task.TaskSchedulerBuilder
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime

class SchedulerService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val taskScheduler: ThreadPoolTaskScheduler

    init {
        val taskExecutorBuilder = TaskSchedulerBuilder()
            .poolSize(5)
            .threadNamePrefix("TaskScheduler")

        taskScheduler = taskExecutorBuilder.build()
        taskScheduler.initialize()

        logger.info("SchedulerService Started with [${taskScheduler::class.java}]")
    }

    fun addScheduledTask(task: Runnable, frequency: TestFrequency) {
        val startTime = TestFrequency.getNextTick(frequency)
        val durationBetween = TestFrequency.timeBetweenTicks(frequency)

        taskScheduler.scheduleAtFixedRate(task, startTime, durationBetween)

        logger.info("Scheduled [${task::class.java}] with frequency [$frequency]")
    }
}