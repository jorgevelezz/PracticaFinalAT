package com.example.demo.controlador;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    @RequestMapping(value="/verPoder")
    public String verPoder(Heroe heroe, ModelMap mp){	
    	
    	mp.addAttribute("heroe", heroe);
    	
    	mp.put("poderes", rhp.findByHeroe(heroe));
		
        return "verPoder";
        }
    
    
    @RequestMapping(value="/seleccionarPoder/{id}")
    public String seleccionarPoder(@PathVariable int id,ModelMap mp){
    	
    	mp.addAttribute("idHeroe", id);
    	
    	
    	mp.addAttribute("poderes", rp.findAll());
    	
    	return "seleccionarPoder";
	 	
        }
    
    @RequestMapping(value="/darPoder/{id}")
    public String darPoder(@PathVariable int id,Poder poder,ModelMap mp){
    	
    	rhp.save(new HeroePoder(new HeroePoderKey(id,poder.getPoderId()),rh.findById(id).get(),poder));
    	
    	return "x";
	
    	
        }

    @PostMapping(value="/delete/HeroePoder")
    public String eliminarPoder(HeroePoderKey heroePoder, ModelMap mp){
    	
    	System.out.println(heroePoder.toString());	
    	rhp.deletePoderHeroe(heroePoder);
            return "delete/Poder";
        }
    
    @RequestMapping(value = "/editar/{letra}/{id}")
    public String mostrarFormularioEditar(@PathVariable String letra,@PathVariable int id, ModelMap model) 
    {
    	
    	if(letra.equals("H")) {
        model.addAttribute("heroe", rh.findById(id).orElse(null));
        model.addAttribute("universos", ru.findAll());
        return "edit/Heroe";
    	}
    	else if (letra.equals("P")) {
    		model.addAttribute("poder", rp.findById(id).orElse(null));
            return "edit/Poder";
    		
    	}
    	else{
    		model.addAttribute("universo", ru.findById(id).orElse(null));
            return "edit/Universo";
    	}
    }
    
    @PostMapping(value = "/edit/Heroe/{id}")
    public String actualizarHeroe(@Valid Heroe heroe, ModelMap model) 
    {

        Optional<Heroe> posibleHeroe = rh.findById(heroe.getHeroeId());

        if (posibleHeroe.isPresent()  && !posibleHeroe.get().getHeroeId().equals(heroe.getHeroeId())) {
            System.out.println("error");
        }
        
        rh.save(heroe);
        return "/inicio";
    }
    
    @PostMapping(value = "/edit/Poder/{id}")
    public String actualizarPoder(@Valid Poder poder, ModelMap model) 
    {

        Optional<Heroe> posibleHeroe = rh.findById(poder.getPoderId());

        if (posibleHeroe.isPresent()  && !posibleHeroe.get().getHeroeId().equals(poder.getPoderId())) {
            System.out.println("error");
        }
        
        rp.save(poder);
        return "/lista";
    }
    
    @PostMapping(value = "/edit/Universo/{id}")
    public String actualizarUniverso(@Valid Universo universo, ModelMap model) 
    {

        Optional<Heroe> posibleHeroe = rh.findById(universo.getUniversoId());

        if (posibleHeroe.isPresent()  && !posibleHeroe.get().getHeroeId().equals(universo.getUniversoId())) {
            System.out.println("error");
        }
        
        ru.save(universo);
        return "/lista";
    }
    
    
    @RequestMapping(value="/buscar/porId", method=RequestMethod.POST)
    public String buscarHeroeId(Heroe heroe, ModelMap mp){
    	
    	Optional<Heroe> posibleHeroe = rh.findById(heroe.getHeroeId());

            if (posibleHeroe.isPresent()) {
            	mp.put("heroe", posibleHeroe.get());
                return "/mostrar/porId";
            	
            }
            else {
            	return "/error/noExisteEntidad";
            }
        }
    
    @RequestMapping(value="/buscar/porNombre", method=RequestMethod.POST)
    public String buscarHeroeNombre(Heroe heroe, ModelMap mp){
    	
    	
    	List<Heroe> posibleHeroe = rh.findByName(heroe.getNombre());
    	

            if (!posibleHeroe.isEmpty()) {
            	mp.put("heroes", posibleHeroe);
                return "/mostrar/porNombre";
            	
            }
            else {
            	return "/error/noExisteEntidad";
            }
        }
    
    //TODO
    @RequestMapping(value="/cambiarVida", method=RequestMethod.POST)
    public String cambiarVida(Heroe heroe, ModelMap mp){
    	
    	
    	heroe = rh.findById(heroe.getHeroeId()).get();
    	if(heroe.isVivo()) {
    		heroe.matar();
    	}
    	else {
    		heroe.resucitar();
    	}
    	
    	rh.save(heroe);

    	
    	
    		return "x";
        }
   
    @RequestMapping(value="/buscarPorId", method = RequestMethod.GET)
    public String vistaId(Heroe heroe,ModelMap mp){
	    return "/buscar/porId"; 
	}
    
    @RequestMapping(value="/buscarPorNombre", method = RequestMethod.GET)
    public String vistaNombre(Heroe heroe,ModelMap mp){
	    return "/buscar/porNombre"; 
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
    
