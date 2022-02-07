package com.orion.coppelmvvvm.data.network

import com.orion.coppelmvvvm.data.model.HeroModel
import com.orion.coppelmvvvm.domain.model.DetailHero
import retrofit2.Response
import javax.inject.Inject

class HeroApiClientImpl @Inject constructor():HeroApiClient {
    override suspend fun getAllHero(id:Int): Response<HeroModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailHero(id: Int): Response<DetailHero> {
        TODO("Not yet implemented")
    }
}