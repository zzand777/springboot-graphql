package com.example.graphql.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;

public interface TbmMdEquipIdRepository extends CrudRepository<TbmMdEquipId, TbmMdEquipIdPK> {
    
}
