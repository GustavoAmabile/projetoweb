package br.com.ada.locate.controller;


import br.com.ada.locate.model.Aluguel;
import br.com.ada.locate.model.Cliente;
import br.com.ada.locate.model.Veiculo;
import br.com.ada.locate.service.AluguelService;
import br.com.ada.locate.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    private ClienteService clienteService;

    @GetMapping("/alugueis")
    public String clientes(Model model) {
        List<Aluguel> alugueis = this.aluguelService.listarTodos();
        model.addAttribute("alugueis", alugueis);
        return "alugueis";
    }

    @GetMapping("/aluguel/add")
    public String addAluguel(Model model) {
        model.addAttribute("aluguel", new Aluguel());

        return "aluguel-add";
    }

    @PostMapping("/aluguel/add")
    public String criarAluguel(@ModelAttribute("aluguel")Aluguel aluguel) {
        Cliente cliente = aluguel.getCliente();
        Veiculo veiculo = aluguel.getVeiculo();
        this.aluguelService.createAluguel(aluguel);
        return "redirect:/alugueis";
    }







}
