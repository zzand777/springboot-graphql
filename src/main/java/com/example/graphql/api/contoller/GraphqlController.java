package com.example.graphql.api.contoller;

import java.util.List;
import java.util.Optional;

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
import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;
import com.example.graphql.api.entity.TbmMdLine;
import com.example.graphql.api.entity.TbmRmEptEquipState;
import com.example.graphql.api.entity.TbmRmEptEquipStatePK;
import com.example.graphql.api.repository.TbmMdEquipIdRepository;
import com.example.graphql.api.repository.TbmMdLineRepository;
import com.example.graphql.api.repository.TbmRmEptEquipStateRepository;
import com.example.graphql.api.service.EquipService;
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
    private TbmRmEptEquipStateRepository tbmRmEptEquipStateRepository;

    private FluxSink<List<TbmRmEptEquipState>> equipStateStream;
    private ConnectableFlux<List<TbmRmEptEquipState>> equipStatePublisher;

    @PostConstruct
    private void init() {
        Flux<List<TbmRmEptEquipState>> publisher = Flux.create(emitter -> {
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
    public Optional<TbmRmEptEquipState> findEquipStateById(@Argument TbmRmEptEquipStatePK equipState) {
        return tbmRmEptEquipStateRepository.findById(equipState);
    }

    @QueryMapping
    public List<TbmRmEptEquipState> findEquipStateByFctCode(@Argument TbmRmEptEquipState equipState) {
        return tbmRmEptEquipStateRepository.findByFctCode(equipState.getFctCode());
    }

    @MutationMapping
    public List<TbmRmEptEquipState> saveAllEquipState(@Argument List<TbmRmEptEquipState> equipState) {
        List<TbmRmEptEquipState> saveEquipStateList = tbmRmEptEquipStateRepository.saveAll(equipState);
        equipStateStream.next(saveEquipStateList);
        return saveEquipStateList;
    }

    @SubscriptionMapping
    public Publisher<List<TbmRmEptEquipState>> notifyEquipState() {
        return equipStatePublisher;
    }

}
