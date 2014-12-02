package footballcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.csv.CSVFormat; //the library is used for parsing and writing csv files
import org.apache.commons.csv.CSVParser; //parser used for reading csv files
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class FootballCsvParser {

	Map<Integer, MatchRating> matchRatings; // maps match ratings to match
											// rating objects
	Map<String, ArrayList<GoalDifferential>> teamGoalDifferences; // maps teams
																	// to their
																	// goals for
	// against count for all dates found in the csv file
	int matchratingLimit; // the number of games to use for the match rating  metric
	private static final String [] FILE_HEADER_MAPPING = {"Date","Team 1","Team 2","FT","HT"};
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	private static final String [] OUTPUT_CSV_MAPPING ={"Match rating", "home wins", "draws",
		"away wins", "total match pct", "home win pct", "draw pct", "away win pct"};
	String dirPath; // path to directory containing files to parse
	String outputCSV;
	// format to use for csv files that will be read
	CSVFormat format = CSVFormat.RFC4180.withHeader(FILE_HEADER_MAPPING).withDelimiter(',');
	 CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
	CSVParser parser;
	CSVPrinter csvFilePrinter ;
	public ArrayList<Match> matches; // set of all matches from csv files parsed

	/**
	 * initializes class members for the FootballCsvParser
	 * 
	 * @param dirPath
	 *            directory path for files
	 * @param matchLimit
	 *            limit to use for match rating
	 */
	public FootballCsvParser(String dirPath, int matchLimit, String outputFile) {
		super();
		this.matchratingLimit = matchLimit;
		this.dirPath = dirPath;
		this.matches = new ArrayList<Match>();
		this.teamGoalDifferences = new HashMap<String, ArrayList<GoalDifferential>>();
		this.matchRatings = new HashMap<Integer, MatchRating>();
		this.outputCSV = outputFile;
		
	}

	/**
	 * 
	 * @param args
	 *            array containing directory path of files to be parsed
	 * @throws FileNotFoundException
	 *             if file is not found
	 * @throws IOException
	 *             if file does not match expected format
	 */
	public static void main(String[] args) {
		
		if(args.length > 1 ) {
		int matchLimit = Integer.valueOf(args[1]);
		FootballCsvParser parser = new FootballCsvParser(args[0], matchLimit, args[2]);
		
		try {
			parser.process();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Number of Matches is" +parser.matches.size());
		System.out.println("Number of unique match ratings is "+ parser.matchRatings.size());
		try {
			parser.generateFinalCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	parser.printMap(parser.matchRatings);
		} else {
			System.out.println("Invalid number of arguments");
		}
		
	}

	/**
	 * adds goal differential to date for two teams. Computes and calculates the
	 * match rating for that particular game
	 * 
	 * @return
	 */
	public int getMatchRating(Match aMatch) {
		return Integer.MAX_VALUE;

	}

	/**
	 * Calculates goal superiority for a team within the time frame limit set
	 * 
	 * @param team
	 *            name of the team
	 * @return goal superiority of the team
	 */
	private int getGoalSuperiority(String team) {

		// check to see if we have encountered the home team
		if (this.teamGoalDifferences.containsKey(team)) {
			int goalDifferencesCount = this.teamGoalDifferences.get(team)
					.size();
			int baseIndex = goalDifferencesCount - 1; // index of the last
														// element in

			if (goalDifferencesCount > this.matchratingLimit) {
				int goalsFor = 0;
				int goalsAgainst = 0;

				// get all goals the team has scored within the time frame
				goalsFor = this.teamGoalDifferences.get(team).get(baseIndex)
						.getGoalsFor()
						- this.teamGoalDifferences.get(team)
								.get(baseIndex - this.matchratingLimit)
								.getGoalsFor();

				// get all goals scored against this team within the time frame
				goalsAgainst = this.teamGoalDifferences.get(team)
						.get(baseIndex).getGoalsAgainst()
						- this.teamGoalDifferences.get(team)
								.get(baseIndex - this.matchratingLimit)
								.getGoalsAgainst();
				return goalsFor - goalsAgainst;

			}

		}
		return Integer.MAX_VALUE;
	}

	/*
	 * add the goal differentials of each team in a match to the set of goal
	 * differentials each team has
	 * 
	 * @param aMatch The match
	 * 
	 * @ return true if there was a successful addition
	 */
	public boolean addGoalDifferentials(Match aMatch) {

		// create goal differential for home team
		GoalDifferential homeGoalDifferential = new GoalDifferential(
				aMatch.getDate(), aMatch.getHomeTeam(), aMatch.getHomeScore(),
				aMatch.getAwayScore());

		this.updateGoalDifferential(homeGoalDifferential);

		// create goal differential for away team
		GoalDifferential awayGoalDifferential = new GoalDifferential(
				aMatch.getDate(), aMatch.getAwayTeam(), aMatch.getAwayScore(),
				aMatch.getHomeScore());

		this.updateGoalDifferential(awayGoalDifferential);

		return (this.addGoalDifferential(homeGoalDifferential) && this
				.addGoalDifferential(awayGoalDifferential));

	}

	/**
	 * add goal differential to array lists for the team
	 * 
	 * @param gd
	 * @return
	 */
	private boolean addGoalDifferential(GoalDifferential gd) {
		// check to see if we already have the team
		if (this.teamGoalDifferences.containsKey(gd.getTeamName())) {
			return this.teamGoalDifferences.get(gd.getTeamName()).add(gd);
		} else {
			ArrayList<GoalDifferential> differentials = new ArrayList<GoalDifferential>();
			differentials.add(gd);
			this.teamGoalDifferences.put(gd.getTeamName(), differentials);
			return this.teamGoalDifferences.containsKey(gd.getTeamName());
		} 
	}

	/**
	 * updates goal differential to date for a particular team
	 * 
	 * @param gd
	 *            goal differential to be updated
	 */
	private void updateGoalDifferential(GoalDifferential gd) {
		if (this.teamGoalDifferences.containsKey(gd.getTeamName())) {
			int count = this.teamGoalDifferences.get(gd.getTeamName()).size();
			// get the last goal differential for the given team
			GoalDifferential lastGoalDifferential = this.teamGoalDifferences
					.get(gd.getTeamName()).get(count - 1);

			gd.setGoalsFor(lastGoalDifferential.getGoalsFor()
					+ gd.getGoalsFor());
			gd.setGoalsAgainst(lastGoalDifferential.getGoalsAgainst()
					+ gd.getGoalsAgainst());
		}
	}

	/*
	 * calculates and sets match rating for a given match and adds the match
	 * rating to the set of match ratings we have found so far
	 */
	public boolean addMatchRating(Match aMatch) {
		int homeGoalSuperiority = this.getGoalSuperiority(aMatch.getHomeTeam());
		int awayGoalSuperiority = this.getGoalSuperiority(aMatch.getAwayTeam());

		// check to see if the match is available for a match rating
		if (homeGoalSuperiority != Integer.MAX_VALUE
				&& awayGoalSuperiority != Integer.MAX_VALUE) {
			int matchRating = homeGoalSuperiority - awayGoalSuperiority;
			aMatch.setMatchRating(matchRating);
			MatchRating rating = new MatchRating(matchRating);
			// check to see if we have encountered this match rating
			if (this.matchRatings.containsKey(matchRating)) {

				rating = this.matchRatings.get(matchRating);
				// update this match rating with new information
			}
			if (aMatch.getHomeScore() > aMatch.getAwayScore()) { // did the home
																	// team win
				rating.setHomeWins(rating.getHomeWins() + 1);
			} else if (aMatch.getAwayScore() > aMatch.getHomeScore()) { // did
																		// the
																		// away
																		// side
																		// win
				rating.setAwayWins(rating.getAwayWins() + 1);
			} else { // the match ended as a draw
				rating.setDraws(rating.getDraws() + 1);
			}
			// add the match rating with updated statistics to our map of match
			// ratings
			this.matchRatings.put(matchRating, rating);
			return true;
		}
		return false;
	}

	public void readCSVFile(File fileName) throws FileNotFoundException,
			IOException, ParseException {

		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		this.parser = new CSVParser(new FileReader(fileName), this.format);
		this.teamGoalDifferences = new HashMap<String, ArrayList<GoalDifferential>>();
		List csvRecords = this.parser.getRecords(); 
		for( int i = 1; i < csvRecords.size(); i++) {
		CSVRecord record = (CSVRecord) csvRecords.get(i);
			Date date = format.parse(record.get("Date"));
			String homeTeam = record.get("Team 1");
			String awayTeam = record.get("Team 2");
			String fullTimeScore = record.get("FT");
			int homeSideGoals = Integer.valueOf(fullTimeScore.split("-")[0]);
			int awaySideGoals = Integer.valueOf(fullTimeScore.split("-")[1]);
			

			Match aMatch = new Match(homeTeam, awayTeam, date,
					Integer.MAX_VALUE, homeSideGoals, awaySideGoals);
			this.matches.add(aMatch);
			//add the match rating 
			this.addMatchRating(aMatch);
			this.addGoalDifferentials(aMatch);
		}

	}
	
	/**
	 * main processor for csv parser, goes through init directory
	 * and attempts to parse all files within the directory
	 * @throws FileNotFoundException if specified file is not found
	 * @throws IOException if there is an error reading the file
	 * @throws ParseException if there is an error parsing the file
	 */ 
	public void process () throws FileNotFoundException, IOException, ParseException {
		File folder = new File(this.dirPath);
		File[] filelist = folder.listFiles();
		
		for(int i =0; i<filelist.length; i++) {
			if(filelist[i].isFile()) {
				this.readCSVFile(filelist[i]);
			}
			}
	}
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	/**
	 * 
	 * @throws IOException if there is an error reading the file
	 */
	public void generateFinalCSV() throws IOException {
		FileWriter fileWriter = new FileWriter(this.outputCSV);
		this.csvFilePrinter= new CSVPrinter(fileWriter, csvFileFormat);
		Iterator it = this.matchRatings.entrySet().iterator();
		 this.csvFilePrinter.printRecord(OUTPUT_CSV_MAPPING);
		while(it.hasNext()) {
			List matchratings = new ArrayList();
			Map.Entry <Integer, MatchRating>pairs = (Entry<Integer, MatchRating>)it.next();
			matchratings.add((int)(pairs.getKey()));
			matchratings.add(pairs.getValue().getHomeWins());
			matchratings.add(pairs.getValue().getDraws());
			matchratings.add(pairs.getValue().getAwayWins());
			matchratings.add((float) pairs.getValue().getTotalGames() *100/this.matches.size());
			matchratings.add((float)(pairs.getValue().getHomeWinsPercent()));
			matchratings.add((float)(pairs.getValue().getDrawsPercent()));
			matchratings.add((float)(pairs.getValue().getAwayWinsPercent()));
			this.csvFilePrinter.printRecord(matchratings);
		}
		fileWriter.flush();
		fileWriter.close();
		this.csvFilePrinter.close();
		
	}
}
