package com.example.chat.ui.start_fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.R
import com.example.chat.databinding.FragmentStartListBinding
import com.example.chat.ui.view_model.StartListFragmentViewModel
import com.example.chat.utillite.APP_ACTIVITY
import com.example.chat.utillite.PERSON_ID
import com.example.chat.utillite.showToast

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

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }

    private fun initialization() {

        mViewModel = ViewModelProvider(this)[StartListFragmentViewModel::class.java]
        mPersonAdapter = PersonAdapter()
        mRecyclerView = mBinding.personRecyclerView
        mRecyclerView.adapter = mPersonAdapter
        mViewModel.getAllPerson.observe(this, { it?.let { mPersonAdapter.setList(it) } })

        mPersonAdapter.onItemClick = {
            val bundlePersonId = Bundle()
            bundlePersonId.putInt(PERSON_ID,it)
            APP_ACTIVITY.mNavController.navigate(R.id.action_startListFragment_to_chatFragment,bundlePersonId)
        }

        mBinding.add.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_startListFragment_to_addPersonFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.search_menu, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}