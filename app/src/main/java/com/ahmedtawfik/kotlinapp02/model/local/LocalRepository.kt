package com.ahmedtawfik.kotlinapp02.model.local

import com.ahmedtawfik.kotlinapp02.model.entity.User

interface LocalRepository {

    suspend fun getUsers():List<User>

    suspend fun deleteUser(user: User)

    suspend fun insertOrUpdateUser(user: User)
}