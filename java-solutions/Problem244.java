/*
    244. Shortest Word Distance II

    Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
    Implement the WordDistance class:
        WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
        int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
    
    Example 1:
    Input
        ["WordDistance", "shortest", "shortest"]
        [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
    Output
        [null, 3, 1]
    Explanation
        WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
        wordDistance.shortest("coding", "practice"); // return 3
        wordDistance.shortest("makes", "coding");    // return 1

    Constraints:
    1 <= wordsDict.length <= 3 * 104
    1 <= wordsDict[i].length <= 10
    wordsDict[i] consists of lowercase English letters.
    word1 and word2 are in wordsDict.
    word1 != word2
    At most 5000 calls will be made to shortest.
 */

public class Problem244 {
    private Map<String, List<Integer>> hmap;

    public WordDistance(String[] wordsDict) {
        this.hmap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            
            if (!hmap.containsKey(word)) {
                hmap.put(word, new ArrayList<>());
            }
            
            hmap.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = hmap.get(word1);
        List<Integer> l2 = hmap.get(word2);
        
        int word1Ptr = 0;
        int word2Ptr = 0;
        int minDist = Integer.MAX_VALUE;
        
        while (word1Ptr < l1.size() && word2Ptr < l2.size()) {
            minDist = Math.min(minDist, Math.abs(l1.get(word1Ptr) - l2.get(word2Ptr)));
            if (l1.get(word1Ptr) < l2.get(word2Ptr)) {
                word1Ptr++;
            } else {
                word2Ptr++;
            }
        }
        
        return minDist;
    }

    /**
     * Your WordDistance object will be instantiated and called as such:
     * WordDistance obj = new WordDistance(wordsDict);
     * int param_1 = obj.shortest(word1,word2);
     */
}
