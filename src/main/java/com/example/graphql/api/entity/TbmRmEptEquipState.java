package com.example.graphql.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(TbmRmEptEquipStatePK.class)
@DynamicInsert
@DynamicUpdate
public class TbmRmEptEquipState {

    @Id
    private String fctCode;

    @Id
    private String plantCode;

    @Id
    private String equipId;

    @Id
    private String unitId;
    
    private String state;
    
    private String eventDt;
}
