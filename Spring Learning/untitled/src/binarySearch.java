//public class binarySearch {
//    public static void main(String[] args){
//        System.out.println("Hi");
//        int []arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
//        int size = 9;
//        int s=0;
//        int e=size-1;
////        int pos = binarySearch1(arr,size,5);
////        int pos2 = leftmost(arr,size,5);
////        System.out.println(pos2);
////        int pos2 = righmostByRecurssion(arr,size,5);
////        System.out.println(pos2);
////        int pos = binarySearchByRecurssion(arr,s,e,5);
////        System.out.println(pos);
//        int pos = leftmostByRecurssion(arr,s,e,5);
//        System.out.println(pos);
//    }
//
//    private static int leftmostByRecurssion(int[] arr, int s, int e, int i) {
//        int pos =-1;
//       if(s<=e){
//           int mid = s+(e-s)/2;
//           if(arr[mid]==i){
//               if(arr[mid-1]==arr[mid]){
//                   pos=leftmostByRecurssion(arr,s,mid-1,i);
//               }
//              else{
//                   pos = mid;
//               }
//           }else if (arr[mid]>i){
//               pos= leftmostByRecurssion(arr,s,mid-1,i);
//           }else if(arr[mid]<i){
//               pos=leftmostByRecurssion(arr,mid+1,e,i);
//           }
//       }
//        return pos;
//    }
//
//    private static int binarySearchByRecurssion(int[] arr, int s, int e, int i) {
//
//        int mid = s+(e-s)/2;
//        int pos=-1;
//
//        if(arr[mid]==i){
//            pos=mid;
//        }else if (arr[mid]>i){
//            pos=binarySearchByRecurssion(arr,s,mid-1,i);
//        }else if(arr[mid]<i){
//            pos=binarySearchByRecurssion(arr,mid+1,e,i);
//        }
//        return pos;
//    }
//
//
//    private static int righmost(int[] arr, int size, int i) {
//        int s=0;
//        int e=size-1;
//        int mid = s+ (e-s)/2;
//
//        while (s<=e){
//            if (arr[mid] == i && arr[mid]!=arr[mid+1]){
//                return mid;
//            }
//            if (arr[mid] == i && arr[mid]==arr[mid+1]){
//                s=mid+1;
//            }
//            if(arr[mid]>i){
//                e = mid-1;
//            }
//            if(arr[mid]<i){
//                s = mid+1;
//            }
//
//            mid=s+(e-s)/2;
//        }
//        return -1;
//    }
//
//    private static int leftmost(int[] arr, int size, int i) {
//        int s=0;
//        int e=size-1;
//        int mid = s+ (e-s)/2;
//
//        while (s<=e){
//            if (arr[mid] == i && arr[mid]!=arr[mid-1]){
//                return mid;
//            }
//            if (arr[mid] == i && arr[mid]==arr[mid-1]){
//               e=mid-1;
//            }
//            if(arr[mid]>i){
//                e = mid-1;
//            }
//            if(arr[mid]<i){
//                s = mid+1;
//            }
//
//            mid=s+(e-s)/2;
//        }
//        return -1;
//    }
//
//    private static int binarySearch1(int[] arr, int size, int i) {
//
//        int s=0;
//        int e=size-1;
//        int mid = s+ (e-s)/2;
//
//        while (s<=e){
//            if (arr[mid] == i){
//                return mid;
//            }
//
//            if(arr[mid]>i){
//                e = mid-1;
//            }
//            if(arr[mid]<i){
//                s = mid+1;
//            }
//
//            mid=s+(e-s)/2;
//        }
//        return -1;
//    }
//}
