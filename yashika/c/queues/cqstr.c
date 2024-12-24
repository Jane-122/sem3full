#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 5
#define STR_LEN 100  // Maximum length of each string

struct Queue
{
    char arr[MAX][STR_LEN];  // Array to store strings
    int front;
    int rear;
};

void initQueue(struct Queue *q)
{
    q->front = q->rear = -1;
}

int isFull(struct Queue *q)
{
    return (q->rear + 1) % MAX == q->front;
}

int isEmpty(struct Queue *q)
{
    return q->front == -1;
}

void enqueue(struct Queue *q, char *value)
{
    if (isFull(q))
        printf("Queue is full\n");
    else
    {
        if (q->front == -1)  // For the first element
            q->front = 0;
        q->rear = (q->rear + 1) % MAX;
        strcpy(q->arr[q->rear], value);  // Copy the string into the queue
    }
}

char* dequeue(struct Queue *q)
{
    if (isEmpty(q))
    {
        printf("Queue empty\n");
        return NULL;
    }
    else
    {
        char *value = q->arr[q->front];
        if (q->front == q->rear)
            // Only one element, so reset queue
            q->front = q->rear = -1;
        else
            q->front = (q->front + 1) % MAX;
        return value;
    }
}

void display(struct Queue *q)
{
    if (isEmpty(q))
        printf("Queue empty\n");
    else
    {
        int i = q->front;
        while (i != q->rear)
        {
            printf("%s ", q->arr[i]);
            i = (i + 1) % MAX;
        }
        printf("%s\n", q->arr[q->rear]);
    }
}

int main()
{
    struct Queue q;
    int choice;
    char value[STR_LEN];

    initQueue(&q);

    do
    {
        printf("\nQueue Operations Menu:\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        getchar();  // Consume newline character left by scanf

        switch (choice)
        {
        case 1:
            printf("Enter string to enqueue: ");
            fgets(value, STR_LEN, stdin);
            value[strcspn(value, "\n")] = '\0';  // Remove newline character
            enqueue(&q, value);
            break;
        case 2:
            {
                char* dequeuedValue = dequeue(&q);
                if (dequeuedValue != NULL) {
                    printf("Dequeued: %s\n", dequeuedValue);
                }
                break;
            }
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

    return 0;
}
