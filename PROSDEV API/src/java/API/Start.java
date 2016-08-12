/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Database.DB;
import static Database.DB.con;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Hannah
 */
@WebServlet(name = "Start", urlPatterns = {"/Start"})
public class Start extends HttpServlet {

    private String token;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String u = request.getParameter("username");
            String p = request.getParameter("password");
            JSONObject json = new JSONObject();
            
            if(isAuthorized(u, p)) {
                try {
                    json.put("token", token);
                    out.println(json);
                } catch (JSONException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }
    
    private boolean isAuthorized(String username, String password) {
        boolean isAuthorized = false;
        String modifiedPw = password;
        
        try {
            
            PreparedStatement query = 
                    con.prepareStatement("SELECT sha(concat(username, rand())) as token, password, salt from user WHERE username = ?");
            query.setString(1, username);
            
            ResultSet rs = query.executeQuery();
            if(rs.next()){
                String salt = rs.getString(3);
                modifiedPw = modifiedPw.concat(salt);
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(modifiedPw.getBytes(StandardCharsets.UTF_8));
                String hashPass = DatatypeConverter.printHexBinary(hash);
                if(hashPass.equals(rs.getString(2))){
                    token = rs.getString(1);
                    setToken(token, username);
                    isAuthorized = true;
                }
            }
            
            /*******/
            
            /*
            - identify if token is valid
            - if valid get type and location id
            */
            /*
            boolean isAuthorized = false;
            
            String sql = "select sha(concat(username, rand())) as token\n" +
                    "from user \n" +
                    "where username = ? and password = ?;";
            
            try {
                PreparedStatement s = con.prepareStatement(sql);
                s.setString(1, username);
                s.setString(2, password);
                ResultSet rs = s.executeQuery();
                
                if(rs.next()) {
                    token = rs.getString(1);
                    setToken(token, username, password);
                    isAuthorized = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return isAuthorized;
            */
            
        } catch (SQLException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isAuthorized;
        
    }
    
    private void setToken(String token, String username) {
        String sql = "UPDATE user \n" +
                        "SET token = ?, token_time_start = ?\n" +
                        "WHERE username = ?;";
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, token);
            s.setString(2, getTime());
            s.setString(3, username);
            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("TOK: " + token + " SET!");
    }
    
    private String getTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = f.format(date);
        return dateStr;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
