/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

/**
 *
 * @author queima rosca
 */
public class Filme {
    private Integer id;
    private String nome;
    private Estudio estudio;
    private Dublador dublador;
    
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

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Dublador getDublador() {
        return dublador;
    }

    public void setDublador(Dublador dublador) {
        this.dublador = dublador;
    }

//    @Override
//    public String toString() {
//        return nome ;
//    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nome=" + nome + ", estudio=" + estudio + ", dublador=" + dublador + '}';
    }
    
    
    
    
}
