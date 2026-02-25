
package Frontend;
import backend.MenuItem;
import backend.MenuManager;
import backend.Order;
import backend.UserManager;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderForm extends javax.swing.JFrame {
    private Order currentOrder;
    private MenuManager menuManager;
    DefaultTableModel model;
    private String customerName;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrderForm.class.getName());
     public OrderForm(MenuManager menuManager,String customerName) {
    initComponents();
    this.menuManager = menuManager;
    this.customerName = customerName;
    currentOrder = new Order();
    model = new DefaultTableModel(new String[]{"Item Name", "Quantity", "Price", "Total"}, 0);
    tblorder.setModel(model);
    this.setSize(736,1104);
    setLocationRelativeTo(null);
    this.dispose();
   }

    public OrderForm(MenuManager menuManager){
        this.menuManager = menuManager;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtitem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblorder = new javax.swing.JTable();
        txtmenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(736, 1104));
        setSize(new java.awt.Dimension(736, 1104));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("N&B RESTAURANT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 30, 217, 32);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLACE ORDER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 100, 120, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Name:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 190, 78, 20);
        getContentPane().add(txtitem);
        txtitem.setBounds(350, 190, 208, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 260, 61, 20);
        getContentPane().add(txtQty);
        txtQty.setBounds(350, 250, 208, 34);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(51, 0, 51));
        btnAdd.setText("Add item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(340, 330, 92, 27);

        btnBill.setBackground(new java.awt.Color(255, 255, 255));
        btnBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBill.setForeground(new java.awt.Color(51, 0, 51));
        btnBill.setText("Generate Bill");
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnBill);
        btnBill.setBounds(460, 330, 116, 27);

        tblorder.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblorder);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(150, 400, 452, 257);

        txtmenu.setBackground(new java.awt.Color(255, 255, 255));
        txtmenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtmenu.setForeground(new java.awt.Color(51, 0, 51));
        txtmenu.setText("View Menu");
        txtmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmenuActionPerformed(evt);
            }
        });
        getContentPane().add(txtmenu);
        txtmenu.setBounds(200, 330, 110, 27);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(14, 15, 0, 0);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(6, 15, 0, 0);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Order.jpeg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 736, 1104);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     try{
        String itemName = txtitem.getText().trim();
        int quantity = Integer.parseInt(txtQty.getText().trim());

        MenuItem menuItem = menuManager.getMenuItemByName(itemName);
        if(menuItem != null){
            double price = menuItem.getPrice();
            double total = price * quantity;

            model.addRow(new Object[]{menuItem.getName(), quantity, price, total});
        } else {
            JOptionPane.showMessageDialog(this, "Item not found!");
        }
        txtitem.setText("");
        txtQty.setText("");
        txtitem.requestFocus();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Enter a valid quantity!");
    }   
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
    double grandTotal = 0;
    StringBuilder bill = new StringBuilder();

    bill.append("===== ORDER =====\n");
    bill.append("Customer: ").append(customerName).append("\n\n");

    for(int i = 0; i < model.getRowCount(); i++){
        String name = model.getValueAt(i, 0).toString();
        int qty = Integer.parseInt(model.getValueAt(i, 1).toString());
        double total = Double.parseDouble(model.getValueAt(i, 3).toString());

        bill.append(name).append(" x").append(qty).append(" = ").append(total).append("\n");
        grandTotal += total;
    }
     bill.append("\nTotal Bill: ").append(grandTotal).append("\n");
    bill.append("====================\n\n");

    try(FileWriter fw = new FileWriter("orders.txt", true)){
        fw.write(bill.toString());
    } catch(IOException e){
        JOptionPane.showMessageDialog(this, "File Error: " + e.getMessage());
    }
    JOptionPane.showMessageDialog(this, bill.toString());
    model.setRowCount(0);
    JOptionPane.showMessageDialog(this, "Fi amanillah!!");
    this.dispose();
    }//GEN-LAST:event_btnBillActionPerformed

    private void txtmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmenuActionPerformed
    new MenuForm(menuManager, customerName, this).setVisible(true);
    this.setVisible(false); 
    }//GEN-LAST:event_txtmenuActionPerformed

    private void saveOrderToFile(String text) {
    try {
        FileWriter fw = new FileWriter("orders.txt", true);
        fw.write(text);
        fw.write("\n-----------------------\n");
        fw.close();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "File error: " + e.getMessage());
    }
}

    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> new OrderForm(menuManager).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblorder;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtitem;
    private javax.swing.JButton txtmenu;
    // End of variables declaration//GEN-END:variables
}
