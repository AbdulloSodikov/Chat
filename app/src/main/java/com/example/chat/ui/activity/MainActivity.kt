package com.example.chat.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.chat.R
import com.example.chat.databinding.ActivityMainBinding
import com.example.chat.ui.objects.AppDrawer
import com.example.chat.ui.view_model.MainActivityViewModel
import com.example.chat.utillite.APP_ACTIVITY
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    lateinit var mToolbar: Toolbar
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mViewModel: MainActivityViewModel
    lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this
        initialization()

    }

    override fun onStart() {
        super.onStart()
    }
    private fun initialization() {
        mToolbar = mBinding.mainToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.toolbar_title)
        mAppDrawer = AppDrawer(this,mToolbar)
        mAppDrawer.create()
        mNavController = Navigation.findNavController(this, R.id.nav_host)

        mViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mViewModel.init()

    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}