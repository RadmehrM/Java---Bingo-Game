public class BingoTests {

    private static int[][] SEQ = {  // only the first sequence is used. The rest can be used for further testing...
            { 50, 32, 11, 15, 25, 20, 36, 42, 6, 43, 72, 62, 40, 5, 55, 30, 8, 59, 73, 47, 67, 70, 74, 44, 24, 26, 39,
                    51, 54, 3, 33, 64, 57, 9, 45, 58, 19, 17, 3, 1, 21, 2, 53, 69, 61, 23, 65, 38, 46, 60, 14, 56, 48,
                    49, 41, 66, 18, 27, 34, 28, 29, 37, 10, 71, 4, 22, 52, 75, 7, 12, 68, 63, 35, 16, 1, 13 },
            { 37, 57, 19, 7, 44, 17, 52, 41, 64, 45, 73, 13, 2, 32, 66, 58, 67, 74, 30, 38, 9, 75, 4, 3, 23, 42, 8, 43,
                    6, 61, 55, 25, 40, 15, 20, 54, 70, 33, 62, 49, 14, 69, 5, 16, 35, 11, 12, 26, 10, 56, 22, 60, 53,
                    50, 47, 72, 1, 46, 71, 29, 27, 31, 59, 24, 28, 63, 65, 34, 48, 21, 36, 68, 51, 18, 39 },
            { 75, 45, 74, 29, 56, 25, 50, 46, 27, 4, 57, 37, 65, 62, 31, 64, 26, 8, 69, 55, 54, 33, 73, 9, 24, 68, 16,
                    15, 18, 47, 52, 61, 1, 72, 13, 21, 2, 12, 38, 7, 34, 3, 59, 63, 10, 66, 42, 5, 43, 60, 71, 20, 32,
                    48, 36, 17, 35, 49, 22, 70, 41, 44, 6, 51, 53, 30, 28, 23, 14, 39, 40, 19, 58, 67, 11 },
            { 55, 6, 34, 33, 39, 43, 19, 67, 2, 59, 41, 18, 60, 72, 21, 28, 10, 23, 3, 56, 31, 54, 37, 68, 51, 75, 32,
                    8, 53, 13, 38, 65, 5, 26, 50, 63, 25, 57, 45, 40, 36, 47, 14, 30, 62, 61, 70, 20, 74, 48, 52, 69,
                    46, 9, 15, 4, 27, 35, 17, 66, 29, 24, 7, 58, 12, 11, 1, 49, 22, 42, 73, 16, 64, 44, 71 },
            { 1, 45, 37, 3, 60, 66, 46, 14, 20, 27, 55, 31, 58, 65, 28, 23, 29, 12, 38, 47, 57, 2, 32, 53, 68, 10, 69,
                    51, 36, 19, 75, 42, 4, 39, 34, 33, 7, 74, 11, 40, 54, 52, 15, 44, 6, 22, 73, 49, 8, 43, 50, 64, 63,
                    30, 56, 16, 67, 61, 70, 17, 62, 59, 25, 18, 48, 9, 71, 41, 26, 24, 13, 72, 21, 5, 35 },
            { 72, 35, 29, 57, 65, 11, 47, 2, 66, 59, 21, 42, 36, 64, 31, 68, 70, 46, 3, 32, 74, 55, 51, 39, 34, 69, 12,
                    45, 30, 9, 62, 8, 7, 53, 41, 56, 16, 50, 17, 1, 14, 25, 24, 10, 5, 22, 40, 20, 28, 67, 6, 18, 37,
                    63, 54, 71, 60, 38, 26, 23, 75, 15, 4, 61, 73, 43, 49, 44, 33, 13, 48, 27, 58, 19, 52 },
            { 72, 52, 37, 20, 70, 21, 65, 29, 28, 11, 32, 30, 51, 7, 60, 34, 62, 6, 53, 18, 8, 46, 67, 55, 22, 59, 73,
                    23, 33, 71, 13, 17, 66, 63, 48, 75, 43, 27, 54, 57, 25, 56, 5, 58, 24, 49, 4, 16, 36, 14, 61, 40,
                    41, 2, 69, 9, 31, 74, 39, 26, 47, 1, 64, 35, 3, 68, 42, 50, 44, 10, 19, 38, 15, 45, 12 },
            { 1, 23, 9, 62, 53, 17, 46, 65, 64, 10, 33, 73, 49, 2, 51, 44, 8, 28, 26, 31, 69, 36, 61, 27, 55, 16, 72,
                    70, 56, 20, 41, 30, 40, 7, 67, 24, 48, 47, 14, 12, 13, 57, 59, 60, 42, 68, 39, 37, 21, 58, 34, 43,
                    22, 35, 63, 45, 29, 66, 54, 18, 38, 6, 32, 52, 5, 3, 50, 75, 19, 74, 25, 11, 4, 15, 71 } };
    private static int[] SEQ_MYWINNER = { 73, 20, 23, 7, 32, 2, 16, 29, 68, 38, 52, 17 };
    private static int[][] TEST_DRAWS = { { 22, 50, 18, 13, 70, 66 }, { 12, 13, 27, 66, 33, 53, 58 },
            { 10, 24, 42, 56, 71, 22, 50, 73, 3, 31 } };
    private static int[][] BC_DATA = {
            { 9, 15, 4, 10, 7, 26, 30, 18, 24, 21, 32, 39, 42, 37, 58, 21, 49, 56, 50, 74, 65, 75, 71, 72 },
            { 12, 3, 7, 6, 11, 28, 24, 25, 22, 19, 31, 35, 45, 37, 52, 57, 56, 57, 53, 62, 66, 67, 72, 75 },
            { 4, 8, 5, 2, 13, 25, 27, 22, 26, 18, 36, 33, 34, 44, 50, 59, 48, 58, 46, 74, 71, 73, 70, 66 },
            { 11, 3, 7, 6, 12, 28, 24, 25, 22, 19, 31, 35, 45, 37, 52, 57, 56, 50, 53, 62, 66, 67, 72, 75 },
            { 9, 15, 4, 10, 7, 26, 30, 18, 24, 21, 32, 39, 42, 37, 58, 51, 49, 56, 50, 74, 65, 75, 71, 72 },
            { 10, 5, 12, 7, 2, 26, 24, 18, 29, 21, 33, 40, 43, 32, 49, 60, 57, 46, 56, 64, 67, 72, 62, 65 },
            { 7, 8, 6, 14, 9, 27, 16, 23, 25, 21, 44, 37, 45, 34, 53, 52, 60, 56, 48, 73, 66, 65, 74, 62 },
            { 4, 2, 13, 15, 6, 19, 24, 22, 26, 18, 33, 43, 34, 32, 55, 50, 58, 59, 46, 70, 73, 68, 64, 71 },
            { 5, 13, 7, 12, 10, 29, 19, 23, 26, 30, 41, 36, 40, 35, 51, 54, 56, 48, 53, 71, 61, 66, 69, 74 },
            { 5, 11, 9, 1, 2, 25, 16, 28, 20, 19, 39, 40, 44, 42, 55, 58, 54, 53, 60, 72, 67, 70, 61, 71 },
            { 6, 7, 11, 3, 4, 17, 18, 25, 24, 20, 38, 42, 33, 41, 48, 54, 52, 57, 46, 66, 63, 69, 64, 61 } };

    private static int passed = 0;
    private static int tested = 0;

    public static void main(String[] args) {
        BingoCard bc = new BingoCard(BC_DATA[2]);
        String result = bc.toString();

        // ********** BingoCard: constructor & toString() - (format and content)
        test(1, "BingoCard: constructor & toString() - (format and content)",
                result.contains(" B    I    N    G    O   ")
                        && result.contains("  4   25   36   50   74  ")
                        && result.contains("  8   27   33   59   71  ")
                        && result.contains("  5   22  [FR]  48   73  ")
                        && result.contains("  2   26   34   58   70  ")
                        && result.contains(" 13   18   44   46   66  "));

        BingoCard bc2 = new BingoCard(BC_DATA[1]);
        BingoCard bc3 = new BingoCard(BC_DATA[0]);

        // ********** BingoCard: isValid()
        test(2, "BingoCard: isValid()",
                (bc.isValid() + " " + bc2.isValid() + " " + bc3.isValid()).equals("true false false"));

        bc.drawn(TEST_DRAWS[0]);
        bc.reset();
        bc.drawn(TEST_DRAWS[1]);

        result = bc.toString();

        // ********** BingoCard: drawn and reset
        test(3, "BingoCard: drawn and reset",
                result.contains(" B    I    N    G    O   ")
                        && result.contains("  4   25   36   50   74  ")
                        && result.contains("  8  [27] [33]  59   71  ")
                        && result.contains("  5   22  [FR]  48   73  ")
                        && result.contains("  2   26   34  [58]  70  ")
                        && result.contains("[13]  18   44   46  [66] "));

        bc2 = new BingoCard(BC_DATA[3]);
        bc2.drawn(TEST_DRAWS[1]);
        bc3 = new BingoCard(BC_DATA[4]);
        bc3.drawn(TEST_DRAWS[1]);

        // ********** BingoCard: minToWin()
        test(4, "BingoCard: minToWin()", (bc.minToWin() + " " + bc2.minToWin() + " " + bc3.minToWin()).equals("1 3 4"));

        bc.drawn(TEST_DRAWS[2]);
        bc2.drawn(TEST_DRAWS[2]);
        bc3.drawn(TEST_DRAWS[2]);

        // ********** BingoCard: isAWinner()
        test(5, "BingoCard: isAWinner()",
                (bc.isAWinner() + " " + bc2.isAWinner() + " " + bc3.isAWinner()).equals("false false true"));

        bc = new BingoCard(BingoCard.MY_WINNER);

        bc.drawn(SEQ_MYWINNER);

        // ********** BingoCard: MY_WINNER
        test(6, "BingoCard: MY_WINNER", bc.isValid() && bc.isAWinner());

        BingoSim sim = new BingoSim(50);
        for (int i = 3; i < 11; i++) {
            sim.addCard(new BingoCard(BC_DATA[i]));
        }
        result = sim.toString();

        // ********** BingoSim: constructor & toString() - (format and content)
        test(7, "BingoSim: constructor & toString() - (format and content)",
                result.contains(" B    I    N    G    O   ")
                        && result.contains("  1   16   31   46   61  ")
                        && result.contains("  2   17   32   47   62  ")
                        && result.contains("  3   18   33   48   63  ")
                        && result.contains("  4   19   34   49   64  ")
                        && result.contains("  5   20   35   50   65  ")
                        && result.contains("  6   21   36   51   66  ")
                        && result.contains("  7   22   37   52   67  ")
                        && result.contains("  8   23   38   53   68  ")
                        && result.contains("  9   24   39   54   69  ")
                        && result.contains(" 10   25   40   55   70  ")
                        && result.contains(" 11   26   41   56   71  ")
                        && result.contains(" 12   27   42   57   72  ")
                        && result.contains(" 13   28   43   58   73  ")
                        && result.contains(" 14   29   44   59   74  ")
                        && result.contains(" 15   30   45   60   75  ")
                        && result.contains("# Drawn: 0")
                        && result.contains("mins:4 4 4 4 4 4 4 4 ")
                        && result.contains("# Winners: 0 out of 8"));

        result = sim.simulate(SEQ[0]);

        // ********** BingoSim: simulate
        test(8, "BingoSim: simulate",
                result.contains("Simulating ...")
                        && result.contains("1. G-50 3 4 4 4 3 4 4 4 ")
                        && result.contains("2. N-32 3 3 3 4 3 4 4 4 ")
                        && result.contains("3. B-11 2 3 3 4 3 4 4 3 ")
                        && result.contains("4. B-15 2 3 3 4 3 4 4 3 ")
                        && result.contains("5. I-25 2 3 3 3 3 4 4 2 ")
                        && result.contains("6. I-20 2 3 3 3 3 4 3 2 ")
                        && result.contains("7. N-36 2 3 3 3 3 3 3 2 ")
                        && result.contains("8. N-42 2 2 3 3 3 3 3 2 ")
                        && result.contains("9. B-6 2 2 3 3 2 3 3 2 ")
                        && result.contains("10. N-43 2 2 2 3 2 3 3 2 ")
                        && result.contains("11. O-72 2 2 2 3 2 3 2 2 ")
                        && result.contains("12. O-62 2 2 2 3 2 3 2 2 ")
                        && result.contains("13. N-40 2 2 1 3 2 2 2 2 ")
                        && result.contains("14. B-5 2 2 1 3 2 2 2 2 ")
                        && result.contains("15. G-55 2 2 1 3 2 2 1 2 ")
                        && result.contains("16. I-30 2 2 1 3 2 2 1 2 ")
                        && result.contains("17. B-8 2 2 1 3 2 2 1 2 ")
                        && result.contains("18. G-59 2 2 1 3 2 2 1 2 ")
                        && result.contains("19. O-73 2 2 1 2 2 2 1 2 ")
                        && result.contains("20. G-47 2 2 1 2 2 2 1 2 ")
                        && result.contains("21. O-67 2 2 1 2 2 2 1 2 ")
                        && result.contains("22. O-70 2 2 1 2 1 2 1 2 ")
                        && result.contains("23. O-74 2 2 1 2 1 2 1 2 ")
                        && result.contains("24. N-44 2 2 1 2 1 2 1 2 ")
                        && result.contains("25. I-24 1 2 1 2 1 2 1 2 ")
                        && result.contains("26. I-26 1 2 1 2 0 2 1 2 "));

        result = sim.showCardsWithMin(0);

        // ********** BingoSim: results
        test(9, "BingoSim: results",
                result.contains(" B    I    N    G    O   ")
                        && result.contains("  4   19   33  [55] [70] ")
                        && result.contains("  2  [24] [43] [50] [73] ")
                        && result.contains(" 13   22  [FR]  58   68  ")
                        && result.contains("[15] [26]  34  [59]  64  ")
                        && result.contains("[ 6]  18  [32]  46   71  "));

        result = sim.toString();

        // ********** BingoSim: updated
        test(10, "BingoSim: updated ",
                result.contains(" B    I    N    G    O   ")
                        && result.contains("  1   16   31   46   61  ")
                        && result.contains("  2   17  [32] [47] [62] ")
                        && result.contains("  3   18   33   48   63  ")
                        && result.contains("  4   19   34   49   64  ")
                        && result.contains("[ 5] [20]  35  [50]  65  ")
                        && result.contains("[ 6]  21  [36]  51   66  ")
                        && result.contains("  7   22   37   52  [67] ")
                        && result.contains("[ 8]  23   38   53   68  ")
                        && result.contains("  9  [24]  39   54   69  ")
                        && result.contains(" 10  [25] [40] [55] [70] ")
                        && result.contains("[11] [26]  41   56   71  ")
                        && result.contains(" 12   27  [42]  57  [72] ")
                        && result.contains(" 13   28  [43]  58  [73] ")
                        && result.contains(" 14   29  [44] [59] [74] ")
                        && result.contains("[15] [30]  45   60   75  ")
                        && result.contains("# Drawn: 26")
                        && result.contains("mins:1 2 1 2 0 2 1 2 ")
                        && result.contains("# Winners: 1 out of 8"));

        System.out.println("\n Your code passed " + passed + " out of " + tested);

    }

    public static void test(int testNumber, String message, boolean testStatus) {
        tested++;
        System.out.println("Test " + testNumber + " (" + message + ") " + (testStatus ? "passed" : "failed"));
        if (testStatus)
            passed++;
    }
}
