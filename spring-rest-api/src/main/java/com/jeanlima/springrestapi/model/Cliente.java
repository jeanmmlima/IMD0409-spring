package com.jeanlima.springrestapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente") //opicional caso a tabela tenha nome igual da entidadeou caso use schema!
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nome;

    @Column(length = 11)
    private String cpf;

    //um cliente pode ter muitos pedidos
    /*
     * mappedBy --> para a partir da classe cliente eu possa mapear/retornar os pedidos
     * passo como parametro o campo, na tabela de pedidos, que faz referencia a cliente.
     * no caso é cliente.
     * 
     * fetch  --> Lazy ou Eager - CUIDADO!!!
     */
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    
    public Cliente() {
    }
    public Cliente(String nome) {
        this.nome = nome;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

    
    
}
