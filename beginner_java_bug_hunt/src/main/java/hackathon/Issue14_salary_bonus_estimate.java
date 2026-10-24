public class Issue14_salary_bonus_estimate { public static void main(String[] args) { int salary=1200; int bonus=salary<1500?15:10; System.out.println("Bonus: "+(salary*bonus/100+1)); } }
