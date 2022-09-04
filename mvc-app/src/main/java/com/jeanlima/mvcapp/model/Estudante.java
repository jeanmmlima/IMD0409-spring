package com.jeanlima.mvcapp.model;


public class Estudante {


    private int id;
    private String primeiroNome;
    private String ultimoNome;
    private String curso;
    private String linguagem;
    private String email;

    private String[] sistemasOperacionas;


    private final String[] cursos = {
        "BTI", "EngSoft", "EngComp"
    };

    public Estudante(){

    }


    public Estudante(String primeiroNome, String ultimoNome, String curso, String linguagem, String email) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.curso = curso;
        this.linguagem = linguagem;
        this.email = email;
    }



    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    public String getUltimoNome() {
        return ultimoNome;
    }
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
    @Override
    public String toString() {
        return "Estudante [primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + "]";
    }
    public String[] getCursos() {
        return cursos;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getLinguagem() {
        return linguagem;
    }
    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
    public String[] getSistemasOperacionas() {
        return sistemasOperacionas;
    }
    public void setSistemasOperacionas(String[] sistemasOperacionas) {
        this.sistemasOperacionas = sistemasOperacionas;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
    
}
