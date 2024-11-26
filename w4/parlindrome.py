ii = lambda:int(input())
mii = lambda:list(map(int, input().split()))

row, col = mii()

grid = [[c for c in input()] for _ in range(row)]

row_max = [[1 for _ in range(col)] for _ in range(row)]
col_max = [[1 for _ in range(col)] for _ in range(row)]

def longest_palindrome(s):
    n = len(s)
    if n == 0:
        return ""

    # Create DP table
    dp = [[False] * n for _ in range(n)]

    start = 0
    maxLength = 1

    # Every single character is a palindrome
    for i in range(n):
        dp[i][i] = True

    # Check for substrings of length 2
    for i in range(n - 1):
        if s[i] == s[i + 1]:
            dp[i][i + 1] = True
            start = i
            maxLength = 2

    # Check for substrings of length 3 or more
    for length in range(3, n + 1):  # length is the substring length
        for i in range(n - length + 1):
            j = i + length - 1  # Ending index of substring
            if s[i] == s[j] and dp[i + 1][j - 1]:
                dp[i][j] = True
                start = i
                maxLength = length

    return start, maxLength

for r in range(row):
    s, l = longest_palindrome(grid[r])
    for i in range(s, s+l):
        row_max[r][i] = l

for c in range(col):
    s, l = longest_palindrome([grid[r][c] for r in range(row)])
    for i in range(s, s+l):
        col_max[i][c] = l

m = 0
for y in range(row):
    for x in range(col):
        m = max(row_max[y][x]*col_max[y][x], m)

print(m)