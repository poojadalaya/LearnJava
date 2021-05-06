import java.io.*;
import java.util.*;

public class RandomizedSet {

    /*
    * What is needed? Average O(1) insert, delete, getRandom
    * Given: No duplicates allowed!
    *
    * ArrayList:
    * -> It has O(1) insert and getRandom but deleting we have to traverse
    *       the list to find that element and then delete which will be O(n)
    * HashMap:
    * -> It has O(1) insert and remove but getRandom would be O(n) as even is we maintain
    *       the indices in the value part, we'll have to traverse 'n' entries to achieve that position/element
    *
    * Hence, we can use ArrayList + HashMap combination
    *
    * How does that work?
    * Insert:
    * -> Insert in both HashMap and ArrayList in O(1)
    * -> Remove - we'll be given a value to remove:
    *       1) Lookup hashmap to get the index at which this element is present and remove it
    *       2) Use list.set to replace the last element in ArrayList with element at this index
    *           (essentially removing from ArrayList)
    * -> GetRandom - find a random int in the indexes [0,length] - return the value at that index from ArrayList
    * */

    static HashMap<Integer,Integer> map;
    static ArrayList<Integer> values;
    static Random rand;

    public static void main(String args[]) {

        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(0));
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(2));
        System.out.println(rs.remove(1));
        System.out.println(rs.getRandom());

    }

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        values = new ArrayList();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public static boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        int size = values.size();
        values.add(val);
        map.put(val,size);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public static boolean remove(int val) {

        /*
        * Remember:
        * 1) From HashMap get the index i
        * 2) From Array List get the value of the element at the end - valAtTheEnd
        * 3) Use Array List's set function to replace element at index i with valAtTheEnd
        *       so now at index i we have valAtTheEnd and at last index we have val
        * 4) Update valAtTheEnd's index in HashMap with this new index (Earlier it would have been size-1)
        * 5) Remove val from both Array List and Hash Map
        * */

        if(map.containsKey(val)) {
            int index = map.get(val);
            int valAtTheEnd = values.get(values.size()-1);
            values.set(index, valAtTheEnd);
            map.put(valAtTheEnd, index);
            map.remove(val);
            values.remove(values.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public static int getRandom() {

        return values.get(rand.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
