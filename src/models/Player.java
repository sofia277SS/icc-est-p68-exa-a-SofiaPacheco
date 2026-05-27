package models;

public class Player {
  private String name;
  private int goals;
  private boolean isActive;

  public Player() {
  }

  public Player(String name, int goals, boolean isActive) {
    this.name = name;
    this.goals = goals;
    this.isActive = isActive;
  }

  public boolean isActive() {
    return isActive;
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

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}
