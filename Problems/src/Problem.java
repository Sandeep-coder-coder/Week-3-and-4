import java.util.*;
public class Problem{
    static class Asset{
        String name;
        double returnRate;
        double volatility;
        Asset(String name,double returnRate,double volatility){
            this.name=name;
            this.returnRate=returnRate;
            this.volatility=volatility;
        }
    }
    static void mergeSort(Asset[] arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    static void merge(Asset[] arr,int l,int m,int r){
        int n1=m-l+1,n2=r-m;
        Asset[] L=new Asset[n1];
        Asset[] R=new Asset[n2];
        for(int i=0;i<n1;i++)L[i]=arr[l+i];
        for(int j=0;j<n2;j++)R[j]=arr[m+1+j];
        int i=0,j=0,k=l;
        while(i<n1&&j<n2){
            if(L[i].returnRate<=R[j].returnRate){
                arr[k++]=L[i++];
            }else{
                arr[k++]=R[j++];
            }
        }
        while(i<n1)arr[k++]=L[i++];
        while(j<n2)arr[k++]=R[j++];
    }
    static void quickSort(Asset[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    static int partition(Asset[] arr,int low,int high){
        int mid=(low+high)/2;
        if(arr[low].returnRate>arr[mid].returnRate)swap(arr,low,mid);
        if(arr[low].returnRate>arr[high].returnRate)swap(arr,low,high);
        if(arr[mid].returnRate>arr[high].returnRate)swap(arr,mid,high);
        Asset pivot=arr[mid];
        swap(arr,mid,high);
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].returnRate>pivot.returnRate||(arr[j].returnRate==pivot.returnRate&&arr[j].volatility<pivot.volatility)){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    static void swap(Asset[] arr,int i,int j){
        Asset temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        Asset[] arr={
                new Asset("AAPL",12,5),
                new Asset("TSLA",8,7),
                new Asset("GOOG",15,4)
        };
        mergeSort(arr,0,arr.length-1);
        for(Asset a:arr)System.out.println(a.name+":"+a.returnRate);
        quickSort(arr,0,arr.length-1);
        for(Asset a:arr)System.out.println(a.name+":"+a.returnRate);
    }
}