package com.examen.ledevin;

public class Stats {

    private   int score_recent;
    private   int score_min;
    private   int score_max;
    private  int games_won ;
    private  int games_lost;

    public Stats() {
    }

    public Stats(int score_recent, int score_min, int score_max, int games_won, int games_lost) {

        this.score_recent = score_recent;
        this.score_min = score_min;
        this.score_max = score_max;
        this.games_won = games_won;
        this.games_lost = games_lost;
    }



    public int getScore_recent() {
        return score_recent;
    }

    public void setScore_recent(int score_recent) {
        this.score_recent = score_recent;
    }

    public int getScore_min() {
        return score_min;
    }

    public void setScore_min(int score_min) {
        this.score_min = score_min;
    }

    public int getScore_max() {
        return score_max;
    }

    public void setScore_max(int score_max) {
        this.score_max = score_max;
    }

    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    public int getGames_lost() {
        return games_lost;
    }

    public void setGames_lost(int games_lost) {
        this.games_lost = games_lost;
    }
}
