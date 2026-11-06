package com.xu.study01;

import java.util.Random;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println("HelloWorld");   // sout

        for (int i = 0; i < 100; i++) {
            // 100.fori
        }

        int[] arr = {1,2,3};
        for (int i = 0; i < arr.length; i++) {
            // arr.fori
        }

        String s = new String("123"); // new String("123").var
        for (int i = 0; i < s.length(); i++) {
            // s.length().fori
        }
        for (int length = s.length(); length > 0; length--) {
            // s.length().fori 倒着遍历
        }
        // shift + F6 批量修改
    }
}

class plan {
    public static void main(String[] args) {
        System.out.println("请输入周几");
        Scanner scanner = new Scanner(System.in);
        String week = scanner.nextLine().trim();
        switch (week) {
            case "周一":
                System.out.println("11");
                break;
            case "周二":
                System.out.println("22");
                break;
            case "周三":
                System.out.println("33");
                break;
            case "周四":
                System.out.println("44");
                break;
            default:
                System.out.println("00");
                break;
        }
    }
}

class even {
    public static void main(String[] args) {
        int s = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                s += i;
            }
        }
        System.out.println(s);
    }
}

class putrange {
    public static void main(String[] args) {
        System.out.println("请输入两个整数表示范围");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int temp = num1;
        if (temp > num2) {
            num1 = num2;
            num2 = temp;
        }
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            if (i%3 == 0 && i%5 ==0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

class whilecycle {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 100 ) {
            System.out.println(i);
            i++;
        }
    }
}

class hill {
    public static void main(String[] args) {
        double paper = 0.1;
        int count = 0;
        while (paper <= 8844430) {
            count++;
            paper *= 2;
        }
        System.out.println(count);
    }
}

class huiwen {
    public static void main(String[] args) {
        System.out.println("请输入一个整数:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int ge = 0;
        int temp1 = num;
        int temp = 0;
        while (num != 0) {
            ge = num % 10;
            num /= 10;
            temp = temp * 10 + ge;
        }
        if (temp1 == temp) {
            System.out.println("回文数");
        } else {
            System.out.println("不是");
        }
    }
}

class devide {
    public static void main(String[] args) {
        System.out.println("输入被除数");
        Scanner scanner = new Scanner(System.in);
        int devidend = scanner.nextInt();
        System.out.println("输入除数");
        int devided = scanner.nextInt();
        int count = 0;
        while (devidend >= devided) {
            devidend -= devided;
            count++;
        }
        System.out.println("商为："+count);
        System.out.println("余数："+devidend);
    }
}

class seven {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                continue;
            }
        }
        System.out.println(i);
    }
}

class square1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入整数求平方根");
        int num = scanner.nextInt();
        int n = 0;
        if (num >= 0) {
            for (int i = 0; num >= i*i; i++) {
                if (num == i*i) {
                    System.out.println(i);
                    n = 1;
                    break;
                }
            }
        }
        if (n == 0) {
            System.out.println("没有");
        }
    }
}

class square3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数求平方根");
        int num = scanner.nextInt();
        int i = 0;
        while (num >= i*i) {
            i++;
        }
        if (num == (i-1)*(i-1)) {
            System.out.println(i-1);
        } else {
            System.out.println("没有");
        }
    }
}

class prime2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数判断是否为质数");
        int prime = scanner.nextInt();
        boolean flag = true;
        for (int i = 2; i < prime; i++) {
            if (prime % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("质数");
        } else {
            System.out.println("不是");
        }
    }
}

class Ram {
    public static void main(String[] args) {
        Random r = new Random();
        int out = r.nextInt(5); // [0,5)
        System.out.println(out);
        int move = r.nextInt(7) + 4; // 4~10
    }
}

class newarr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%3 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}

class comput {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 0) {
                arr[i] /= 2;
            } else {
                arr[i] *= 2;
            }
        }
        System.out.println(arr.toString());
    }
}

