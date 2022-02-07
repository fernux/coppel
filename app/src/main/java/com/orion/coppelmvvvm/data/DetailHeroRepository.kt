package com.orion.coppelmvvvm.data

import com.orion.coppelmvvvm.data.network.HeroService
import com.orion.coppelmvvvm.domain.model.DetailHero
import javax.inject.Inject

class DetailHeroRepository@Inject constructor(
    private val  api : HeroService
    ) {
    suspend fun getDetailHeroFromApi(id:Int): DetailHero? {
        return api.getDetailHero(id = id)
    }
}