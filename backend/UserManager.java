package backend;

import Connection.DBConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class UserManager {
    private User[] users = new User[50];
    private int count = 0;

    public void addUser(User u){
        users[count++] = u;
    }

    public User loginUser(String email, String password){
        for(int i=0;i<count;i++){
            if(users[i].login(email,password)){
                return users[i];
            }
        }
        return null;
    }
    
    public void saveCustomerToDB(Customer c) {
    try {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO customer(name,email,password) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, c.getName());
        pst.setString(2, c.getEmail());
        pst.setString(3, c.getPassword());

        pst.executeUpdate();
    } catch(Exception e){
        e.printStackTrace();
    }
}
    
    public void saveAdminToDB(Admin a) {
    try {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO admin(name,email,password) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, a.getName());
        pst.setString(2, a.getEmail());
        pst.setString(3, a.getPassword());

        pst.executeUpdate();
    } catch(Exception e){
        e.printStackTrace();
    }
}
    
   public User loginAdminFromDB(String name, String password) {
    try {
        Connection con = DBConnection.getConnection();

        String sql1 = "SELECT * FROM admin WHERE name=? AND password=?";
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setString(1, name);
        pst1.setString(2, password);

        ResultSet rs1 = pst1.executeQuery();
        if(rs1.next()){
            return new Admin(rs1.getInt("id"), rs1.getString("email"), name, password);
        }
        }catch(Exception e){
        e.printStackTrace();
        }
    return null;
    }
    
    public User loginCustomerFromDB(String name, String password){
        try{
        Connection con = DBConnection.getConnection();
        String sql2 = "SELECT * FROM customer WHERE name=? AND password=?";
        PreparedStatement pst2 = con.prepareStatement(sql2);
        pst2.setString(1, name);
        pst2.setString(2, password);

        ResultSet rs2 = pst2.executeQuery();
        if(rs2.next()){
            return new Customer(rs2.getInt("id"), rs2.getString("email"), name, password);

    }
    }catch(Exception e){
        e.printStackTrace();
    }
    return null;
}
}

