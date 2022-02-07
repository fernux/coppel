package com.orion.coppelmvvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orion.coppelmvvvm.data.database.dao.HeroDao
import com.orion.coppelmvvvm.data.database.entities.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class HeroDatabase :RoomDatabase(){
    abstract fun getQuoteDao(): HeroDao
}