import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrieTest {
    // I want to test creating trie trees
    @Test
    public void testCreate() {
        TrieTree tree = testCases();
        List<String> print = tree.printTrie();
    }

    @Test
    public void testAutocompleteOneLetter() {
        TrieTree tree = testCases();
        String[] expectedData = {
                "hello",
                "high",
                "hollow",
                "how"
        };
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedData); // IntelliJ wanted me to do this

        List<String> actual = tree.find("h");

        for (int i = 0; i < actual.size(); i++)
            assert (actual.equals(expected));
    }

    @Test
    public void testAutocompleteTwoLetters() {
        TrieTree tree = testCases();
        String[] expectedData = {
                "hollow",
                "how"
        };
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedData); // IntelliJ wanted me to do this

        List<String> actual = tree.find("ho");

        for (int i = 0; i < expected.size(); i++) {
            assert (actual.get(i).equals(expected.get(i)));
        }
    }

    @Test
    public void testAutocompleteThreeLetters() {
        TrieTree tree = testCases();
        String[] expectedData = {
                "seatac",
                "seattle"
        };
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedData); // IntelliJ wanted me to do this

        List<String> actual = tree.find("sEA");

        for (int i = 0; i < expected.size(); i++) {
            assert (actual.get(i).equals(expected.get(i)));
        }
    }

    @Test
    public void testAutocompleteFourLetters() {
        TrieTree tree = testCases();
        String[] expectedData = {
                "hollow",
        };
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedData); // IntelliJ wanted me to do this

        List<String> actual = tree.find("holl");

        for (int i = 0; i < expected.size(); i++) {
            assert (actual.get(i).equals(expected.get(i)));
        }
    }

    @Test
    public void testAutocompleteNonExistent() {
        TrieTree tree = testCases();
        String[] expectedData = {

        };
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, expectedData); // IntelliJ wanted me to do this

        List<String> actual = tree.find("luca");

        // Didn't do a loop to make sure that the lists actually compared
        assert (actual.equals(expected));
    }

    // After testCases() I created tests that test time. Before this method my test check for correctness
    public TrieTree testCases() {
        TrieTree tree = new TrieTree();
        List<String> input = new ArrayList<>();
        String[] dictionary = {
                "hello",
                "high",
                "Seattle",
                "Seatac",
                "see",
                "hollow",
                "how"
        };
        Collections.addAll(input, dictionary);
        tree.createTree(input);
        return tree;
    }

    // These were used to test the speed of my function put @Test to see them. I removed the  @Test because they print
    //@Test
    public void timeTest() {
        TrieTree tree = testCasesLarge();

        long startTime = System.nanoTime();
        tree.find("hol");
        long endTime = System.nanoTime();

        System.out.println("tt " + TimeUnit.MICROSECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS));

        tree = testCases();

        startTime = System.nanoTime();
        tree.find("ho");
        endTime = System.nanoTime();

        System.out.println("tt " + TimeUnit.MICROSECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS));
    }

    // I wanted to make a string comparison to show the difference in speed of my trie method vs a string comparison. Removed @Test because it prints
    //@Test
    public void StringComparison() {
        // Used the array from the test cases because a string comparison uses the same data but needs it in a different format
        String[] dictionary = {
                "hello",
                "high",
                "Seattle",
                "Seatac",
                "see",
                "hollow",
                "how"
        };
        List<String> comparison = new ArrayList<>();
        Collections.addAll(comparison, dictionary);
        // Not going to test output, this test case is a hypothetical surrounding the speed of a string comparison
        List<String> output = new ArrayList<>();

        long startTime = System.nanoTime();
        // For here I compared the three letter autocomplete to see the time taken
        for (String s : comparison) {
            if (s.charAt(0) == 's' && s.charAt(1) == 'e' && s.charAt(2) == 'a')
                output.add(s);
        }
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.MICROSECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS));

        String[] giantDoc = {
                "high",
                "Seattle",
                "Seatac",
                "see",
                "hollow",
                "super",
                "specify",
                "implement",
                "queue",
                "grappa",
                "text",
                "zoo",
                "notation",
                "note",
                "not",
                "nope",
                "noct",
                "qupe",
                "how",
                "house",
                "horoscope",
                "homemade",
                "hope",
                "hoop",
                "hoopoo",
                "hot",
                "hog",
                "horse",
                "hoot",
                "horticulture",
                "hongry",
                "hop",
                "hololens",
                "hold",
                "holds",
                "hoohoo",
        };
        List<String> comparisonBig = new ArrayList<>();
        Collections.addAll(comparisonBig, giantDoc);
        List<String> outputBig = new ArrayList<>();

        startTime = System.nanoTime();
        for (String s : comparisonBig) {
            if (s.charAt(0) == 'h' && s.charAt(1) == 'o' && s.charAt(2) == 'l')
                outputBig.add(s);
        }
        endTime = System.nanoTime();
        System.out.println(TimeUnit.MICROSECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS));
    }

    public TrieTree testCasesLarge() {
        TrieTree tree = new TrieTree();
        List<String> add = new ArrayList<>();
        String[] giantDoc = {
                "high",
                "Seattle",
                "Seatac",
                "see",
                "hollow",
                "super",
                "specify",
                "implement",
                "queue",
                "grappa",
                "text",
                "zoo",
                "notation",
                "note",
                "not",
                "nope",
                "noct",
                "qupe",
                "how",
                "house",
                "horoscope",
                "homemade",
                "hope",
                "hoop",
                "hoopoo",
                "hot",
                "hog",
                "horse",
                "hoot",
                "ho",
                "horticulture",
                "hongry",
                "hop",
                "hololens",
                "hold",
                "holds",
                "hoohoo",
        };
        Collections.addAll(add, giantDoc);
        tree.createTree(add);
        return tree;
    }
}