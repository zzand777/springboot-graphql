package com.example.graphql.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbm_md_line")
@Getter
@Setter
@IdClass(TbmMdLinePK.class)
public class TbmMdLine {
    @Id
    @Column(name = "fct_code")
    private String fctCode;

    @Id
    @Column(name = "line_code")
    private String lineCode;

    @Column(name = "line_nm")
    private String lineNm;
    
    @Column(name = "proc_type_code")
    private String procTypeCode;
}
