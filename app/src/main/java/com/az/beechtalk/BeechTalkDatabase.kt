package com.az.beechtalk

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.az.beechtalk.Models.User
import com.az.beechtalk.dao.UserDAO

@Database(entities = [User::class], version = 1,  exportSchema = false)
abstract class BeechTalkDatabase:RoomDatabase() {
    abstract val userdao: UserDAO

    companion object {
        //volatoile means dont cache it any change to it should be visible asap to all threads
        @Volatile
        private var INSTANCE: BeechTalkDatabase? = null
        fun getInstance(context: Context): BeechTalkDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BeechTalkDatabase::class.java,
                        "beechtalk_user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
