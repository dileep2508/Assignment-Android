package com.example.githubsearchapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<RepositoryEntity>)

    @Query("SELECT * FROM repositories LIMIT 15")
    fun getCachedRepositories(): LiveData<List<RepositoryEntity>>
}
