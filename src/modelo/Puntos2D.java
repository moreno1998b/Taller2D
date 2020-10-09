/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.paint.Color;

/**
 *
 * @author Administrador
 */

/**
 *
 * @author Administrador
 *
 * Utilidad: Tiene los métodos para guardar y cargar el archivo xml.
 *
 * @author Jairo Vergara Portocarrero 2151714
 * @author Jorge Moreno 2175321
 * @author Sebastian Bejarano 2190853
 *
 *
 * @date 9 Octubre 2020
 * @version 1.0
 */

    
    public class Puntos2D {

    public double x;
    public double y;
    public Color colorRelleno;
    public Color colorResaltado;

    public Puntos2D() {
    }

    public Puntos2D(double x, double y, Color colorRelleno, Color colorResaltado) {
        this.x = x;
        this.y = y;
        this.colorRelleno = colorRelleno;
        this.colorResaltado = colorResaltado;
    }

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public double getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public double getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(double x) {
        this.x = x;
    }

    public Color getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public Color getColorResaltado() {
        return colorResaltado;
    }

    public void setColorResaltado(Color colorResaltado) {
        this.colorResaltado = colorResaltado;
    }
     @Override
    public String toString() {
        return x + ", " + y;
    }
    }
