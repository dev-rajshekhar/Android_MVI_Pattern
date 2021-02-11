package com.android.mvipattern.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.mvipattern.room.BlogCacheEntity
import com.android.mvipattern.room.BlogDao

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract  class BlogDb : RoomDatabase() {
    abstract  fun blogDao(): BlogDao
    companion object{
        val DATABASE_NAME="blog_db"
    }

}