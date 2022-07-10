package com.example.graphql.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.graphql.api.entity.TbmMdLine;
import com.example.graphql.api.entity.TbmMdLinePK;

public interface TbmMdLineRepository extends CrudRepository<TbmMdLine, TbmMdLinePK> {
    
}
