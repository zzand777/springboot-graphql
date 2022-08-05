package com.example.graphql.api.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TbmRmEptEquipStatePK implements Serializable {
    private String fctCode, plantCode, equipId, unitId;
}
