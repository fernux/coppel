package com.orion.coppelmvvvm.data.network

import androidx.annotation.CallSuper
import com.orion.coppelmvvvm.data.model.HeroModel
import com.orion.coppelmvvvm.domain.model.DetailHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface HeroApiClient {

    @GET("api/4554603741334228/{id}/image")
    @CallSuper
    suspend fun getAllHero(@Path("id")id:Int): Response<HeroModel>

    @GET("api/4554603741334228/{id}")
    @CallSuper
    suspend fun getDetailHero(@Path("id")id:Int): Response<DetailHero>


}