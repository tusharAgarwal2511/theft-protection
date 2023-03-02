package com.example.theftprotection.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
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
        // Inflate the layout for this fragment


        var isThemeDark: Boolean = false

        when (context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                isThemeDark = true
//                settingsFragmentViewModel.changeTheme(isThemeDark)
                settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isChecked = true
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                isThemeDark = false
//                settingsFragmentViewModel.changeTheme(isThemeDark)
                settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isChecked = false
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                isThemeDark = false
//                settingsFragmentViewModel.changeTheme(isThemeDark)
                settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isChecked = false
            }
        }




        settingsFragmentBinding.settingsFragmentThemeChangeSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            } else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        return settingsFragmentBinding.root

//        settingsFragmentBinding.settingsFragmentThemeChangeSwitch.isSelected = false
    }

}