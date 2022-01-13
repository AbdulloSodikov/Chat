package com.example.chat.ui.start_fragment

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.R
import com.example.chat.databinding.FragmentStartListBinding
import com.example.chat.model.Person
import com.example.chat.ui.view_model.StartListFragmentViewModel
import com.example.chat.utillite.APP_ACTIVITY
import java.util.*

class StartListFragment : Fragment() {
    private var _binding: FragmentStartListBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartListFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mPersonAdapter: PersonAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartListBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        initialization()

    }

    private fun initialization() {

        mViewModel = ViewModelProvider(this)[StartListFragmentViewModel::class.java]
        mPersonAdapter = PersonAdapter()
        mRecyclerView = mBinding.personRecyclerView
        mRecyclerView.adapter = mPersonAdapter
        mViewModel.getAllPerson.observe(this,{it?.let { mPersonAdapter.setList(it) }})


    }
}