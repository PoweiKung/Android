package com.example.deron.t5_Room.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class RoomUser(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int
)
