package com.example.demo.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repos.RepHeroes;
import com.example.demo.repos.RepPoderes;


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

	/*
	Constructor:
	
	public controladorCrud(RepPoderes rp) {
		this.rp = rp;
	}
	
	*/


	//D
    @RequestMapping(value="/lista", method = RequestMethod.GET)
    public String lista(
    		@RequestParam("entidad") String entidad,
    		ModelMap mp){
    	
    		switch (entidad) {
    		case "heroes":
    			mp.put("heroes", rh.findAll());
    	        return "listaHeroes";
    		case "poderes":
    			mp.put("poderes", rp.findAll());
    	        return "listaPoderes";
    		case "universos":
    			mp.put("universos", rh.findAll());
    	        return "listaUniversos";
    	    default:
    	    	return "X";	
    		}
    	
    	}
    		
        
    }
    
