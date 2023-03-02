package com.example.theftprotection.viewmodels

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theftprotection.fragments.SecurityFragment

class MainActivityViewModel(private var selectedItemId : Int) : ViewModel() {

    var selectedItem = MutableLiveData<Int>(selectedItemId)
    var defaultFragment : Fragment = SecurityFragment()

    fun newItemSelected(newSelectedItemId : Int, SelectedFragment : Fragment){
        selectedItem.value = newSelectedItemId
        defaultFragment = SelectedFragment
    }
}