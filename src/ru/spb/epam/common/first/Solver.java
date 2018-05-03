package ru.spb.epam.common.first;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solver implements ISolver {
    public void task1() {
        String[] string;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine());
            int MAX = 0;
            int MIN = 0;
            string = new String[n]; //массив строк

            for (int i = 0; i < n; i++) {
                string[i] = scanner.nextLine();
                if (string[i].length() <= string[MIN].length())
                    MIN = i;
                if (string[i].length() >= string[MAX].length())
                    MAX = i;
            }

            //System.out.println("Количество строк:" + n );
            System.out.printf("MIN (%d): \"%s\"%n", string[MIN].length(), string[MIN]);
            System.out.printf("MAX (%d): \"%s\"%n", string[MAX].length(), string[MAX]);
        }
    }

    public void task2() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int n = Integer.parseInt(scan.nextLine());
            List<String> string = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                string.add(scan.nextLine());
            }
            StringLengthListSort sort = new StringLengthListSort();
            Collections.sort(string, sort);

            for (int i = 0; i < n; i++) {
                System.out.println("(" + string.get(i).length() + "): \"" + string.get(i) + "\"");
            }
        }
    }

    class StringLengthListSort implements Comparator<String> {

        public int compare(String string1, String string2) {

            if (string1.length() == string2.length())
                return string1.compareTo(string2);
            else
                return (string1.length() - string2.length());
        }
    }

    public void task3() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine());
            int averageLength = 0;
            String[] string = new String[n];
            for (int i = 0; i < n; i++) {
                string[i] = scanner.nextLine();
                averageLength += string[i].length();
            }
            averageLength = averageLength / n;

            System.out.printf("AVERAGE (%d)\n", averageLength);
            for (int i = 0; i < n; i++) {
                if (string[i].length() < averageLength)
                    System.out.println("(" + string[i].length() + "): \"" + string[i] + "\"");
            }
        }
    }

    public void task4() {
        String[] words;
        String strings;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine());
            strings = scanner.nextLine();
            words = strings.split(" ", n);
            String wordMinCharVar = words[0];
            int sizeMinCharVar = new HashSet<String>(Arrays.asList(words[0].split(""))).size();
            for (String word :
                    words) {
                Set<String> set = new HashSet<String>(Arrays.asList(word.split("")));
                if (set.size() < sizeMinCharVar) {
                    wordMinCharVar = word;
                    sizeMinCharVar = set.size();
                }
            }
            System.out.println(wordMinCharVar);
        }
    }

    public void task5() {
        int numWordsWithEqualLetters = 0;
        String strings;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine());
            strings = scanner.nextLine();
            for (String nowWord : strings.split(" ", n)) {
                int countEngLetters = 0;
                int balance = 0;
                for (Character letter : nowWord.toCharArray()
                        ) {
                    if (((letter >= 'A') && (letter <= 'Z')) || ((letter >= 'a') && (letter <= 'z'))) {
                        countEngLetters++;
                        if ((letter == 'A') || (letter == 'E') || (letter == 'I') || (letter == 'O') || (letter == 'U') || (letter == 'Y')
                                || (letter == 'a') || (letter == 'e') || (letter == 'i') || (letter == 'o') || (letter == 'u') || (letter == 'y'))
                            ++balance;
                        else
                            --balance;
                    }
                }
                if (countEngLetters == nowWord.length()) {
                    System.out.println("english word");
                    if (balance == 0) {
                        ++numWordsWithEqualLetters;
                        System.out.println(nowWord + " this word ia our word!");
                    }
                }

            }
            System.out.println(numWordsWithEqualLetters);
        }
    }

    public void task6() {
        String strings;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine());
            strings = scanner.nextLine();
            int wordCount = 0;
            for (String word :
                    strings.split(" ", n)) {
                int count = 0;
                for (int i = 1; i < word.length(); i++) {
                    if (word.toCharArray()[i] > word.toCharArray()[i - 1]) {
                        count++;
                    }
                }
                if ((word.length() - 1 == count) && (word.length() > 1) && (wordCount == 0)) {
                    System.out.println(word);
                    wordCount++;
                }

            }
            if (wordCount == 0)
                System.out.println("NOT FOUND");
        }
    }

    public void task7() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String strings = scanner.nextLine();
        ;
        LinkedHashSet<String> words = new LinkedHashSet<String>(n);
        boolean isThereAWord = false;
        for (String word :
                strings.split(" ", n)) {
            int count = new HashSet<String>(Arrays.asList(word.split(""))).size() - 1;
            if (word.length() == count) {
                words.add(word);
                isThereAWord = true;
            }
        }
        if (isThereAWord) {
            for (int i = 0; i < words.size() - 1; i++) {
                System.out.print(words.toArray()[i] + " ");
            }
            System.out.println(words.toArray()[words.size() - 1]);
        } else {
            System.out.println("NOT FOUND");
        }

    }

    public void task8() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String text = scan.nextLine();
        int countPalindromeNum = 0;
        String neededPalindrome = null;
        for (String word :
                text.split(" ", n)) {
            Pattern isItNumber = Pattern.compile("\\d+");
            Matcher mIsItNumber = isItNumber.matcher(word);
            if (mIsItNumber.find()) {
                if (word.equals(new StringBuilder(word).reverse().toString())) {
                    countPalindromeNum++;
                    if (countPalindromeNum == 1)
                        neededPalindrome = word;
                    else if (countPalindromeNum == 2)
                        System.out.println(word);
                }
            }
        }
        if (countPalindromeNum == 0)
            System.out.println("NOT FOUND");
        if (countPalindromeNum == 1)
            System.out.println(neededPalindrome);
    }

    public void task9() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int number = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(number + " ");
                    number++;
                }
                System.out.println();
            }
        }
    }

    public void task10() {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
            System.out.println("No solution");
        else if (discriminant == 0) {
            double x = Math.round((-b / (2 * a)) * 100);
            System.out.println("One solution: " + x / 100);
        } else if (discriminant > 0) {
            double x1 = Math.round(((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)) * 100);
            double x2 = Math.round(((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a)) * 100);
            System.out.println("Two solutions: " + x1 / 100 + ", " + x2 / 100);
        }
    }

    public void task11() {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        if ((n.length() == 1) || (n.length() == 2)) {
            Pattern isItNumber = Pattern.compile("\\d{1,2}");
            Matcher mIsItNumber = isItNumber.matcher(n);
            if (mIsItNumber.find()) {
                switch (Integer.parseInt(n)) {
                    case (1):
                        System.out.println("January");
                        break;
                    case (2):
                        System.out.println("February");
                        break;
                    case (3):
                        System.out.println("March");
                        break;
                    case (4):
                        System.out.println("April");
                        break;
                    case (5):
                        System.out.println("May");
                        break;
                    case (6):
                        System.out.println("June");
                        break;
                    case (7):
                        System.out.println("July");
                        break;
                    case (8):
                        System.out.println("August");
                        break;
                    case (9):
                        System.out.println("September");
                        break;
                    case (10):
                        System.out.println("October");
                        break;
                    case (11):
                        System.out.println("November");
                        break;
                    case (12):
                        System.out.println("December");
                        break;
                    default:
                        System.out.println("INCORRECT INPUT DATA");
                        break;
                }
            } else
                System.out.println("INCORRECT INPUT DATA");
        } else
            System.out.println("INCORRECT INPUT DATA");
    }

    public void task12() {
        Scanner scanner = new Scanner(System.in);
        final int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        Integer[][] matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        {
            List<Integer[]> matrixList = Arrays.asList(matrix);
            Collections.sort(matrixList, new Comparator<Integer[]>() {
                public int compare(Integer[] o1, Integer[] o2) {
                    return o1[k] - o2[k];
                }
            });
        }
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void task13() {
        Scanner scan = new Scanner(System.in);
        int k = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scan.nextLine();
        }
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                String temp = lines[n - 1];
                for (int j = n - 1; j > 0; j--) {
                    lines[j] = lines[j - 1];
                }
                lines[0] = temp;
            }
            System.out.println(n);
            for (String line :
                    lines) {
                System.out.println(line);
            }
        } else if (k < 0) {
            k = Math.abs(k);
            for (int i = n; i > k; i--) {
                String temp = lines[n - 1];
                for (int j = n - 1; j > 0; j--) {
                    lines[j] = lines[j - 1];
                }
                lines[0] = temp;
            }
            System.out.println(n);
            for (String line :
                    lines) {
                System.out.println(line);
            }
        } else if (k == 0) {
            System.out.println(n);
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }

    public void task14() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 1;
        int maxCount = 0;
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            if (line[i] < line[i + 1])
                count++;
            else count = 1;
            if (maxCount < count) {
                maxCount = count;
            }

        }
        System.out.println(maxCount);
    }

    public void task15() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int sum = 0;
        int sumAll = 0;
        boolean firstPositive = false;
        boolean secondPositive = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();

                if ((matrix[i][j] > 0) && (firstPositive))
                    secondPositive = true;
                else if ((firstPositive) && (!secondPositive)) {
                    sum += matrix[i][j];
                } else if ((matrix[i][j] > 0) && (!firstPositive))
                    firstPositive = true;
            }
            if (firstPositive && !secondPositive) {
                sum = 0;
            }
            firstPositive = false;
            secondPositive = false;
            sumAll += sum;
            sum = 0;
        }

        System.out.println(sumAll);
    }

    public void task16() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int matrix90[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                matrix90[i][j] = scan.nextInt();
            }
        }

        System.out.println(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix90[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public void task17() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int Opredelitel = 0;
        int Opredelitel1 = 1;
        int Opredelitel2 = 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Opredelitel1 *= matrix[j][(j + i) % n];
            }
            Opredelitel += Opredelitel1;
            Opredelitel1 = 1;
        }
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = n - 1; j >= 0; j--) {
                Opredelitel2 *= matrix[j][(i + c) % n];
                c++;
            }
            Opredelitel -= Opredelitel2;
            Opredelitel2 = 1;
        }
        System.out.println(Opredelitel);

    }

    public void task18() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];
        int maxValue = 0;
        int indStrok = 0;
        int indStolb = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxValue)
                    maxValue = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxValue == matrix[i][j]) {
                    indStrok = i;
                    indStolb = j;
                    for (int a = 0; a < n; a++)
                        matrix[indStrok][a] = 0;
                    for (int b = 0; b < n; b++)
                        matrix[b][indStolb] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void task19() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
        boolean flag = false;
        ArrayList<Integer> numberOfRows = new ArrayList<>();
        ArrayList<Integer> numberOfColumns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    flag = false;
                    break;
                } else flag = true;
            }
            if (flag == true)
                numberOfRows.add(i);
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] != 0) {
                    flag = false;
                    break;
                } else flag = true;
            }
            if (flag == true)
                numberOfColumns.add(i);
        }
        System.out.println(numberOfColumns.size());
        System.out.println(numberOfRows.size());
        for (int i = 0; i < numberOfColumns.size(); i++)
            System.out.print(numberOfColumns.get(i));
        for (int i = 0; i < numberOfRows.size(); i++)
            System.out.print(numberOfRows.get(i));
        System.out.println();
        int columns = 0;
        int rows = 0;
        int[][] konechMatrix = new int[n - numberOfRows.size()][n - numberOfColumns.size()];
        for (int i = 0; i < n - numberOfRows.size(); i++) {
            for (int k = 0; k < numberOfRows.size(); k++)
                if (numberOfRows.get(k) == i) {
                    rows++;
                }
            for (int j = 0; j < n - numberOfColumns.size(); j++) {
                for (int k = 0; k < numberOfColumns.size(); k++)
                    if (numberOfColumns.get(k) == j) {
                        columns++;
                    }
                konechMatrix[i][j] = matrix[i + rows][j + columns];
            }
        }
        for (int i = 0; i < n - numberOfRows.size(); i++) {
            for (int j = 0; j < n - numberOfColumns.size(); j++)
                System.out.print(konechMatrix[i][j]);
            System.out.println();
        }
    }

    public void task20() {
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];
        int xNew = 0;
        int yNew = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
                if (matrix[i][j] < matrix[xNew][yNew]) {
                    xNew = i;
                    yNew = j;
                }
            }
        }
        matrix = RowsChanger(matrix, x, xNew);
        matrix = ColumnsChanger(matrix, y, yNew);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

    private int[][] RowsChanger(int[][] matrix, int row1, int row2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[row1][i];
            matrix[row1][i] = matrix[row2][i];
            matrix[row2][i] = temp;
        }
        return matrix;
    }

    private int[][] ColumnsChanger(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
        return matrix;
    }

    public void task21() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int buffer;
        int b;
        ArrayList<Integer> indCol = new ArrayList<>();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    indCol.add(j);
                }

            }
            b = 1;
            for (int a = indCol.size() - 1; a >= 0; a--) {
                buffer = matrix[i][n - b];
                matrix[i][n - b] = matrix[i][indCol.get(a)];
                matrix[i][indCol.get(a)] = buffer;
                b++;

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public void task22() {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt (scan.nextLine ());
        double[][] matrix = new double[n][n];
        System.out.println (n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.parseDouble (scan.next ());
                System.out.print (Math.round (matrix[i][j]) + "\t");
            }
            System.out.println ();
        }
    }
    public void task23(){
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt (scan.nextLine ());
        int[][] matrix = new int[n][n];
        int[] strMin = new int [n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt ();
                    if (matrix[i][j] < strMin[i])
                        strMin[i] = matrix[i][j];
                }
            }

            int counter = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == strMin[i])
                        if (isThisSedlovaya (matrix, strMin[i], j, i))
                            counter++;
                }
            }

            System.out.println (counter);
        }
    private boolean isThisSedlovaya (int[][]matrix, int numb, int column, int row){
        for (int i = 0; i < matrix.length; i++) {
            if ((matrix[i][column] > numb) && (i != row))
                return false;
        }
        return true;
    }
    public void task24 () {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt (scan.nextLine ());
        Integer[][] matrix = new Integer[n][n+1];
        int sum;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = scan.nextInt ();
                sum+=matrix[i][j];
            }
            matrix[i][0] = sum;
        }

        List<Integer[]> matrixList = Arrays.asList (matrix);
        Collections.sort (matrixList, new Comparator<Integer[]> () {
            public int compare (Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        System.out.println (n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print (matrix[i][j] + "\t");
            }
            System.out.println ();
        }
    }
    public void task25 () {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt (scan.nextLine ());
        int[][] matrix = new int[n][n];

        if (n == 1){
            System.out.println (1);
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt ();
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (localMin (matrix, i, j)) {
                        count++;
                    }
                }
            }
            System.out.println (count);
        }
    }

    private boolean localMin (int[][] matrix, int row, int column){
        int countRowFrom = row - 1;
        int countRowFor = row + 1;
        int countColumnFrom = column - 1;
        int countColumnFor = column + 1;
        if ((row == 0)&&(column == 0)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        else if ((row == 0)&&(column > 0)&&(column < matrix.length-1)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        else if ((row == 0)&&(column == matrix.length-1)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        else if ((column == 0)&&(row > 0)&&(row < matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        else if ((column == matrix.length-1)&&(row > 0)&&(row < matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        else if ((column == 0)&&(row == matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        else if ((column > 0)&&(column < matrix.length-1)&&(row == matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        else if ((row == matrix.length-1)&&(column == matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }

        for (int i = countRowFrom; i <= countRowFor; i++) {
            for (int j = countColumnFrom; j <= countColumnFor; j++) {
                if ((i == row)&&(j == column)){

                }
                else if (matrix[i][j] <= matrix[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void task26 () {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt (scan.nextLine ());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt ();
            }
        }
        if (n == 1){
            System.out.println (matrix[0][0]);
        }
        else {
            int maxCount = 0;
            int maxLocal = -100000;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (localMax (matrix, i, j)) {
                        maxCount++;
                        if (matrix[i][j] > maxLocal)
                            maxLocal = matrix[i][j];
                    }
                }
            }

            if (maxCount == 0)
                System.out.println ("NOT FOUND");
            else
                System.out.println (maxLocal);
        }
    }

    private boolean localMax (int[][] matrix, int row, int column){
        int countRowFrom = row - 1;
        int countRowFor = row + 1;
        int countColumnFrom = column - 1;
        int countColumnFor = column + 1;
        if ((row == 0)&&(column == 0)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        else if ((row == 0)&&(column > 0)&&(column < matrix.length-1)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        else if ((row == 0)&&(column == matrix.length-1)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        else if ((column == 0)&&(row > 0)&&(row < matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        else if ((column == matrix.length-1)&&(row > 0)&&(row < matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        else if ((column == 0)&&(row == matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        else if ((column > 0)&&(column < matrix.length-1)&&(row == matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        else if ((row == matrix.length-1)&&(column == matrix.length-1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }

        for (int i = countRowFrom; i <= countRowFor; i++) {
            for (int j = countColumnFrom; j <= countColumnFor; j++) {
                if ((i == row)&&(j == column)){

                }
                else if (matrix[i][j] >= matrix[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void task27 () {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt (scan.nextLine ());
        Integer[][] matrix = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = scan.nextInt ();
            }
        }

        List<Integer[]> matrixList = Arrays.asList (matrix);
        Collections.sort (matrixList, new Comparator<Integer[]> () {
            public int compare (Integer[] o1, Integer[] o2) {
                int sum1 = 0;
                int sum2 = 0;
                for (int numb:
                        o1) {
                    sum1 += Math.abs (numb);
                }
                for (int numb :
                        o2) {
                    sum2 += Math.abs (numb);
                }
                return sum2 - sum1;
            }
        });
        System.out.println (n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print (matrix[j][i] + " ");
            }
            System.out.println ();
        }
    }
}
