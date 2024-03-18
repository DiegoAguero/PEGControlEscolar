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

    // Constructor
    public Career(String name) {
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

    // Método toString para representar la carrera como una cadena
    @Override
    public String toString() {
        return "Career: " + name;
    }

}
