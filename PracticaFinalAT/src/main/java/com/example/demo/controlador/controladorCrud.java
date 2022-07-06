package com.example.demo.controlador;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Heroe;
import com.example.demo.entity.HeroePoder;
import com.example.demo.entity.HeroePoderKey;
import com.example.demo.entity.Poder;
import com.example.demo.entity.Universo;
import com.example.demo.repos.RepHeroePoder;
import com.example.demo.repos.RepHeroes;
import com.example.demo.repos.RepPoderes;
import com.example.demo.repos.RepUniversos;


@Controller
public class controladorCrud {

	@Autowired
	private RepHeroes rh;
	
	/*
	Constructor:
	
	public controladorCrud(RepHeroes rh) {
		this.rh = rh;
	}
	
	*/
	
	@Autowired
	private RepPoderes rp;
	
	@Autowired
	private RepUniversos ru;
	
	@Autowired
	RepHeroePoder rhp;

	//D
    @RequestMapping(value="/lista", method = RequestMethod.GET)
    public String lista(
    		@RequestParam("entidad") String entidad,
    		ModelMap mp){
    	
    		switch (entidad.toLowerCase()) {
    		case "heroes":
    			mp.put("heroes", rh.findAll());
    			
    			mp.put("heroePoder", rhp.findAll());
    	        return "/list/listaHeroes";
    		case "poderes":
    			mp.put("poderes", rp.findAll());
    	        return "/list/listaPoderes";
    		case "universos":
    			mp.put("universos", ru.findAll());
    	        return "/list/listaUniversos";
    	    default:
    	    	return "/error/noExisteEntidad";
    		}
    	
    	}
    
    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String crear(@RequestParam("entidad") String entidad,
    		ModelMap mp){
    	
    	switch (entidad) {
		case "heroe":
    		mp.put("heroe", new Heroe());
    		mp.put("universos", ru.findAll());
    	    return "/create/createHeroe"; 

		case "poder":
			
    		mp.put("poder", new Poder());
    	    return "/create/createPoder"; 
    	    
		case "universo":
    		mp.put("universo", new Universo());
    	    return "/create/createUniverso"; 
	    default:
	    	return "/error/noExisteEntidad";	
		}
    	

    	
    	}
    
    @RequestMapping(value="/create/createHeroe", method=RequestMethod.POST)
    public String crearHeroe(@Valid Heroe heroe,
            BindingResult bindingResult, ModelMap mp){
    	
    	//Comprueba si se cumplen los requisitos establecidos en la clase Heroe
    	//Size,NonNull...
        if(bindingResult.hasErrors()){
            mp.put("heroes", rh.findAll());
            return "/list/listaHeroes";
        }else{
            rh.save(heroe);
            mp.put("heroe", heroe);
            return "/creado/heroeCreado";
        }
    }
    
    @RequestMapping(value="/create/createUniverso", method=RequestMethod.POST)
    public String crearUniverso(@Valid Universo universo,
            BindingResult bindingResult, ModelMap mp){
    	
        if(bindingResult.hasErrors()){
            mp.put("universos", ru.findAll());
            return "/list/listaUniversos";
        }else{
            ru.save(universo);
            mp.put("universo", universo);
            return "/creado/universoCreado";
        }
    }
    
    @RequestMapping(value="/create/createPoder", method=RequestMethod.POST)
    public String crearPoder(@Valid Poder poder,
            BindingResult bindingResult, ModelMap mp){
    	
    	bindingResult.getAllErrors().forEach(System.out::println);
    	
        if(bindingResult.hasErrors()){
            mp.put("universos", ru.findAll());
            return "/list/listaPoderes";
        }else{
            rp.save(poder);
            mp.put("poder", poder);
            return "/creado/poderCreado";
        }
    }
    
    @PostMapping(value="/delete/Heroe")
    public String eliminarHeroe(Heroe heroe, ModelMap mp){
    		rh.delete(heroe);
            return "delete/Heroe";
        }
    
    @PostMapping(value="/delete/Poder")
    public String eliminarPoder(Poder poder, ModelMap mp){
    		rp.delete(poder);
            return "delete/Poder";
        }
    
    @PostMapping(value="/delete/Universo")
    public String eliminarPoder(Universo universo, ModelMap mp){
    		ru.delete(universo);
            return "delete/Universo";
        }
    
    
    @PostMapping(value="/seleccionarPoder")
    public String seleccionarPoder(Heroe heroe, ModelMap mp){
    	
    	mp.addAttribute("heroeId", rh.findById(heroe.getHeroeId()).orElse(null));
		mp.put("poderes", rp.findAll());
            return "darPoder";
        }
    
    @PostMapping(value="/darPoder")
    public String darPoder(Poder poder,Heroe heroe,ModelMap mp){
    	
    	rhp.save(new HeroePoder(new HeroePoderKey(heroe.getHeroeId(),poder.getPoderId()),heroe,poder));
    	
    	return "x";
	
    	
        }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String inicio(ModelMap mp){
	    return "/inicio"; 
	}
    
    @RequestMapping(value="/inicio", method = RequestMethod.GET)
    public String inicio2(ModelMap mp){
	    return "/inicio"; 
	}
        
    }
    
