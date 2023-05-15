/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

import java.util.Objects;
/**
 *
 * @author leonardo
 */

/**
  * Classe Coord.
 */
public class Coord {
     private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coord coord)) {
            return false;
        }
        return getX() == coord.getX() && getY() == coord.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

     @Override
    public String toString() {
        return "Coord [x=" + x + ", y=" + y + "]";
    }
}
