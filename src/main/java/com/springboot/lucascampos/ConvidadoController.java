package com.springboot.lucascampos;

import com.springboot.lucascampos.model.Convidado;
import com.springboot.lucascampos.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository repository;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/lista-convidados")
    public String list(Model model) {
        Iterable<Convidado> convidados = repository.findAll();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

}
