package com.example.githubsearchapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RepositoryEntity::class], version = 1)
abstract class RepositoryDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao

    companion object {
        @Volatile
        private var INSTANCE: RepositoryDatabase? = null

        fun getDatabase(context: Context): RepositoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RepositoryDatabase::class.java,
                    "repository_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
