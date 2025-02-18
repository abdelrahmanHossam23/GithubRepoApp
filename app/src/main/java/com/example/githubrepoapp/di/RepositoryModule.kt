package com.example.githubrepoapp.di

import com.example.githubrepoapp.data.dataSources.remote.GithubRemoteDataSource
import com.example.githubrepoapp.data.repository.GithubRepositoryImpl
import com.example.githubrepoapp.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubRepository(
        githubRemoteDataSource: GithubRemoteDataSource
    ): GithubRepository {
        return GithubRepositoryImpl(githubRemoteDataSource)
    }

}

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModuleWithBinds {
//    @Binds
//    abstract fun provideTrendingGithubRepositoryImpl(
//        trendingRepositoryImpl: TrendingRepositoryImp
//    ): TrendingRepository
// }}