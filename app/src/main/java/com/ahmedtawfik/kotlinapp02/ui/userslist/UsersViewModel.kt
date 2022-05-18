package com.ahmedtawfik.kotlinapp02.ui.userslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmedtawfik.kotlinapp02.model.entity.User
import com.ahmedtawfik.kotlinapp02.model.local.LocalRepositoryImp
import com.ahmedtawfik.kotlinapp02.model.local.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application) :AndroidViewModel(application) {

    private var localRepositoryImp:LocalRepositoryImp

    private var usersMutableLiveData = MutableLiveData<List<User>>()

    val usersLiveData:LiveData<List<User>> get() = usersMutableLiveData


    init {
        var db = UserDatabase.getInstance(application)

        localRepositoryImp = LocalRepositoryImp(db)
    }

    fun getUsers()= viewModelScope.launch{
        usersMutableLiveData.postValue(localRepositoryImp.getUsers())
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            localRepositoryImp.insertOrUpdateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            localRepositoryImp.deleteUser(user)
        }
    }

}