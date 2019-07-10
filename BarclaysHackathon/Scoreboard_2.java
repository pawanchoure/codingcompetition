package CodingCompetition.Barclays;

/**
 * Created by Pawan on 2/5/2015.
 */
@SuppressWarnings("ALL")
public class Scoreboard {


    enum Score {
        B(1000),
        b(250),
        R(50),
        J(10000),
        D(20000);
        private final int scorePoint;

        Score(int scorePoint) {
            this.scorePoint = scorePoint;
        }

        public int getScorePoint() {
            return this.scorePoint;
        }

        public static int getScorePointValue(String input) {
            if (input.equals(Score.B.name())) {
                return Score.B.scorePoint;
            }
            if (input.equals(Score.b.name())) {
                return Score.b.scorePoint;
            }
            if (input.equals(Score.R.name())) {
                return Score.R.scorePoint;
            }
            if (input.equals(Score.J.name())) {
                return Score.J.scorePoint;
            }
            if (input.equals(Score.D.name())) {
                return Score.D.scorePoint;
            }
            return 0;
        }

    }

    public static void main(String args[]) {
        System.out.println(getScore("BbRJD"));

    }

    public static int getScore(String input) {
        if (input != null && !input.isEmpty()) {
            int score = 0;
            char[] charArray = input.toCharArray();
            for (char i : charArray) {
                String val=String.valueOf(i);
                score += Score.getScorePointValue(val);
            }
            return score;
        }
        return 0;

    }
}
