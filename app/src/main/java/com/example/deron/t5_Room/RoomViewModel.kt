package com.example.deron.t5_Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.deron.t5_Room.repository.UserRepository
import com.example.deron.t5_Room.table.RoomUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val userList: LiveData<List<RoomUser>> = repository.allUsers.asLiveData()

    fun insertUser(user: RoomUser) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun update(user: RoomUser) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: RoomUser) = viewModelScope.launch {
        repository.delete(user)
    }
}