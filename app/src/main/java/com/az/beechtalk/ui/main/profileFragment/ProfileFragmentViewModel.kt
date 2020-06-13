package com.az.beechtalk.ui.main.profileFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.az.beechtalk.Models.User

class ProfileFragmentViewModel: ViewModel() {
    //internal backing property
    private var _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() {
            return _user
        }
}