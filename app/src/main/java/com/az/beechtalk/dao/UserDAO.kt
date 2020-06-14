package com.az.beechtalk.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.az.beechtalk.Models.User

@Dao
interface UserDAO {
    @Insert
    fun insert(user: User)
    @Update
    fun update(user: User)
    @Query("SELECT * from user_table WHERE userId = :key")
    fun get(key: Long): User?
    @Query("SELECT * from user_table WHERE phoneNumber = :number")
    fun getNumber(number: String): User?
    @Query("DELETE FROM user_table")
    fun clear()
    @Delete
    fun delete(user:User)
    @Query("SELECT * from user_table")
    fun getAll():LiveData<List<User>>
}