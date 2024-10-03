package com.curriculo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String sexo;
    private String formacaoAcademica;
    private String experiencia;
    private String cursosLivres;
    private String certificacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getCursosLivres() {
        return cursosLivres;
    }

    public void setCursosLivres(String cursosLivres) {
        this.cursosLivres = cursosLivres;
    }

    public String getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }

    // Método para atualizar dados de um currículo existente
    public void atualizarDados(Curriculo novoCurriculo) {
        this.nome = novoCurriculo.getNome();
        this.idade = novoCurriculo.getIdade();
        this.sexo = novoCurriculo.getSexo();
        this.formacaoAcademica = novoCurriculo.getFormacaoAcademica();
        this.experiencia = novoCurriculo.getExperiencia();
        this.cursosLivres = novoCurriculo.getCursosLivres();
        this.certificacao = novoCurriculo.getCertificacao();
    }
}
