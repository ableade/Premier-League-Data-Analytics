package footballcsv;

public class MatchRating {

	public MatchRating(int matchRating, int homeWins, int awayWins, int draws) {
		super();
		this.matchRating = matchRating;
		this.homeWins = homeWins;
		this.awayWins = awayWins;
		this.draws = draws;
	}
	int matchRating;
	
	int homeWins;
	int awayWins;
	int draws;
	
	public MatchRating (int matchRating) {
		this.matchRating = matchRating;
		this.homeWins =0;
		this.awayWins =0;
		this.draws =0;
	}
	public int getMatchRating() {
		return matchRating;
	}
	public void setMatchRating(int matchRating) {
		this.matchRating = matchRating;
	}
	public int getHomeWins() {
		return homeWins;
	}
	public void setHomeWins(int homeWins) {
		this.homeWins = homeWins;
	}
	public int getAwayWins() {
		return awayWins;
	}
	public void setAwayWins(int awayWins) {
		this.awayWins = awayWins;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	@Override
	public String toString() {
		return "MatchRating [matchRating=" + matchRating + ", homeWins="
				+ homeWins + ", awayWins=" + awayWins + ", draws=" + draws
				+ "]";
	}
	
	public int getTotalGames () {
		return this.awayWins+ this.homeWins +this.draws;
	}
	public float getHomeWinsPercent() {
		
		if(this.homeWins==0) {
			return (float) 0;
		}
		float percentage;
		return (  percentage = (float)this.homeWins *100/this.getTotalGames()) ;
	}
	
	public float getDrawsPercent() {
		if(this.draws==0) {
			return (float) 0;
		}
			
		float percentage;
		return (  percentage = (float)this.draws *100/this.getTotalGames());
	}
	
	public float getAwayWinsPercent() {
		if(this.awayWins==0) {
			return (float) 0;
		}
		float percentage;
		return (  percentage = (float)this.awayWins *100/this.getTotalGames()) ;
	}
}
