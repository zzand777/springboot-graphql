package com.example.graphql.api.dto;

import java.util.List;

import lombok.Data;

@Data
public class TbmMdLineDTO {
    private String fctCode, lineCode, lineNm, procTypeCode;
    private List<TbmMdEquipIdDTO> equip;
}
