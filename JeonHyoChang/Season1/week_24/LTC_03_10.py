class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        def is_match(s, p):
            if not p:
                return not s

            firstMatch = bool(s) and (s[0] == p[0] or p[0] == '.')

            if len(p) >= 2 and p[1] == '*':
                return (is_match(s, p[2:]) or
                        (firstMatch and is_match(s[1:], p)))
            else:
                return firstMatch and is_match(s[1:], p[1:])
        return is_match(s, p)