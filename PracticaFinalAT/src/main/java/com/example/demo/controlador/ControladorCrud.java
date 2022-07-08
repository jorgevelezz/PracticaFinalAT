package com.example.demo.controlador;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.example.service.HeroePoderService;
import com.demo.example.service.HeroeService;
import com.demo.example.service.PoderService;
import com.demo.example.service.UniversoService;
import com.example.demo.dto.HeroeDTO;
import com.example.demo.dto.PoderDTO;
import com.example.demo.dto.UniversoDTO;
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
public class ControladorCrud {

	
	@Autowired
	private HeroeService heroeService;
	
	/*
	Constructor:
	
	public controladorCrud(HeroeService heroeService) {
		this.heroeService = heroeService;
	}
	
	*/
	
	@Autowired
	private PoderService poderService;
	
	@Autowired
	private UniversoService universoService;
	
	@Autowired
	private HeroePoderService heroePoderService;
	

	private ModelMapper modelMapper = new ModelMapper();

	static final String ERRORENTIDAD = "/error/noExisteEntidad";
	
	static final String SHEROE = "heroe";
	
	static final String SHEROES = "heroes";
	
	static final String SPODER = "poder";
	
	static final String SUNIVERSO = "universo";
	
	static final String SPODERES = "poderes";
	
	static final String SUNIVERSOS = "universos";
	
	
    @GetMapping(value="/lista")
    public String lista(
    		@RequestParam("entidad") String entidad,
    		ModelMap mp){
    	
    		switch (entidad.toLowerCase()) {
    		case SHEROES:
    			
    			mp.put(SHEROES, heroeService.findAll());
    			mp.put("heroePoder", heroePoderService.findAll());
    	        return "/list/listaHeroes";
    	        
    		case SPODERES:
    			
    			mp.put(SPODERES, poderService.findAll());
    	        return "/list/listaPoderes";
    	        
    		case SUNIVERSOS:
    			
    			mp.put(SUNIVERSOS, universoService.findAll());
    	        return "/list/listaUniversos";
    	        
    	    default:
    	    	return ERRORENTIDAD;
    		}
    	
    	}
    
    @GetMapping(value="/create" )
    public String crear(@RequestParam("entidad") String entidad,
    		ModelMap mp){
    	
    	switch (entidad) {
    	
			case SHEROE:
				
	    		mp.put(SHEROE, new Heroe());
	    		mp.put(SUNIVERSOS, universoService.findAll());
	    	    return "/create/createHeroe"; 
	
			case SPODER:
				
	    		mp.put(SPODER, new Poder());
	    	    return "/create/createPoder"; 
	    	    
			case SUNIVERSO:
	    		mp.put(SUNIVERSO, new Universo());
	    	    return "/create/createUniverso"; 
		    
			default:
		    	return ERRORENTIDAD;	
		}
    	

    	
    	}
    
    @PostMapping(value="/create/createHeroe")
    public String crearHeroe(@Valid @ModelAttribute HeroeDTO heroe,
            BindingResult bindingResult, ModelMap mp){
    	
    	//Comprueba si se cumplen los requisitos establecidos en la clase Heroe
    	//Size,NonNull...
        if(bindingResult.hasErrors()){
            mp.put(SHEROE, heroeService.findAll());
            return crear(SHEROE,mp);
            
        }else{
        	
        	heroeService.save(modelMapper.map(heroe, Heroe.class));
            mp.put(SHEROE, heroe);
            return lista(SHEROES,mp);
        }
    }
    @PostMapping(value="/create/createUniverso")
    public String crearUniverso(@Valid UniversoDTO universo,
            BindingResult bindingResult, ModelMap mp){
    	
        if(bindingResult.hasErrors()){
            mp.put(SUNIVERSOS, universoService.findAll());
            return crear(SUNIVERSO,mp);
            
        }else{
        	universoService.save(modelMapper.map(universo, Universo.class));
            mp.put(SUNIVERSO, universo);
            
            return lista(SUNIVERSOS,mp);
        }
    }
    
    @PostMapping(value="/create/createPoder")
    public String crearPoder(@Valid PoderDTO poder,
            BindingResult bindingResult, ModelMap mp){
    	
        if(bindingResult.hasErrors()){
            mp.put(SUNIVERSOS, universoService.findAll());
            return crear(SPODER,mp);
            
        }else{
        	poderService.save(modelMapper.map(poder, Poder.class));
            mp.put(SPODER, poder);
            return lista(SPODERES,mp);
        }
    }
    
    @PostMapping(value="/delete/Heroe")
    public String eliminarHeroe(HeroeDTO heroe, ModelMap mp){
    	
    		//Primero borramos sus poderes
    		heroePoderService.deleteAllPoderHeroe(modelMapper.map(heroe, Heroe.class));
    		//Luego al héroe
    		heroeService.delete(modelMapper.map(heroe, Heroe.class));
    		
    		return lista(SHEROES,mp);
        }
    
    @PostMapping(value="/delete/Poder")
    public String eliminarPoder(PoderDTO poder, ModelMap mp){
    	
    	poderService.delete(modelMapper.map(poder, Poder.class));
            return lista(SPODERES,mp);
        }
    
    @PostMapping(value="/delete/Universo")
    public String eliminarPoder(UniversoDTO universo, ModelMap mp){
    	
    		universoService.delete(modelMapper.map(universo, Universo.class));
            return "delete/Universo";
        }
    
    
    @RequestMapping(value="verPoder")
    public String verPoder(HeroeDTO heroe, ModelMap mp){	
    	
    	mp.addAttribute(SHEROE, heroe);
    	
    	mp.put(SPODERES, heroePoderService.findByHeroe(modelMapper.map(heroe, Heroe.class)));
		
        return "asign/verPoder";
        }
    
    
    @RequestMapping(value="/seleccionarPoder/{id}")
    public String seleccionarPoder(@PathVariable int id,ModelMap mp){
    	
    	mp.addAttribute("idHeroe", id);
    	
    	
    	mp.addAttribute(SPODERES, poderService.findAll());
    	
    	return "asign/seleccionarPoder";
	 	
        }
    
    @RequestMapping(value="/darPoder/{id}")
    public String darPoder(@PathVariable int id,PoderDTO poder,ModelMap mp){
    	
    	Optional<Heroe> heroe = heroeService.findById(id);
    	
    	if(heroe.isPresent()) {
    	
    		heroePoderService.save(new HeroePoder(new HeroePoderKey(id,poder.getPoderId()),heroe.get(),modelMapper.map(poder, Poder.class)));
    	
    		return verPoder(modelMapper.map(heroe.get(), HeroeDTO.class),mp);
    	}
    	
    	else {
    		
    		return ERRORENTIDAD;
    	}
	
    	
        }

    @PostMapping(value="/delete/HeroePoder")
    public String eliminarPoder(HeroePoderKey heroePoder, ModelMap mp){
    	
    	heroePoderService.deletePoderHeroe(heroePoder);
    	
    	Optional <Heroe> heroe = heroeService.findById(heroePoder.getHeroeId());
    	
    	if(heroe.isPresent()) {
    		
    		return verPoder(modelMapper.map(heroe.get(), HeroeDTO.class),mp);
    		
    	}
    	
    	return "error/noExisteEntidad";
            
        }
    
    @RequestMapping(value = "/editar/{letra}/{id}")
    public String mostrarFormularioEditar(@PathVariable String letra,@PathVariable int id, ModelMap model) 
    {
    	
    	if(letra.equals("H")) {
        model.addAttribute(SHEROE, heroeService.findById(id).orElse(null));
        model.addAttribute(SUNIVERSOS, universoService.findAll());
        return "edit/Heroe";
    	}
    	else if (letra.equals("P")) {
    		model.addAttribute(SPODER, poderService.findById(id).orElse(null));
            return "edit/Poder";
    		
    	}
    	else{
    		model.addAttribute(SUNIVERSO, universoService.findById(id).orElse(null));
            return "edit/Universo";
    	}
    }
    
    @PostMapping(value = "/edit/Heroe/{id}")
    public String actualizarHeroe(@Valid HeroeDTO heroe, ModelMap model) 
    {
    	

        Optional<Heroe> posibleHeroe = heroeService.findById(heroe.getHeroeId());
        

        if (posibleHeroe.isPresent()) {
        	
        	heroeService.save(modelMapper.map(heroe, Heroe.class));
        	return lista(SHEROES,model);
        }
        
        else {
        	
        	return ERRORENTIDAD;
        }
        
        
    }
    
    @PostMapping(value = "/edit/Poder/{id}")
    public String actualizarPoder(@Valid PoderDTO poder, ModelMap model) 
    {

    		poderService.save(modelMapper.map(poder, Poder.class));
         	return lista(SPODERES,model);
 

    }
    
    @PostMapping(value = "/edit/Universo/{id}")
    public String actualizarUniverso(@Valid UniversoDTO universo, ModelMap model) 
    {

        Optional<Universo> posibleUniverso = universoService.findById(universo.getUniversoId());

        if (posibleUniverso.isPresent()) {
        	
        	universoService.save(modelMapper.map(universo, Universo.class));
        	return lista(SUNIVERSOS,model);
        }
        else {
        	
        	return ERRORENTIDAD;
        }
        
        
    }
    
    
    @PostMapping(value="/buscar/porId")
    public String buscarHeroeId(HeroeDTO heroe, ModelMap mp){
    	
    	Optional<Heroe> posibleHeroe = heroeService.findById(heroe.getHeroeId());

            if (posibleHeroe.isPresent()) {
            	mp.put(SHEROE, posibleHeroe.get());
                return "/mostrar/porId";
            	
            }
            else {
            	return ERRORENTIDAD;
            }
        }
    
    @PostMapping(value="/buscar/porNombre")
    public String buscarHeroeNombre(HeroeDTO heroe, ModelMap mp){
    	
    	
    	List<Heroe> posibleHeroe = heroeService.findByName(heroe.getNombre());
    	

            if (!posibleHeroe.isEmpty()) {
            	mp.put(SHEROES, posibleHeroe);
                return "/mostrar/porNombre";
            	
            }
            else {
            	return ERRORENTIDAD;
            }
        }
    
    @PostMapping(value="/cambiarVida")
    public String cambiarVida(HeroeDTO heroeDTO, ModelMap mp){
    	
    	
    	Optional<Heroe >posibleHeroe = heroeService.findById(heroeDTO.getHeroeId());
    	
    	if(posibleHeroe.isPresent()) {		
    		
    		Heroe heroe = posibleHeroe.get();
    		
    		if(heroe.isVivo()) {
    			
        		heroe.matar();
        	}
        	else {
        		
        		heroe.resucitar();
        	}
        	
    		heroeService.save(modelMapper.map(heroe, Heroe.class));
	
    	}
    	
    	
    	return lista(SHEROES,mp);
        }
   
    @GetMapping(value="/buscarPorId")
    public String vistaId(HeroeDTO heroe,ModelMap mp){
    	
	    return "/buscar/porId"; 
	}
    
    @GetMapping(value="/buscarPorNombre")
    public String vistaNombre(HeroeDTO heroe,ModelMap mp){
	    return "/buscar/porNombre"; 
	}
    
  
   
    ///INICIO
    @GetMapping(value="/")
    public String inicio(ModelMap mp){
	    return "/inicio"; 
	}
    
    @GetMapping(value="/inicio")
    public String inicio2(ModelMap mp){
	    return "/inicio"; 
	}
        
    }
    
