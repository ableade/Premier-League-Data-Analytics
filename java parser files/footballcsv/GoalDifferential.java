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
	
	public int getGoalDifferential() {
		return goalsFor - goalsAgainst;		
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
}
