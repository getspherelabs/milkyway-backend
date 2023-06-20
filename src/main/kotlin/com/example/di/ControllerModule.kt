package com.example.di

import com.example.controller.DefaultPlanetController
import com.example.controller.DefaultStartController
import com.example.controller.PlanetController
import com.example.controller.StarController
import org.koin.dsl.module

val controllerModule = module {
    single<PlanetController> {
        DefaultPlanetController(get())
    }
    single<StarController> { DefaultStartController(get()) }
}