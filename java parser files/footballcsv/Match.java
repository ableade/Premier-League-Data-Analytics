/**
 * Match.java
 */
package footballcsv;

import java.util.Date;

/**
 * This class is used to represent a match
 * it can be extended for use with other kinds of data
 * @version 1.0
 * @author Sola Adekunle
 *
 */
public class Match {
	
	
	/**
	 * constructor
	 * @param homeTeam the name of the home team
	 * @param awayTeam the name of the away team
	 * @param date the date the match was played
	 * @param matchRating the match rating of the match
	 * @param homeScore number of goals for home team
	 * @param awayScore number of goals for the away team
	 */
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
	private String homeTeam;  //team that played at home
	private String awayTeam;  //team that played away	 
	private Date date;     //date the match was played
	private int MatchRating;  //the match rating for the game
	private int homeGoals; //goals scored by home team
	private int awayGoals; // goals scored by the away team
	
	/**
	 * returns name of home team
	 * @return the home team
	 */
	public String getHomeTeam() {
		return homeTeam;
	}
	
	/**
	 * sets the name of the home team
	 * @param homeTeam the home team
	 */
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	/**
	 * returns name of the away team
	 * @return the away team
	 */
	public String getAwayTeam() {
		return awayTeam;
	}
	/**
	 * sets the name of the away team
	 * @param awayTeam the away team
	 */
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	/**
	 * returns the date of the match
	 * @return match date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * sets the date of the match
	 * @param date match date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * returns the match rating of the match
	 * @return match rating
	 */
	public int getMatchRating() {
		return MatchRating;
	}
	/**
	 * sets the match rating for the match
	 * @param matchRating sets the match rating
	 */
	public void setMatchRating(int matchRating) {
		MatchRating = matchRating;
	}
	/**
	 * returns number of goals scored for the home team
	 * @return number of goals scored for the away team
	 */
	public int getHomeScore() {
		return homeGoals;
	}
	
	/**
	 * sets the number of goals for the home team
	 * @param homeScore home number of goals
	 */
	public void setHomeScore(int homeScore) {
		this.homeGoals = homeScore;
	}
	
	/**
	 * returns the number of goals for the away team
	 * @return away team number of goals
	 */
	public int getAwayScore() {
		return awayGoals;
	}
	/**
	 * sets the number of goals for the away team
	 * @param awayScore number of goals for away team
	 */
	public void setAwayScore(int awayScore) {
		this.awayGoals = awayScore;
	}
}
