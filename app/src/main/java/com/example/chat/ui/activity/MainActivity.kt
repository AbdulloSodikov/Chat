package com.example.chat.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.chat.R
import com.example.chat.databinding.ActivityMainBinding
import com.example.chat.ui.view_model.MainActivityViewModel
import com.example.chat.utillite.APP_ACTIVITY

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    lateinit var mToolbar: Toolbar
    lateinit var mNavController: NavController
    lateinit var mViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initialization()
    }

    private fun initialization() {
        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.toolbar_title)

        mNavController = Navigation.findNavController(this, R.id.nav_host)

        mViewModel =ViewModelProvider(this)[MainActivityViewModel::class.java]
        mViewModel.init()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}