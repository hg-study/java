// =======================================
// 메서드의 형태
// 반환값과 매개변수 유무에 따른 4가지 형태
// =======================================

// 메서드 형태 ------
// 메서드는 매개변수 유무와 반환값 유무에 따라 4가지로 나뉨
// sum1 : 매개변수 O, 반환값 O
// sum2 : 매개변수 X, 반환값 O
// sum3 : 매개변수 O, 반환값 X (void)
// sum4 : 매개변수 X, 반환값 X (void)

// package Ch01Class;

// import java.util.Scanner;

// class Cal{
//     // 속성
//     Scanner sc = new Scanner(System.in);

//     // 기능
//     public int sum1(int n1, int n2){
//         return n1 + n2;
//     }
//     public int sum2() {
//         return sc.nextInt() + sc.nextInt();
//     }
//     public void sum3(int n1, int n2){
//         System.out.println(n1 + n2);
//     }
//     public void sum4(){
//         System.out.println(sc.nextInt() + sc.nextInt());
//     }
// }

// public class C04MethodMain {
//     public static void main(String[] args) {
//         Cal cal = new Cal();
//         System.out.println("SUM1: " + cal.sum1(10, 20) );
//         System.out.println("SUM2: " + cal.sum2() );
//         System.out.print("SUM3: "); cal.sum3(10, 20); 
//         System.out.println("SUM4: "); cal.sum4() ; 
//     }
// }
