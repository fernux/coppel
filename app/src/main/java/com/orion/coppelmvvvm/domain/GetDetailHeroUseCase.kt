package com.orion.coppelmvvvm.domain


import com.orion.coppelmvvvm.data.DetailHeroRepository
import com.orion.coppelmvvvm.domain.model.DetailHero
import javax.inject.Inject

class  GetDetailHeroUseCase @Inject constructor(private val repository: DetailHeroRepository) {

    suspend operator fun invoke(id:Int):DetailHero?{
        val quotes = repository.getDetailHeroFromApi(id = id)

       return quotes
    }

}