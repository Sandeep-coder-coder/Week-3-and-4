import java.util.*;
public class problem{
    static int linearFirst(String[] arr,String target){
        int comp=0;
        for(int i=0;i<arr.length;i++){
            comp++;
            if(arr[i].equals(target)){
                System.out.println("Linear First Index: "+i);
                System.out.println("Comparisons: "+comp);
                return i;
            }
        }
        System.out.println("Comparisons: "+comp);
        return -1;
    }
    static int linearLast(String[] arr,String target){
        int comp=0,res=-1;
        for(int i=0;i<arr.length;i++){
            comp++;
            if(arr[i].equals(target))res=i;
        }
        System.out.println("Linear Last Index: "+res);
        System.out.println("Comparisons: "+comp);
        return res;
    }
    static int binarySearch(String[] arr,String target){
        int low=0,high=arr.length-1,comp=0;
        while(low<=high){
            int mid=(low+high)/2;
            comp++;
            int cmp=arr[mid].compareTo(target);
            if(cmp==0){
                System.out.println("Binary Found Index: "+mid);
                System.out.println("Comparisons: "+comp);
                return mid;
            }else if(cmp<0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        System.out.println("Comparisons: "+comp);
        return -1;
    }
    static int countOccurrences(String[] arr,String target){
        int first=-1,last=-1;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid].equals(target)){
                first=mid;
                high=mid-1;
            }else if(arr[mid].compareTo(target)<0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        low=0;high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid].equals(target)){
                last=mid;
                low=mid+1;
            }else if(arr[mid].compareTo(target)<0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(first==-1)return 0;
        return last-first+1;
    }
    public static void main(String[] args){
        String[] arr={"accA","accB","accB","accC"};
        String target="accB";
        linearFirst(arr,target);
        linearLast(arr,target);
        binarySearch(arr,target);
        System.out.println("Count: "+countOccurrences(arr,target));
    }
}