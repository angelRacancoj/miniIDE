package miniide.frontEnd;

/**
 *
 * @author angel
 */
public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        filesOpenTabbedPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        fileMenu = new javax.swing.JMenu();
        newFileMenuItem = new javax.swing.JMenuItem();
        editFileMenuItem = new javax.swing.JMenuItem();
        proyectMenu = new javax.swing.JMenu();
        newProyectMenuItem = new javax.swing.JMenuItem();
        openProyectMenuItem = new javax.swing.JMenuItem();
        closeActualProyectMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        optionsMenu.setText("Options");

        fileMenu.setText("File");

        newFileMenuItem.setText("New File");
        newFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newFileMenuItem);

        editFileMenuItem.setText("Edit File");
        fileMenu.add(editFileMenuItem);

        optionsMenu.add(fileMenu);

        proyectMenu.setText("Proyect");

        newProyectMenuItem.setText("New Proyect");
        proyectMenu.add(newProyectMenuItem);

        openProyectMenuItem.setText("Open Proyect");
        proyectMenu.add(openProyectMenuItem);

        closeActualProyectMenuItem.setText("Close Actual Proyect");
        proyectMenu.add(closeActualProyectMenuItem);

        optionsMenu.add(proyectMenu);

        jMenuBar1.add(optionsMenu);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filesOpenTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(filesOpenTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileMenuItemActionPerformed
        try {
            filesOpenTabbedPane.add(new ventana());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_newFileMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeActualProyectMenuItem;
    private javax.swing.JMenuItem editFileMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTabbedPane filesOpenTabbedPane;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem newFileMenuItem;
    private javax.swing.JMenuItem newProyectMenuItem;
    private javax.swing.JMenuItem openProyectMenuItem;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenu proyectMenu;
    // End of variables declaration//GEN-END:variables
}
