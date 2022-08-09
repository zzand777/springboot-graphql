package com.example.graphql.api.dto;

import lombok.Data;

@Data
public class TbmRmEptEquipStateDTO {
    private String fctCode, plantCode, equipId, unitId, state, eventDt;
}
