package com.example.graphql.api.contoller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.api.dto.TbmMdEquipIdDTO;
import com.example.graphql.api.dto.TbmMdLineDTO;
import com.example.graphql.api.dto.TbmRmEptEquipStateDTO;
import com.example.graphql.api.service.EquipService;
import com.example.graphql.api.service.EquipStateService;
import com.example.graphql.api.service.LineService;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Controller
public class GraphqlController {

    @Autowired
    private EquipService equipService;

    @Autowired
    private LineService lineService;
    
    @Autowired
    private EquipStateService equipStateService;

    

    private FluxSink<List<TbmRmEptEquipStateDTO>> equipStateStream;
    private ConnectableFlux<List<TbmRmEptEquipStateDTO>> equipStatePublisher;

    @PostConstruct
    private void init() {
        Flux<List<TbmRmEptEquipStateDTO>> publisher = Flux.create(emitter -> {
            equipStateStream = emitter;
        });

        equipStatePublisher = publisher.publish();
        equipStatePublisher.connect();
    }
    

    @QueryMapping
    public List<TbmMdEquipIdDTO> findAllEquip() {
        return equipService.findAll();
    }

    @QueryMapping
    public TbmMdEquipIdDTO findEquipById(@Argument TbmMdEquipIdDTO equip) {
        return equipService.findById(equip);
    }

    @MutationMapping
    public TbmMdEquipIdDTO saveEquip(@Argument TbmMdEquipIdDTO equip) {
        return equipService.save(equip);
    }

    @MutationMapping
    public List<TbmMdEquipIdDTO> saveAllEquip(@Argument List<TbmMdEquipIdDTO> equip) {
        return equipService.saveAll(equip);
    }
    

    @QueryMapping
    public List<TbmMdLineDTO> findAllLine() {
        return lineService.findAll();
    }

    @MutationMapping
    public List<TbmMdLineDTO> saveAllLine(@Argument List<TbmMdLineDTO> line) {
        return lineService.saveAll(line);
    }


    @QueryMapping
    public TbmRmEptEquipStateDTO findEquipStateById(@Argument TbmRmEptEquipStateDTO equipState) {
        return equipStateService.findById(equipState);
    }

    @QueryMapping
    public List<TbmRmEptEquipStateDTO> findEquipStateByFctCode(@Argument TbmRmEptEquipStateDTO equipState) {
        return equipStateService.findByFctCode(equipState);
    }

    @MutationMapping
    public List<TbmRmEptEquipStateDTO> saveAllEquipState(@Argument List<TbmRmEptEquipStateDTO> equipState) {
        List<TbmRmEptEquipStateDTO> saveEquipStateList = equipStateService.saveAll(equipState);
        equipStateStream.next(saveEquipStateList);
        return saveEquipStateList;
    }

    @SubscriptionMapping
    public Publisher<List<TbmRmEptEquipStateDTO>> notifyEquipState() {
        return equipStatePublisher;
    }

}
