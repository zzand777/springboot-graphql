package com.example.graphql.api.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TbmMdEquipIdPK implements Serializable {
    private String fctCode, plantCode, equipId;
}
