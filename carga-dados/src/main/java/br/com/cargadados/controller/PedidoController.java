package br.com.cargadados.controller;


import br.com.cargadados.dto.RequisicaoNovoPedido;
import br.com.cargadados.model.Pedido;
import br.com.cargadados.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    PedidoRepository repository;

    @GetMapping("/pedidos")
    public ModelAndView index(){
        List<Pedido> pedidos =  this.repository.findAll();

        ModelAndView mv = new ModelAndView("/pedidos/index");
        mv.addObject("pedidos",pedidos);

        return mv;

    }


    @GetMapping("/pedidos/new")
    public ModelAndView nnew(){

        ModelAndView mv = new ModelAndView("pedidos/new");
//        mv.addObject("pedidos",pedidos);
        return mv;
    }

    @PostMapping("/pedidos")
    public ModelAndView create(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result){
        if(result.hasErrors()){
            System.out.println("\n**************** Tem erros ****************************\n");
            ModelAndView mv = new ModelAndView("pedidos/new");

            return mv;

        }else {

            Pedido pedido = requisicaoNovoPedido.toPedido();
            this.repository.save(pedido);
            return new ModelAndView("redirect:/pedidos");
        }
    }



}
























