package com.bryan.dslist.controllers;

import com.bryan.dslist.dto.GameDTO;
import com.bryan.dslist.dto.GameMinDTO;
import com.bryan.dslist.entities.Game;
import com.bryan.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = service.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = service.findById(id);
        return result;
    }
}
