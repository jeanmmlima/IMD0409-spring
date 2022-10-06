package com.jeanlima.springrestapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.repository.ClienteRepository;

@Controller
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController( ClienteRepository clienteRepository ) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/api/clientes/{id}") //requestMapping especializado
    @ResponseBody //sem o responseBody espera o retorno String: url da página que deve acessar
    public ResponseEntity<Cliente> getClienteById( @PathVariable Integer id ){ //se o nome do parametro for diferente de id. Ex: @PathVariable("codigoCliente") Integer id
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            /*
             * ResponseEntity - representa o copor da resposta. Padrão: json :)
             * HttpHeaders headers = new HttpHeaders();
             * headers.put("Authorization","token");
             * new ResponseEntity<>(cliente.get(), headers, HttpStatus.Ok);
             */
            return ResponseEntity.ok( cliente.get() ); //status 200 - ok
        }

        return ResponseEntity.notFound().build(); //status 404 - nao encontrado
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity<Cliente> saveCliente( @RequestBody Cliente cliente ){ //objeto mapeado no corpo da requisicao
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo); //retorna o cliente persistido 
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity deleteCliente(@PathVariable Integer id){ //objeto mapeado no corpo da requisicao
        
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build(); //nao retorna nada no corpo
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity updateCliente( @PathVariable Integer id,
                                  @RequestBody Cliente cliente ){
        return clienteRepository
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() ); //nao encontrou o cliente
    }

    @GetMapping("/api/clientes")
    public ResponseEntity findCliente( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase() //ignorar case sensitive
                                    .withStringMatcher( //filtro de String - nesse caso é conter ou não. Ex: buscar os clientes com A no nome.
                                            ExampleMatcher.StringMatcher.CONTAINING );

        //objeto que vai pegar o cliente passado e verificar os campos populados com os critérios do matcher.
        Example example = Example.of(filtro, matcher);

        List<Cliente> lista = clienteRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }

}
