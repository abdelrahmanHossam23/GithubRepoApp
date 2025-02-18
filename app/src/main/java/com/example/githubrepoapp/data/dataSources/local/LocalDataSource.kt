package com.example.githubrepoapp.data.dataSources.local

import com.example.githubrepoapp.data.dataSources.local.data_store.DataStorePreference
import com.example.githubrepoapp.data.dataSources.local.room.entities.GithubRepositoriesEntity
import com.example.githubrepoapp.data.dataSources.local.room.GithubRepositoriesDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val githubRepositoriesDao: GithubRepositoriesDao,
    private val datsStorePreference: DataStorePreference
) {
    fun getTrendingRepositories(): List<GithubRepositoriesEntity> {
        return githubRepositoriesDao.getTrendingRepositories()
    }

    suspend fun insertTrendingRepositories(githubRepositoriesEntity: List<GithubRepositoriesEntity>) {
        githubRepositoriesDao.insertTrendingRepositories(githubRepositoriesEntity)
    }

    suspend fun readIsFirstTime(): Boolean { // support flows
        return datsStorePreference.readIsFirstTime()
    }

    suspend fun saveIsFirstTime(isFirstTime: Boolean) {
        datsStorePreference.saveIsFirstTime(isFirstTime = isFirstTime)
    }
}