package com.example.theftprotection.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
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


//        val sharedPrefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val name = sharedPrefs.getString("name", null)
//
//        if (name != null) {
//            Log.e("MyTag", name.toString())
//        }

        homeActivityBinding = ActivityHomeBinding.inflate(layoutInflater)



        setContentView(homeActivityBinding.root)

        supportActionBar?.elevation = 0F;


        // Retrieve the SharedPreferences object using the same name as before
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        // Use the getBoolean method to retrieve the boolean value
        val isDarkValue = sharedPreferences.getBoolean("isDark", false)

        if(isDarkValue) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


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