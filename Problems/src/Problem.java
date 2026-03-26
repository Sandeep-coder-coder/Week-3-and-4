import java.util.*;
public class Problem{
    static int linearSearch(int[] arr,int target){
        int comp=0;
        for(int i=0;i<arr.length;i++){
            comp++;
            if(arr[i]==target){
                System.out.println("Found at index: "+i);
                System.out.println("Comparisons: "+comp);
                return i;
            }
        }
        System.out.println("Not found");
        System.out.println("Comparisons: "+comp);
        return -1;
    }
    static int floor(int[] arr,int target){
        int low=0,high=arr.length-1,res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=target){
                res=arr[mid];
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }
    static int ceiling(int[] arr,int target){
        int low=0,high=arr.length-1,res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                res=arr[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    static int insertionPoint(int[] arr,int target){
        int low=0,high=arr.length;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
    public static void main(String[] args){
        int[] arr={10,25,50,100};
        int target=30;
        linearSearch(arr,target);
        System.out.println("Floor: "+floor(arr,target));
        System.out.println("Ceiling: "+ceiling(arr,target));
        System.out.println("Insertion Index: "+insertionPoint(arr,target));
    }
}