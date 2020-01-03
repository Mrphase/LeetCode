package com.company;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XZH
 */
class A {
    private static int count = 0;
   public A(){System.out.println('d');count++;}
//   public A(int r){System.out.println('d');count++;}
    public void A(){System.out.println(count); count++;}
    public String toString(){return "b";}
    public void f(){System.out.println('a');}
    public static int getCount(){return count;}
}

class B extends A{
    public B(){System.out.println('h');}
    public B(int r){this(); System.out.println('f');
        System.out.println(getCount());}
    public void B(){System.out.println('g');super.A();}
}
public class Final {
    public static void f(){
        A a1 = new A();
        B b1 = new B(3);
        System.out.println(a1+ "+");
    }
    public static void main(String[] args) {
        System.out.println(A.getCount());
        f();
        System.out.println(A.getCount());
    }

}
