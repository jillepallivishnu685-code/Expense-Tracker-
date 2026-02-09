package com.student;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String type = req.getParameter("type");

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studentdb",
        "root",
        "password"   // 🔴 change this
      );

      if ("register".equals(type)) {
        PreparedStatement ps = con.prepareStatement(
          "INSERT INTO users (email, password) VALUES (?, ?)");
        ps.setString(1, email);
        ps.setString(2, password);
        ps.executeUpdate();
      }

      PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM users WHERE email=? AND password=?");
      ps.setString(1, email);
      ps.setString(2, password);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        res.sendRedirect("dashboard.html");
      } else {
        res.getWriter().println("Invalid login");
      }

      con.close();

    } catch (Exception e) {
      e.printStackTrace();
      res.getWriter().println("Server error");
    }
  }
}