package com.android.mvipattern.di

import com.android.mvipattern.network.ApiService
import com.android.mvipattern.network.NetworkMapper
import com.android.mvipattern.repository.MainRepository
import com.android.mvipattern.room.BlogDao
import com.android.mvipattern.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepo(
          apiService: ApiService,
         mapper: NetworkMapper,
         cacheMapper: CacheMapper,
         dao: BlogDao
    ) :MainRepository= MainRepository(apiService,mapper,cacheMapper,dao)

}