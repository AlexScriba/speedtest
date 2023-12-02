package com.scriba.speedtest.domain

import org.slf4j.LoggerFactory
import java.time.LocalDateTime

class SpeedTest : Runnable {
    val logger = LoggerFactory.getLogger(this::class.java)

    override fun run() {
        logger.info("Tick [${LocalDateTime.now()}]")
    }
}