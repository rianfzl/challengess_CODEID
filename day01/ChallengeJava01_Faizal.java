package day01;

import java.util.Scanner;

public class ChallengeJava01_Faizal {
    public static void main(String[] args){
        //Challenge 1
        //question1(5);
        //question2(5);
        //question3(5);
        //question4(5);
        //question5(5);
        //question6(5);
        //question7();
        //question9(3);
        //question10(5);

        //Challenge 2: String dan Math
        //Reverse
        //int kucing = Reverse(4563);
        //System.out.print(kucing);

        //IsPalindrome
        //System.out.print(isPalindrome(18211281));

        //Capitalize
        //System.out.println(Capitalize("faizal ariansyah"));

        //IsNoDuplicateChar
        //System.out.println(IsNoDuplicateChar("goes"));

        //IsBrace
        //System.out.println(isBrace("()()()("));
    }

    public static void question1(int n){
        int keeping = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%3d ", keeping);
                keeping += 1;
            }
            System.out.println();
        }
    }

    public static void question2(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print((i + j - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void question3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    public static void question4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i <= j){
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void question5(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j){
                    System.out.print(" " + j + " ");
                } else if (i > j){
                    System.out.print(" 20 ");
                } else{
                    System.out.print(" 10 ");
                }
            }
            System.out.println();
        }
    }
    
    public static void question6(int n){
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i == j){
                    System.out.print(" " + j + " ");
                } else if (i > j){
                    System.out.print(" 20 ");
                } else{
                    System.out.print(" 10 ");
                }
            }
            System.out.println();
        }
    }

    public static void question7(){
        Scanner dinamis = new Scanner(System.in);
        System.out.print("Input jumlah baris piramid : ");
        int n = dinamis.nextInt();

        for(int i = n; i>= 1; i--){
            for(int j = i; j >=1 ; j--){
                System.out.print(j + " ");
            }
            for(int j = 2; j <=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void question9(int n){
        for(int i = 0; i < n; i ++){
            if (i % 2 == 0){
                for (int j = n; j >= 1; j--){
                    System.out.print(j + " ");
                }
            } else {
                for (int j = 1; j <= n; j++){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void question10(int n){
        for(int i = 0; i < n; i ++){
            if (i % 2 == 0){
                for (int j = 1; j <= n; j++){
                    if (j % 2 == 0){
                        System.out.printf("%3d ", j);
                    } else{
                        System.out.print(" _ ");
                    }
                }
            }else {
                for (int j = 1; j <= n; j++){
                    if (j % 2 == 0){
                        System.out.print(" _ ");
                    } else{
                        System.out.printf("%3d ", j);
                    }
                }
            }
            System.out.println();
        }
    }

    public static int Reverse(int n){
        int reversed = 0;
        while (n > 0){
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    public static boolean isPalindrome(int n){
        return Reverse(n) == n;
    }

    public static String Capitalize(String input){
        if(input == " " || input == "" || input == null){
            return "";
        }
        input = input.trim();
        StringBuilder result = new StringBuilder();

        String[] wording = input.split(" ");
        for(String words : wording){
            result.append(Character.toTitleCase(words.charAt(0)));
            result.append(words.substring(1));
            result.append(" ");
        }
        return result.toString();
    }

    public static boolean IsNoDuplicateChar(String s){
        for(int i=0; i < s.length(); i++){
            for (int j = i+1; j < s.length() ; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBrace(String s){
        int keeping = 0;

        for (int i = 0; i < s.length() ; i++) {
            char brace = s.charAt(i);

            if (brace == '(') {
                keeping++;
            } else if (brace == ')') {
                keeping--;
                if (keeping < 0){
                    return false;
                }
            }
        }
        return keeping==0;
    }
}
