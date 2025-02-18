package com.example.githubrepoapp.data.dataSources.local.room

import androidx.room.TypeConverter
import com.example.githubrepoapp.data.dataSources.local.room.entities.GithubRepositoriesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepositoriesTypeConverter {

    @TypeConverter
    fun trendingRepositoriesToString(trendingRepositoriesResponse: List<GithubRepositoriesEntity>):String {
        return Gson().toJson(trendingRepositoriesResponse)
    }
    @TypeConverter
    fun fromStringToTrendingRepositories(data: String):List<GithubRepositoriesEntity> {
        val listType = object : TypeToken<List<GithubRepositoriesEntity>>(){}.type
        return Gson().fromJson(data,listType)
    }
}