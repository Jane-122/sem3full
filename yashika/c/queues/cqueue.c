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
	return (q->rear+1)%MAX==q->front;
}

int isEmpty(struct Queue *q)
{
	return q->front==-1;
}

void enqueue(struct Queue *q, int value)
{
	if (isFull(q))
		printf("Queue is full\n");
	else
	{
		if (q->front==-1)     //for one element
			q->front=0;
		q->rear=(q->rear+1)%MAX;
		q->arr[q->rear]=value;
	}
}

int dequeue(struct Queue *q)
{
	if (isEmpty(q))
	{
		printf("Queue empty\n");
		return -1;
	}

	else
	{
		int value=q->arr[q->front];
		if (q->front==q->rear)
			//only one element, so reset queue
			q->front=q->rear=-1;
		else
			q->front=(q->front+1)%MAX;
		return value;
	}
}

void display(struct Queue *q)
{
	if (isEmpty(q))
		printf("Queue empty\n");
	else
	{
		int i=q->front;
		while (i!=q->rear)
		{
			printf("%d ",q->arr[i]);
			i=(i+1)%MAX;
		}
		printf("%d\n", q->arr[q->rear]);
	}
}

int main() {
    struct Queue q;
    int choice, value;

    initQueue(&q);

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

    return 0;
}








































