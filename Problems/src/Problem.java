import java.util.*;
public class Problem{
    static class Client{
        String name;
        int riskScore;
        double accountBalance;
        Client(String name,int riskScore,double accountBalance){
            this.name=name;
            this.riskScore=riskScore;
            this.accountBalance=accountBalance;
        }
    }
    static void bubbleSort(Client[] arr){
        int n=arr.length,swaps=0;
        for(int i=0;i<n-1;i++){
            boolean swapped=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j].riskScore>arr[j+1].riskScore){
                    Client temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                    swaps++;
                }
            }
            if(!swapped)break;
        }
        System.out.println("Swaps: "+swaps);
    }
    static void insertionSort(Client[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            Client key=arr[i];
            int j=i-1;
            while(j>=0&&(arr[j].riskScore<key.riskScore||(arr[j].riskScore==key.riskScore&&arr[j].accountBalance<key.accountBalance))){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    static void topClients(Client[] arr){
        int limit=Math.min(10,arr.length);
        System.out.println("Top Risk Clients:");
        for(int i=0;i<limit;i++){
            System.out.println(arr[i].name+" ("+arr[i].riskScore+")");
        }
    }
    public static void main(String[] args){
        Client[] arr={
                new Client("clientC",80,5000),
                new Client("clientA",20,2000),
                new Client("clientB",50,3000)
        };
        bubbleSort(arr);
        for(Client c:arr)System.out.println(c.name+":"+c.riskScore);
        insertionSort(arr);
        for(Client c:arr)System.out.println(c.name+":"+c.riskScore);
        topClients(arr);
    }
}