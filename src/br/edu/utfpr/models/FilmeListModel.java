/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Estudio;
import br.edu.utfpr.entidades.Filme;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class FilmeListModel extends AbstractModel<Filme>{
    
    String[]colunas = new String[]{"Id", "Nome", "Dublador", "Estudio"};

    public FilmeListModel(List<Filme> listaObjeto) {
        super(listaObjeto);
        super.setColuna(colunas);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Filme filme = listaObjeto.get(row);
        switch (column) {
            case 0:
                return filme.getId();
            case 1:
                return filme.getNome();
            case 2:
                return filme.getDublador();
            case 3:
                return filme.getEstudio();
            default:
                break;
        }
        return filme;    
    }
     @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            default:
               throw new RuntimeException("Coluna inexistente");
        }
    }

    
}
