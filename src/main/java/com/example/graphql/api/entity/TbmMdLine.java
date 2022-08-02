package com.example.graphql.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbm_md_line")
@Getter
@Setter
@DynamicUpdate
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "fct_code", insertable = false, updatable = false), @JoinColumn(name = "line_code", insertable = false, updatable = false)})
    @JsonManagedReference
    private List<TbmMdEquipId> equip;
}
