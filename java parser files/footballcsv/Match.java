package footballcsv;

import java.util.Date;

/**
 * This class is used to represent a match
 * it is not used in our match ratings for draws/wins prediction but is
 * included so it can be extended for use with other kinds of data
 * @author Sola Adekunle
 *
 */
public class Match {
	
	
	public Match(String homeTeam, String awayTeam, Date date, int matchRating,
			int homeScore, int awayScore) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.date = date;
		MatchRating = matchRating;
		this.homeGoals = homeScore;
		this.awayGoals = awayScore;
	}
	String homeTeam;  //team that played at home
	String awayTeam;  //team that played away	 
	Date date;     //date the match was played
	int MatchRating;  //the match rating for the game
	int homeGoals; //goals scored by home team
	int awayGoals; // goals scored by the away team
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMatchRating() {
		return MatchRating;
	}
	public void setMatchRating(int matchRating) {
		MatchRating = matchRating;
	}
	public int getHomeScore() {
		return homeGoals;
	}
	public void setHomeScore(int homeScore) {
		this.homeGoals = homeScore;
	}
	public int getAwayScore() {
		return awayGoals;
	}
	public void setAwayScore(int awayScore) {
		this.awayGoals = awayScore;
	}
}
