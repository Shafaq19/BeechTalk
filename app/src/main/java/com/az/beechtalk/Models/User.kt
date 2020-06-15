package com.az.beechtalk.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table" )
public data class User(
@PrimaryKey(autoGenerate = true)
    val userId: Long=0L,
@ColumnInfo(name = "name")
    var name : String ="shafaq",
@ColumnInfo(name = "phoneNumber")
    var phoneNumber : String="090",
@ColumnInfo(name = "rating")

    var rating: Int=0,
@ColumnInfo(name = "topdp")

    var topdp: String="",
@ColumnInfo(name = "bottomDp")

    var bottomDp : String=""

)