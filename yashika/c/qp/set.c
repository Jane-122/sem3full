#include <stdio.h>
#include <stdlib.h>

int* BuildSet(int n) {
    int *set = (int*)malloc(n * sizeof(int));
    if (set == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }

    int count = 0;
    while (count < n) {
        int element;
        int found = 0;
        printf("Enter element %d: ", count + 1);
        scanf("%d", &element);

        // Check for duplicate
        for (int i = 0; i < count; i++) {
            if (set[i] == element) {
                found = 1;
                printf("Duplicate element! Please enter a different element.\n");
                break;
            }
        }

        if (!found) {
            set[count] = element;
            count++;
        }
    }

    return set;
}

int SearchSet(int* A, int x, int n) {
    for (int i = 0; i < n; i++) {
        if (A[i] == x) {
            return 1;
        }
    }
    return 0;
}

int* Union(int* A, int nA, int* B, int nB, int* resultSize) {
    int *unionSet = (int*)malloc((nA + nB) * sizeof(int));
    if (unionSet == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }

    int count = 0;

    // Add all elements of A to the union set
    for (int i = 0; i < nA; i++) {
        unionSet[count++] = A[i];
    }

    // Add elements of B to the union set if not already present
    for (int i = 0; i < nB; i++) {
        if (!SearchSet(A, B[i], nA)) {
            unionSet[count++] = B[i];
        }
    }

    *resultSize = count;
    return unionSet;
}

void DisplaySet(int* set, int n) {
    printf("{ ");
    for (int i = 0; i < n; i++) {
        printf("%d ", set[i]);
    }
    printf("}\n");
}

int main() {
    int nA, nB;
    
    printf("Enter the number of elements in set A: ");
    scanf("%d", &nA);
    int* A = BuildSet(nA);

    printf("Enter the number of elements in set B: ");
    scanf("%d", &nB);
    int* B = BuildSet(nB);

    printf("\nSet A: ");
    DisplaySet(A, nA);

    printf("Set B: ");
    DisplaySet(B, nB);

    int resultSize;
    int* unionSet = Union(A, nA, B, nB, &resultSize);

    printf("\nUnion of A and B: ");
    DisplaySet(unionSet, resultSize);

    // Free allocated memory
    free(A);
    free(B);
    free(unionSet);

    return 0;
}
