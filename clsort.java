package algo_sort;
import java.util.*;

public class clsort {
public static void main(String args[])
{
	
	int i,num;

	Scanner s=new Scanner(System.in);
	System.out.println("Enter size of array");
	num=s.nextInt();
	int ar[]=new int[num];
	System.out.println("Enter elements of array");
	for(i=0;i<num;i++)
	  	ar[i]=s.nextInt();	
	System.out.println("Sorting:\n");
	//bubble_sort(ar,num);
	//selection_sort(ar,num);
	//insertion_sort(ar,num);
	    
    char choice;
    
    do
    {
        System.out.println("Sort : ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Exit");
        
        System.out.println("Choose any one : ");
        choice = s.next().charAt(0);
    }while(choice != '3');
    
    System.out.println("\n");
    
    switch(choice)
    {
        case '1' : System.out.println("Bubble Sort:\n");
        bubble_sort(ar,num);
            break;
        
        case '2' : System.out.println("Selection Sort :\n");
        selection_sort(ar,num);
            break;
            
        case '3' : System.out.println("Insertion Sort :\n");
        insertion_sort(ar,num);
            break;            
                
        case '4':break;
    }
    
	for(i=0;i<num;i++)
	  	System.out.println(ar[i]);
}

static void bubble_sort(int a[],int n)
{
	/*Bubble sort is based on the idea of repeatedly comparing pairs 
	of adjacent elements and then swapping their positions if they 
	exist in the wrong order.
	The complexity of bubble sort is O(n**2) in both worst and average 
	cases, because the entire array needs to be iterated for every 
	element.*/
	
	int t;
	for(int k=0;k<n-1;k++){
		for(int i=0;i<n-k-1;i++){ 
			// (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
			if(a[i]>a[i+1]){
				t=a[i];		//swapping of positions
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
	}
}

static void selection_sort(int a[],int n)
{
/*The Selection sort algorithm is based on the idea of finding the 
 minimum or maximum element in an unsorted array and then putting
 it in its correct position in a sorted array.Assume that the array 
 A=[7,5,4,2] needs to be sorted in ascending order.	The minimum 
 element in the array i.e. 2 is searched for and then swapped with 
 the element that is currently located at the first position, i.e. 7.
 Now the minimum element in the remaining unsorted array is searched 
 for and put in the second position, and so on.
 Time Complexity:to find the minimum element from the array of N elements,
 N-1 comparisons and then N-2 comparisons are required to find the minimum
 in the unsorted array. Therefore (N-1)+(N-2)+.....+1=(N.(N-1))/2 
 comparisons and N swaps result in overall complexity of O(N**2)   
 */
	
	int min,t;
	// reduces the effective size of the array by one in  each iteration.

	for(int i=0;i<n-1;i++){
		// assuming the first element to be the minimum of the unsorted array .
		min=i;
		// gives the effective size of the unsorted  array .

		for(int j=i+1;j<n;j++){
			if (a[j]<a[min]) //finds the minimum element
				min=j;
		}
		// putting minimum element on its proper position.
	t=a[min];
    a[min]=a[i];
    a[i]=t;
    }	
}

static void insertion_sort(int a[],int n)
{
	/*Insertion sort is based on the idea that one element from the
    input elements is consumed in each iteration to find its 
	correct position i.e, the position to which it belongs 
	in a sorted array.It iterates the input elements by growing 
	the sorted array at each iteration. It compares the current
	element with the largest value in the sorted array. If the 
	current element is greater, then it leaves the element in 
	its place and moves on to the next element else it finds 
	its correct position in the sorted array and moves it to
	that position. This is done by shifting all the elements, 
	which are larger than the current element, in the sorted
	array to one position ahead
	Time Complexity:In worst case,each element is compared with 
	all the other elements in the sorted array. For N elements, 
	there will be N2 comparisons. Therefore, the time complexity 
	is O(N**2)

*/
	
	for(int i=0;i<n;i++){
		/*storing current element whose left side is checked for its 
        correct position .*/
		int t=a[i];
		int j=i;
		/* check whether the adjacent element in left side is greater or
        less than the current element. */
        while(j>0 && t<a[j-1]){
        	 // moving the left side element to one position forward.
        	a[j]=a[j-1];
        	j=j-1;
        }
     // moving current element to its  correct position.
        a[j] = t;
	}
}


}


