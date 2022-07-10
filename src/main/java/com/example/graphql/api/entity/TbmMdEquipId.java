package com.example.graphql.api.entity;

import javax.persistence.Column;
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
    @Column(name = "fct_code")
    private String fctCode;
    
    @Id
    @Column(name = "plant_code")
    private String plantCode;
    
    @Id
    @Column(name = "equip_id")
    private String equipId;
    
    @Column(name = "equip_nm")
    private String equipNm;
    
    @Column(name = "line_code")
    private String lineCode;
}
