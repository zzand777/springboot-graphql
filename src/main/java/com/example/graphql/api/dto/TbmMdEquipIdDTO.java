package com.example.graphql.api.dto;

import lombok.Data;

@Data
public class TbmMdEquipIdDTO {
    private String fctCode, plantCode, equipId, equipNm, procTypeCode, lineCode;
    private TbmMdLineDTO line;
}
