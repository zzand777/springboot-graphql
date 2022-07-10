package com.example.graphql.api.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.api.dao.TbmMdEquipIdRepository;
import com.example.graphql.api.dao.TbmMdLineRepository;
import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;
import com.example.graphql.api.entity.TbmMdLine;

@Controller
public class GraphqlController {

    @Autowired
    private TbmMdEquipIdRepository tbmMdEquipIdRepository;

    @Autowired
    private TbmMdLineRepository tbmMdLineRepository;

    @QueryMapping
    public List<TbmMdEquipId> findAllEquip() {
        return tbmMdEquipIdRepository.findAll();
    }

    @QueryMapping
    public TbmMdEquipId getReferenceById(@Argument TbmMdEquipIdPK equip) {
        return tbmMdEquipIdRepository.getReferenceById(equip);
    }

    @MutationMapping
    public TbmMdEquipId saveEquip(@Argument TbmMdEquipId equip) {
        return tbmMdEquipIdRepository.save(equip);
    }

    @MutationMapping
    public List<TbmMdEquipId> saveAllEquip(@Argument List<TbmMdEquipId> equip) {
        return tbmMdEquipIdRepository.saveAll(equip);
    }


    @QueryMapping
    public List<TbmMdLine> findAllLine() {
        return tbmMdLineRepository.findAll();
    }

    @MutationMapping
    public List<TbmMdLine> saveAllLine(@Argument List<TbmMdLine> line) {
        return tbmMdLineRepository.saveAll(line);
    }
}
