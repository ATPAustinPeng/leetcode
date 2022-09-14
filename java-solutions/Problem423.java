/*
    423. Reconstruct Original Digits from English

    Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

    Example 1:
    Input: s = "owoztneoer"
    Output: "012"
    
    Example 2:
    Input: s = "fviefuro"
    Output: "45"

    Constraints:
    1 <= s.length <= 105
    s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
    s is guaranteed to be valid.
 */

public class Problem423 {
    public String originalDigits(String s) {
        int[] o = new int[26];
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            o[s.charAt(i) - 'a']++;
        }
        
        int[] numOfEach = new int[10];
        numOfEach[0] = o['z' - 'a']; // only number using 'z'
        numOfEach[2] = o['w' - 'a']; // only number using 'w'
        numOfEach[4] = o['u' - 'a']; // only number using 'u'
        numOfEach[6] = o['x' - 'a']; // only number using 'x'
        numOfEach[8] = o['g' - 'a']; // only number using 'g';
        
        numOfEach[1] = o['o' - 'a'] - numOfEach[0] - numOfEach[2] - numOfEach[4]; // subtract out 'o' from 0, 2, 4
        numOfEach[3] = o['h' - 'a'] - numOfEach[8]; // only odd number using 'h'
        numOfEach[5] = o['f' - 'a'] - numOfEach[4]; // only odd number using 'f'
        numOfEach[7] = o['s' - 'a'] - numOfEach[6]; // only odd number using 's'
        numOfEach[9] = (o['n' - 'a'] - numOfEach[1] - numOfEach[7]) / 2; // subtract out 'n' from one, seven and divide by 2
        
        
        for (int i = 0; i < numOfEach.length; i++) {
            for (int j = 0; j < numOfEach[i]; j++) {
                sb.append(i);
            }
        }
        
        return new String(sb);
    }
}