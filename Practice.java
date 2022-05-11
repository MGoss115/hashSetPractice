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
    
}
