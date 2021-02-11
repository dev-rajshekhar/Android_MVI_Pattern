package com.android.mvipattern.network

import com.android.mvipattern.model.Blog
import com.android.mvipattern.utility.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor() : EntityMapper<BlogNetworkEntity, Blog> {
    override fun fromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            body = entity.body,
            category = entity.category,
            title = entity.title,
            image = entity.image
        )
    }

    override fun mapToEntity(domain: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domain.id,
            body = domain.body,
            category = domain.category,
            title = domain.title,
            image = domain.image
        )
    }
    fun  mapFromEntityList(entities: List<BlogNetworkEntity>):List<Blog>{
        return  entities.map { fromEntity(it) }
    }
}