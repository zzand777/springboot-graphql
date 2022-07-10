package com.example.graphql.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbm_md_equip_id")
@Getter
@Setter
@IdClass(TbmMdEquipIdPK.class)
public class TbmMdEquipId {
    @Id
    private String fct_code, plant_code, equip_id;
    
    private String equip_nm;
}
