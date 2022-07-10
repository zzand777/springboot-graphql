package com.example.graphql.api.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.api.dao.TbmMdEquipIdRepository;
import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;

@Controller
public class GraphqlController {

    @Autowired
    private TbmMdEquipIdRepository tbmMdEquipIdRepository;

    @QueryMapping
    public Iterable<TbmMdEquipId> findAllEquip() {
        return tbmMdEquipIdRepository.findAll();
    }

    @QueryMapping
    public Optional<TbmMdEquipId> findByIdEquip(@Argument TbmMdEquipIdPK equip) {
        return tbmMdEquipIdRepository.findById(equip);
    }

    @MutationMapping
    public TbmMdEquipId saveEquip(@Argument TbmMdEquipId equip) {
        return tbmMdEquipIdRepository.save(equip);
    }

    @MutationMapping
    public Iterable<TbmMdEquipId> saveAllEquip(@Argument List<TbmMdEquipId> equip) {
        return tbmMdEquipIdRepository.saveAll(equip);
    }
}
