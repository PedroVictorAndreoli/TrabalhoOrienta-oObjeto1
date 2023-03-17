/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

    protected Connection connection;

    public Connection getConn() {
        Conexao conexao = Conexao.getInstance();//obtém a instância única
        connection = conexao.getConexao();//retorna a conexao com URL, USUARIO e SENHA
        return connection;
    }

    public void closePreparedStatement(PreparedStatement psmt) {
        if (psmt == null) {
            return;
        }
        try {
            if (!psmt.isClosed()) {
                psmt.close(); //libera recursos alocados no sistema quando insere, atualiza ou exclui um registro
            }
        } catch (SQLException ex) {
        }
    }

    public void closeResultSet(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            if (!rs.isClosed()) {
                rs.close(); //libera recursos alocados no sistema quando retorna um conjuntos de dados do banco
            }
        } catch (SQLException ex) {
        }
    }
}
