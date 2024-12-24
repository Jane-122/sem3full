#include <stdio.h>
#define MAX 5

typedef struct {
    int arr[MAX];
    int front, rear;
} priority;

void init(priority *q) {
    q->front = -1;
    q->rear = -1;
}

int isempty(priority *q) {
    return q->front == -1;
}

int isfull(priority *q) {
    return q->rear == MAX - 1;
}

void enqueue(priority *q, int value) {
    if (isfull(q)) {
        printf("Queue full\n");
    } else {
        if (isempty(q)) {
            q->front = 0;
        }
        q->arr[++(q->rear)] = value;
    }
    printf("Inserted %d into the queue\n", value);
}

void dequeue(priority *q) {
    if (isempty(q)) {
        printf("Queue empty\n");
        return;
    }

    int smallest = q->front;

    for (int i = q->front; i <= q->rear; i++) {
        if (q->arr[i] < q->arr[smallest]) {
            smallest = i;
        }
    }

    printf("Dequeued %d from the queue\n", q->arr[smallest]);

    for (int i = smallest; i < q->rear; i++) {
        q->arr[i] = q->arr[i + 1];
    }

    q->rear--;

    if (q->rear < 0) {
        q->front = -1;
    }
}

void display(priority *q) {
    if (isempty(q)) {
        printf("Queue empty\n");
        return;
    }

    printf("Queue elements: ");
    for (int i = q->front; i <= q->rear; i++) {
        printf("%d ", q->arr[i]);
    }
    printf("\n");
}

int main() {
    priority q;
    init(&q);

    int choice, value;

    while (1) {
        printf("\nPriority Queue Operations (Ascending Priority):\n");
        printf("1. Insert element\n");
        printf("2. Delete smallest priority element\n");
        printf("3. Display Queue\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                enqueue(&q, value);
                break;
            case 2:
                dequeue(&q);
                break;
            case 3:
                display(&q);
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
