package com.bryan.dslist.controllers;

import com.bryan.dslist.dto.GameDTO;
import com.bryan.dslist.dto.GameListDTO;
import com.bryan.dslist.services.GameListService;
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
    private GameListService service;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = service.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        GameListDTO obj = service.findById(id);
        return obj;
    }

}
