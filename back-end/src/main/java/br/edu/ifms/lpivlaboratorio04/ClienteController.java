package br.edu.ifms.lpivlaboratorio04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    List<Cliente> clientes;
    Integer contador = 2;

    public ClienteController(){
        clientes = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente(1, "João", "joao@gmail.com");
        Cliente cliente2 = new Cliente(2, "Maria", "maria@hotmail.com");
        clientes.add(cliente1);
        clientes.add(cliente2);
    }

    @GetMapping("/listagem")
    public ModelAndView listagem(){
        ModelAndView modelAndView = new ModelAndView("cliente/listagem");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @GetMapping("/formulario")
    public String formulario(Cliente cliente){
        return "cliente/formulario";
    }

    @GetMapping("/formulario/{id}")
    public ModelAndView formularioEdicao(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                modelAndView.addObject("cliente", cliente);
                break;
            }
        }
        return modelAndView;
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente){
        cliente.setId(++contador);
        clientes.add(cliente);
        return "redirect:/cliente/listagem";
    }

    @PostMapping("/atualizar")
    public String atualizar(Cliente clienteAtualizado){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(clienteAtualizado.getId())){
                clientes.remove(cliente);
                clientes.add(clienteAtualizado);
                break;
            }
        }
        return "redirect:/cliente/listagem";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Integer id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                break;
            }
        }
        return  "redirect:/cliente/listagem";
    }
    
}
