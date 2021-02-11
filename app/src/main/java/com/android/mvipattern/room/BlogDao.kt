package com.android.mvipattern.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.mvipattern.model.Blog

@Dao
interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insert(blog:BlogCacheEntity):Long

    @Query("SELECT * FROM table_blog")
    suspend fun get():List<BlogCacheEntity>
}