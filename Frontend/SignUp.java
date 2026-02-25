
package Frontend;
import backend.Admin;
import backend.Customer;
import backend.MenuManager;
import backend.User;
import backend.UserManager;
import javax.swing.JOptionPane;



public class SignUp extends javax.swing.JFrame {
    private UserManager userManager;
    private MenuManager menuManager;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SignUp.class.getName());
     public SignUp(UserManager userManager, MenuManager menuManager){
        initComponents();
         this.userManager = userManager;
        this.menuManager = menuManager;
        setTitle("N&B Restaurant - Signup");
        setSize(736,1307);
        setLocationRelativeTo(null);
        this.dispose();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        rolecombo = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnlogin = new javax.swing.JButton();
        btnsignup = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(736, 1307));
        setSize(new java.awt.Dimension(736, 1307));
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("N&B RESTAURANT");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(250, 80, 230, 32);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SignUp Form");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 130, 120, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 220, 44, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 300, 40, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Password:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 390, 68, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Select Your Role:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 490, 114, 20);

        txtname.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtname);
        txtname.setBounds(250, 210, 280, 37);

        txtemail.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtemail);
        txtemail.setBounds(250, 290, 280, 40);

        txtpassword.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtpassword);
        txtpassword.setBounds(260, 380, 270, 36);

        rolecombo.setBackground(new java.awt.Color(255, 255, 255));
        rolecombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rolecombo.setForeground(new java.awt.Color(0, 0, 0));
        rolecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Admin" }));
        getContentPane().add(rolecombo);
        rolecombo.setBounds(270, 480, 243, 37);

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(470, 430, 110, 20);

        btnlogin.setBackground(new java.awt.Color(255, 255, 255));
        btnlogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(0, 0, 0));
        btnlogin.setText("Back to Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin);
        btnlogin.setBounds(180, 570, 121, 27);

        btnsignup.setBackground(new java.awt.Color(255, 255, 255));
        btnsignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsignup.setForeground(new java.awt.Color(0, 0, 0));
        btnsignup.setText("SignUp");
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btnsignup);
        btnsignup.setBounds(450, 570, 78, 27);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/signup.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 736, 1307);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
        String name = txtname.getText().trim();
        String email = txtemail.getText().trim();
        String password = txtpassword.getText();
        String role = rolecombo.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }
  

        if (role.equals("Customer")) {
       Customer c = new Customer(0,name, email, password);
       userManager.saveCustomerToDB(c);
      } else {
       Admin a = new Admin(0,name, email, password);
       userManager.saveAdminToDB(a);
     }


        if (role.equals("Customer")) {
            JOptionPane.showMessageDialog(this, " Customer Signup Successful!");
            Login login = new Login(userManager, menuManager);
            login.setVisible(true);
            this.dispose();
        }else {
            JOptionPane.showMessageDialog(this, " Admin Signup Successful!");
            Login login = new Login(userManager, menuManager);
            login.setVisible(true);
            this.dispose(); 
        }
    }//GEN-LAST:event_btnsignupActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
      Login login = new Login(userManager,menuManager);
       login.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnloginActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
     if(jCheckBox1.isSelected()){
        txtpassword.setEchoChar((char)0);
    }
    else{
        txtpassword.setEchoChar('*');
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    
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
        java.awt.EventQueue.invokeLater(() -> new SignUp(userManager,menuManager).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnsignup;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> rolecombo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
