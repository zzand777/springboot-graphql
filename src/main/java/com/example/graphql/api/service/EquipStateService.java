package com.example.graphql.api.service;

import java.util.List;

import com.example.graphql.api.dto.TbmRmEptEquipStateDTO;

public interface EquipStateService {
    TbmRmEptEquipStateDTO findById(TbmRmEptEquipStateDTO equipState);
    List<TbmRmEptEquipStateDTO> findByFctCode(TbmRmEptEquipStateDTO equipState);
    List<TbmRmEptEquipStateDTO> saveAll(List<TbmRmEptEquipStateDTO> equipState);
}
