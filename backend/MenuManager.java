package backend;

import Connection.DBConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class MenuManager {
    private MenuItem[] menu = new MenuItem[100];
    private int count = 0;

    public void addItem(MenuItem m){
        if(count < menu.length) {
            menu[count++] = m;
        }
    }

    public MenuItem[] getAllMenuItems() {
    MenuItem[] result = new MenuItem[count]; 
    for (int i = 0; i < count; i++) {
        result[i] = menu[i];
    }
    return result;
    }


    public int getCount(){
        return count;
    }
    
    
    public MenuItem getMenuItemByName(String name){
        for(int i = 0; i < count; i++){
            if(menu[i].getName().equalsIgnoreCase(name)){
                return menu[i]; 
            }
        }
        return null; 
    }
    
    public void addMenuToDB(MenuItem m) {
    try {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO menu(name, price, category) VALUES(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, m.getName());
        pst.setDouble(2, m.getPrice());
        pst.setString(3, m.getCategory());  
        pst.executeUpdate();
    } catch(Exception e){ 
        e.printStackTrace(); 
    }
}

public void updateMenuInDB(int id, String name, double price, String category){
    try {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE menu SET name=?, price=?, category=? WHERE id=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setString(3, category); 
        pst.setInt(4, id);
        pst.executeUpdate();
    } catch(Exception e){ 
        e.printStackTrace(); 
    }
}


public void deleteMenuFromDB(int id){
    try {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM menu WHERE id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
    } catch(Exception e){ 
        e.printStackTrace(); 
    }
}

public void loadMenuFromDB(){
    try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM menu");

        count = 0;
        while(rs.next()){
            menu[count++] = new MenuItem(
            rs.getInt("id"),
           rs.getString("name"),
           rs.getDouble("price"),
           rs.getString("category"));
        }
    } catch(Exception e){ 
        e.printStackTrace(); 
    }
}


}
