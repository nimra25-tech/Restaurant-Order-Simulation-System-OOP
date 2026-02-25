
package Frontend;


import backend.MenuItem;
import backend.MenuManager;
import backend.User;
import backend.UserManager;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    private UserManager userManager;
    private MenuManager menuManager;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
      public Login(UserManager userManager, MenuManager menuManager) {
        initComponents();
        this.userManager = userManager;
        this.menuManager = menuManager;
        setTitle("N&B Restaurant - Login");
        setSize(736,1313);
        setLocationRelativeTo(null);
        this.dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnsignup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(736, 1313));
        setSize(new java.awt.Dimension(736, 1313));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N&B RESTAURANT");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(220, 40, 246, 28);

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("      LOGIN FORM");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 110, 210, 35);

        txtname.setBackground(new java.awt.Color(255, 255, 255));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname);
        txtname.setBounds(290, 230, 202, 22);

        jLabel3.setBackground(new java.awt.Color(255, 204, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password   :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 290, 97, 40);

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(390, 340, 120, 30);

        login.setBackground(new java.awt.Color(0, 0, 0));
        login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(360, 430, 72, 24);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 230, 63, 20);

        txtpassword.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtpassword);
        txtpassword.setBounds(290, 300, 202, 22);

        btnsignup.setBackground(new java.awt.Color(0, 0, 0));
        btnsignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsignup.setForeground(new java.awt.Color(255, 255, 255));
        btnsignup.setText("Signup");
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btnsignup);
        btnsignup.setBounds(210, 430, 94, 27);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/login.jpeg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 736, 1313);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    if(jCheckBox1.isSelected()){
        txtpassword.setEchoChar((char)0);
    }
    else{
        txtpassword.setEchoChar('*');
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
       String name = txtname.getText();
       String password = txtpassword.getText();

if(name.isEmpty() || password.isEmpty()){
    JOptionPane.showMessageDialog(this, "Please fill all fields");
    return;
}

User admin = userManager.loginAdminFromDB(name, password);

if(admin != null){
    JOptionPane.showMessageDialog(this, "Admin Login Successful");  
   AdminPanel ap = new AdminPanel(userManager,menuManager);
   menuManager.loadMenuFromDB();
   ap.loadMenu();
   ap.setVisible(true);
    this.dispose();
    return;
}
User customer = userManager.loginCustomerFromDB(name, password);

if(customer != null){
    JOptionPane.showMessageDialog(this, "Customer Login Successful");
    
    String customerName = txtname.getText().trim(); 
    MenuManager menuManager = new MenuManager();
    menuManager.loadMenuFromDB();

   OrderForm orderForm = new OrderForm(menuManager, customerName);
   orderForm.setVisible(true);
   this.dispose();    
}

else{
JOptionPane.showMessageDialog(this, "Invalid Login");
MainFrame main = new MainFrame();
main.setVisible(true);
this.dispose();
}
    
    }//GEN-LAST:event_loginActionPerformed

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
         new SignUp(userManager, menuManager).setVisible(true);
         this.dispose();       
    }//GEN-LAST:event_btnsignupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MenuManager menuManager = new MenuManager();
        UserManager userManager = new UserManager();
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
        java.awt.EventQueue.invokeLater(() -> new Login(userManager,menuManager).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsignup;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton login;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
