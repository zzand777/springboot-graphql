package com.example.graphql.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.api.entity.TbmMdLine;
import com.example.graphql.api.entity.TbmMdLinePK;

public interface TbmMdLineRepository extends JpaRepository<TbmMdLine, TbmMdLinePK> {
    
}
