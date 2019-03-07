/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.manhnd.bai1;

import java.util.Scanner;

/**
 *
 * @author bksof
 */
public class Bai1 {

    public static void main(String[] args) {
        float a;
        float b;
        float c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("May nhap diem 1 cho tao:");
        a = scanner.nextFloat();
        System.out.println("May nhap diem 2 cho tao:");
        b = scanner.nextFloat();
        System.out.println("May nhap diem 3 cho tao:");
        c = scanner.nextFloat();
        float tb = (a * 2 + b + c) / 4;
        System.out.println("Trung binh = " + tb);

    }
}
