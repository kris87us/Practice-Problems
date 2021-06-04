package learn.other;

public class ScoresClump {
    public static boolean scoresClump(int[] scores) {
        for (int i =1;i<=scores.length-1;i++) {
            if (Math.abs(scores[i] - scores[i-1]) >= 3) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(scoresClump(new int[]{3,4,6}));
    }
}
