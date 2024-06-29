package com.charlottewiltshire0.updaterinstaller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UpdaterInstallerApplication

fun main(args: Array<String>) {
	runApplication<UpdaterInstallerApplication>(*args)
}
