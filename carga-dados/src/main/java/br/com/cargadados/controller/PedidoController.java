package br.com.cargadados.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidoController {

    @GetMapping("/pedidos")
    public String index(){
        return "pedidos/index";

    }


//    @GetMapping("/hello-model")
//    public ModelAndView hello(){
//       ModelAndView mv = new ModelAndView("hello");
//       mv.addObject("nome", "Joana");
//        return mv;
//
//    }
//
//    @GetMapping("/hello")
//    public String hello(Model model){
//        model.addAttribute("nome", "Maria");
//        return "hello";
//    }



}
