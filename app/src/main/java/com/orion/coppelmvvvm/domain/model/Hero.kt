package com.orion.coppelmvvvm.domain.model

import com.orion.coppelmvvvm.data.database.entities.HeroEntity
import com.orion.coppelmvvvm.data.model.HeroModel

data class Hero (val id: String, val name:String , val url:String)

fun HeroModel.toDomain() = Hero(id,name,url)
fun HeroEntity.toDomain() = Hero(id.toString(),name,url)
