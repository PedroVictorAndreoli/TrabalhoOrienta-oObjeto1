/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Dublador;
import br.edu.utfpr.entidades.Estudio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author queima rosca
 */
public class EstudioDao extends AbstractDaoImpl<Estudio> {
     private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public Estudio insert(Estudio estudio) {
         try {
            pstm = getConn().prepareStatement("INSERT INTO estudio "
                    + "(nome, CNPJ) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
//Statement.RETURN_GENERATED_KEYS permite recuperar as chaves geradas automaticamente por meio do método getGeneratedKeys
            pstm.setString(1, estudio.getNome());
            pstm.setLong(2, estudio.getCNPJ());
            if (pstm.executeUpdate() > 0) { //Executa uma instrução SQL referente a um INSERT, UPDATE e DELETE, o retorno é o número de linhas afetadas
                rs = pstm.getGeneratedKeys();//Recupera todas as chaves geradas automaticamente 
                rs.next();
                estudio.setId(rs.getInt("id"));
                return estudio;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dublador " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public Estudio update(Estudio estudio) {
         try {
            pstm = getConn().prepareStatement("UPDATE estudio "
                    + "SET nome=?, CNPJ=? "
                    + "WHERE id=?");

            pstm.setString(1, estudio.getNome());
            pstm.setLong(2, estudio.getCNPJ());
            pstm.setInt(3, estudio.getId());
            if (pstm.executeUpdate() > 0) {
                return estudio;
            }
            return null;

            // Se a atualização acontecer corretamente, o valor é a quantidade de linhas afetada na execuação,
            //senão retorna 0 indicando que a  atualização não afetou nenhuma linha.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar item do pedido. " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public boolean delete(int codigo) {
        try {
             pstm = getConn().prepareStatement("DELETE FROM estudio WHERE ID = ?");
             pstm.setInt(1, codigo);
             pstm.executeUpdate();
             return true;
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"erro ao excluir o estudio  "+ ex.getMessage());
             Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
             return false;
         }finally{
         super.closePreparedStatement(pstm);
         }
    }

    @Override
    public Estudio findById(int codigo) {
     Estudio estudio = new Estudio();
        try {
            pstm = getConn().prepareStatement("SELECT * FROM estudio WHERE ID = ?");
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()){
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao retornar objeto dublador"+ ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        }    
    }

    @Override
    public List<Estudio> findAll() {
      List<Estudio> listaEstudios = new ArrayList<>();
      try {
            pstm = getConn().prepareStatement("SELECT * FROM estudio");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
      return listaEstudios;
    }

    @Override
    public Estudio mount(ResultSet res) {
        try {
            Estudio estudio = new Estudio();
            estudio.setId(res.getInt("id"));
            estudio.setNome(res.getString("nome"));
            estudio.setCNPJ(res.getLong("CNPJ"));
            return estudio;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar estudio: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Estudio> mountList(ResultSet res) {
    List<Estudio> listaEstudio = new ArrayList();
        try {
            while (res.next()) {
                Estudio estudio = mount(res);
                listaEstudio.add(estudio);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
        }
        return listaEstudio;    
    }
    
    public List<Estudio> mountList() {
    List<Estudio> listaEstudio = new ArrayList();
        try {
            while (rs.next()) {
                Estudio estudio = mount(rs);
                listaEstudio.add(estudio);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
        }
        return listaEstudio;    
    }
}
