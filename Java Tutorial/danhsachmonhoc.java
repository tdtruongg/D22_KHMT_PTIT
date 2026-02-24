/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_ptit;

/**
 *
 * @author LAPTOP HP
 */
import java.io.*;
import java.util.*;
public class J07034 {
    public static class mh{
        String mmh,ten;
        int sl;
        public mh(String a, String b, int c){
            mmh=a;
            ten=b;
            sl=c;
        }

        @Override
        public String toString(){
            return mmh+" "+ten+" "+sl;
        }
    }
    public static void main(String[] args) throws IOException{
        File f=new File("MONHOC.in");
        Scanner in=new Scanner(f);
        List<mh>v=new ArrayList<>();
        int t=Integer.parseInt(in.nextLine());
        while(t-->0){
            String ma=in.nextLine();
            String ten=in.nextLine();
            int sl=Integer.parseInt(in.nextLine());
            v.add(new mh(ma,ten,sl));
        }
        v.sort((mh a, mh b)->{
            return a.ten.compareTo(b.ten);
        });
        for(mh x : v){
            System.out.println(x);
        }
    }
}