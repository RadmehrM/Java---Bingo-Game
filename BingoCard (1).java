public class BingoCard {
    /**
     * This class represents a Bingo card. Each bingo card has a set of numbers in the correct format, and
     * there is also a taken array which determines if a card has been taken or drawn in that card.
     * @author Radmehr Mehdipour
     */

    private int[][] card;
    private boolean[][] taken;

    public static final int[] MY_WINNER = {73, 20, 23, 7,
            32, 1, 16, 29, 68, 38, 52, 17};

    public BingoCard(int[] data) {
        /***
         * @param data: array of numbers we want to have on our bingo card.
         * takes data and puts its in 5 by 5 array called card which represents the bingo card.
         * initializes the taken array based on each number in card.
         */
        card = new int[5][5];
        taken = new boolean[5][5];

        //the middle of the card is always a free number given to the player.
        taken[2][2] = true;

        //creates a card based on the MY_WINNER array.
        if (data == MY_WINNER) {
            //this is the data that represent a card with MY_WINNER sequence.
            int[] newData = {1,7,8,9,10,16,17,20,23,29,32,38,40,41,52,53,54,55,56,73,68,69,70,71};
            int x = 0;
            for (int i = 0; i < card.length; i++) {
                for (int j = 0; j < card.length; j++) {
                    //give the middle square a value of 0 since its already given to the player.
                    if (i == 2 && j == 2) {
                        card[i][j] = 0;
                    }

                    else {
                        //place each number in the array data, into each column of bingo card.
                        card[i][j] = newData[x];
                        x++;
                    }
                }
            }
        }
        else {

            int x = 0;
            for (int i = 0; i < card.length; i++) {
                for (int j = 0; j < card.length; j++) {
                    if (i == 2 && j == 2) {
                        //give the middle square a value of 0 since its already given to the player.
                        card[i][j] = 0;
                    } else {
                        //place each number in the array data, into each column of bingo card.
                        card[i][j] = data[x];
                        x++;
                    }
                }
            }
        }

    }

    public boolean isValid() {
        /***
         * @returns a boolean value based on whether a card is valid or not.
         */

        //puts each number in the bingo card into an array.
        int[] numbers = new int[25];
        int x = 0;
        for (int[] ints: card) {
            for (int i = 0; i < card.length; i++) {
                numbers[x] = ints[i];
                x++;
            }
        }

        // checks for any duplications
        for (int z = 0; z < numbers.length; z++) {
            for (int y = z + 1; y < numbers.length; y++) {
                // if two numbers in the numbers array equal, then return false.
                if (numbers[z] == (numbers[y])) {
                    return false;
                }
            }
        }


        //This portion checks if each number is in the correct column.

        for (int i = 0; i < card.length; i++) {
            if (card[0][i] >= 15) {
                return false;
            }
            if (card[1][i] < 16 || card[1][i] > 30) {
                return false;
            }
            if (card[2][i] < 31 || card[2][i] > 45) {
                // this part is for the FR part of the bingo card. Since its always 0, it should return true.
                if (card[2][i] == 0) {
                    return true;
                }

                return false;
            }
            if (card[3][i] < 46 || card[3][i] > 60) {
                return false;
            }
            if (card[4][i] < 61 || card[4][i] > 75) {
                return false;
            }
        }

        return true;
    }

    public void drawn(int number) {
        /***
         * @param number: int that is drawn.
         *
         * changes the taken value based on the number that is drawn.
         */
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card.length; j++) {
                //the boolean needs to be in the same spot as the drawn number on the card.
                if (card[i][j] == number) {
                    taken[i][j] = true;
                }
            }
        }
    }

    public void drawn(int[] numbers) {
        /***
         * does the same thing as drawn but instead of one number it changes multiple taken values all at once.
         */
        for (int x = 0; x < card.length; x++) {
            for (int i = 0; i < card.length; i++) {
                for (int k: numbers) {
                    //for every number in numbers, if its in the card, then taken at that position should return true.
                    if (card[x][i] == k) {
                        taken[x][i] = true;
                    }
                }
            }
        }
    }

    public void reset() {
        //resets the whole taken array.
        for (int i = 0; i < taken.length; i++) {
            for (int j = 0; j < taken.length; j++) {
                taken[i][j] = false;
            }
        }

        taken[2][2] = true;
    }

    public boolean isAWinner() {
        /***
         * @returns a boolean to reveal whether we have a winning card or not.
         */

        // this portion is for every column that is taken in the bingo card. Returns true if one column is full. Therefore bingo.

        if ((taken[0][0] == true) && (taken[0][1] == true) && (taken[0][2] == true) && (taken[0][3] == true) && (taken[0][4] == true)) {
            return true;
        }
        else if (((taken[1][0] == true) && (taken[1][1] == true) && (taken[1][2] == true) && (taken[1][3] == true) && (taken[1][4] == true))) {
            return true;
        }

        else if (((taken[2][0] == true) && (taken[2][1] == true) && (taken[2][2] == true) && (taken[2][3] == true) && (taken[2][4] == true))) {
            return true;
        }

        else if (((taken[3][0] == true) && (taken[3][1] == true) && (taken[3][2] == true) && (taken[3][3] == true) && (taken[3][4] == true))) {
            return true;
        }

        else if (((taken[4][0] == true) && (taken[4][1] == true) && (taken[4][2] == true) && (taken[4][3] == true) && (taken[4][4] == true))) {
            return true;
        }

        //this portion is for every row that is the winner. So if a row is all taken you get bingo.

        else if (((taken[0][0] == true) && (taken[1][0] == true) && (taken[2][0] == true) && (taken[3][0] == true) && (taken[4][0] == true))) {
            return true;
        }

        else if (((taken[0][1] == true) && (taken[1][1] == true) && (taken[2][1] == true) && (taken[3][1] == true) && (taken[4][1] == true))) {
            return true;
        }

        else if (((taken[0][2] == true) && (taken[1][2] == true) && (taken[2][2] == true) && (taken[3][2] == true) && (taken[4][2] == true))) {
            return true;
        }

        else if (((taken[0][3] == true) && (taken[1][3] == true) && (taken[2][3] == true) && (taken[3][3] == true) && (taken[4][3] == true))) {
            return true;
        }

        else if (((taken[0][4] == true) && (taken[1][4] == true) && (taken[2][4] == true) && (taken[3][4] == true) && (taken[4][4] == true))) {
            return true;
        }

        // for diagonal wins. So if you get a diagonal, you get bingo.

        else if (((taken[0][0] == true) && (taken[1][1] == true) && (taken[2][2] == true) && (taken[3][3] == true) && (taken[4][4] == true))) {
            return true;
        }

        else if (((taken[0][4] == true) && (taken[1][3] == true) && (taken[2][2] == true) && (taken[3][1] == true) && (taken[4][0] == true))) {
            return true;
        }

        else {
            return false;
        }
    }

    public String toString() {
        String s = " B    I    N    G    O   " + "\n";

        for (int k = 0; k < card.length; k++) {
            //valueOf(int) reveals whether a number is single or double digits.
            if ((String.valueOf(card[k][0]).length()) == 2 && taken[k][0] == false) {
                s = s + " " + card[k][0] + "  ";
            }
            if ((String.valueOf(card[k][0]).length()) == 1 && taken[k][0] == false) {
                s = s + "  " + card[k][0] + "  ";
            }
            if (((String.valueOf(card[k][0]).length()) == 1) && taken[k][0] == true) {
                s = s + "[ " + card[k][0] + "] ";
            }
            if ((String.valueOf(card[k][0]).length()) == 2 && taken[k][0] == true) {
                s = s + "[" + card[k][0] + "] ";

            }

            //after the O column in bingo go to the next line.
            if (k == 4) {
                s = s + "\n";
            }
        }

        for (int k = 0; k < card.length; k++) {
            if ((String.valueOf(card[k][1]).length()) == 2 && taken[k][1] == false) {
                s = s + " " + card[k][1] + "  ";
            }
            if ((String.valueOf(card[k][1]).length()) == 1 && taken[k][1] == false) {
                s = s + "  " + card[k][1] + "  ";
            }
            if (((String.valueOf(card[k][1]).length()) == 1) && taken[k][1] == true) {
                s = s + "[ " + card[k][1] + "] ";
            }
            if ((String.valueOf(card[k][1]).length()) == 2 && taken[k][1] == true) {
                s = s + "[" + card[k][1] + "] ";
            }
            if (k == 4) {
                s = s + "\n";
            }
        }

        for (int k = 0; k < card.length; k++) {
            if ((String.valueOf(card[k][2]).length()) == 2 && taken[k][2] == false) {
                s = s + " " + card[k][2] + "  ";
            }
            if ((String.valueOf(card[k][2]).length()) == 1 && taken[k][2] == false) {
                s = s + "  " + card[k][2] + "  ";
            }
            if (((String.valueOf(card[k][2]).length()) == 1) && taken[k][2] == true) {
                if (k == 2) {
                    s = s + "[" + "FR" + "] ";
                }
                else {
                    s = s + "[ " + card[k][2] + "] ";
                }
            }
            if ((String.valueOf(card[k][2]).length()) == 2 && taken[k][2] == true) {
                s = s + "[" + card[k][2] + "] ";
            }
            if (k == 4) {
                s = s + "\n";
            }

        }

        for (int k = 0; k < card.length; k++) {
            if ((String.valueOf(card[k][3]).length()) == 2 && taken[k][3] == false) {
                s = s + " " + card[k][3] + "  ";
            }
            if ((String.valueOf(card[k][3]).length()) == 1 && taken[k][3] == false) {
                s = s + "  " + card[k][3] + "  ";
            }
            if (((String.valueOf(card[k][3]).length()) == 1) && taken[k][3] == true) {
                s = s + "[ " + card[k][3] + "] ";
            }
            if ((String.valueOf(card[k][3]).length()) == 2 && taken[k][3] == true) {
                s = s + "[" + card[k][3] + "] ";
            }
            if (k == 4) {
                s = s + "\n";
            }

        }

        for (int k = 0; k < card.length; k++) {
            if ((String.valueOf(card[k][4]).length()) == 2 && taken[k][4] == false) {
                s = s + " " + card[k][4] + "  ";
            }
            if ((String.valueOf(card[k][4]).length()) == 1 && taken[k][4] == false) {
                s = s + "  " + card[k][4] + "  ";
            }
            if (((String.valueOf(card[k][4]).length()) == 1) && taken[k][4] == true) {
                s = s + "[ " + card[k][4] + "] ";
            }
            if ((String.valueOf(card[k][4]).length()) == 2 && taken[k][4] == true) {
                s = s + "[" + card[k][4] + "] ";
            }
            if (k == 4) {
                s = s + "\n";
            }

        }

        return s;
    }

    private int minCalc(int[] mins) {
        /***
         * @param mins: list of mins.
         * goes thru each min that a card can have and returns the lowest one.
         */
        int min = mins[0];
        for (int number: mins) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public int minToWin() {
        /***
         * @returns the minimum numbers left for a bingo card before the player gets BINGO!
         * goes through each row, column and diagonal of taken, puts each number in array and then with help of a helper
         * method, returns the smallest minimum.
         */

        //Array where the minimums will go into.
        int[] mins = new int[12];
        int min;

        //will look at each column and put its minToWin in the array.
        int numFalse1 = 0;
        for (boolean b: taken[0]) {

            if (b == false) {
                numFalse1++;
            }
            mins[0] = numFalse1;
        }

        int numFalse2 = 0;
        for (boolean b: taken[1]) {

            if (b == false) {
                numFalse2++;
            }
            mins[1] = numFalse2;
        }

        int numFalse3 = 0;
        for (boolean b: taken[2]) {
            if (b == false) {
                numFalse3++;
            }
            mins[2] = numFalse3;
        }

        int numFalse4 = 0;
        for (boolean b: taken[3]) {

            if (b == false) {
                numFalse4++;
            }

        }
        mins[3] = numFalse4;

        int numFalse5 = 0;
        for (boolean b: taken[4]) {
            if (b == false) {
                numFalse5++;
            }
            mins[4] = numFalse5;
        }

        //will look at each rown and put every rows minToWin in the array.
        int numFalse6 = 0;
        for (int i = 0; i < card.length; i++) {
            if (taken[i][0] == false) {
                numFalse6++;
            }
            mins[5] = numFalse6;
        }

        int numFalse7 = 0;
        for (int i = 0; i < card.length; i++) {
            if (taken[i][1] == false) {
                numFalse7++;
            }
            mins[6] = numFalse7;
        }

        int numFalse8 = 0;
        for (int i = 0; i < card.length; i++) {
            if (taken[i][2] == false) {
                numFalse8++;
            }
            mins[7] = numFalse8;
        }

        int numFalse9 = 0;
        for (int i = 0; i < card.length; i++) {
            if (taken[i][3] == false) {
                numFalse9++;
            }
            mins[8] = numFalse9;
        }

        int numFalse10 = 0;
        for (int i = 0; i < card.length; i++) {
            if (taken[i][4] == false) {
                numFalse10++;
            }
            mins[9] = numFalse10;
        }

        //Looks at the diagonals of card and puts minToWin of both in array.
        int numFalse11 = 0;
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card.length; j++) {
                if (i == j && taken[i][j] == false) {
                    numFalse11++;
                }
                mins[10] = numFalse11;
            }
        }

        int numFalse12 = 0;
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card.length; j++) {
                if ((i + j) == (card.length - 1) && taken[i][j] == false) {
                    numFalse12++;
                }
                mins[11] = numFalse12;
            }
        }

        //helper method is used here.
        min = minCalc(mins);

        return min;
    }

}