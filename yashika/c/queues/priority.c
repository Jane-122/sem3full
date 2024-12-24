#include <stdio.h>
#define MAX 5

typedef struct{
    int arr[MAX];
    int front, rear;
}priority;

void init(priority *q){
    q->front=-1;
    q->rear=-1;
}

int isempty(priority *q){
    return q->front==-1;
}

int isfull(priority *q){
    return q->rear==MAX-1;
}

void enqueue(priority *q, int value) {
    if (isfull(q)) {
        printf("Queue full\n");
    } else {
        if (isempty(q)) {
            q->front = 0;  // Set front to 0 only if queue was empty
        }
        q->arr[++(q->rear)] = value;
    }
}

void dequeue(priority *q) {
    if (isempty(q)) {
        printf("Queue empty\n");
        return;
    }

    int highest = q->front;

    // Find the index of the element with the highest priority (largest value)
    for (int i = q->front; i <= q->rear; i++) {
        if (q->arr[i] > q->arr[highest]) {
            highest = i;
        }
    }

    // Shift elements to remove the highest priority element
    for (int i = highest; i < q->rear; i++) {
        q->arr[i] = q->arr[i + 1];
    }

    q->rear--;  // Decrease the rear index

    if (q->rear < 0) {
        q->front = -1;  // If the queue is empty, set front to -1
    }
}
