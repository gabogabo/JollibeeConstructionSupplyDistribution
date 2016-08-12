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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Hannah
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Distributions"})
public class Distributions extends HttpServlet {
    
    private int type, location_id;
    
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
            String token = request.getParameter("token");
            if(isAuthorized(token) && isActive(token)) {
                updateTime(token);
                out.println(getDistributions());
            }
        }    
    }
    
    private boolean isAuthorized(String token) {
        
        /* 
            - identify if token is valid
            - if valid get type and location id 
        */
        
        boolean isAuthorized = false;
        
        String sql = "select type, location_id\n" +
                        "from user \n" +
                        "where token = ?;";
        
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, token);
            ResultSet rs = s.executeQuery();
            
            if(rs.next()) {
                type = rs.getInt(1);
                location_id = rs.getInt(2);
                isAuthorized = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isAuthorized;
        
    }
    
    JSONArray getDistributions() {
        
        /* produce json */
        
        JSONArray json = new JSONArray();
        try {
            String sql = "";
            PreparedStatement s = con.prepareStatement(sql);
            if(type == 0) {
                sql = ("SELECT * from distributions;");
                s = con.prepareStatement(sql);
            }
            else if(type == 1) {
                sql = ("SELECT * from distributions where type = 'request' and to_location_id = ?;");
                s = con.prepareStatement(sql);
                s.setInt(1, location_id);
            }
                
            ResultSet rs = s.executeQuery();
            JSONObject object;
            
            while(rs.next()) {
                object = new JSONObject();
                object.put("dist_id", rs.getInt(1));
                object.put("type", rs.getString(2));
                object.put("to_location_id", rs.getInt(3));
                object.put("from_location_id", rs.getInt(4));
                object.put("date_filled", rs.getDate(5));
                object.put("status", rs.getString(6));
                object.put("percent_completed", rs.getFloat(7));
                object.put("date_completed", rs.getDate(8));
                json.put(object);
            }
           
        } catch (JSONException | SQLException ex) {
            Logger.getLogger(Distributions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    
    private void updateTime(String token) {
        String sql = "UPDATE user \n" +
                        "SET token_time_start = ?\n" +
                        "WHERE token = ?;";
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, getTime());
            s.setString(2, token);
            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean isActive(String token) {
        boolean isActive = false;
        
        String sql = "SELECT token_time_start\n" +
                        "FROM user\n" +
                        "WHERE token = ?;";
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, token);
            ResultSet rs = s.executeQuery();
            String time;
            
            if(rs.next()) {
                time = rs.getString(1);
                if(getDifference(time) <= 30) {  // if less than 30 mins
                    isActive = true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isActive;
    }
    
    private long getDifference(String timeStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date time2 = format.parse(getTime());
            Date time1 = format.parse(timeStr);
            
            // Get msec from each, and subtract.
            long diff = time2.getTime() - time1.getTime();
            //long diffMinutes = diff / (60 * 1000);
            long diffMinutes = diff / (60 * 1000) % 60;
            System.out.println("DIFFMINS: " + diffMinutes);
            System.out.println(" T1: " + time1);
            System.out.println(" T2: " + time2);
            return diffMinutes;
        } catch (ParseException ex) {
            Logger.getLogger(Distributions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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
