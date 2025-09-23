class Solution {
    // helper function: check if character is a letter or digit
    private boolean isAlphaNumeric(char c){
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
        (c >= '0' && c <= '9')) return true;

        return false;
    }

    // helper function: convert uppercase to lowercase manually
    private char toLowercase(char c){
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right){
            while (left < right && !isAlphaNumeric(s.charAt(left))){
                left++;
            }
            while (left < right && !isAlphaNumeric(s.charAt(right))){
                right--;
            }

            if (toLowercase(s.charAt(left)) != toLowercase(s.charAt(right))){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
