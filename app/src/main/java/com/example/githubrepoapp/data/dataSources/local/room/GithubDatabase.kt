package com.example.githubrepoapp.data.dataSources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.githubrepoapp.data.dataSources.local.room.entities.GithubRepositoriesEntity

@Database(
    entities = [GithubRepositoriesEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(RepositoriesTypeConverter::class)
abstract class GithubDatabase: RoomDatabase() {
    abstract fun githubRepositoriesDao(): GithubRepositoriesDao
}