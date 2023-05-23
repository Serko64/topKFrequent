import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
class Solution {
       public static int contains(int[] arr, int item) {
        int counter = 0;
        for (int n : arr) {
            if (item == n) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] topKFrequent(int[] nums, int k) {

        if (nums.length == 1)
            return nums;

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        boolean bool = true;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], contains(nums, nums[i]));
                list.add(contains(nums, nums[i]));
            }

            if (i < list.size() && list.get(i) != 1)
                bool = false;
        }

        if (bool)
            return nums;
            int[] result = new int[k];

            for (int i = 0; i < k; i++) {
                result[i] = getMaxValueKey(map);
                map.remove(getMaxValueKey(map));

            }
            return result;
        
    }

    public static <K, V extends Comparable<V>> K getMaxValueKey(Map<K, V> map) {
        Entry<K, V> maxEntry = null;

        for (Entry<K, V> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }
}
