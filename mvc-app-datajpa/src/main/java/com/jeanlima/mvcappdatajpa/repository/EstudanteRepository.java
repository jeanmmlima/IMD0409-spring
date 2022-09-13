package com.jeanlima.mvcappdatajpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jeanlima.mvcappdatajpa.model.Estudante;

@Repository
public class EstudanteRepository {
    //utilizando entity manager!
    @Autowired
    private EntityManager entityManager;


    //preciso anotar com transactional para dizer que vai fazer uma transação com o banco (commit and finish)
    @Transactional
    public Estudante salvar(Estudante estudante){
        entityManager.persist(estudante);
        return estudante;
    }

    @Transactional
    public Estudante atualizar(Estudante estudante){
        entityManager.merge(estudante);
        return estudante;
    }

    @Transactional
    public void deletar(Estudante estudante){
        if(!entityManager.contains(estudante)){
            estudante = entityManager.merge(estudante);
        }
        entityManager.remove(estudante);
    }

    @Transactional
    public void deletaById(Integer id){
        Estudante estudante = entityManager.find(Estudante.class, id);
        deletar(estudante);
    }


    @Transactional(readOnly = true)
    public List<Estudante> buscarPorNome(String nome){
        //:nome serve para definir o parametro jpa
        String jpql = " select c from Estudante c where c.nome like :nome";
        TypedQuery<Estudante> query = entityManager.createQuery(jpql,Estudante.class);
        query.setParameter("nome", "%"+nome+"%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Estudante> obterTodos(){
        return entityManager
        .createQuery("from Estudante",Estudante.class)
        .getResultList();
        
    }

    @Transactional(readOnly = true)
    public Estudante obterPorId(Integer id){
        return entityManager.find(Estudante.class, id);
    }
}
