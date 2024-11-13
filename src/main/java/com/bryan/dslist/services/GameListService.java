package com.bryan.dslist.services;

import com.bryan.dslist.dto.GameListDTO;
import com.bryan.dslist.entities.GameList;
import com.bryan.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

     public GameListDTO findById(Long id){
        GameList obj = repository.findById(id).get();
        return new GameListDTO(obj);
    }
}
