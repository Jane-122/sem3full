#include <stdio.h>
#include <stdlib.h>

#define MAX 5

struct Queue
{
	int arr[MAX];
	int front;
	int rear;
};

void initQueue(struct Queue *q)
{
	q->front=q->rear=-1;
}

int isFull(struct Queue *q)
{
	return q->rear==MAX-1;
}

int isEmpty(struct Queue *q)
{
	return q->front==-1 || q->front > q->rear;
}

void enqueue(struct Queue *q, int value)
{
	if (isFull(q))
		printf("Queue is full\n");
	else
	{
		if (q->front==-1)
			q->front=0;
		q->arr[++(q->rear)]=value;
	}
}

int dequeue(struct Queue *q)
{
	if (isEmpty(q))
	{
		printf("Queue empty.\n");
		return -1;
	}
	return q->arr[q->front++];
}

void display(struct Queue *q)
{
	if (isEmpty(q))
		printf("Queue empty.\n");
	else
	{
		for (int i=q->front; i<=q->rear; i++)
		{
			printf("%d ", q->arr[i]);
		}
		printf("\n");
	}
}


int main() {
    struct Queue q;
    int choice, value;

    // Initialize the queue
    initQueue(&q);

    do {
        // Display menu options
        printf("\nQueue Operations Menu:\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                // Enqueue operation
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                enqueue(&q, value);
                break;
            case 2:
                // Dequeue operation
                value = dequeue(&q);
                if (value != -1) {
                    printf("Dequeued: %d\n", value);
                }
                break;
            case 3:
                // Display queue elements
                display(&q);
                break;
            case 4:
                // Exit program
                printf("Exiting the program.\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 4);

    return 0;
}
































