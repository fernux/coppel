package com.orion.coppelmvvvm.domain

import com.orion.coppelmvvvm.data.HeroRepository
import com.orion.coppelmvvvm.data.database.entities.toDatabase
import com.orion.coppelmvvvm.domain.model.Hero
import com.orion.coppelmvvvm.domain.model.toDomain
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(private val repository :  HeroRepository){


    suspend operator fun invoke():MutableList<Hero>{

        if(repository.getAllHerosFromDatabase().count()<100){


            val heros = repository.getAllHerosFromApi()

            return if(heros.isNotEmpty()){
                //repository.clearHeros()
                //repository.insertHeros(heros = heros)
                //repository.insertHeros(heros.map { it.toDatabase() })
                repository.insertHeros(heros.map { it.toDatabase() }.toMutableList())
                heros.map { it.toDomain() }.toMutableList()
            }else{
                repository.getAllHerosFromDatabase().map { it.toDomain() }.toMutableList()

            }


        }else{

            return    repository.getAllHerosFromDatabase().map { it.toDomain() }.toMutableList()
            }
       // return arrayListOf()



    }

}