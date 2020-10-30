package com.scooter.service.service;

import com.scooter.service.model.BasicEntity;
import com.scooter.service.model.ScooterModel;
import com.scooter.service.reporitory.PageableScooterRepository;
import com.scooter.service.reporitory.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ScooterService extends AbstractService {
    @Autowired
    ScooterRepository repository;
    @Autowired
    PageableScooterRepository pageableScooterRepository;

    public ScooterService(ScooterRepository repository) {
        super(repository);
    }
    public List<ScooterModel> getFreeScoots(){
        return repository.getFreeScoots();
    }
//    public List<ScooterModel> getPageFreeScoots(int numberPage){
//        int count=pageableScooterRepository.countAll();
//        while ((count/3)<numberPage){
//            numberPage-=3;
//        }
//        if(count%3==0){
//            Pageable page= PageRequest.of(numberPage,3);
//            return pageableScooterRepository.getFreeScoots(page);
//        }
//
//
//        if (numberPage<(count/3)){
//            Pageable page= PageRequest.of(numberPage,3);
//            return pageableScooterRepository.getFreeScoots(page);
//        }
//        if(count%3==0){
//            while ((count/3)<numberPage){
//                numberPage-=3;
//            }
//            Pageable page= PageRequest.of(numberPage,3);
//            return pageableScooterRepository.getFreeScoots(page);
//        }
//        else {
//            int re=(count/3);
//
//        }
//
//        Pageable page= PageRequest.of(numberPage,3);
//
//        return pageableScooterRepository.getFreeScoots(page);
//    }
}
