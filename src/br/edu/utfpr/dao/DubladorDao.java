/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Dublador;
import java.io.File;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DubladorDao  extends AbstractDaoImpl<Dublador> {
    private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public Dublador insert(Dublador dublador) {
         try {
            pstm = getConn().prepareStatement("INSERT INTO dublador "
                    + "(nome, DRT) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
//Statement.RETURN_GENERATED_KEYS permite recuperar as chaves geradas automaticamente por meio do método getGeneratedKeys
            pstm.setString(1, dublador.getNome());
            pstm.setLong(2, dublador.getDRT());
            if (pstm.executeUpdate() > 0) { //Executa uma instrução SQL referente a um INSERT, UPDATE e DELETE, o retorno é o número de linhas afetadas
                rs = pstm.getGeneratedKeys();//Recupera todas as chaves geradas automaticamente 
                rs.next();
                dublador.setId(rs.getInt("id"));
                return dublador;
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
    public Dublador update(Dublador dublador) {
        try {
            pstm = getConn().prepareStatement("UPDATE dublador "
                    + "SET nome=?, DRT=? "
                    + "WHERE id=?");

            pstm.setString(1, dublador.getNome());
            pstm.setLong(2, dublador.getDRT());
            pstm.setInt(3, dublador.getId());
            if (pstm.executeUpdate() > 0) {
                return dublador;
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
             pstm = getConn().prepareStatement("DELETE FROM dublador WHERE ID = ?");
             pstm.setInt(1, codigo);
             pstm.executeUpdate();
             return true;
         } catch (SQLException ex) {
             String erro = "erro ao excluir o dublador  "+ ex.getMessage();
             JOptionPane.showMessageDialog(null,erro);
             Arquivos arquivos = new Arquivos();
             arquivos.gravar(erro);
             return false;
         }finally{
         super.closePreparedStatement(pstm);
         }
    }

    @Override
    public Dublador findById(int codigo) {
        Dublador dublador = new Dublador();
        try {
            pstm = getConn().prepareStatement("SELECT * FROM DUBLADOR WHERE ID = ?");
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
    public List<Dublador> findAll() {
      try {
            pstm = getConn().prepareStatement("SELECT * FROM dublador");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public Dublador mount(ResultSet res) {
        try {
            Dublador dublador = new Dublador();
            dublador.setId(res.getInt("id"));
            dublador.setNome(res.getString("nome"));
            dublador.setDRT(res.getLong("DRT"));
            return dublador;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar dublador: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Dublador> mountList(ResultSet res) {
    List<Dublador> listaDublador = new ArrayList();
        try {
            while (res.next()) {
                Dublador dublador = mount(res);
                listaDublador.add(dublador);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
        }
        return listaDublador;    
    }
    
    public List<Dublador> mountList() {
    List<Dublador> listaDublador = new ArrayList();
        try {
            while (rs.next()) {
                Dublador dublador = mount(rs);
                listaDublador.add(dublador);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
        }
        return listaDublador;    
    }

}
