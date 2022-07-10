package com.example.graphql.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;

public interface TbmMdEquipIdRepository extends JpaRepository<TbmMdEquipId, TbmMdEquipIdPK> {
    
}
