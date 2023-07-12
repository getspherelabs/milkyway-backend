package com.example.dao

import com.example.core.CosmoTest
import com.example.data.dao.PlanetDao
import io.github.serpro69.kfaker.faker
import org.junit.Test
import org.koin.test.inject
import java.util.UUID
import kotlin.test.assertEquals

class PlanetDaoTest : CosmoTest() {


    private val planetDao: PlanetDao by inject()
    private val faker = faker { }

    @Test
    fun `should insert planets and verify counts`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        val planetCounts = planetDao.getPlanetCounts()

        assertEquals(2, planetCounts)
    }

    @Test
    fun `should insert planet and get planets`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        val planets = planetDao.getPlanets()

        assertEquals(desc, planets.first().description)
    }

    @Test
    fun `should insert planets and remove all`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        planetDao.removeAll()

        val planetCounts = planetDao.getPlanetCounts()

        assertEquals(0, planetCounts)
    }

    @Test
    fun `should insert planets and get by id`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        val firstPlanet = planetDao.getPlanets().first()
        val newPlanet = planetDao.getPlanetById(firstPlanet.id)

        assertEquals(newPlanet, firstPlanet)
    }

    @Test
    fun `should insert planet and check id if it is true`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        val firstPlanet = planetDao.getPlanets().first()
        val exists = planetDao.exists(firstPlanet.id)

        assertEquals(true, exists)
    }

    @Test
    fun `should insert planet and check id if it is false`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        val exists = planetDao.exists(UUID.randomUUID().toString())

        assertEquals(false, exists)
    }

    @Test
    fun `should insert planets and delete by id`() = withApp {
        val planetName = faker.space.planet()
        val desc = faker.rickAndMorty.quotes()
        val isPopular = false
        val size = "100"
        val distanceFromSun = "1001km"

        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )
        planetDao.insert(
            name = planetName,
            description = desc,
            isPopular = isPopular,
            size = size,
            distanceFromSun = distanceFromSun
        )

        val firstPlanet = planetDao.getPlanets().first()
        val result = planetDao.deleteById(firstPlanet.id)
        val planetCounts = planetDao.getPlanetCounts()

        assertEquals(true, result)
        assertEquals(1, planetCounts)
    }

}