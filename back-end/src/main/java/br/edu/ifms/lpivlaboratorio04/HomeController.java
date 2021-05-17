package br.edu.ifms.lpivlaboratorio04;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @GetMapping("/home")
    public ModelAndView home(){
        String[] frutas = {"Banana","Laranja","Maçã"}; 

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("meunome", "Gustavo Maruyama");
        modelAndView.addObject("data", new Date());
        modelAndView.addObject("frutas", frutas);
        return modelAndView;

    }
}
