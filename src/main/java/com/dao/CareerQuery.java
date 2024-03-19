package com.dao;

import java.sql.*;
import com.models.Career;
import java.util.*;
public class CareerQuery{
    public CareerQuery(){}
    public void insertCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO carreras (nombre) VALUES (?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int rowsInserted = st.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
    }
    public void updateCareer(String oldName, Career career, Connection stablishConnection) throws SQLException{
       String SQLQuery = "UPDATE carreras SET nombre = ? WHERE nombre = ?";
       PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
       st.setString(1, career.getName());
       st.setString(2, oldName);
       int rowsInserted = st.executeUpdate();
       System.out.println("Rows updated: " + rowsInserted);
    }
    public void deleteCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "DELETE FROM carreras WHERE nombre = ?";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int careerDeleted = st.executeUpdate();
        System.out.println("Career deleted: " + careerDeleted);
    }
    public ArrayList getAllCareers(Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM carreras";
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        ArrayList<Career> careerList = new ArrayList<>();
        Career[] career = new Career[100];
        short counter = 0;
        while (rs.next()) {
            String nameOfCareer = rs.getString("nombre");
            int id = rs.getInt("id");
            if(nameOfCareer != null){
                career[counter] = new Career(id, nameOfCareer);
                careerList.add(career[counter]);
                counter++;
            }
        }
        return careerList;
    }
    public void seeStudentsFromCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT a.nombre, a.DNI, c.nombre AS carrera FROM alumnos a " + 
                          "JOIN alumnos_materias am ON a.id = am.idAlumnos " + 
                          "JOIN materias m ON am.idMaterias = m.id " + 
                          "JOIN carreras c ON m.idCarreras = c.id " + 
                          "WHERE c.nombre = '"+ career.getName() + "' " + 
                          "GROUP BY a.nombre, a.DNI " +
                          "ORDER BY a.nombre DESC";
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        while(rs.next()){
            String nameOfStudent = rs.getString("nombre");
            String DNIOfStudent = rs.getString("DNI");
            String nameOfCareer = rs.getString("carrera");
            System.out.println("Carrera: " + nameOfCareer); 
            System.out.println("Nombre del estudiante: " + nameOfStudent);
            System.out.println("DNI del estudiante: " + DNIOfStudent);
            System.out.println("======================");

        }
    }
}
