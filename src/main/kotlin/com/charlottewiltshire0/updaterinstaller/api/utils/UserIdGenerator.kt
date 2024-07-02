package com.charlottewiltshire0.updaterinstaller.api.utils

import java.util.Random

object UserIdGenerator {
    private val random = Random()

    fun generateUserId(): String {
        val sb = StringBuilder(18)
        for (i in 0 until 18) {
            sb.append(random.nextInt(10))
        }
        return sb.toString()
    }
}