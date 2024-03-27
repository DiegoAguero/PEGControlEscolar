package com.dao;

import java.sql.*;
import com.models.Career;
import java.util.*;
public class CareerQuery{
    public CareerQuery(){}
    public int insertCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO carreras (nombre) VALUES (?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int rowsInserted = st.executeUpdate();
        return rowsInserted;
    }
    public int updateCareer(int id, Career career, Connection stablishConnection) throws SQLException{
       String SQLQuery = "UPDATE carreras SET nombre = ? WHERE id = ?";
       PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
       st.setString(1, career.getName());
       st.setInt(2, id);
       int rowsUpdated = st.executeUpdate();
       return rowsUpdated;
    }
    public int deleteCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "DELETE FROM carreras WHERE id = ?";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setInt(1, career.getId());
        int careerDeleted = st.executeUpdate();
        System.out.println("Deleted");
        return careerDeleted;
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
    public Career getCareerById(int id, Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM carreras where id = ?";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Career career = null;
        while(rs.next()){
            String nameOfCareer = rs.getString("nombre");
            int idCareer = rs.getInt("id");
            career = new Career(idCareer, nameOfCareer);
        }
        return career;
    }
//    public ArrayList seeStudentsFromCareer(Career career, Connection stablishConnection) throws SQLException{
//        String SQLQuery = "SELECT a.nombre, a.DNI, c.nombre AS carrera FROM alumnos a " + 
//                          "JOIN alumnos_materias am ON a.id = am.idAlumnos " + 
//                          "JOIN materias m ON am.idMaterias = m.id " + 
//                          "JOIN carreras c ON m.idCarreras = c.id " + 
//                          "WHERE c.nombre = '"+ career.getName() + "' " + 
//                          "GROUP BY a.nombre, a.DNI " +
//                          "ORDER BY a.nombre DESC";
//        Statement st = stablishConnection.createStatement();
//        ResultSet rs = st.executeQuery(SQLQuery);
//        String[] studentArray = new String[100];
//        ArrayList<String> studentList = new ArrayList<>();
//        short counter = 0;
//        while(rs.next()){
//            String nameOfStudent = rs.getString("nombre");
//            String DNIOfStudent = rs.getString("DNI");
//            String nameOfCareer = rs.getString("carrera");
////            studentList.add(nameOfStudent, DNIOfStudent, nameOfCareer);
//        }
//        return studentList;
//    }
}
