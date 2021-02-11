package com.android.mvipattern.di

import android.content.Context
import androidx.room.Room
import com.android.mvipattern.room.BlogDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDb = Room.databaseBuilder(
        context,
        BlogDb::class.java,
        BlogDb.DATABASE_NAME
    ).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideBlogDao(blogDb: BlogDb)=blogDb.blogDao()
}