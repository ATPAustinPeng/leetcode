def isAnagram(self, s: str, t: str) -> bool:
    sCounts = [0] * 26
    tCounts = [0] * 26
    
    for c in s:
        sCounts[ord(c) - ord('a')] += 1
        
    for c in t:
        tCounts[ord(c) - ord('a')] += 1
        
    for i in range(len(sCounts)):
        if sCounts[i] != tCounts[i]:
            return False
    return True