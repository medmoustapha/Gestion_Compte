package gestion.compte.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompteController{
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}

}
