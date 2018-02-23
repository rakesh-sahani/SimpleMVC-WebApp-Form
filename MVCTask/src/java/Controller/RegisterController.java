/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RegisterDAO;
import Model.Register;
import com.sun.org.apache.bcel.internal.generic.NEW;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryu
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name, email, dob, phone;
        name = request.getParameter("name");
        email = request.getParameter("email");
        dob = request.getParameter("dob");
        phone = request.getParameter("phone");
        PrintWriter out = response.getWriter();
        
        Register r = new Register();
        r.setName(name);
        r.setEmail(email);
        r.setDob(dob);
        r.setPhone(phone);
        
        String sql = "insert into info values (?,?,?,?)";
        int i = RegisterDAO.RegisterUser(r,sql);
        if (i != 0) {
            out.print("Value Inserted");                
        } 
        else {
             System.out.println("Error");              
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
