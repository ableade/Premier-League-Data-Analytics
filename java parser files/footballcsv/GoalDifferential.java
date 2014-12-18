/**
 * GoalDifferential.java
 */
package footballcsv;

import java.util.Date;


/**
 * This class provides a measure of goal superiority rating as it stood on
 * a certain date for the team. By keeping a measure of total goals for 
 * and total goals against each team  we can quickly 
 * calculate the goal superiority rating for any team within the  time period given 
 * @author Sola Adekunle
 *
 */
public class GoalDifferential {
	/**
	 * constructor 
	 * @param date the date for goal differential
	 * @param teamName the name of the team
	 * @param goalsFor total goals scored by team to date
	 * @param goalsAgainst total goals scored against a team to date
	 */
	public GoalDifferential(Date date, String teamName, int goalsFor,
			int goalsAgainst) {
		super();
		this.date = date;
		this.teamName = teamName;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
	}

	private Date date;
	private String teamName;
	private int goalsFor;
	private int goalsAgainst;
	
	/**
	 * calculates and returns goal differential
	 * @return goalsFor minus goalsAgainst
	 */
	public int getGoalDifferential() {
		return goalsFor - goalsAgainst;		
	}

	/**
	 * Overridden from java.lang.class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + goalsAgainst;
		result = prime * result + goalsFor;
		result = prime * result
				+ ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	/**
	 * Overridden from Java.lang.class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoalDifferential other = (GoalDifferential) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;	
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	/**
	 * returns date
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * sets the date
	 * @param date date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * returns the team name
	 * @return teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * sets a name for the team
	 * @param teamName team name
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * returns goals scored for team to date
	 * @return goals for the team
	 */
	public int getGoalsFor() {
		return goalsFor;
	}

	/**
	 * sets the goals for team
	 * @param goalsFor goals for team to date
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	/**
	 * gets goals against team to date
	 * @return goals against team
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	/**
	 * sets goals against team to date
	 * @param goalsAgainst goals against team
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
}
