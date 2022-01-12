package com.example.chat.ui.start_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chat.R
import com.example.chat.databinding.FragmentStartListBinding
import com.example.chat.utillite.APP_ACTIVITY

class StartListFragment : Fragment() {
    private var _binding: FragmentStartListBinding? = null
    private val mBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartListBinding.inflate(inflater)
        return mBinding.root

    }

    override fun onStart() {
        super.onStart()
        mBinding.button.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_startListFragment_to_chatFragment)
        }
    }
}