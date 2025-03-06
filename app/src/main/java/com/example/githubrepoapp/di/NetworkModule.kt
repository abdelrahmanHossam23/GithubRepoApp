package com.example.githubrepoapp.di

import com.example.githubrepoapp.data.Constants.Companion.BASE_URL
import com.example.githubrepoapp.data.dataSources.remote.GithubRemoteDataSource
import com.example.githubrepoapp.data.dataSources.remote.retrofit.api.GithubApi
import com.example.githubrepoapp.data.dataSources.remote.retrofit.api.IssuesApi
import com.example.githubrepoapp.data.dataSources.remote.retrofit.api.RepoDetailsApi
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_details.RepositoryDetailsDataModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

//    @Provides
//    @Singleton
//    fun provideRemoteDataSource(
//        githubApi: GithubApi
//    ): GithubRemoteDataSource {
//        return GithubRemoteDataSource(githubApi)
//    }

    @Provides
    @Singleton
    fun provideGithubApi(
        retrofit: Retrofit
    ):GithubApi {
        return retrofit.create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepoDetailsApi(
        retrofit: Retrofit
    ):RepoDetailsApi {
        return retrofit.create(RepoDetailsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideIssuesApi(retrofit: Retrofit): IssuesApi {
        return retrofit.create(IssuesApi::class.java)
    }

}