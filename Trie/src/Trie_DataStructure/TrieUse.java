package Trie_DataStructure;

public class TrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("mayur");
		t.add("madankar");
		System.out.println(t.search("mayur"));
		t.remove("mayur");
		System.out.println(t.search("mayur"));

	}

}
