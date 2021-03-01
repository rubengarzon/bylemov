package com.garzon.bylemov;

import java.util.ArrayList;

public class ListaMovilesComprados {
    private static ArrayList<String> movilesList = new ArrayList<>();

    public ArrayList<String> getMovilesList() {
        return movilesList;
    }

    public void add(String toString) {
        movilesList.add(toString);
    }
}
