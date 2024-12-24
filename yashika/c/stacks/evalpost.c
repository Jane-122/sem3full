
#define MAX 100

typedef struct
{
	int arr[MAX];
	int top;
} STACK;

void init(STACK *s)
{
	s->top=-1;
}

int isEmpty(STACK *s)
{
	return s->top==-1;
}

int isFull(STACK *s)
{
	return s->top==MAX-1;
}

void push(STACK *s,int value)
{
	s->arr[++(s->top)]=value;
}

void pop(STACK *s)
{
	return s->arr[(s->top)--];
}

int eval(char x,int a, int b)
{
	switch(x) {
	case '+': return (a+b); break;
	case '-': return (a-b); break;
	case '*': return (a*b); break;
	case '/': return (a/b); break;
	case '%': return (a%b); break;
}

void main()
{
	STACK s;
	char x;
	int top1, top2, val;
	init(&s);
	printf("Enter expression\n");
	while (x=getchar()!='\n')
	{
		if (isdigit(x))
			push(&s,x-'0');
		else
		{
			top1=pop(&s);
			top2=pop(&s);
			val=eval(x,top2,top1);
		}
	}
	val=pop(&s);
	printf("Value of expression=%d",val)
}































