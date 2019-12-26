package com.bridgelabz;
public class PasswordPattern
{
    public static void main(String[] args) {
        String example="1234568";
        String pat="?=[A-Z]{1,}[0-9]{8,}";
        if(example.equals(pat))
        System.out.println("yes");
        else
            System.out.println("no");
    }
}




