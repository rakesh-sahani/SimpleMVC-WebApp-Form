/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Register;
import java.sql.*;

/**
 *
 * @author Ryu
 */
public class RegisterDAO {

    public static int RegisterUser(Register r, String sql) {
        Connection con;
        PreparedStatement ps;
        int i = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "1234");
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getName());
            ps.setString(2, r.getEmail());
            ps.setString(3, r.getDob());
            ps.setString(4, r.getPhone());
            i = ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(r.getName());
            System.out.println(r.getEmail());
            System.out.println(r.getDob());
            System.out.println(r.getPhone());
        }
        return i;
    }
}
