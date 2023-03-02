package com.example.theftprotection.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.theftprotection.viewmodels.MainActivityViewModel

class MainActivityViewModelFactory(private val selectedItem : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass : Class<T>) : T {
        return MainActivityViewModel(selectedItem) as T
    }


}