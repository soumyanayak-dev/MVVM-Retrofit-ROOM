package com.soumya.sonarqubelocal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soumya.sonarqubelocal.repository.PublicAPIRepository

class MainViewModelFactory(private val publicAPIRepository: PublicAPIRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(publicAPIRepository) as T
    }
}