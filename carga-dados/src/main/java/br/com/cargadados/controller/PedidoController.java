package br.com.cargadados.controller;


import br.com.cargadados.model.Pedido;
import br.com.cargadados.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    PedidoRepository repository;

    @GetMapping("/pedidos")
    public ModelAndView index(){


        List<Pedido> pedidos = (List<Pedido>) this.repository.findAll();

        ModelAndView mv = new ModelAndView("pedidos/index");
        mv.addObject("pedidos",pedidos);

        return mv;

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
