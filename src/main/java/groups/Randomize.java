package groups;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

public class Randomize {

    List<String> firstBucket() {

        List<String> teams = new ArrayList<String>();
        teams.add("Real Madryt");
        teams.add("Atletico Madryt");
        teams.add("Barcelona");
        teams.add("Manchester City");
        teams.add("Bayern Monachium");
        teams.add("PSG");
        teams.add("Lokomotiv Moskwa");
        teams.add("Juventus");
        return teams;
    }

    List<String> secondBucket() {

        List<String> teams = new ArrayList<String>();
        teams.add("Borrusia Dortmund");
        teams.add("FC Porto");
        teams.add("Manchester United");
        teams.add("Szachtar Donieck");
        teams.add("AS Roma");
        teams.add("Napoli");
        teams.add("Tottenham Hotspurs");
        teams.add("Benfica");
        return teams;
    }

    List<String> thirdBucket() {

        List<String> teams = new ArrayList<String>();
        teams.add("Liverpool");
        teams.add("Schalke 04");
        teams.add("Olympique Lyon");
        teams.add("AS Monaco");
        teams.add("Ajax Amsterdam");
        teams.add("CSKA Moskwa");
        teams.add("PSV Eindhoven");
        teams.add("Valencia");
        return teams;
    }

    List<String> fourthBucket() {
        List<String> teams = new ArrayList<String>();
        teams.add("Victoria Pilzno");
        teams.add("Crvena Zvezda");
        teams.add("Club Brugge");
        teams.add("Galatasaray");
        teams.add("Young Boys");
        teams.add("Inter Mediolan");
        teams.add("Hoffenheim");
        teams.add("AEK Ateny");
        return teams;
    }



    //Drawing and set number of group
    public void drawingFrom1bucket(List<String> bucketList, Multimap<Integer,String> groups) {
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            int index = random.nextInt(bucketList.size());
            String team = bucketList.get(index);
            groups.put(i, team);

            bucketList.remove(index);
        }
    }

    // Creation group List
    public List<String> groupList() {
        List<String> group = new ArrayList<String>();
        for (char i = 'A'; i <= 'H'; i++) {
            group.add(Character.toString(i));
        }
        return group;
    }

    //Printing drawing result
    public void printDrawingResult(Multimap<Integer,String> groups,List<String> groupList) {

        // Printing result for each group
        Set<Integer> keys = groups.keySet();
        for (int key : keys) {
            String groupName = "Group" + (groupList().get(key)) + ": ";
            System.out.print(groupName);
            for (String team : groups.get(key)) {
                String teamDrawn = team;
                System.out.print(teamDrawn + ", ");
            }
            System.out.println();
        }
    }

    public int findingRealMadrytGroup(Multimap<Integer,String> groups,List<String> groupList) {

        // Printing result for each group
        int groupIndex = 0;
        Set<Integer> keys = groups.keySet();
        for (int key : keys) {
            for (String team : groups.get(key)) {
                if (team.equals("Real Madryt")) {
                    System.out.println("Real Madryt will play in group "+ groupList().get(key)+".");
                    groupIndex = key;
                }
            }
        }
            return groupIndex;
    }

    public  List<String> realMadridOpponents (Multimap<Integer,String> groups, int groupIndex) {

        List<String> listOpponents = new ArrayList<String>();
        for (String team: groups.get(groupIndex)) {
            listOpponents.add(team);
        }
        listOpponents.remove(0);

        return listOpponents;
    }

    public static void main(String[] args) {

        Randomize randomize = new Randomize();

        Multimap<Integer,String> groups = ArrayListMultimap.create();


        //Drawing team from each bucket independently
        randomize.drawingFrom1bucket(randomize.firstBucket(),groups);
        randomize.drawingFrom1bucket(randomize.secondBucket(),groups);
        randomize.drawingFrom1bucket(randomize.thirdBucket(),groups);
        randomize.drawingFrom1bucket(randomize.fourthBucket(),groups);

        //Printing result
        randomize.printDrawingResult(groups,randomize.groupList());

        //Printing result - which group has been drawn by Real Madrid.
        System.out.println();
        int indexNumber = randomize.findingRealMadrytGroup(groups,randomize.groupList());

        List<String> opponents = randomize.realMadridOpponents(groups,indexNumber);

        System.out.println("Group opponents of Real Madrid: " + opponents.get(0) + ", " + opponents.get(1) + " i " +
                opponents.get(2)+".");
	
	//Welcome

    }
}
