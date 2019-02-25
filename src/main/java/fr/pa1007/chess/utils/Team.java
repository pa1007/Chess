package fr.pa1007.chess.utils;

public enum Team {


    BLACK("Black"),
    WHITE("White");

    private final String name;

    Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
