package com.orion.coppelmvvvm.data.database.dao


import androidx.room.Dao;
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query;
import com.orion.coppelmvvvm.data.database.entities.HeroEntity



@Dao
public interface HeroDao {

    @Query(value = "SELECT * FROM hero_table ORDER BY name ASC")
    suspend fun getAllHero():MutableList<HeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:MutableList<HeroEntity>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHero()
}
