package com.example.chat.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.chat.R
import com.example.chat.databinding.ActivityMainBinding
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
    lateinit var mDrawer: Drawer
    lateinit var mHeader: AccountHeader
    private lateinit var mViewModel: MainActivityViewModel
    lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this
        initialization()
        initFunc()
    }


    private fun initialization() {
        mToolbar = mBinding.mainToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.toolbar_title)
        mNavController = Navigation.findNavController(this, R.id.nav_host)
        mViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mViewModel.init()

    }

    private fun initFunc() {
        createHeader()
        createDrawer()

    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Имя (Nick Name)")
                    .withEmail("+992 99 999 99 99")

            ).build()
    }
    private fun createDrawer() {
      mDrawer =  DrawerBuilder()
            .withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Cоздать группу")
                    .withSelectable(false)
            ).build()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}