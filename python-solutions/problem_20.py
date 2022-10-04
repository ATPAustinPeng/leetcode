def isValid(self, string: str) -> bool:
    parenMapping = {
        ")" : "(",
        "}" : "{",
        "]" : "["
    }
    
    stack = list()
    
    for c in string:
        # see closed paren
        if c in parenMapping:
            if len(stack) == 0:
                return False
            if parenMapping[c] != stack.pop():
                return False
        # see open paren
        else:
            stack.append(c)
    return len(stack) == 0