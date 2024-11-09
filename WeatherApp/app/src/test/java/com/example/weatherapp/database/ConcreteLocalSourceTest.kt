package com.example.weatherapp.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.model.alert.AlertItem
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.runner.RunWith
import java.time.LocalDateTime

@RunWith(AndroidJUnit4::class)
class ConcreteLocalSourceTest {

    private lateinit var database: AppDataBase
    private lateinit var localSource: ConcreteLocalSource
    private lateinit var alertsDao: AlertsDao

    @Before
    fun setUp() {
        // Create in-memory database for testing
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()

        alertsDao = database.getAlertsDao()
        localSource = ConcreteLocalSource(ApplicationProvider.getApplicationContext())
    }

    @After
    fun tearDown() {
        database.close() // Close the database after tests
    }

    @Test
    fun `test insertAlert inserts alert correctly`() = runBlocking {
        // Given
        val alertItem = AlertItem(
            startDateTime = LocalDateTime.now(),
            type = "Weather Alert",
            locationName = "Test Location",
            lat = 34.0522,
            lon = -118.2437
        )

        // When
        localSource.insertAlert(alertItem)

        // Then
        val insertedAlerts = alertsDao.getAlerts()
        assertEquals(1, insertedAlerts.size)
        assertEquals(alertItem, insertedAlerts[0])
    }

    @Test
    fun `test deleteAlert deletes alert correctly`() = runBlocking {
        // Given
        val alertItem = AlertItem(
            startDateTime = LocalDateTime.now(),
            type = "Weather Alert",
            locationName = "Test Location",
            lat = 34.0522,
            lon = -118.2437
        )
        alertsDao.insertAlert(alertItem)
        val alertId = alertsDao.getAlerts()[0].id

        // When
        localSource.deleteAlert(alertId)

        // Then
        val alertsAfterDeletion = alertsDao.getAlerts()
        assertTrue(alertsAfterDeletion.isEmpty())
    }
}
