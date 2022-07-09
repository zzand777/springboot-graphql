package com.example.graphql.api.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.graphql.api.dao.TbmMdEquipIdRepository;
import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;

@RestController
public class EquipController {

    @Autowired
    private TbmMdEquipIdRepository tbmMdEquipIdRepository;

    @GetMapping("/equip")
    public Iterable<TbmMdEquipId> findAllEquip() {
        return tbmMdEquipIdRepository.findAll();
    }

    @GetMapping("/equip/{plant_code}/{equip_id}")
    public Optional<TbmMdEquipId> findByIdEquip(@PathVariable String plant_code, @PathVariable String equip_id) {
        return tbmMdEquipIdRepository.findById(new TbmMdEquipIdPK(plant_code, equip_id));
    }

    @PostMapping("/equip")
    public Iterable<TbmMdEquipId> saveAllEquip(@RequestBody Iterable<TbmMdEquipId> equips) {
        return tbmMdEquipIdRepository.saveAll(equips);
    }
}
