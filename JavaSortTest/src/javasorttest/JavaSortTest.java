/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasorttest;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 18323
 */
public class JavaSortTest {

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]){ 
       boolean needAnswer = false;
       JavaSort javasort = new JavaSort();
       Scanner scanner=new Scanner(System.in);
       //Initialize the originalArray outside of the scope of the "do while" loop.
       int[] originalArray = JavaSort.randomArrayGen();   
    
       do{         
        //intitiate a user input switch case for sorting algo selection via method call
        System.out.print("Select what sorting method should be used (enter the number) \n1. Bubble Sort\n2. Insertion Sort\n3. Shell Sort\n4. Merge Sort\n5. Quick Sort.\n6. Heap Sort\n7. End Program\n8. New Array\nEnter value here: ");
        //initiate a do-while loop for multiple uses without restart
        
        while (!scanner.hasNextInt()){
                System.out.println("Enter a valid number!");
                scanner.next();
            }
        int UserInput=scanner.nextInt();
        //Important** make a copy of the original unsorted array for use in each individual case to scope. 
        int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
        
        switch(UserInput){
            
            case 1:
                System.out.println("");
                System.out.println("Start Bubble Algorithm");
                long startTime = System.nanoTime();
                javasort.bubbleSort(arrayToSort);//call bubble algo
                long endTime = System.nanoTime();
                System.out.println("End Bubble Algorithm time taken: "+(endTime-startTime)+" nano-seconds");
                System.out.println(" ");
                break;
            case 2:
                System.out.println(" ");
                System.out.println("Start Insertion Algorithm");
                long startTime1 = System.nanoTime();
                javasort.InsertSort(arrayToSort);//call insertion algo
                long endTime1 = System.nanoTime();                
                System.out.println("End Insertion Algorithm "+(endTime1-startTime1)+" nano-seconds");
                System.out.println(" ");
                break;
            case 3:
                System.out.println(" ");
                System.out.println("Start Shell Algorithm");
                long startTime2 = System.nanoTime();
                javasort.ShellSort(arrayToSort);//call insertion algo
                long endTime2 = System.nanoTime();
                System.out.println("End Shell Algorithm "+(endTime2-startTime2)+" nano-seconds");
                System.out.println(" ");
                break;
            case 4:
                System.out.println(" ");
                System.out.println("Start Merge Algorithm");
                long startTime3 = System.nanoTime();
                javasort.mergeSort(arrayToSort, 0, arrayToSort.length-1);//call insertion algo
                long endTime3 = System.nanoTime();
                System.out.println("End Merge Algorithm "+(endTime3-startTime3)+" nano-seconds");
                System.out.println(" ");
                break;
            case 5:
                System.out.println(" ");
                System.out.println("Start Quicksort Algorithm");
                long startTime4 = System.nanoTime();
                javasort.quickSort(arrayToSort, 0, arrayToSort.length-1);//call insertion algo
                long endTime4 = System.nanoTime();
                System.out.println("End Quicksort Algorithm "+(endTime4-startTime4)+" nano-seconds");
                System.out.println(" ");
                break;
            case 6:
                System.out.println(" ");
                System.out.println("Start Heapsort Algorithm");
                long startTime5 = System.nanoTime();
                javasort.sort(arrayToSort);//call insertion algo
                long endTime5 = System.nanoTime();
                System.out.println("End Heapsort Algorithm "+(endTime5-startTime5)+" nano-seconds");
                System.out.println(" ");
                break;    
            case 7:
                System.out.println(" ");
                System.out.println("-Closing Program-");//break and close loop per user input request
                needAnswer = true;
                break;
            case 8:
                System.out.println(" ");
                System.out.println("-Generating A New Array-");//break and close loop per user input request
                originalArray = JavaSort.randomArrayGen();   
                break;
            default :
                System.out.println("-Enter a valid input-");//default catch bad input values, request valid input
                
        }}
       while(!needAnswer);//close do while loop.
       scanner.close();//close scanner           
   }
}

