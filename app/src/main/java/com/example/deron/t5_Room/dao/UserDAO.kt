package com.example.deron.t5_Room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.deron.t5_Room.table.RoomUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: RoomUser)

    @Update
    suspend fun update(user: RoomUser)

    @Delete
    suspend fun delete(user: RoomUser)

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getAllUsers(): Flow<List<RoomUser>>

}