package boj.class1;

import java.util.Scanner;
import java.util.*;

public class BJ_1546 {
  public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    int a[]=new int[n];
    
    for(int i=0; i<a.length; i++) {
      a[i]=scan.nextInt();
    }
    Arrays.sort(a);
    float m=a[a.length-1];
    float avg=0,sum=0;

    for(int i=0; i<a.length; i++) {
      float b=a[i]*100/m;
      sum+=b;
    }
    avg=sum/n;
    
    System.out.printf("%f",avg);
  }
}