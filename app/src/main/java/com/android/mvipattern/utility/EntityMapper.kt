package com.android.mvipattern.utility

interface EntityMapper<Entity,DomainModel> {
    fun  fromEntity(entity:Entity):DomainModel
    fun  mapToEntity(domain:DomainModel):Entity
}