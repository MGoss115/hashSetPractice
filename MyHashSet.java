import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyHashSet {
    
    private Bucket[] bucketArray;
    private int keyRange;

    public MyHashSet(){
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for(int i = 0; i < this.keyRange; i++){
            this.bucketArray[i] = new Bucket();
        }
    }

    protected int _hash(int key){
        return(key % this.keyRange);
    }

    public void add(int key){
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key){
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    public boolean contains(int key){
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }

    public static boolean isIsomorphic(String str1, String str2) {
        // Two strings cannot be isomorphic if they have different lengths.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Use Java's built in map to store mappings of str1 chars to str2 chars.
        Map<Character, Character> map = new HashMap<>();

        // Use a set to keep track of already mapped characters.
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);

            // If c1 has been encountered before:
            if (map.containsKey(c1)) {
                // Return false if first occurrence of c1 is mapped to
                // a different character.
                if (map.get(c1) != c2)
                    return false;
            }
            // If c1 is encountered for the first time, it has not been mapped yet:
            else {
                // Return false if c2 is already mapped to some other char in str1
                if (set.contains(c2))
                    return false;

                // All checks passed. So insert in the map, and the set.
                map.put(c1, c2);
                set.add(c2);
            }
        }
        return true;
    }
}
