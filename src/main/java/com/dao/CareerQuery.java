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
}
