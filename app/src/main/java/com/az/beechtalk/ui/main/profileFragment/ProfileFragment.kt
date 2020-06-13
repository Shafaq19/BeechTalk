package com.az.beechtalk.ui.main.profileFragment

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.az.beechtalk.R
import com.az.beechtalk.databinding.ProfileLayoutBinding
import com.az.beechtalk.ui.main.PageViewModel
import com.az.beechtalk.ui.main.PlaceholderFragment

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    lateinit var viewmodel: ProfileFragmentViewModel
    lateinit var binding: ProfileLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_layout, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(this).get(ProfileFragmentViewModel::class.java)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
          var fragment: ProfileFragment? = null

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun instance(): ProfileFragment {
            if (fragment == null) {
                fragment = ProfileFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
            }

            return fragment as ProfileFragment
        }
    }
}

