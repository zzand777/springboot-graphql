package com.example.graphql.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.api.entity.TbmRmEptEquipState;
import com.example.graphql.api.entity.TbmRmEptEquipStatePK;

@Repository
public interface TbmRmEptEquipStateRepository extends JpaRepository<TbmRmEptEquipState, TbmRmEptEquipStatePK> {
    public List<TbmRmEptEquipState> findByFctCode(String fctCode);
}
