package TennisDatabase;

public class TennisDatabase implements TennisDatabaseInterface {
    private TennisPlayersContainer tpc = null;
    private TennisMatchesContainer tmc = null;

    public TennisDatabase() { }

    public void loadFile() { }

    public void printAllPlayers() { tpc.printAllPlayers(); }

    public void printMatchesOfPlayer( String playerId ) { tpc.printMatchesOfPlayer(playerId); }

    public void printAllMatches() { tmc.printAllMatches(); }

    public void insertPlayer( String id, String firstName, String lastName, int year, String country ) {
        TennisPlayer p = new TennisPlayer( id, firstName, lastName, year, country);
        tpc.insertPlayer(p);
    };

    public void insertMatch( String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score ) {
        TennisMatch m = new TennisMatch( idPlayer1, idPlayer2, year, month, day, tournament, score );
        tmc.insertMatch(m);
    };
}