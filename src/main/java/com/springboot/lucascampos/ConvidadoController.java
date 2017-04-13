package com.springboot.lucascampos;

import com.springboot.lucascampos.model.Convidado;
import com.springboot.lucascampos.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String save(Model model, @RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone) {

        Convidado convidado = new Convidado(nome, email, telefone);

        repository.save(convidado);

        model.addAttribute("convidados", repository.findAll());

        return "listaconvidados";
    }

    @RequestMapping(value = "{id}")
    public String delete(Model model, @PathVariable ("id") Long id) {

        repository.delete(id);

        model.addAttribute("convidados", repository.findAll());

        return "listaconvidados";
    }

}
