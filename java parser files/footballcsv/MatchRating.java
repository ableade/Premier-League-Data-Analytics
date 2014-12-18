/**
 * MatchRating.java
 */
package footballcsv;
/**
 * stores a match rating and number of home wins, away wins and draws
 * for that match rating
 * @author Sola Adekunle
 * @version 1.0
 *
 */
public class MatchRating {

	public MatchRating(int matchRating, int homeWins, int awayWins, int draws) {
		super();
		this.matchRating = matchRating;
		this.homeWins = homeWins;
		this.awayWins = awayWins;
		this.draws = draws;
	}
	int matchRating;
	
	private int homeWins;
	private int awayWins;
	private int draws;
	
	/**
	 * constructor
	 * @param matchRating a match rating
	 */
	public MatchRating (int matchRating) {
		this.matchRating = matchRating;
		this.homeWins =0;
		this.awayWins =0;
		this.draws =0;
	}
	/**
	 * returns the match rating
	 * @return the match rating
	 */
	public int getMatchRating() {
		return matchRating;
	}
	/**
	 * sets the match rating
	 * @param matchRating the match rating
	 */
	public void setMatchRating(int matchRating) {
		this.matchRating = matchRating;
	}
	/**
	 * returns the number of home wins for the match rating
	 * @return number of home wins
	 */
	public int getHomeWins() {
		return homeWins;
	}
	
	/**
	 * sets the number of home wins for the match rating
	 * @param homeWins number of home wins
	 */
	public void setHomeWins(int homeWins) {
		this.homeWins = homeWins;
	}
	
	/**
	 * returns the number of away wins for the match rating
	 * @return number of away wins
	 */
	public int getAwayWins() {
		return awayWins;
	}
	
	/**
	 * sets the number of away wins for the match rating
	 * @param awayWins number of away wins
	 */
	public void setAwayWins(int awayWins) {
		this.awayWins = awayWins;
	}
	/**
	 * returns the number of draws for the match rating
	 * @return number of draws
	 */
	public int getDraws() {
		return draws;
	}
	/**
	 * sets the number of draws for the match rating
	 * @param draws number of draws
	 */
	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	/**
	 * Overridden from Java.lang.class
	 */
	@Override
	public String toString() {
		return "MatchRating [matchRating=" + matchRating + ", homeWins="
				+ homeWins + ", awayWins=" + awayWins + ", draws=" + draws
				+ "]";
	}
	/**
	 * gets total home wins, draws and away wins and returns a total
	 * @return total of home wins, draws and away wins
	 */
	public int getTotalGames () {
		return this.awayWins+ this.homeWins +this.draws;
	}
	/**
	 * returns home wins as a percentage of total games for the match rating
	 * @return home win pecentage
	 */
	public float getHomeWinsPercent() {
		float percentage =0;
		if(this.homeWins!=0) {
			percentage = (float)this.homeWins *100/this.getTotalGames() ;
		}
		
		return percentage;
	}
	/**
	 * returns draws as a percentage of total games for the match rating
	 * @return draw percentage
	 */
	public float getDrawsPercent() {
		float percentage =0;
		if(this.draws!=0) {
			percentage = (float)this.draws *100/this.getTotalGames() ;
		}
		
		return percentage;
	}
	
	/**
	 * returns away wins as a percentage of total games for match rating
	 * @return away wins percentage
	 */
	public float getAwayWinsPercent() {
		float percentage =0;
		if(this.awayWins!=0) {
			percentage = (float)this.awayWins *100/this.getTotalGames() ;
		}
		
		return percentage;
	}
}
