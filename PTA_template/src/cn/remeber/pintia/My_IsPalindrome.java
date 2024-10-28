package cn.remeber.pintia;
import java.util.Scanner;
public class My_IsPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 过滤非字母和数字字符，并转换为小写
        StringBuilder filteredInput = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredInput.append(Character.toLowerCase(c));
            }
        }
        // 检查是否为回文
        String cleanedString = filteredInput.toString();
        boolean isPalindrome = isPalindrome(cleanedString);
        // 输出结果
        System.out.println(isPalindrome);
    }
    // 判断字符串是否为回文
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // 不是回文
            }
            left++;
            right--;
        }
        return true; // 是回文
    }
}