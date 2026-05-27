package models;

public class League {
  private String name;
  private Team[] teams;

  public League() {
  }

  public League(String name, Team[] teams) {
    this.name = name;
    this.teams = teams;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Team[] getTeams() {
    return teams;
  }

  public void setTeams(Team[] teams) {
    this.teams = teams;
  }

  public int getTotalActiveGoals() {
    int contPlayersGoals = 0;
    int contTeamsGoals = 0;
    for (Team team : teams) {
      Player[] players = team.getPlayers();
      contTeamsGoals = contTeamsGoals + contPlayersGoals;
      for (Player player : players) {
        if (player.isActive() == true) {
          contPlayersGoals = contPlayersGoals + player.getGoals();
        }
      }
    }
    return contTeamsGoals;
  }
}
