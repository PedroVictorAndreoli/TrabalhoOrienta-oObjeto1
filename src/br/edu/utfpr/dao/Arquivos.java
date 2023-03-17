/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;

/**
 *
 * @author queima rosca
 */
public class Arquivos {
   private String erro ;

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Arquivos() {
    }
    
    public void gravar(String erro){
       try ( FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\log.txt");  PrintWriter pw = new PrintWriter(fw,true)) {
            pw.println(erro);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o arquivo. "
                    + ex.getMessage());
        }
    }
}
