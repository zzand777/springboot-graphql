package com.example.graphql.api.service;

import java.util.List;

import com.example.graphql.api.dto.TbmMdLineDTO;

public interface LineService {
    public List<TbmMdLineDTO> findAll();
    public List<TbmMdLineDTO> saveAll(List<TbmMdLineDTO> line);
}
