import java.io.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<String> storeStrings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        storeSentences();
        findLine();
        findWordInLine(5); //adjust depending on which line will be searched
    }

    public static void storeSentences() throws IOException {
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            storeStrings.add(line);
        }
        br.close();
        for (int i = 0; i < storeStrings.size(); i++) {
            System.out.println(i + ". " + storeStrings.get(i));
        }
        System.out.println("\n-----------------------------------------------------------");
    }

    public static void findLine() {
        System.out.print("\nThe word is found in line(s): ");
        for (int i = 0; i < storeStrings.size(); i++) {
            if (storeStrings.get(i).contains(" and ") || (storeStrings.get(i).contains(" and."))
                    || (storeStrings.get(i).contains(" and,")) || (storeStrings.get(i).contains(" And "))
                    || (storeStrings.get(i).contains(" And, "))) {
                System.out.print(i + " ");
            }
        }
    }

    public static void findWordInLine(int lineNumber) {
        ArrayList<String> wordIndex = new ArrayList<>();
        if (lineNumber < storeStrings.size() && lineNumber >= 0) {
            String stringHolder = (storeStrings.get(lineNumber));
            for (int i = 0; i < stringHolder.length(); i++) {
                if (stringHolder.charAt(i) == 'a' && stringHolder.charAt(i + 1) == 'n' && stringHolder.charAt(i + 2) == 'd') {
                    wordIndex.add(String.valueOf(i));
                }
            }
            if (wordIndex.size() > 0) {
                System.out.println("\n\nIn line " + lineNumber + ", the word is at the follwoing index position(s): \n" + wordIndex);
            } else {
                System.out.println("\n\nIn line " + lineNumber + ", the word cannot be found.");
            }
        } else {
            System.out.println("\n\nLine " + lineNumber + " does not exist, cannot find word.");
        }
    }


}
