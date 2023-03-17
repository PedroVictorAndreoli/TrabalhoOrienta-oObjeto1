/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Dublador;
import br.edu.utfpr.entidades.Estudio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author queima rosca
 */
public abstract class AbstractModel<T> extends AbstractTableModel{
     protected List<T> listaObjeto;
     protected String[] colunas = new String[]{} ;
     
     
     
     public void setColuna(String[] colunas){
         
        this.colunas = colunas;
     }
      
     public AbstractModel(List<T> listaObjeto) {
        this.listaObjeto= listaObjeto;
    }
    

    @Override
    public int getRowCount() {
        return listaObjeto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length; 
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    public void insertModel(T objeto) {
        listaObjeto.add(objeto);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaObjeto.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha,T objeto) {
        listaObjeto.set(indiceLinha, objeto);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
}
