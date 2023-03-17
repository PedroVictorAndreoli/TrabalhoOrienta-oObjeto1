/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

/**
 *
 * @author queima rosca
 */
public class Estudio {
    private Integer id;
    private String nome;
    private Long CNPJ;

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

    public Long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Long CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
