package com.orion.coppelmvvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.orion.coppelmvvvm.data.model.HeroModel
import com.orion.coppelmvvvm.domain.model.Hero

@Entity(tableName = "hero_table")
data class HeroEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")val id:Int =1,
    @ColumnInfo(name = "name")val name:String,
    @ColumnInfo(name = "url")val url:String
)

fun HeroModel.toDatabase() = HeroEntity(id = id.toInt(), name = name, url = url)
