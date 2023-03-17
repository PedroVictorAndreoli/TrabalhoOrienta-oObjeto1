/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.views;

import br.edu.utfpr.dao.DubladorDao;
import br.edu.utfpr.dao.EstudioDao;
import br.edu.utfpr.dao.FilmeDao;
import br.edu.utfpr.entidades.Dublador;
import br.edu.utfpr.entidades.Estudio;
import br.edu.utfpr.entidades.Filme;
import br.edu.utfpr.models.EstudioListModel;
import br.edu.utfpr.models.FilmeListModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FrmFilmePesquisa extends javax.swing.JInternalFrame {

    private FilmeListModel filmeListModel;
    private List<Filme> listaFilme;
    FilmeDao filmeDao = new FilmeDao();
    private boolean edit = false;
    
    public FrmFilmePesquisa() {
        initComponents();
        super.setTitle("Tela de Filme");
        montarLista();
        filmeListModel = new FilmeListModel(listaFilme);
        tblFilme.setModel(filmeListModel);
    }
    
    
    
    
    private void montarLista(){
        listaFilme = filmeDao.findAll();
        System.out.println(listaFilme);
        EstudioDao estudioDao = new EstudioDao();
        listaFilme.forEach(estudio -> estudio.setEstudio(estudioDao.findById(estudio.getEstudio().getId())));
        DubladorDao dubladorDao = new DubladorDao();
        listaFilme.forEach(dublador -> dublador.setDublador(dubladorDao.findById(dublador.getDublador().getId())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfDublador = new javax.swing.JTextField();
        tfEstudio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFilme = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nome");

        jButton1.setText("Buscar");
        jButton1.setActionCommand("JButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estudio");

        tfEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEstudioActionPerformed(evt);
            }
        });

        jLabel3.setText("Dublador");

        tblFilme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Estudio", "Dublador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFilme);

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Novo");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(36, 36, 36)
                .addComponent(jButton4)
                .addGap(143, 143, 143))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(tfDublador, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(440, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDublador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jLabel1)
                    .addContainerGap(255, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmFilme frmFilme = new FrmFilme(null, true,filmeListModel);
        frmFilme.setLocationRelativeTo(null);
        frmFilme.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pesquisa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEstudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEstudioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFilme;
    private javax.swing.JTextField tfDublador;
    private javax.swing.JTextField tfEstudio;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
    private void excluir(){
    int linhaSelecionada = tblFilme.getSelectedRow();
    if(linhaSelecionada >= 0){
        int opcao = JOptionPane.showInternalConfirmDialog(null, "Deseja excluir?","Exclusao",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opcao == JOptionPane.YES_OPTION)
        {
            int id = (int) tblFilme.getValueAt(linhaSelecionada, 0);
            FilmeDao filmeDao = new FilmeDao();
            if(filmeDao.delete(id))
            {
                JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                filmeListModel.removeModel(linhaSelecionada);
            }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Selecione uma linha");
    }
    }
    
    
private void editar(){
int linhaSelecionada = tblFilme.getSelectedRow();
if(linhaSelecionada >= 0){
        int id = (int) tblFilme.getValueAt(linhaSelecionada, 0);
        FilmeDao filmeDao = new FilmeDao();
        Filme fil = filmeDao.findById(id);
        FrmFilme frmFilme = new FrmFilme(this,true,fil,filmeListModel,linhaSelecionada);
        frmFilme.setLocationRelativeTo(null);
        frmFilme.setVisible(true);
}else{
    JOptionPane.showMessageDialog(null, "Selecione uma linha");
}
}

private Filme uppperFilme(Filme filme){
   
    return filme;
}
private void pesquisa(){
    List<Filme> listaFilmeFiltrado;
    List<Filme> listaFilmeUPPER = listaFilme;
    List<Integer> listaIds = new ArrayList<Integer>();
    listaFilmeUPPER.forEach(filme -> {
        filme.setNome(filme.getNome().toUpperCase());
        Dublador dublador;
        dublador = filme.getDublador();
        dublador.setNome(dublador.getNome().toUpperCase());
        filme.setDublador(dublador);
        Estudio estudio;
        estudio = filme.getEstudio();
        estudio.setNome(estudio.getNome().toUpperCase());
        filme.setEstudio(estudio);
    });
    listaFilmeFiltrado = listaFilmeUPPER.stream().filter(nome -> nome.getNome().contains( tfNome.getText().toUpperCase()) && 
            nome.getEstudio().getNome().contains( tfEstudio.getText().toUpperCase()) && nome.getDublador().getNome().contains( tfDublador.getText().toUpperCase())).collect(Collectors.toList());
    listaFilmeFiltrado.forEach(filme -> {
       listaIds.add(filme.getId());});
    listaFilmeFiltrado.clear();
    montarLista();
    listaIds.forEach(id -> {
    listaFilmeFiltrado.add(listaFilme.stream().filter(filme -> filme.getId().equals(id)).findFirst().get());
    });
    filmeListModel = new FilmeListModel(listaFilmeFiltrado);
    tblFilme.setModel(filmeListModel);
}



}