package com.example.deron.t5_Room.repository

import com.example.deron.t5_Room.dao.UserDAO
import com.example.deron.t5_Room.table.RoomUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDAO: UserDAO) {

    val allUsers: Flow<List<RoomUser>> = userDAO.getAllUsers()

    suspend fun insertUser(user: RoomUser) {
        userDAO.insert(user)
    }

    suspend fun update(user: RoomUser) {
        userDAO.update(user)
    }

    suspend fun delete(user: RoomUser) {
        userDAO.delete(user)
    }

}