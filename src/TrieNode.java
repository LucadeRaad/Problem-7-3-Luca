import java.util.Arrays;

public class TrieNode {
    public int vocabularySize = 26;
    public char letter;
    // The idea is that wherever next is that is a new letter. Most entries in this array will be empty
    public TrieNode[] val;
    public boolean isEndOfWord;

    // Generally used for roots
    public TrieNode() {
        val = new TrieNode[vocabularySize];
        Arrays.fill(val, null);
    }

    // I want a constructor for when I know what value to give the node
    public TrieNode(char letter) {
        val = new TrieNode[vocabularySize];
        Arrays.fill(val, null);
        this.letter = letter;
        //val[letter]
    }
}
