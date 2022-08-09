package com.example.graphql.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.graphql.api.dto.TbmMdLineDTO;
import com.example.graphql.api.entity.TbmMdLine;
import com.example.graphql.api.repository.TbmMdLineRepository;
import com.example.graphql.api.service.LineService;

@Service
@Transactional
public class LineServiceImpl implements LineService {

    @Autowired
    private TbmMdLineRepository tbmMdLineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TbmMdLineDTO> findAll() {
        return tbmMdLineRepository.findAll().stream().map(v -> modelMapper.map(v, TbmMdLineDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TbmMdLineDTO> saveAll(List<TbmMdLineDTO> line) {
        return tbmMdLineRepository.saveAll(line.stream().map(v -> modelMapper.map(v, TbmMdLine.class)).collect(Collectors.toList()))
        .stream().map(v -> modelMapper.map(v, TbmMdLineDTO.class)).collect(Collectors.toList());
    }
    
}
