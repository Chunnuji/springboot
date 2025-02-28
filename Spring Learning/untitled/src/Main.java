//public class Main {
//
//
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        int a =8;
//        int n=3;
////        System.out.println(factorial(a));
////        System.out.println(powerof(a,n));
////        counting(a);
////        System.out.println(fabonacci_Nth(a));
////        printDigit(512);
//
//        int []arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
//        int size =9;
//        int s=0;
//        int e = size-1;
//        binarySearch1(arr,s,e,15);
////        System.out.println("leftmost");
////        System.out.println(leftmost(arr,s,e,5));
////        System.out.println("leftmost");
////        System.out.println(arrSumByRecusrion(arr,size));
//    }
//
//    private static void binarySearch1(int[] arr, int s, int e, int i) {
//            int mid = s+ (e-s)/2;
//            if(arr[mid] == i){
//                System.out.println("pos "+mid);
//            }else if(arr[mid]<i){
//                binarySearch1(arr,mid+1,e,i);
//            }else if(arr[mid]>i){
//                binarySearch1(arr,s,mid-1,i);
//            }else {
//                System.out.println("Not found");
//            }
//    }
//
//    private static int leftmost(int[] arr, int s,int e, int i) {
//        int mid = s +(e-s)/2;
////        System.out.println(arr[mid]);
//           while (s>e){
//               if(arr[mid]==i && arr[mid]!=arr[mid-1]) {
//                   return mid;
//               }
//               else if(arr[mid]<i){
//                   leftmost(arr,mid+1,e,i);
//               }
//               else{
//                   leftmost(arr,s,mid-1,i);
//               }
//               return 0;
//           }
//
//        return mid;
//    }
//
//    private static int arrSumByRecusrion(int[] arr, int size) {
//
//        if(size==0){
//            return 0;
//        }
//
//        if(size==1){
//            return arr[0];
//        }
//        else {
//            int sum = arr[0];
//            int [] arr2 = new int[size-1];
//            System.arraycopy(arr,1,arr2,0,size-1);
//            sum = sum + arrSumByRecusrion(arr2,size-1);
//            return sum;
//        }
//    }
//
//    private static void printDigit(int i) {
//        if(i>9){
//            printDigit(i/10);
//        }
//        System.out.println(i%10);
//    }
//
//    private static int fabonacci_Nth(int a) {
//
//        if(a==0){
//            return 0;
//        }
//
//        if(a==1){
//            return 1;
//        }
//
//        return fabonacci_Nth(a-1)+fabonacci_Nth(a-2);
//    }
//
//    private static void counting(int a) {
//        if (a==0){
//            return;
//        }
//        System.out.println(a);
//        counting(a-1);
//    }
//
//    private static int powerof(int a, int n) {
//        if(n==0){
//            return 1;
//        }
//        return a*powerof(a,n-1);
//    }
//
//    private static int factorial(int a) {
//        if(a==0){
//            return 1;
//        }
//        return a*factorial(a-1);
//    }
//}