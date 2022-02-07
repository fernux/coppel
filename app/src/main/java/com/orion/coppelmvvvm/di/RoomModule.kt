package com.orion.coppelmvvvm.di

import android.content.Context
import androidx.room.Room
import com.orion.coppelmvvvm.data.database.HeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val HERO_DATABASE_NAME = "hero_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)
     = Room.databaseBuilder(context, HeroDatabase::class.java,HERO_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:HeroDatabase) = db.getQuoteDao()

}