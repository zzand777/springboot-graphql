package com.example.graphql.api.service;

import java.util.List;

import com.example.graphql.api.dto.TbmMdEquipIdDTO;

public interface EquipService {
    public List<TbmMdEquipIdDTO> findAll();
    public TbmMdEquipIdDTO findById(TbmMdEquipIdDTO equip);
    public TbmMdEquipIdDTO save(TbmMdEquipIdDTO equip);
    public List<TbmMdEquipIdDTO> saveAll(List<TbmMdEquipIdDTO> equip);
}
