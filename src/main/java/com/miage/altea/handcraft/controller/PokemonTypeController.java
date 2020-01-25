package com.miage.altea.handcraft.controller;

import com.miage.altea.handcraft.Controller;
import com.miage.altea.handcraft.RequestMapping;
import com.miage.altea.handcraft.bo.PokemonType;
import com.miage.altea.handcraft.repository.PokemonTypeRepository;

import java.util.Map;

@Controller
public class PokemonTypeController {

    private PokemonTypeRepository repository = new PokemonTypeRepository();

    @RequestMapping(uri="/pokemons")
    public PokemonType getPokemon(Map<String,String[]> parameters){
        if(parameters == null){
            throw new IllegalArgumentException("parameters should not be empty");
        }
        if(parameters.containsKey("id")){
            return repository.findPokemonById(Integer.valueOf(parameters.get("id")[0]));
        }
        else if(parameters.containsKey("name")){
            return repository.findPokemonByName(parameters.get("name")[0]);
        }
        throw new IllegalArgumentException("unknown parameter");
    }
}
