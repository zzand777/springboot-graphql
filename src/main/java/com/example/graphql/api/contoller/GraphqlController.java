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

import com.example.graphql.api.dao.TbmMdEquipIdRepository;
import com.example.graphql.api.dao.TbmMdLineRepository;
import com.example.graphql.api.dao.TbmRmEptEquipStateRepository;
import com.example.graphql.api.entity.TbmMdEquipId;
import com.example.graphql.api.entity.TbmMdEquipIdPK;
import com.example.graphql.api.entity.TbmMdLine;
import com.example.graphql.api.entity.TbmRmEptEquipState;
import com.example.graphql.api.entity.TbmRmEptEquipStatePK;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Controller
public class GraphqlController {

    @Autowired
    private TbmMdEquipIdRepository tbmMdEquipIdRepository;

    @Autowired
    private TbmMdLineRepository tbmMdLineRepository;

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
    public List<TbmMdEquipId> findAllEquip() {
        return tbmMdEquipIdRepository.findAll();
    }

    @QueryMapping
    public Optional<TbmMdEquipId> findEquipById(@Argument TbmMdEquipIdPK equip) {
        return tbmMdEquipIdRepository.findById(equip);
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
