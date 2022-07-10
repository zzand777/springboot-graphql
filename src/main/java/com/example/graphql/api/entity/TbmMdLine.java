package com.example.graphql.api.entity;

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
    private String fct_code, line_code;

    private String line_nm, proc_type_code;
}
