
#define MAX 5;

typedef struct
{
	int arr[MAX];
	int front, rear;
} Deque;

void init(Deque *dq)
{
	dq->front=-1;
	dq->rear=-1;
}

int isEmpty(Deque *dq)
{
	return (dq->front==-1);
}

int isFull(Deque *dq)
{
	return (dq->rear==MAX-1);
}

vois insertFront(Deque *dq, int value)
{
	if (isFull(dq))
	{
		printf("Deque is full\n");
		return;
	}

	//deque empty
	if (dq->front==-1)
	{
		dq->front=0;
		dq->rear=0;
	}
	//front at start, wrap it to end
	else if (dq->front==0)
		dq->front=MAX-1;
	//front backwards
	else
		dq->front--;
	dq->arr[dq->front]=value;
}

void insertRear(Deque *dq, int value)
{
	if (isFull(dq))
	{
		printf("Deque is full\n");
		return;
	}

	//deque empty
	if (dq->front==-1)
	{
		dq->front=0;
		dq->rear=0;
	}
	else
		dq->rear=(dq->rear+1)%MAX;
	dq->arr[dq->rear]=value;
}

void deleteFront(Deque *dq)
{
	if (isEmpty(dq))
	{
		printf("Deque empty\n");
		return;
	}
	//only one element
	if (dq->front==dq->rear)
	{
		dq->front=dq->rear=-1;
	}
	else
		dq->front=(dq->front+1)%MAX;
}

void deleteRear(Deque *dq)
{
	if (isEmpty(dq))
	{
		printf("Deque is empty\n");
		return;
	}
	//one element
	if (dq->front==dq->rear)
		dq->front=dq->rear=-1;
	else
		dq->rear=(dq->rear-1+MAX)%MAX;
}

void display(Deque *dq) {
    if (isEmpty(dq)) {  // If deque is empty, print a message
        printf("Deque is empty\n");
        return;
    }
    printf("Deque elements: ");
    int i = dq->front;
    while (i != dq->rear) {  // Traverse the deque from front to rear
        printf("%d ", dq->arr[i]);
        i = (i + 1) % MAX;  // Move the index forward, wrapping around if necessary
    }
    printf("%d\n", dq->arr[dq->rear]);  // Print the last element at the rear
}










































































