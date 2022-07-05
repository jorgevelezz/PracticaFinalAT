package com.example.demo.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Heroe;
import com.example.demo.service.HelloService;


@Controller
public class controladorCrud {

	@Autowired
	private HelloService hc;

	/*
	public controladorCrud(HelloService helloService) {
		this.helloService = helloService;
	}*/

    
    @RequestMapping(value="/lista", method = RequestMethod.GET)
    public String listaHeroes(ModelMap mp){
        mp.put("heroes", hc.findAll());
        return "lista";
    }
 
 
}
