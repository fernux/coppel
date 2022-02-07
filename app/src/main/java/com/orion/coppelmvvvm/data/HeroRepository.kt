package com.orion.coppelmvvvm.data

import com.orion.coppelmvvvm.data.database.dao.HeroDao
import com.orion.coppelmvvvm.data.database.entities.HeroEntity
import com.orion.coppelmvvvm.data.model.HeroModel
import com.orion.coppelmvvvm.data.network.HeroService
import javax.inject.Inject

    class HeroRepository  @Inject constructor(
        private val  api :HeroService,
        private val heroDao: HeroDao
        ) {


        suspend fun getAllHerosFromApi(): MutableList<HeroModel> {
            return api.getHeros()
        }
        suspend fun getAllHeroesFromApi(): MutableList<HeroModel> {
            return api.getHeroes()
        }

        suspend fun getAllHerosFromDatabase(): MutableList<HeroEntity> {

            return heroDao.getAllHero()
        }

        suspend fun insertHeros(heros:MutableList<HeroEntity>){
            heroDao.insertAll(heros)
        }

        suspend fun clearHeros(){
            heroDao.deleteAllHero()
        }
}