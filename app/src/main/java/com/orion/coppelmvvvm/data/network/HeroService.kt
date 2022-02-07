package com.orion.coppelmvvvm.data.network

import com.orion.coppelmvvvm.data.model.HeroModel
import com.orion.coppelmvvvm.domain.model.DetailHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeroService @Inject constructor(private val api:HeroApiClient) {
    suspend fun getHeros(): MutableList<HeroModel> {
        var responseDef = mutableListOf<HeroModel>()
         withContext(Dispatchers.IO) {

             for(num in 1..100) {
             val fail = api.getAllHero(num)
             if (fail.isSuccessful) {
                 fail.body()?.let {
                     HeroModel(
                         fail.body()!!.response,
                         it.id, fail.body()!!.name, fail.body()!!.url
                     )
                 }?.let { responseDef.add(it) }
             } else {
                 responseDef = arrayListOf()
             }
         }

        }
        return responseDef
    }
     suspend fun getHeroes(): MutableList<HeroModel> {
        var responseDef = mutableListOf<HeroModel>()
        withContext(Dispatchers.Default) {

            for(num in 101..732) {
                val fail = api.getAllHero(num)
                if (fail.isSuccessful) {
                    fail.body()?.let {
                        HeroModel(
                            fail.body()!!.response,
                            it.id, fail.body()!!.name, fail.body()!!.url
                        )
                    }?.let { responseDef.add(it) }
                } else {
                    responseDef = arrayListOf()
                }
            }

        }
        return responseDef
    }

    suspend fun getDetailHero( id:Int): DetailHero? {
        var responseDetail: DetailHero = DetailHero()
        withContext(Dispatchers.IO) {
            val response = api.getDetailHero(id)
            if(response.isSuccessful){
                responseDetail= response.body()!!
            }
        }
        return responseDetail

    }

}