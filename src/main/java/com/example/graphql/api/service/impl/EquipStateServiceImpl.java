package com.example.graphql.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.graphql.api.dto.TbmRmEptEquipStateDTO;
import com.example.graphql.api.entity.TbmRmEptEquipState;
import com.example.graphql.api.entity.TbmRmEptEquipStatePK;
import com.example.graphql.api.repository.TbmRmEptEquipStateRepository;
import com.example.graphql.api.service.EquipStateService;

@Service
@Transactional
public class EquipStateServiceImpl implements EquipStateService {

    @Autowired
    private TbmRmEptEquipStateRepository tbmRmEptEquipStateRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TbmRmEptEquipStateDTO findById(TbmRmEptEquipStateDTO equipState) {
        return tbmRmEptEquipStateRepository.findById(modelMapper.map(equipState, TbmRmEptEquipStatePK.class))
        .map(v -> modelMapper.map(v, TbmRmEptEquipStateDTO.class)).orElse(null);
    }

    @Override
    public List<TbmRmEptEquipStateDTO> findByFctCode(TbmRmEptEquipStateDTO equipState) {
        return tbmRmEptEquipStateRepository.findByFctCode(equipState.getFctCode())
        .stream().map(v -> modelMapper.map(v, TbmRmEptEquipStateDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TbmRmEptEquipStateDTO> saveAll(List<TbmRmEptEquipStateDTO> equipState) {
        return tbmRmEptEquipStateRepository.saveAll(equipState.stream().map(v -> modelMapper.map(v, TbmRmEptEquipState.class)).collect(Collectors.toList()))
        .stream().map(v -> modelMapper.map(v, TbmRmEptEquipStateDTO.class)).collect(Collectors.toList());

    }

}
