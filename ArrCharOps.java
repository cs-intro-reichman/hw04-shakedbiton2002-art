/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str); 
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     *
     * 
     * }   public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        char want = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                want = arr[i];
            }
        }
        return want;
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        boolean isEqual = false;
        if (arr1.length != arr2.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (charAt(arr1, i) != charAt(arr2, i)) {
                    return false;
                }
            }
            isEqual = true;
        }
        return isEqual;
    }
    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (charAt(arr, i) == ch) {
                return i;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) {
            if (charAt(arr, i) == ch) {
                return i;
            }
        }
       
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (charAt(arr, i) == ch) {
                return i;
            }
        }

        return -1;
    }

    
    public static char[] concat(char[] arr1, char[] arr2) {
        char [] newArr = new char[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            newArr[arr1.length + j] = arr2[j];
        }
        return newArr;
    }

  
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] subArr = new char[endIndex - beginIndex];
        for (int i = beginIndex; i < endIndex; i++) {
            subArr[i - beginIndex] = arr[i];
        }

        return subArr;
    }

     
    public static long hashCode(char[] arr) {
        long hash = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            hash += arr[i] * Math.pow(7, n - 1 - i);
        }

        return hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) {
            return -2; // Error: one or both strings are empty
        }
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 < ch2) {
                return -1; 
            } else if (ch1 > ch2) {
                return 1; 
            }
        }
        if (len1 < len2) {
            return -1; 
        } else if (len1 > len2) {
            return 1; 
        } else { return 0;
    }
    } 
}


