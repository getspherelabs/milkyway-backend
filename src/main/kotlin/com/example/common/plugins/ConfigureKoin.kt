package com.example.common.plugins

import com.example.di.controllerModule
import com.example.di.daoModule
import com.example.di.repositoryModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(listOf(controllerModule, daoModule, repositoryModule))
    }
}