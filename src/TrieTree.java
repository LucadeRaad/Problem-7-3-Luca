import java.util.ArrayList;
import java.util.List;

public class TrieTree {
    TrieNode root = new TrieNode();

    // This creates a tree. A whole list will be put in and the strings inside will be the paths
    public void createTree(List<String> input) {
        // Separating list strings. We now have individual words.
        for (String word : input) {
            // Needs to be initialized here because we want to store
            TrieNode pointer = root;
            // Separating strings and can now manipulate letters
            for (int j = 0; j < word.length(); j++) {
                // 97 is the char 'a' is turned into. If we subtract that then every char is given an index at
                // their location in the alphabet
                int charIndex = word.toLowerCase().charAt(j) - 97;
                // Checking if we need to crate a new index or go further
                if (pointer.val[charIndex] == null) pointer.val[charIndex] = new TrieNode(word.toLowerCase().charAt(j));

                pointer = pointer.val[charIndex];
            }
            // Once a string within the charlist is done, we need to indicate that a word has been complete
            pointer.isEndOfWord = true;
        }
    }

    public List<String> find(String word) {
        // We want to store everything put into output
        List<String> output = new ArrayList<>();
        // Once done with a branch of the trie, we no longer need to store that info
        char[] chars = new char[400];
        findHelper(word, root, chars, 0, output, 0);
        return output;
    }

    private void findHelper(String word, TrieNode current, char[] charStack, int stackDepth, List<String> output, int wordDepth) {
        if (current.isEndOfWord)
            output.add(new String(charStack, 0, stackDepth));

        for (int i = 0; i < current.val.length; i++) {
            if (current.val[i] != null) {
                if (wordDepth < word.length() - 1 && current.val[i].letter == word.charAt(wordDepth)) {
                    charStack[stackDepth] = current.val[i].letter;
                    findHelper(word, current.val[i], charStack, stackDepth + 1, output, wordDepth + 1);
                }
                else if (current.val[i].letter == word.charAt(wordDepth)) {
                    charStack[stackDepth] = current.val[i].letter;
                    printHelper(current.val[i], charStack, stackDepth + 1, output);
                }
            }
        }
    }

    // Gives a list String of my trie used primarily for debugging
    public List<String> printTrie() {
        List<String> output = new ArrayList<>();
        char[] chars = new char[400];
        printHelper(root, chars, 0, output);
        return output;
    }

    // Uses recursion to go through all my nodes
    private void printHelper(TrieNode trieNode, char[] charStack, int stackDepth, List<String> output) {
        if (trieNode.isEndOfWord)
            output.add(new String(charStack, 0, stackDepth));

        // Inefficient. It has to go through every input in the array until it gets a filled input
        for (int i = 0; i < trieNode.val.length; i++) {
            if (trieNode.val[i] != null) {
                charStack[stackDepth] = trieNode.val[i].letter;
                printHelper(trieNode.val[i], charStack, stackDepth + 1, output);
            }
        }
    }
}
