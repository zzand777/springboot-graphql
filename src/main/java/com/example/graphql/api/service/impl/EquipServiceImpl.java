package com.example.graphql.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.graphql.api.dto.TbmMdEquipIdDTO;
import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;
import com.example.graphql.api.repository.TbmMdEquipIdRepository;
import com.example.graphql.api.service.EquipService;

@Service
@Transactional
public class EquipServiceImpl implements EquipService {

    @Autowired
    private TbmMdEquipIdRepository tbmMdEquipIdRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TbmMdEquipIdDTO> findAll() {
        return tbmMdEquipIdRepository.findAll().stream().map(v -> modelMapper.map(v, TbmMdEquipIdDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TbmMdEquipIdDTO findById(TbmMdEquipIdDTO equip) {
        return tbmMdEquipIdRepository.findById(modelMapper.map(equip, TbmMdEquipIdPK.class)).map(v -> modelMapper.map(v, TbmMdEquipIdDTO.class)).orElse(null);
    }

    @Override
    public TbmMdEquipIdDTO save(TbmMdEquipIdDTO equip) {
        return modelMapper.map(tbmMdEquipIdRepository.save(modelMapper.map(equip, TbmMdEquipId.class)), TbmMdEquipIdDTO.class);
    }

    @Override
    public List<TbmMdEquipIdDTO> saveAll(List<TbmMdEquipIdDTO> equip) {
        return tbmMdEquipIdRepository.saveAll(equip.stream().map(v -> modelMapper.map(v, TbmMdEquipId.class)).collect(Collectors.toList()))
        .stream().map(v -> modelMapper.map(v, TbmMdEquipIdDTO.class)).collect(Collectors.toList());
    }
    
}
