package com.example.chat.ui.add_person_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.chat.R
import com.example.chat.databinding.FragmentAddPersonBinding
import com.example.chat.model.Person
import com.example.chat.ui.view_model.AddPersonFragmentViewModel
import com.example.chat.utillite.APP_ACTIVITY


class AddPersonFragment : Fragment() {
    private var _binding: FragmentAddPersonBinding? = null
    private val mBinding get() = _binding!!
    lateinit var mViewModel: AddPersonFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPersonBinding.inflate(layoutInflater)
        return mBinding.root

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this)[AddPersonFragmentViewModel::class.java]

        mBinding.apply {
           btnAdd.setOnClickListener {

                val tempPersonSurname = addPersonSurname.text.toString()
                val tempPersonName = addPersonName.text.toString()
                val urlDefaultImage = R.drawable.person_default_image

                val tempAddPerson = Person(
                    0,
                    "$tempPersonSurname $tempPersonName",
                    urlDefaultImage
                )
                mViewModel.insertPerson(tempAddPerson)
                APP_ACTIVITY.mNavController.navigate(R.id.action_addPersonFragment_to_startListFragment)
            }
    }
}


override fun onDestroy() {
    super.onDestroy()
    _binding = null
}
}