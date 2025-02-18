package com.example.githubrepoapp.data.dataSources.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubrepoapp.data.dataSources.local.room.entities.GithubRepositoriesEntity

@Dao
interface GithubRepositoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendingRepositories(githubRepositoriesEntity: List<GithubRepositoriesEntity>)

    @Query("SELECT * FROM GITHUB_REPOSITORIES_TABLE")
    fun getTrendingRepositories(): List<GithubRepositoriesEntity>

}