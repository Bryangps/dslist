package com.bryan.dslist.services;

import com.bryan.dslist.dto.GameDTO;
import com.bryan.dslist.dto.GameMinDTO;
import com.bryan.dslist.entities.Game;
import com.bryan.dslist.projections.GameMinProjection;
import com.bryan.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game obj = repository.findById(id).get();
        return new GameDTO(obj);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = repository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
