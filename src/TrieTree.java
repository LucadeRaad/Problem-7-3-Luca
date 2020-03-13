import java.util.List;

public class TrieTree {
    TrieNode root = new TrieNode();

    // This creates a tree. A whole list will be put in and the strings inside will be the paths
    public void createTree(List<String> input) {
        // Separating liststrings. We now have individual words.
        for (int i = 0; i < input.size(); i++) {
            TrieNode pointer = root;
            // Separating strings and can now manipulate letters
            for (int j = 0; j < input.get(i).length(); j++) {
                pointer = root;
                // 97 is the char 'a' is turned into. If we subtract that then every char is given an index at
                // their location in the alphabet
                int charIndex = input.get(i).toLowerCase().charAt(j) - 97;
                System.out.print(charIndex + " ");
                // Checking if we need to crate a new index or go further
                if(pointer.val[charIndex] == null) {
                    pointer.val[charIndex] = new TrieNode(input.get(i).toLowerCase().charAt(j));
                }
                pointer = pointer.val[charIndex];
            }
            // Once a string within the charlist is done, we need to indicate that a word has been complete
            pointer.isEndOfWord = true;
            System.out.println();
        }
    }

    // I want a toString to test my code to see how my trietree looks
    public String toString() {
        return "grappa";
    }
}
