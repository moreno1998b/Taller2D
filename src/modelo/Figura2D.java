/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 *

 *
 * @author Jairo Vergara Portocarrero 2151714
 * @author Jorge Moreno 2175321
 * @author Sebastian Bejarano 2190853
 *
 *
 * @date 9 Octubre 2020
 * @version 1.0
 */
package modelo;

/**
 *
 * @author Administrador
 */
public class Figura2D {
     public Figura2D() {
    }

    public Figura2D(double[] fx, double[] fy) {
        this.fx = fx;
        this.fy = fy;

    }

    public double[] fx;
    public double[] fy;

    /**
     * Get the value of fy
     *
     * @return the value of fy
     */
    public double[] getFy() {
        return fy;
    }

    /**
     * Set the value of fy
     *
     * @param fy new value of fy
     */
    public void setFy(double[] fy) {
        this.fy = fy;
    }

    /**
     * Get the value of fx
     *
     * @return the value of fx
     */
    public double[] getFx() {
        return fx;
    }

    /**
     * Set the value of fx
     *
     * @param fx new value of fx
     */
    public void setFx(double[] fx) {
        this.fx = fx;
    }
    
}
