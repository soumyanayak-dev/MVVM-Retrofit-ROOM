package com.soumya.sonarqubelocal.retrofit

import com.soumya.sonarqubelocal.model.PublicAPI
import retrofit2.Response
import retrofit2.http.GET

interface PublicAPIService {

    @GET("/entries")
    suspend fun getPublicAPI(): Response<PublicAPI>
}