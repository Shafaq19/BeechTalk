package com.az.beechtalk.ui.main.profileFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.az.beechtalk.BeechTalkDatabase
import com.az.beechtalk.Models.User
import com.az.beechtalk.dao.UserDAO
import com.az.beechtalk.utilities.getPhoneNumber
import kotlinx.coroutines.*

//AndroidViewmodel allow app context as parameter gonna need it for resouces access
class ProfileFragmentViewModel(private val database: UserDAO, application: Application) : AndroidViewModel(application) {

    private var getUserJob = Job()
    private var uiscope = CoroutineScope(Dispatchers.Main+getUserJob)
    //internal backing property
    private var _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() {
            return _user
        }
    init {
uiscope.launch { _user.value = getUserfromDb() }
    }
//coroutine will be suspended untill this call return
    private suspend fun  getUserfromDb(): User? {
    return withContext(Dispatchers.IO) {
        var user = database.getNumber(getPhoneNumber())
        if(user!=null)
            user
        else
            User()
    }
    }
    override fun onCleared() {
        super.onCleared()
        //so that we dont have jobs that have no where to go
        getUserJob.cancel()
    }
}