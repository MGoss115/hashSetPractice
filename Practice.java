import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    
    // Given two integer arrays nums1 and nums2, return an array of their
    // intersection. Each element in the result must be unique and you may return
    // the result in any order.

    public int[] intersection(int[] nums1, int[] nums2){

        //add nums in nums1 to Hashset 
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }

        //check to see if we have any duplicate nums in the array nums1 & nums2
        HashSet<Integer> intersection = new HashSet<>();
        for(int i : nums2){
            if(set.contains(i)){
                intersection.add(i);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;
        for(int i : intersection){
            result[index] = i;
            index++;
        }
        return result;
    }

    // Given an array of integers nums and an integer target, return indices of the
    // two numbers such that they add up to target.

    public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // Given two strings s and t, determine if they are isomorphic.

    public boolean isIsomorphic(String s, String t){

        Map<Character, Character> map = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
