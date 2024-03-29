package com.example.graphql.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "tbm_md_equip_id")
@IdClass(TbmMdEquipIdPK.class)
@DynamicInsert
@DynamicUpdate
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
    
    @Column(name = "proc_type_code")
    private String procTypeCode;

    @Column(name = "line_code")
    private String lineCode;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "fct_code", insertable = false, updatable = false), @JoinColumn(name = "line_code", insertable = false, updatable = false)})
    @JsonBackReference
    private TbmMdLine line;
}
