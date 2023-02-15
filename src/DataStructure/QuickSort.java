package DataStructure;

import MVC.Flight;

public class QuickSort {
    /* Quick sort algorithm
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    
    public void sort(Flight arr[], int low, int high) {
        if (low < high)
        {
            int pivot = arr[high].getFlightNumber();
            int i = (low-1); // index of smaller element
            for (int j=low; j<high; j++)
            {
                // If current element is smaller than or
                // equal to pivot
                if (arr[j].getFlightNumber() <= pivot)
                {
                    i++;
                    // swap arr[i] and arr[j]
                    Flight temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // swap arr[i+1] and arr[high] (or pivot)
            Flight temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = i+1;
            // Recursively sort elements before partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
        
    }

}
