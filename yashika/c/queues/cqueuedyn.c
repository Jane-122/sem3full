#include <stdio.h>
#include <stdlib.h>

#define INITIAL_CAPACITY 5

struct Queue {
    int *arr;      // Pointer to the dynamically allocated array
    int front;
    int rear;
    int count;     // Tracks the current number of elements in the queue
};

void initQueue(struct Queue *q) {
    q->arr = (int *)malloc(INITIAL_CAPACITY * sizeof(int)); // Initial allocation
    if (q->arr == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    q->front = q->rear = 0;
    q->count = 0;
}

int isFull(struct Queue *q) {
    return q->count == INITIAL_CAPACITY;
}

int isEmpty(struct Queue *q) {
    return q->count == 0;
}

void enqueue(struct Queue *q, int value) {
    // Check if the queue is full and resize it
    if (isFull(q)) {
        printf("Queue is full, resizing...\n");
        q->arr = realloc(q->arr, 2 * INITIAL_CAPACITY * sizeof(int));  // Double the size
        if (q->arr == NULL) {
            printf("Memory allocation failed!\n");
            exit(1);  // Exit if memory allocation fails
        }
    }

    q->arr[q->rear] = value;
    q->rear = (q->rear + 1) % INITIAL_CAPACITY;
    q->count++;
}

int dequeue(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue empty\n");
        return -1;  // Indicate error
    }
    int value = q->arr[q->front];
    q->front = (q->front + 1) % INITIAL_CAPACITY;
    q->count--;
    return value;
}

void display(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
    } else {
        int i = q->front;
        printf("Queue elements: ");
        while (i != q->rear) {
            printf("%d ", q->arr[i]);
            i = (i + 1) % INITIAL_CAPACITY;
        }
        printf("\n");
    }
}

void freeQueue(struct Queue *q) {
    free(q->arr);  // Free the dynamically allocated memory
}

int main() {
    struct Queue q;
    int choice, value;

    initQueue(&q);  // Initialize the queue with initial size

    do {
        printf("\nQueue Operations Menu:\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                enqueue(&q, value);
                break;
            case 2:
                value = dequeue(&q);
                if (value != -1) {
                    printf("Dequeued: %d\n", value);
                }
                break;
            case 3:
                display(&q);
                break;
            case 4:
                printf("Exiting the program.\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 4);

    freeQueue(&q);  // Free the dynamically allocated memory
    return 0;
}
