/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Dublador;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DubladorListModel extends AbstractModel<Dublador>{
    

    private String[] colunas = new String[]{"Id", "Nome", "DRT"};

    public DubladorListModel(List<Dublador> listaObjeto) {
        super(listaObjeto);
        super.setColuna(colunas);
    }
  
    @Override
    public Object getValueAt(int row, int column) {
       Dublador dublador = listaObjeto.get(row);
        switch (column) {
            case 0:
                return dublador.getId();
            case 1:
                return dublador.getNome();
            case 2:
                return dublador.getDRT();
            default:
                break;
        }
        return dublador;
    }
    
    
    
}
