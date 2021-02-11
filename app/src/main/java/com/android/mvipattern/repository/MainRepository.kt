package com.android.mvipattern.repository

import com.android.mvipattern.model.Blog
import com.android.mvipattern.network.ApiService
import com.android.mvipattern.network.NetworkMapper
import com.android.mvipattern.room.BlogDao
import com.android.mvipattern.room.CacheMapper
import com.android.mvipattern.utility.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepository (
    private val apiService: ApiService,
    private val mapper: NetworkMapper,
    private val cacheMapper: CacheMapper,
    private val dao: BlogDao
) {
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlog = apiService.getBlogs()
            val blogs = mapper.mapFromEntityList(networkBlog)
            for (blog in blogs) {
                dao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlog = dao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlog)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }


    }
}