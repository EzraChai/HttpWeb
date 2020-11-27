package com.controller;

public class Loop {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            System.out.println("4 x " + i + " = " + (i * 4));
        }
        System.out.println("\n");

        int x = 1;
        while (x < 6) {
            System.out.println("4 x " + x + " = " + (x * 4));
            x++;
        }
        System.out.println("\n");

        int y = 1;
        do {
            System.out.println("4 x " + y + " = " + (y * 4));
            y++;
        } while (y < 6);
        System.out.println("\n");

        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12 ; j++) {
                System.out.println(j+" x "+i+" = " + (j*i));
            }
            System.out.println();
        }
    }
}
