#include <stdio.h>
#include <stdlib.h>

// Function to perform Binary Search recursively
int BinSearch(int *arr, int left, int right, int target) {
    if (left > right) {
        return -1;  // Element not found
    }
    
    int mid = left + (right - left) / 2;  // To avoid overflow

    if (arr[mid] == target) {
        return mid;  // Element found
    } 
    if (arr[mid] > target) {
        return BinSearch(arr, left, mid - 1, target);  // Search left half
    } 
    return BinSearch(arr, mid + 1, right, target);  // Search right half
}

// Function to calculate the sum of elements recursively
int AddArray(int *arr, int size) {
    if (size == 0) {
        return 0;  // Base case: no elements to sum
    }
    return arr[size - 1] + AddArray(arr, size - 1);  // Sum last element and recurse
}

int main() {
    int n, target, result;

    // Dynamic memory allocation for the array
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    
    // Dynamically allocate memory for the array
    int *arr = (int *)malloc(n * sizeof(int));
    
    if (arr == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    // Input elements into the array
    printf("Enter %d elements in ascending order: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Test the BinSearch function
    printf("Enter the element to search: ");
    scanf("%d", &target);
    
    result = BinSearch(arr, 0, n - 1, target);
    if (result != -1) {
        printf("Element %d found at index %d.\n", target, result);
    } else {
        printf("Element %d not found.\n", target);
    }

    // Test the AddArray function
    int sum = AddArray(arr, n);
    printf("The sum of all elements in the array is: %d\n", sum);

    // Free the dynamically allocated memory
    free(arr);

    return 0;
}
