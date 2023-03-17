/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private final String URL = "jdbc:postgresql://localhost:5432/PedroAndreoli";
    private final String USUARIO = "postgres";
    private final String SENHA = "123";
    private Connection conexao;
    private static Conexao instancia;

    private Conexao() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectou");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao conectar. " + ex.getMessage());
        }

    }

    public Connection getConexao() {
        return conexao;
    }
    
    
    public static Conexao getInstance(){
       if(instancia == null){
          instancia = new Conexao();
       }
       
       return instancia;
    }

    public static void main(String[] args) {
        getInstance();
    }
}