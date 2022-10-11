
public class BingoSim {
    /**
     * This class represents Bingo game simulations, each game has multiple cards playing in it.
     * @author Radmehr Mehdipour
     */
    private int numCards;
    private boolean[] taken;
    private BingoCard[] cards;
    public BingoSim(int max) {
        /***
         * Constructor method
         * initializes cards and taken variables.
         */
        cards = new BingoCard[max];
        taken = new boolean[76];
    }

    public void addCard(BingoCard b) {
        /***
         * @param a bingo card.
         * adds a bingo card to the cards array.
         */

        //if the num of cards does not equal length of array.
        if (! (numCards == cards.length)) {
            cards[numCards] = b;
            numCards++;
        }
    }

    private BingoCard[] removeNullCards(BingoCard[] cards) {
        /***
         * @param array of bingo cards
         * @returns an array of new bingo cards that doesn't include a null bingo card.
         * private helper method that removes all the null cards from the cards array.
         */
        int nullCount = 0;
        for (BingoCard card: cards) {
            if (card == null) {
                // if card is null add to the null count.
                nullCount++;
            }
        }
        BingoCard[] newCards = new BingoCard[cards.length - nullCount];

        int x = 0;
        // add the bingo cards that aren't null to the newCards array.
        for (BingoCard card: cards) {
            if (card != null) {
                newCards[x] = card;
                x++;
            }
        }
        return newCards;
    }

    private String minArrayStr(BingoCard[] b, int drawNum) {
        /***
         * @param array of bingo cards.
         * @param number that is being drawn
         * @returns A string of minToWins for each card in the cards array.
         */
        BingoCard[] newCards = removeNullCards(b);
        String s = "";
        int x = 0;
        int[] minValArr = new int[newCards.length];
        for (BingoCard card: newCards) {
            //the drawn number will affect whether or not a minToWin is changed.
            card.drawn(drawNum);
            minValArr[x] = card.minToWin();
            x++;
        }

        for (int i = 0; i < minValArr.length; i++) {
            s = s + minValArr[i] + " ";
        }

        return s;
    }

    private void changeTaken(int num) {
        /***
         * @param the index that needs to be changed in the taken array.
         * changes an element of the taken array from false to true.
         *
         */
        taken[num] = true;

    }

    private int findIndex(int nums[], int num) {
        /***
         * @param nums: its an array that we want to check.
         * @param num: the element in nums that we want the index of.
         * @returns the index of a num in the nums array.
         */
        int index = 0;
        //loops through every element until it finds num in nums.
        for (int i =0; i < nums.length; i++) {
            if (nums[i] == num) {
                index = i;
            }
        }
        return index;
    }

    public String simulate(int[] sequence) {
        /***
         * @param sequence: sequence of numbers that have been drawn.
         * @returns a string that represent a simulation of the bingo game.
         */
        int[] numList = {1, 16, 31, 46, 61, 2, 17, 32, 47, 62, 3, 18, 33, 48, 63, 4, 19, 34, 49, 64, 5, 20, 35, 50, 65,
                6, 21, 36, 51, 66, 7, 22, 37, 52, 67, 8, 23, 38, 53, 68, 9, 24, 39, 54, 69, 10, 25, 40, 55, 70,11, 26,
                41, 56, 71, 12, 27, 42, 57, 72, 13, 28, 43, 58, 73, 14, 29,44, 59, 74, 15, 30, 45, 60, 75};

        BingoCard[] newCards = removeNullCards(cards);
        String s = "Simulating ..." + "\n";

        for (int i = 0; i < sequence.length; i++) {
            //change the value of element in taken based on what numbers are available in the sequence.
            changeTaken(findIndex(numList, sequence[i]));
            if (sequence[i] > 0 && sequence[i] <= 15) {
                //if a number is between 0 and 15 and its double digit.
                //used to minArrayStr to show all of the cards minToWins in one string.
                if (sequence[i] > 0 && sequence[i] <= 15 && (String.valueOf(sequence[i]).length()) == 2) {
                    s = s + (i + 1) + "." + " " + "B" + "-" + sequence[i] + " " + minArrayStr(newCards, sequence[i]) + "\n";
                } else {
                    s = s + (i + 1) + "." + " " + "B" + "-" + sequence[i] + " " + minArrayStr(newCards, sequence[i]) + "\n";
                }
            } else if (sequence[i] > 15 && sequence[i] <= 30) {
                s = s + (i + 1) + "." + " " + "I" + "-" + sequence[i] + " " + minArrayStr(newCards, sequence[i]) + "\n";
            } else if (sequence[i] > 30 && sequence[i] <= 45) {
                s = s + (i + 1) + "." + " " + "N" + "-" + sequence[i] + " " + minArrayStr(newCards, sequence[i]) + "\n";
            } else if (sequence[i] > 45 && sequence[i] <= 60) {
                s = s + (i + 1) + "." + " " + "G" + "-" + sequence[i] + " " + minArrayStr(newCards, sequence[i]) + "\n";
            } else if (sequence[i] > 60 && sequence[i] <= 75) {
                s = s + (i + 1) + "." + " " + "O" + "-" + sequence[i] + " " + minArrayStr(newCards, sequence[i]) + "\n";
            }

            //if any of the minToWin values are 0 stop the loop.
            if (minArrayStr(newCards, sequence[i]).contains("0")) {
                break;
            }
        }
        return s;
    }

    public String showCardsWithMin(int min) {
        /***
         * @param min: the minimum that we want to check which card has.
         * @returns the card with of minToWin value of min.
         */
        BingoCard[] newCards = removeNullCards(cards);
        String s = "";
        for (BingoCard card: newCards) {
            //if minToWin of card equals min then add the string form to s.
            if (card.minToWin() == min) {
                s = s + card.toString() + "\n";
            }
        }
        return s;
    }

    public String toString() {
        BingoCard[] newCards = removeNullCards(cards);
        int numWinner = 0;
        int drawn = 0;
        boolean takens[][] = new boolean[15][5];
        int x = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                takens[i][j] = taken[x];
                x++;
            }
        }

        int[][] numbersList = {{1, 16, 31, 46, 61}, {2, 17, 32, 47, 62}, {3, 18, 33, 48, 63}, {4, 19, 34, 49, 64}, {5, 20, 35, 50, 65},
                {6, 21, 36, 51, 66}, {7, 22, 37, 52, 67}, {8, 23, 38, 53, 68}, {9, 24, 39, 54, 69}, {10, 25, 40, 55, 70},
                {11, 26, 41, 56, 71}, {12, 27, 42, 57, 72}, {13, 28, 43, 58, 73}, {14, 29, 44, 59, 74}, {15, 30, 45, 60, 75} };

        String s = " B    I    N    G    O   " + "\n";

        //loop through each number in each array of numbersList and depending on if a number is taken by a bingo card,
        //return different strings.

        for (int i = 0; i < numbersList.length; i++) {
            for (int j = 0; j < numbersList[i].length; j++) {
                if ((String.valueOf(numbersList[i][j]).length()) == 2) {
                    if (j == 4) {
                        if (takens[i][j] == true) {
                            s = s + "[" + numbersList[i][j] + "] " + "\n";
                            //for every number that is taken add one to drawn.
                            drawn++;
                        } else {
                            s = s + " " + numbersList[i][j] + "  " + "\n";
                        }
                    } else if ((takens[i][j] == true)) {
                        s = s + "[" + numbersList[i][j] + "] ";
                        drawn++;

                    } else {
                        s = s + " " + numbersList[i][j] + "  ";
                    }

                } else if ((String.valueOf(numbersList[i][j]).length()) == 1) {

                    if ((takens[i][j] == true)) {
                        s = s + "[ " + numbersList[i][j] + "] ";
                        drawn++;
                    } else {
                        s = s + "  " + numbersList[i][j] + "  ";
                    }
                }

            }
        }

        s = s + "# Drawn: " + drawn + "\n";
        s = s + "mins:";

        for (BingoCard card: newCards) {
            //add all the cards minToWin to a string and then add that string to the main string we want to return.
            s = s + card.minToWin() + " ";
            if (card.isAWinner() == true) {
                numWinner++;
            }
        }

        s = s + "\n" + "# Winners: " + numWinner + " out of " + String.valueOf(newCards.length);

        return s;
    }

}