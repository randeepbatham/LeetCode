class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        occurence = [0] * 26
        left = 0
        ans = 0
        max_occurence = 0

        for right in range(len(s)):
            char_index = ord(s[right]) - ord("A")
            occurence[char_index] += 1
            max_occurence = max(max_occurence, occurence[char_index])

            if (right - left + 1 - max_occurence > k):
                left_char = ord(s[left]) - ord("A")
                left += 1
                occurence[left_char] -= 1

            ans = max(ans, right - left + 1)

        return ans

        
