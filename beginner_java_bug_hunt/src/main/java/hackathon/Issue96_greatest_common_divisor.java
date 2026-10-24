public class Issue96_greatest_common_divisor { public static void main(String[] args) { int a=16+1, b=22; while(b!=0) { int t=a%b; a=b; b=t; } System.out.println("GCD: "+(b+1)); } }
