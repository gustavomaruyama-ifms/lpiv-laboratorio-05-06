package br.edu.ifms.lpivlaboratorio04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/cliente")
@CrossOrigin(origins = "*")
public class ClienteRestController {
    List<Cliente> clientes;
    Integer contador = 2;

    public ClienteRestController(){
        clientes = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente(1, "João", "joao@gmail.com");
        Cliente cliente2 = new Cliente(2, "Maria", "maria@hotmail.com");
        clientes.add(cliente1);
        clientes.add(cliente2);
    }

    @GetMapping
    public List<Cliente> listar(){
        return clientes;
    }

    @PostMapping
    public void salvar(@RequestBody Cliente cliente){
        cliente.setId(++contador);
        clientes.add(cliente);
    }

    @PutMapping
    public void atualizar(@RequestBody Cliente clienteAtualizado){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(clienteAtualizado.getId())){
                clientes.remove(cliente);
                clientes.add(clienteAtualizado);
                break;
            }
        }
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                break;
            }
        }
    }
}
