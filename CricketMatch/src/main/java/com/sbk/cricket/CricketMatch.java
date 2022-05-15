package com.sbk.cricket;

import com.sbk.cricket.model.ScoreCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CricketMatch {

    enum Status {
        STRIKER("striker"), NON_STRIKER("non-striker"), OUT("out"),YET_TO_BAT("yet-to-bat");
        private final String value;

        Status(final String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value;
        }
    };

    public static void main(String[] args) throws IOException {
        int numberOfPlayers, numberOfOvers;
        int[] grandScore = new int[2];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("No. of players for each team: ");
        numberOfPlayers = Integer.parseInt(input.readLine());
        System.out.println("No. of overs: ");
        numberOfOvers = Integer.parseInt(input.readLine());
        List<List<ScoreCard>> innings = new ArrayList<>();
        boolean allOut = false;
        for (int i = 1; i <= 2; i++) {
            grandScore[i - 1] = 0;
            List<ScoreCard> scorecardList = new ArrayList<>();
            System.out.println("Batting Order for team " + i + ":");
            for (int j = 1; j <= numberOfPlayers; j++) {
                scorecardList.add(new ScoreCard(j, "P" + j, 0, 0, 0, 0));
                System.out.println("P" + j);
            }
            ScoreCard onStrike = scorecardList.get(0);
            ScoreCard onNonStrike = scorecardList.get(1);
            allOut = false;
            int wicketCnt = 0;
            for (int k = 1; k <= numberOfOvers; k++) {
                List<String> singleOver = new ArrayList<>();
                System.out.println("Over " + k);
                singleOver = Stream.of(input.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(Collectors.toList());
                System.out.println("singleOver" + singleOver);
                for (int l = 0; l < singleOver.size(); l++) {
                    String singleBall = singleOver.get(l);
                    onStrike.setNumberOfBalls(onStrike.getNumberOfBalls() + 1);
                    if (singleBall.equalsIgnoreCase("WD") || singleBall.equalsIgnoreCase("NB")) {
                        grandScore[i - 1]++;
                        onStrike.setNumberOfBalls(onStrike.getNumberOfBalls() - 1);
                    } else if (singleBall.equalsIgnoreCase("W")) {
                        wicketCnt++;
                        allOut = (numberOfPlayers-1) == wicketCnt;
                        if (allOut)
                            break;
                        int outIdx = onStrike.getSrno() - 1;
                        onStrike.setStatus(Status.OUT.value);
                        scorecardList.remove(outIdx);
                        scorecardList.add(outIdx, onStrike);
                        onStrike = scorecardList.get(wicketCnt + 1);
                    } else {
                        int run = Integer.parseInt(singleBall);
                        grandScore[i - 1] += run;
                        onStrike.setScore(onStrike.getScore() + run);
                        if (run == 4)
                            onStrike.setFours(onStrike.getFours() + 1);
                        else if (run == 6)
                            onStrike.setSixes(onStrike.getSixes() + 1);
                        else if (run % 2 != 0) {
                            System.out.println("changing strike");
                            ScoreCard tmp = onStrike;
                            onStrike = onNonStrike;
                            onNonStrike = tmp;
                        }
                    }
                }

                printScoreBoard(i, scorecardList, grandScore[i - 1], wicketCnt, k);
                innings.add(scorecardList);
                if (allOut)
                    break;
                // System.out.println(scorecardList);
                if(numberOfOvers!= k){
                    System.out.println("changing strike");
                    ScoreCard tmp = onStrike;
                    onStrike = onNonStrike;
                    onNonStrike = tmp;
                }
            }
        }
        System.out.println("Result: Team "+(grandScore[0]>grandScore[1] ? "1": "2")+" won the match by "+Math.abs(grandScore[0]-grandScore[1])+" runs");
    }
    private static void printScoreBoard(int team,List<ScoreCard> scorecardList, int grantScore, int wicket,int overCnt){
        System.out.println("Scorecard for Team "+team);
        System.out.println("Player Name \tScore \t4s \t6s \tBalls");
        for (ScoreCard sc :scorecardList) {
            System.out.println(sc.getPlayerName()+"\t\t\t\t"+sc.getScore()+"\t\t"+sc.getFours()+"\t"+sc.getSixes()+"\t"+sc.getNumberOfBalls());
        }
        System.out.println("Total: "+grantScore+"/"+wicket);
        System.out.println("Over: "+overCnt);
    }
}
