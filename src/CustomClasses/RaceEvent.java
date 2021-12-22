package CustomClasses;

import java.util.LinkedList;
import java.util.List;

public class RaceEvent {

    //DATA

    int numberOfTeams;
    int numberOfRowers;
    int numberOfErgs;

    List<Team> teamList;


    // CONSTRUCTOR

    public RaceEvent (int numberOfTeams, int numberOfRowers, int numberOfErgs) {
        this.numberOfTeams = numberOfTeams;
        this.numberOfRowers = numberOfRowers;
        this.numberOfErgs = numberOfErgs;

        teamList = new LinkedList<>();
    }


    // GETTERS
    public int getNumberOfErgs() {
        return numberOfErgs;
    }

    public int getNumberOfRowers() {
        return numberOfRowers;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }




}