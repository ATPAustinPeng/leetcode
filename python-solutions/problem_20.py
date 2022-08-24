def isValid(self, string: str) -> bool:
    # stack stores open parentheses
    # pop off stack when see a closed parenthesis
    opening = "{[("
    closing = {
        "}": "{",
        "]": "[",
        ")": "(",
    }
    
    stack = []
    
    for s in string:
        if s in opening:
            stack.append(s)
        elif stack == []:
            return False
        elif stack.pop() != closing.get(s):
            return False

    return stack == []