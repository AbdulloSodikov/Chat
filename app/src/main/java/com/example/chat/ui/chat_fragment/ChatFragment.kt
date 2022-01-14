package com.example.chat.ui.chat_fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.R
import com.example.chat.databinding.FragmentChatBinding
import com.example.chat.ui.activity.MainActivity
import com.example.chat.ui.view_model.ChatFragmentViewModel
import com.example.chat.utillite.APP_ACTIVITY
import com.example.chat.utillite.PERSON_ID
import kotlin.properties.Delegates

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: ChatFragmentViewModel
    private lateinit var mChatRecyclerView: RecyclerView
    private lateinit var mChatAdapter: ChatAdapter
   // private  lateinit var mPersonID : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(layoutInflater)
        return mBinding.root


    }

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()


        setHasOptionsMenu(true)
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this)[ChatFragmentViewModel::class.java]
        mChatAdapter = ChatAdapter()
        mChatRecyclerView = mBinding.chatRecyclerView
        mChatRecyclerView.adapter = mChatAdapter
        val personId = arguments?.getInt(PERSON_ID)
        Log.e("MyTag", personId.toString())
        mViewModel.getMessage(personId!!).observe(this, { it?.let { mChatAdapter.setMessageList(it) } })

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.chat_menu, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}