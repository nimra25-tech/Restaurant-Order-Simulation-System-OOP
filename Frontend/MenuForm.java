
package Frontend;

import javax.swing.JOptionPane;
import backend.MenuItem;
import backend.MenuManager;
import backend.UserManager;
import javax.swing.table.DefaultTableModel;

public class MenuForm extends javax.swing.JFrame {
    private MenuManager menuManager;
     private UserManager userManager;
     private DefaultTableModel model;
     private String customerName;
     private OrderForm orderForm;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuForm.class.getName());
     public MenuForm(MenuManager menuManager, String customerName, OrderForm orderForm){
    initComponents();
    this.menuManager = menuManager;
    this.customerName = customerName;
    this.orderForm = orderForm;
    loadMenu();
    setTitle("N&B Restaurant - menu");
    setSize(736,1104);
    setLocationRelativeTo(null);
    this.dispose();
}
     
    public MenuForm(MenuManager menuManager){
        this.menuManager = menuManager;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(736, 1104));
        setSize(new java.awt.Dimension(736, 1104));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("N&B RESTAURANT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 30, 328, 28);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("    MENU");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 80, 114, 22);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(49, 91, 37, 0);

        btnOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(153, 0, 0));
        btnOrder.setText("Place Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrder);
        btnOrder.setBounds(290, 570, 110, 27);

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMenu);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 625, 402);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/menu.jpeg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 736, 1104);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed

    if(orderForm != null){
        orderForm.setVisible(true);
        this.dispose();
    } else {
        new OrderForm(menuManager, customerName).setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_btnOrderActionPerformed

   private void loadMenu(){
     model = new DefaultTableModel(new String[]{"ID","Item Name","Category","Price"},0);
    tblMenu.setModel(model);

    MenuItem[] items = menuManager.getAllMenuItems();
    int count = menuManager.getCount();

    for(int i = 0; i < count; i++){
        MenuItem m = items[i];
        model.addRow(new Object[]{m.getId(), m.getName(), m.getCategory(), m.getPrice()});
    }
}


    public static void main(String args[]) {
        UserManager userManager = new UserManager();
        MenuManager menuManager = new MenuManager();
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuForm(menuManager).setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMenu;
    // End of variables declaration//GEN-END:variables
}
