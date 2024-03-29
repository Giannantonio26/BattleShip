/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

import java.util.Objects;

/**
 * 'Entity'.
 * @author leonardo
 * Classe Coord i cui oggetti sono usati come parti delle navi.
 */
public final class Coord {
    private int x;
    private int y;

/**
 *
 * @param riga
 * @param colonna
 */
    public Coord(final int colonna, final int riga) {
        this.x = colonna;
        this.y = riga;
    }

    public int getX() {
        return x;
    }

    public void setX(final int colonna) {
        this.x = colonna;
    }

    public int getY() {
        return y;
    }

    public void setY(final int riga) {
        this.y = riga;
    }

/**
 *
 * @param o
 * @return
 */
    @Override
    public boolean equals(final Object o) {
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
