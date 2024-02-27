package jva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class HandScore {
    public int score;
    public int highest;

    public HandScore(int score, int highest) {
        this.score = score;
        this.highest = highest;
    }
}

public class Answer54 {
    public static HashMap<String, String> cardKeycode = new HashMap<String, String>();

    public static boolean hasFlush(String[] cards) {
        String suit = "";
        
        for (int i = 0; i < cards.length; i++) {
            if (suit == "") suit = cards[i].substring(1);
            if (suit != cards[i].substring(1)) {
                return false;
            }
        }
        return true;
    }

    public static HashMap<Integer, Integer> getCardMap(ArrayList<Integer> cards) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < cards.size(); i++) {
            int v = cards.get(i);

            if (map.containsKey(v)) {
                map.put(v, map.get(v) + 1);
            } else {
                map.put(v, 1);
            }
        }

        return map;
    }

    // 5 = four of a kind, 4 = full house, 3 = three of a kind, 2 = two pairs, 1 = pair
    public static int checkForPairsAndKinds(HashMap<Integer, Integer> map) {
        if (map.size() == 2) {
            for (int k : map.keySet()) {
                if (map.get(k) == 4) return 5;
                return 4;
            }
        }

        int handValue = 0;
        for (int k : map.keySet()) {
            if (map.get(k) == 3) return 3;
            if (map.get(k) == 2) handValue++;
        }

        return handValue;
    }

    public static ArrayList<Integer> getNumberValues(String[] cards) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < cards.length; i++) {
            String num = cards[i].substring(0, 1);
            if (cardKeycode.containsKey(num)) num = cardKeycode.get(num);

            numbers.add(Integer.parseInt(num));
        }

        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public static boolean hasStraight(ArrayList<Integer> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i) + 1 != cards.get(i + 1)) return false;
        }

        return true;
    }

    public static int getScore(String[] cardArr, ArrayList<Integer> numberValues) {
        boolean hasStraight = hasStraight(numberValues);
        boolean hasFlush = hasFlush(cardArr);
        int checkForPairsAndKinds = checkForPairsAndKinds(getCardMap(numberValues));

        if (hasFlush && hasStraight) {
            if (numberValues.get(4) == 14) return 10;
            return 9;
        }

        if (checkForPairsAndKinds > 3) 
            return checkForPairsAndKinds + 3;

        if (hasFlush) return 6;
        if (hasStraight) return 5;

        if (checkForPairsAndKinds > 0)
            return checkForPairsAndKinds + 1;

        return 1;
    }

    public static int getHighestValuePair(ArrayList<Integer> cards) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < cards.size(); i++) {
            int v = cards.get(i);

            if (map.containsKey(v)) {
                map.put(v, map.get(v) + 1);
            } else {
                map.put(v, 1);
            }
        }

        int highestPair = 0;
        for (int k : map.keySet()) {
            if (map.get(k) == 2 && k > highestPair) {
                highestPair = k;
            }
        }

        return highestPair;
    }

    public static HandScore getHand(String[] cardArr, ArrayList<Integer> numberValues) {
        HandScore handScore = new HandScore(getScore(cardArr, numberValues), 0);

        ArrayList<Integer> highestCardHands = new ArrayList<Integer>();
        highestCardHands.add(1);
        highestCardHands.add(5);
        highestCardHands.add(6);
        highestCardHands.add(9);
        highestCardHands.add(10);
        
        if (highestCardHands.contains(handScore.score)) {
            handScore.highest = numberValues.get(4);
        } else {
            if (handScore.score == 3 || handScore.score == 7 || handScore.score == 8) {
                handScore.highest = numberValues.get(2);
            } else {
                handScore.highest = getHighestValuePair(highestCardHands);
            }
        }

        return handScore;
    }

    public static void main(String[] args) throws Exception {
        cardKeycode.put("T", "10");
        cardKeycode.put("J", "11");
        cardKeycode.put("Q", "12");
        cardKeycode.put("K", "13");
        cardKeycode.put("A", "14");

        FileReader fr = new FileReader("psets/54.txt");
        BufferedReader reader = new BufferedReader(fr);
        
        String c = reader.readLine();

        int p1Wins = 0;
        while (c != null) {
            String p1Cards = c.substring(0, 14);
            String p2Cards = c.substring(15);

            String[] p1Arr = p1Cards.split(" ");
            String[] p2Arr = p2Cards.split(" ");

            HandScore p1Score = getHand(p1Arr, getNumberValues(p1Arr));
            HandScore p2Score = getHand(p1Arr, getNumberValues(p2Arr));

            System.out.println(p1Score.score + " : " + p2Score.score);

            if (p1Score.score > p2Score.score) {
                p1Wins++;
                c = reader.readLine();
                continue;
            } else if (p1Score.score == p2Score.score) {
                if (p1Score.highest > p2Score.highest) {
                    p1Wins++;
                    c = reader.readLine();
                    continue;
                } else if (p1Score.highest == p2Score.highest) {
                    ArrayList<Integer> p1List = getNumberValues(p1Arr);
                    ArrayList<Integer> p2List = getNumberValues(p2Arr);

                    int index = 4;
                    while (p1List.get(index) == p2List.get(index)) {
                        index--;

                        if (index == 0) break;
                    }
                }
            }

            c = reader.readLine();
        }

        reader.close();
        System.out.println(p1Wins);
    }
}
