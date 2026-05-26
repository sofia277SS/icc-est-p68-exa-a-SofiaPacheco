package models;

public class Player {
    private String name;
    private int goals;
    private boolean isActive;

    public Player(String name, int goals, boolean isActive) {
        this.name = name;
        this.goals = goals;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Jugador: " + name + " | Goles: " + goals + " | Activo: " + isActive;
    }
}
