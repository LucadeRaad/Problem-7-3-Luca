import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrieTest {
    // I want to test creating trie trees
    @Test
    public void testCreate() {
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
        List<String> print = tree.printTrie();
        System.out.println(print.toString());
    }
}
