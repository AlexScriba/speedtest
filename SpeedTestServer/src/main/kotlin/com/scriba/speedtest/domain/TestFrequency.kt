package com.scriba.speedtest.domain

import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit

enum class TestFrequency {
    Daily, Hourly, EveryMinute, EverySecond;

    companion object {
        fun getNextTick(frequency: TestFrequency): Instant {
            val now = Instant.now()

            return when(frequency) {
                Daily -> now.truncatedTo(ChronoUnit.DAYS).plusSeconds(days(1))
                Hourly -> now.truncatedTo(ChronoUnit.HOURS).plusSeconds(hours(1))
                EveryMinute -> now.truncatedTo(ChronoUnit.MINUTES).plusSeconds(minutes(1))
                EverySecond -> now.truncatedTo(ChronoUnit.SECONDS).plusSeconds(1)
            }
        }

        fun timeBetweenTicks(frequency: TestFrequency): Duration {
            return when(frequency) {
                Daily -> Duration.ofDays(1)
                Hourly -> Duration.ofHours(1)
                EveryMinute -> Duration.ofMinutes(1)
                EverySecond -> Duration.ofSeconds(1)
            }
        }

        private fun days(numDays: Long) = numDays * hours(24)
        private fun hours(numHours: Long) = numHours * minutes(60)
        private fun minutes(numMinutes: Long) = numMinutes * 60
    }
}