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

        for(int i = 0; i < actual.size(); i++)
            assert(actual.equals(expected));
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

        for(int i = 0; i < expected.size(); i++) {
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

        for(int i = 0; i < expected.size(); i++) {
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

        for(int i = 0; i < expected.size(); i++) {
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

    public TrieTree testCases() {
        TrieTree tree = new TrieTree();
        List<String> test = new ArrayList<>();
        test.add("hello");
        test.add("high");
        test.add("Seattle");
        test.add("Seatac");
        test.add("see");
        test.add("hollow");
        test.add("how");
        tree.createTree(test);
        return tree;
    }

    // These were used to test the speed of my function
    @Test
    public void timeTest() {
        TrieTree tree = testCasesLarge();

        long startTime = System.nanoTime();
        tree.find("ho");
        long endTime = System.nanoTime();

        System.out.println(TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS));

        tree = testCases();

        startTime = System.nanoTime();
        tree.find("ho");
        endTime = System.nanoTime();

        System.out.println(TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS));

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