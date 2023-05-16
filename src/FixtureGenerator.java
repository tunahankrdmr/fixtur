import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        if (teams.size()%2==1){
            teams.add("BAY");
        }

        Collections.shuffle(teams); // Takımları karıştır

        int numTeams = teams.size();
        int numRounds = numTeams - 1;

        List<List<String>> firstHalfRounds = new ArrayList<>();

        for (int round = 0; round < numRounds; round++) {
            List<String> matches = new ArrayList<>();

            for (int i = 0; i < numTeams / 2; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(numTeams - 1 - i);

                String match = homeTeam + " vs " + awayTeam;
                matches.add(match);
            }

            firstHalfRounds.add(matches);

            // Takımları döndürerek fikstürü güncelle
            teams.add(1, teams.remove(numTeams - 1));
        }

        System.out.println("İlk Yarı Maçları:");
        System.out.println("------------------");
        for (int round = 0; round < numRounds; round++) {
            System.out.println("Round " + (round + 1) + ":");
            for (String match : firstHalfRounds.get(round)) {
                System.out.println(match);
            }
            System.out.println();
        }

        Collections.reverse(teams); // Takımları tersine çevirerek ikinci yarı için fikstürü oluştur

        List<List<String>> secondHalfRounds = new ArrayList<>();

        for (int round = 0; round < numRounds; round++) {
            List<String> matches = new ArrayList<>();

            for (int i = 0; i < numTeams / 2; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(numTeams - 1 - i);

                String match = homeTeam + " vs " + awayTeam;
                matches.add(match);
            }

            secondHalfRounds.add(matches);

            // Takımları döndürerek fikstürü güncelle
            teams.add(1, teams.remove(numTeams - 1));
        }

        System.out.println("İkinci Yarı Maçları:");
        System.out.println("----------------------");
        for (int round = 0; round < numRounds; round++) {
            System.out.println("Round " + (round + 1) + ":");
            for (String match : secondHalfRounds.get(round)) {
                System.out.println(match);
            }
            System.out.println();
        }
    }
}
