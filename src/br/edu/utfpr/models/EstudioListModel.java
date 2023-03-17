/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Estudio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EstudioListModel extends AbstractModel<Estudio> {

    private String[] colunas = new String[]{"Id", "Nome", "CNPJ"};

    public EstudioListModel(List<Estudio> listaObjeto) {
        super(listaObjeto);
        super.setColuna(colunas);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Estudio estudio = listaObjeto.get(row);
        switch (column) {
            case 0:
                return estudio.getId();
            case 1:
                return estudio.getNome();
            case 2:
                return estudio.getCNPJ();
            default:
                break;
        }
        return estudio;    
    }
    
}
