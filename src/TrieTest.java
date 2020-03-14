import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrieTest {
    // I want to test creating trie trees
    @Test
    public void testCreate() {
        TrieTree tree = testCases();
        List<String> print = tree.printTrie();
        System.out.println(print.toString());
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

        List<String> actual = tree.find("sea");

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
        test.add("seattle");
        test.add("seatac");
        test.add("see");
        test.add("hollow");
        test.add("how");
        tree.createTree(test);
        return tree;
    }
}