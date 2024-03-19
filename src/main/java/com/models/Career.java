/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.models;
import java.util.*;

/**
 * @author Diego & Arnau
 */
public class Career {
    private String name;
    private int id;
    // Constructor
    public Career(){}
    public Career(String name){
        this.setName(name);
    }
    public Career(int id, String name) {
        this.setId(id);
        this.setName(name);
        // this.name = name;
    }
    // Método para obtener el nombre de la carrera
    public String getName() {
        return name;
    }
    // Método para establecer el nombre de la carrera
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    // Método toString para representar la carrera como una cadena
    @Override
    public String toString() {
        return " id: " + this.id + "Career: " + this.name;
    }

}
