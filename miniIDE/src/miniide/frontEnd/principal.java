package miniide.frontEnd;

import Archivo.ManejadorArchivo;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import miniide.treeManager.treeController;

/**
 *
 * @author angel
 */
public class principal extends javax.swing.JFrame {

    ManejadorArchivo myManejador;
    LexerArch myLexer;
    parser parser;
    treeController control;
    String path;
    String pathRpm;

    public principal() {
        initComponents();
        this.myManejador = new ManejadorArchivo();
        this.control = new treeController(this.fileTree);
        this.myLexer = new LexerArch(new StringReader(""));
        this.parser = new parser(myLexer, control);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        filesOpenTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        fileTree = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        fileMenu = new javax.swing.JMenu();
        openFileMenuItem = new javax.swing.JMenuItem();
        newFileMenuItem = new javax.swing.JMenuItem();
        editFileMenuItem = new javax.swing.JMenuItem();
        CloseMenuItem = new javax.swing.JMenuItem();
        proyectMenu = new javax.swing.JMenu();
        newProyectMenuItem = new javax.swing.JMenuItem();
        openProyectMenuItem = new javax.swing.JMenuItem();
        closeActualProyectMenuItem = new javax.swing.JMenuItem();
        aCercaDe = new javax.swing.JMenu();
        infoMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini IDE V 0.1");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("/");
        fileTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(fileTree);

        optionsMenu.setText("Options");

        fileMenu.setText("File");

        openFileMenuItem.setText("Open File");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openFileMenuItem);

        newFileMenuItem.setText("New File");
        newFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newFileMenuItem);

        editFileMenuItem.setText("Edit File");
        fileMenu.add(editFileMenuItem);

        CloseMenuItem.setText("Close file");
        CloseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(CloseMenuItem);

        optionsMenu.add(fileMenu);

        proyectMenu.setText("Proyect");

        newProyectMenuItem.setText("New Proyect");
        proyectMenu.add(newProyectMenuItem);

        openProyectMenuItem.setText("Open Proyect");
        openProyectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProyectMenuItemActionPerformed(evt);
            }
        });
        proyectMenu.add(openProyectMenuItem);

        closeActualProyectMenuItem.setText("Close Actual Proyect");
        proyectMenu.add(closeActualProyectMenuItem);

        optionsMenu.add(proyectMenu);

        jMenuBar1.add(optionsMenu);

        aCercaDe.setText("About");
        aCercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCercaDeActionPerformed(evt);
            }
        });

        infoMenuItem.setText("Information");
        infoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuItemActionPerformed(evt);
            }
        });
        aCercaDe.add(infoMenuItem);

        jMenuBar1.add(aCercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filesOpenTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(filesOpenTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuItemActionPerformed
        JFileChooser dialogo = new JFileChooser();
        dialogo.setDialogTitle("Open .mcf file");
        if (dialogo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            path = dialogo.getSelectedFile().getAbsolutePath();
            try {
                ventana wind = new ventana(path);
                wind.setText(myManejador.lecturaArchivo(path));
                filesOpenTabbedPane.add(myManejador.nameFile(path), wind);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_openFileMenuItemActionPerformed

    private void openProyectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProyectMenuItemActionPerformed
        JFileChooser dialogo = new JFileChooser();
        dialogo.setDialogTitle("Open .mrp file");
        if (dialogo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            pathRpm = dialogo.getSelectedFile().getAbsolutePath();
            try {
                myLexer.yyreset(new StringReader(myManejador.lecturaArchivo(pathRpm)));
            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.parser.parse();
            } catch (Exception e) {
                Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, e);
            }

            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        }
    }//GEN-LAST:event_openProyectMenuItemActionPerformed

    private void newFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileMenuItemActionPerformed
        JFileChooser guardar = new JFileChooser();
        guardar.setDialogTitle("Create as .mcf file");
        if (guardar.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            path = guardar.getSelectedFile().getAbsolutePath();
            System.out.println(path);
            try {
                myManejador.guardarArchivo(path, "$* Clase " + myManejador.nameFile(path) + " creada *$");
                ventana wind = new ventana(path);
                wind.setText(myManejador.lecturaArchivo(path));
                filesOpenTabbedPane.add(myManejador.nameFile(path), wind);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_newFileMenuItemActionPerformed

    private void CloseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseMenuItemActionPerformed
        ventana auxV = (ventana) this.filesOpenTabbedPane.getSelectedComponent();

        try {
            if (auxV.getEntradaTextArea().equalsIgnoreCase(myManejador.lecturaArchivo(auxV.getPathIn()))) {
                this.filesOpenTabbedPane.remove(this.filesOpenTabbedPane.getSelectedComponent());
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, "Desea salir sin guardar?", "Salir", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {
                    this.filesOpenTabbedPane.remove(this.filesOpenTabbedPane.getSelectedComponent());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CloseMenuItemActionPerformed

    private void aCercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCercaDeActionPerformed

    }//GEN-LAST:event_aCercaDeActionPerformed

    private void infoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Desarrollado por: \nAngel O. Racancoj G. \nID: 201631547  \n1st Semestrer 2018 \nVersion 0.1 (Beta)", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CloseMenuItem;
    private javax.swing.JMenu aCercaDe;
    private javax.swing.JMenuItem closeActualProyectMenuItem;
    private javax.swing.JMenuItem editFileMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTree fileTree;
    private javax.swing.JTabbedPane filesOpenTabbedPane;
    private javax.swing.JMenuItem infoMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem newFileMenuItem;
    private javax.swing.JMenuItem newProyectMenuItem;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JMenuItem openProyectMenuItem;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenu proyectMenu;
    // End of variables declaration//GEN-END:variables

}
