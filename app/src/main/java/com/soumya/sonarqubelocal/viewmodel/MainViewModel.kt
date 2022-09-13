package com.soumya.sonarqubelocal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soumya.sonarqubelocal.model.PublicAPI
import com.soumya.sonarqubelocal.repository.PublicAPIRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository:PublicAPIRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPublicAPI()
        }
    }

    val getEntries: LiveData<PublicAPI>
    get() = repository.entriesLiveData
}