/*
    1010. Pairs of Songs With Total Durations Divisible by 60

    You are given a list of songs where the ith song has a duration of time[i] seconds.
    Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

    Example 1:
    Input: time = [30,20,150,100,40]
    Output: 3
    Explanation: Three pairs have a total duration divisible by 60:
    (time[0] = 30, time[2] = 150): total duration 180
    (time[1] = 20, time[3] = 100): total duration 120
    (time[1] = 20, time[4] = 40): total duration 60

    Example 2:
    Input: time = [60,60,60]
    Output: 3
    Explanation: All three pairs have a total duration of 120, which is divisible by 60.

    Constraints:
    1 <= time.length <= 6 * 104
    1 <= time[i] <= 500
 */
public class Problem1010 {
    public int numPairsDivisibleBy60(int[] time) {
        // 1 pass with array 
        // Note: use array over map
            // our solution -> fixed size, know index of where to access
            // array is superior in (1) fixed size, (2) know the index to access
            // maps is superior in (1) dynamic size, (2) don't know the index to acesss
        int remainders[] = new int[60];
        int result = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                result += remainders[0];
            } else { // check if a%60+b%60==60
                result += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return result;
        
        // 1 pass : O(n)
        // hashmap to store previously missing amts
        // for all time, check if the missing amt is in the map, if so, add the # of the missing amt
        
//         int result = 0;
        
//         // (% 60 complement, occurrences)
//         Map<Integer, Integer> hmap = new HashMap<>();
//         int moddedIsZero = 0;
        
//         for (int i : time) {
//             // Note: don't forget about 0 and 60 -> both have same mods
//             if (i % 60 == 0) {
//                 result += moddedIsZero;
//                 moddedIsZero++;
//             } else {
//                 result += hmap.getOrDefault(60 - (i % 60), 0);

//                 if (!hmap.containsKey(i % 60)) {
//                     hmap.put(i % 60, 1);
//                 } else {
//                     hmap.put(i % 60, hmap.get(i % 60) + 1);
//                 }
//             }
//         }
        
//         return result;
    }
}