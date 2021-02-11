package com.android.mvipattern.room

import com.android.mvipattern.model.Blog
import com.android.mvipattern.network.BlogNetworkEntity
import com.android.mvipattern.utility.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor():EntityMapper<BlogCacheEntity, Blog>{
    override fun fromEntity(entity: BlogCacheEntity): Blog {
        return   Blog(
            id = entity.id,
            body = entity.body,
            category = entity.category,
            title = entity.title,
            image = entity.image
        )
    }

    override fun mapToEntity(domain: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domain.id,
            body = domain.body,
            category = domain.category,
            title = domain.title,
            image = domain.image
        )
    }

    fun  mapFromEntityList(entities: List<BlogCacheEntity>):List<Blog>{
        return  entities.map { fromEntity(it) }
    }
}