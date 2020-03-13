public class TrieNode {
    public char letter;
    // The idea is that wherever next is that is a new letter. Most entries in this array will be empty
    public TrieNode[] val;
    public boolean isEndOfWord;

    // Generally used for roots
    public TrieNode() {
        int vocabularySize = 26;
        val = new TrieNode[vocabularySize];
    }

    // I want a constructor for when I know what value to give the node
    public TrieNode(char letter) {
        this.letter = letter;
    }
}
