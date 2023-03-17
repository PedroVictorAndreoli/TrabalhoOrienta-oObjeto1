/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Dublador;
import br.edu.utfpr.entidades.Estudio;
import br.edu.utfpr.entidades.Filme;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author queima rosca
 */
public class FilmeDao extends AbstractDaoImpl<Filme>  {
     private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public Filme insert(Filme filme) {
         try {
            pstm = getConn().prepareStatement("INSERT INTO filme (idestudio, iddublador, nome) "
                    + "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            //permite recuperar as chaves geradas automaticamente no banco de dados
            pstm.setInt(1, filme.getEstudio().getId());
            pstm.setInt(2, filme.getDublador().getId());
            pstm.setString(3, filme.getNome());
            if (pstm.executeUpdate() > 0) {//se inseriu
                rs = pstm.getGeneratedKeys();
                rs.next();
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir filme " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public Filme update(Filme filme) {
         try {
            pstm = getConn().prepareStatement("UPDATE filme "
                    + "SET nome=?, idestudio=?,iddublador=? "
                    + "WHERE id=?");

            pstm.setString(1, filme.getNome());
            pstm.setInt(2, filme.getEstudio().getId());
            pstm.setInt(3, filme.getDublador().getId());
            pstm.setInt(4, filme.getId());
            if (pstm.executeUpdate() > 0) {
                return filme;
            }
            return null;

            // Se a atualização acontecer corretamente, o valor é a quantidade de linhas afetada na execuação,
            //senão retorna 0 indicando que a  atualização não afetou nenhuma linha.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar filme. " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public boolean delete(int codigo) {
         try {
             pstm = getConn().prepareStatement("DELETE FROM FILME WHERE ID = ?");
             pstm.setInt(1, codigo);
             pstm.executeUpdate();
             return true;
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"erro ao excluir a locacao "+ ex.getMessage());
             return false;
         }finally{
         super.closePreparedStatement(pstm);
         }
    
    }

    @Override
    public Filme findById(int codigo) {
        Filme filme = new Filme();
        try {
            pstm = getConn().prepareStatement("SELECT * FROM filme WHERE ID = ?");
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()){
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao retornar objeto filme"+ ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Filme> findAll() {
        try {
            pstm = getConn().prepareStatement("SELECT * FROM filme");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public Filme mount(ResultSet res) {
         try {
            Estudio estudio = new Estudio();
            estudio.setId(res.getInt("idestudio"));
            Dublador dublador = new Dublador();
            dublador.setId(res.getInt("iddublador"));
            Filme filme = new Filme();
            filme.setId(res.getInt("id"));
            filme.setEstudio(estudio);
            filme.setDublador(dublador);
            filme.setNome(rs.getString("nome"));
            return filme;
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDao.class.getName()).log(Level.SEVERE, null, ex);
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Filme> mountList(ResultSet res) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Filme> mountList() {
    List<Filme> listaFilme = new ArrayList();
        try {
            while (rs.next()) {
                Filme filme = mount(rs);
                listaFilme.add(filme);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Arquivos arquivos = new Arquivos();
            arquivos.gravar(ex.getMessage());
        }
        return listaFilme;    
    }
}
