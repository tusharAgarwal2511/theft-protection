package com.example.theftprotection.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.theftprotection.R
import com.example.theftprotection.databinding.ActivityHomeBinding
import com.example.theftprotection.fragments.HomeFragment
import com.example.theftprotection.fragments.SecurityFragment
import com.example.theftprotection.fragments.SettingsFragment
import com.example.theftprotection.viewmodelfactories.MainActivityViewModelFactory
import com.example.theftprotection.viewmodels.MainActivityViewModel

class HomeActivity : AppCompatActivity() {

    private var selectedItemId = R.id.security

    private lateinit var homeActivityBinding : ActivityHomeBinding

    private lateinit var defaultFragment : Fragment

    private lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)


        homeActivityBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityBinding.root)

        supportActionBar?.elevation = 0F;


        mainActivityViewModel = ViewModelProvider(this, MainActivityViewModelFactory(selectedItemId))[MainActivityViewModel::class.java]


        replaceFragments(mainActivityViewModel.defaultFragment)


        homeActivityBinding.bottomNavigationBar.setOnItemSelectedListener {

            when(it.itemId){


                R.id.home -> {
                    replaceFragments(HomeFragment())
                    mainActivityViewModel.newItemSelected(it.itemId, HomeFragment())
                    defaultFragment = HomeFragment()

                }
                R.id.security -> {
                    replaceFragments(SecurityFragment())
                    mainActivityViewModel.newItemSelected(it.itemId, SecurityFragment())
                    defaultFragment = SecurityFragment()


                }
                R.id.settings -> {
                    replaceFragments(SettingsFragment())
                    mainActivityViewModel.newItemSelected(it.itemId, SettingsFragment())
                    defaultFragment = SettingsFragment()
                }
                else -> {

                }
            }

            true
        }

    }

    private fun replaceFragments(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bottom_navigation_frame_holder, fragment)
        fragmentTransaction.commit()
    }


}