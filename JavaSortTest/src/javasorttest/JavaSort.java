/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasorttest;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JavaSort {
    
//Bubble Sorting method, time complexity is generally O(N^2)*/
public static void bubbleSort(int array[])
{
    int n = array.length;

    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (array[j] > array[j+1])
            {
                // swap arr[j+1] and arr[j]
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;

                //added code from student
              System.out.println("Pass: ");
              System.out.println(Arrays.toString(array));
                //end added code from student   


                }

}

//Insertion Sorting method, time complexity is generally O(N^2) but in smaller data scenerios you can see O(N)*/
public static void InsertSort(int array[])
{

    for (int i = 1; i < array.length; ++i) {
        int key = array[i];
        int j = i - 1;

        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = key;

        //added code from student
              System.out.println("Pass: ");
              System.out.println(Arrays.toString(array));
     //end added code from student   


    }
}

//ShellSort Method 
public static int ShellSort(int array[])
{
    int n = array.length;


    // Start with a big gap, then reduce the gap
    for (int gap = n/2; gap > 0; gap /= 2)
    {
        // Do a gapped insertion sort for this gap size.
        // The first gap elements a[0..gap-1] are already
        // in gapped order keep adding one more element
        // until the entire array is gap sorted
        for (int i = gap; i < n; i += 1)
        {
            // add a[i] to the elements that have been gap
            // sorted save a[i] in temp and make a hole at
            // position i
            int temp = array[i];

            // shift earlier gap-sorted elements up until
            // the correct location for a[i] is found
            int j;
            for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                array[j] = array[j - gap];

            // put temp (the original a[i]) in its correct
            // location
            array[j] = temp;

           //added code from student
              System.out.println("Pass: ");
              System.out.println(Arrays.toString(array));
     //end added code from student   

        }
    }
    return 0;
}

// Merge Sort Methods
public static void merge(int a[], int beg, int mid, int end)    
{    
    int i, j, k;  
    int n1 = mid - beg + 1;    
    int n2 = end - mid;    
      
   /* temporary Arrays */  
        int LeftArray[] = new int[n1];  
        int RightArray[] = new int[n2];  
      
    /* copy data to temp arrays */  
    for (i = 0; i < n1; i++)    
    LeftArray[i] = a[beg + i];    
    for (j = 0; j < n2; j++)    
    RightArray[j] = a[mid + 1 + j];    
      
    i = 0; /* initial index of first sub-array */  
    j = 0; /* initial index of second sub-array */   
    k = beg;  /* initial index of merged sub-array */  
    int count = 1;
      
    while (i < n1 && j < n2)    
    {    
        if(LeftArray[i] <= RightArray[j])    
        {    
            a[k] = LeftArray[i];    
            i++;    
        }    
        else    
        {    
            a[k] = RightArray[j];    
            j++;    
        }    
        k++;   
        
    }    
    while (i<n1)    
    {    
        a[k] = LeftArray[i];    
        i++;    
        k++;    
        
    }    
      
    while (j<n2)    
    {    
        a[k] = RightArray[j];    
        j++;    
        k++;    
        
    }    //added code from student
                  System.out.println("Pass: ");
                  System.out.println(Arrays.toString(a));
         //end added code from student   
                  
}    
  
static void mergeSort(int a[], int beg, int end)  
{  
    if (beg < end)   
    {  
        int mid = (beg + end) / 2;  
        mergeSort(a, beg, mid);  
        mergeSort(a, mid + 1, end);  
        merge(a, beg, mid, end);  
    }  
}  
  
//QuickSort sorting methods

// A utility function to swap two elements
static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
   
}
  
/* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
static int partition(int[] arr, int low, int high)
{
      
    // pivot
    int pivot = arr[high]; 
      
    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (low - 1); 
  
    for(int j = low; j <= high - 1; j++)
    {
          
        // If current element is smaller 
        // than the pivot
        if (arr[j] < pivot) 
        {
              
            // Increment index of 
            // smaller element
            i++; 
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    System.out.print("Pass: ");
    System.out.println(Arrays.toString(arr));
    return (i + 1);   
}
  
//Quicksort Methods
static void quickSort(int[] arr, int low, int high)
{
    int count = 0;
    if (low < high) 
    {
          
        // pi is partitioning index, arr[p]
        // is now at right place 
        int pi = partition(arr, low, high);
  
        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
                        
         //added code from student
                  
         //end added code from student          
    }
}

public void sort(int arr[])
{
    int N = arr.length;

    // Build heap (rearrange array)
    for (int i = N / 2 - 1; i >= 0; i--){
        heapify(arr, N, i);
    }

    // One by one extract an element from heap
    for (int i = N - 1; i > 0; i--) {
        // Move current root to end
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        System.out.print("pass: ");
        System.out.println(Arrays.toString(arr));

        // call max heapify on the reduced heap
        heapify(arr, i, 0);
    }

}

// To heapify a subtree rooted with node i which is
// an index in arr[]. n is size of heap
void heapify(int arr[], int N, int i)
{
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < N && arr[l] > arr[largest])
        largest = l;

    // If right child is larger than largest so far
    if (r < N && arr[r] > arr[largest])
        largest = r;

    // If largest is not root
    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;

        // Recursively heapify the affected sub-tree
        heapify(arr, N, largest);
    }
}

/* A utility function to print array of size n */
public void printArray(int arr[])
{
    int N = arr.length;

    for (int i = 0; i < N; ++i)
        System.out.print(arr[i] + " ");
    System.out.println();
}

//Used for new array case selection. 
public static int[] randomArrayGen(){
    Scanner scanner=new Scanner(System.in);
    int[] randomArray = null;
    try{

        System.out.println("Input the number of values you desire for the array.");
        int i = scanner.nextInt();
        randomArray= new int[i];//Initialize an array of 13 int elements
        Random random=new Random();//create random
        //Assign array a random intergers from 1-100
        System.out.println("Maximum range in values for the randomization? (Reccomend keeping it the same number as the size of the array or greater to avoid value duplication)");
        int j = scanner.nextInt();
        for(int x=0;x<randomArray.length;x++){
            randomArray[x]=random.nextInt(j);
        }
        //Display the Array and return it to the caller. 
        System.out.println("Your current random interger array is:");
        int valuesPerLine = 50; // You can change this to 15 or any other number
        for (int z = 0; z < randomArray.length; z++) {
            System.out.print(randomArray[z] + " "); // Print value followed by space

            // Check if a new line should be started
            if ((z + 1) % valuesPerLine == 0 || z == randomArray.length - 1) {
                System.out.println(); // Print a new line
            }
        }            
        return randomArray;

    }catch(InputMismatchException e){
        System.out.println("Nice one, try using an interger yeah? Lets not break the code please and thanks!");
        return new int[0];
    }


}
    
}          

  

  

    

