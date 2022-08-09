package com.example.graphql.api.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TbmMdEquipIdPK implements Serializable {
    private String fctCode, plantCode, equipId;
}
