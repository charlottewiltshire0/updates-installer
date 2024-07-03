package com.charlottewiltshire0.updaterinstaller.api.controller.updates

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/updates")
@CrossOrigin("*")
class UpdatesController {

    @GetMapping("/latest")
    fun getLatestVersion() {

    }
}