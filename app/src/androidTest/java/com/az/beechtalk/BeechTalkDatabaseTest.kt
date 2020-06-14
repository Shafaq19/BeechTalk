package com.az.beechtalk
import androidx.room.Room
import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.az.beechtalk.Models.User
import com.az.beechtalk.dao.UserDAO
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
    class BeechTalkDatabaseTest {
    private lateinit var db:BeechTalkDatabase
    private lateinit var userDAO:UserDAO
    @Before
    fun setUp ()
    {
        val context = InstrumentationRegistry . getInstrumentation ().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = inMemoryDatabaseBuilder(context, BeechTalkDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        userDAO = db.userdao
    }
    @After
    fun tearDown ()
    {
        db.close()
    }
    @Test
    fun insertAndGetNight ()
    {
        val night = User()
        night.name="shafaq"
        night.phoneNumber = "90"
        userDAO.insert(night)
        val tonight = userDAO.getNumber(night.phoneNumber)
        assertEquals(tonight?.name, "shafaq")
    }
}