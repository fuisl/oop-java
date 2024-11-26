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

    # Return the longest palindrome substring
    return s[start:start + maxLength]


