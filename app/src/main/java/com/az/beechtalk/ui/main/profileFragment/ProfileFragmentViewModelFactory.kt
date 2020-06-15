package com.az.beechtalk.ui.main.profileFragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.az.beechtalk.BeechTalkDatabase
import com.az.beechtalk.dao.UserDAO

class ProfileFragmentViewModelFactory(private val database: UserDAO,private val application: Application):  ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileFragmentViewModel::class.java)) {
            return ProfileFragmentViewModel(database , application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}