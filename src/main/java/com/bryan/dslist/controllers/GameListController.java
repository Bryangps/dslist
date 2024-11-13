package com.bryan.dslist.controllers;

import com.bryan.dslist.dto.GameDTO;
import com.bryan.dslist.dto.GameListDTO;
import com.bryan.dslist.dto.GameMinDTO;
import com.bryan.dslist.entities.Game;
import com.bryan.dslist.services.GameListService;
import com.bryan.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService GameListservice;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = GameListservice.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        GameListDTO obj = GameListservice.findById(id);
        return obj;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

}
