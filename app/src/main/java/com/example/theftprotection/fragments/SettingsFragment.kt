package com.example.theftprotection.fragments

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.theftprotection.databinding.FragmentSettingsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class SettingsFragment : Fragment() {

    lateinit var settingsFragmentBinding : FragmentSettingsBinding
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        settingsFragmentBinding = FragmentSettingsBinding.inflate(layoutInflater)

//        val sharedPrefs = activity?.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPrefs?.edit()
//
//        editor!!.apply {
//            putString("name", "John")
//        }

        val sharedPref = context?.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()



        when (context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isChecked = true
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isChecked = false
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isChecked = false
            }
        }


        settingsFragmentBinding.settingsFragmentThemeChangeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                if (editor != null) {
                    editor.putBoolean("isDark", true)
                    editor.apply()
                }

            } else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                if (editor != null) {
                    editor.putBoolean("isDark", false)
                    editor.apply()
                }
            }
        }

        return settingsFragmentBinding.root

    }


}