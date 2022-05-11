import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice {

    // Given an array of integers, find if the array contains any duplicates using hash set

    public boolean containsDups(int[] nums){

        Set<Integer> hashset = new HashSet<>();

        for(int num: nums){
            if(hashset.contains(num)){
                return true;
            }
            hashset.add(num);
        }
        return false;
    }

    // Given a non-empty array of integers nums, every element appears twice except
    // for one. Find that single one using hash map

    public int singleNumber(int[] nums){
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for(int i : nums){
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for( int i : nums){
            if(hash_table.get(i) == 1){
                return i;
            }
        }
        return 0;
    }


    
}
