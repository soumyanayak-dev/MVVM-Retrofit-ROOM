package com.soumya.sonarqubelocal.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.soumya.sonarqubelocal.model.PublicAPI
import com.soumya.sonarqubelocal.retrofit.PublicAPIService

class PublicAPIRepository(private val publicAPIService: PublicAPIService) {

    private val entriesMutableLiveData = MutableLiveData<PublicAPI>()

    val entriesLiveData: LiveData<PublicAPI>
    get() = entriesMutableLiveData

    /**
     * ViewModel will access this function to get the data from server/local DB
     */
    suspend fun getPublicAPI() {
        val result = publicAPIService.getPublicAPI()
        if (result?.body() != null) {
            entriesMutableLiveData.postValue(result.body())
        }
    }
}