package com.orion.coppelmvvvm.domain

import com.orion.coppelmvvvm.data.HeroRepository
import com.orion.coppelmvvvm.data.database.entities.toDatabase
import com.orion.coppelmvvvm.domain.model.Hero
import com.orion.coppelmvvvm.domain.model.toDomain
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(private val repository : HeroRepository){


    suspend operator fun invoke():MutableList<Hero>{

        if(repository.getAllHerosFromDatabase().count()>99){
            val heros = repository.getAllHeroesFromApi()

            return if(heros.isNotEmpty()){
                repository.insertHeros(heros.map { it.toDatabase() }.toMutableList())
                heros.map { it.toDomain() }.toMutableList()
            }else{
                repository.getAllHerosFromDatabase().map { it.toDomain() }.toMutableList()
            }
        }
        //else{

          //  return    repository.getAllHerosFromDatabase().map { it.toDomain() }.toMutableList()
        //}
         return arrayListOf()



    }

}