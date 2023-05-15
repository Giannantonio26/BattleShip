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
public final class Coord {
     private int x;
    private int y;

/**
 *
 * @param riga
 * @param colonna
 */
    public Coord(final int riga, final int colonna) {
        this.x = riga;
        this.y = colonna;
    }

    public int getX() {
        return x;
    }

    public void setX(final int riga) {
        this.x = riga;
    }

    public int getY() {
        return y;
    }

    public void setY(int colonna) {
        this.y = colonna;
    }

/**
 *
 * @param o
 * @return
 */
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
