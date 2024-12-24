#define MAX 100

struct node
{
	int info;
	struct node* llink;
	struct node* rlink;
};

typedef struct node *NODE;

typedef struct
{
	NODE stack[MAX];
	int top;
}STACK;

int isEmpty(STACK *s)
{
	if (s->top==-1)
		return 1;
	else
		return 0;
}

void Push(STACK *s, NODE x)
{
	if (s->top==MAX-1)
	{
		printf("Stack overflow");
		return;
	}
	s->stack[++s->top]=x;
}

NODE Pop(STACK *s)
{
	return (s->stack[s->top--]);
}

NODE createTree(char postfix[])
{
	NODE temp;
	STACK *s,s1;
	s=&s1;
	char symbol;
	while((symbol=postfix[i++]!="\0"))
	{
		temp=(struct node*)malloc(1*sizeof(struct node));
		temp->info=symbol;
		temp->llink=temp->rlink=NULL;

		if (isalnum(symbol))
			Push(s,temp);
		else
		{
			temp->rlink=Pop(s);
			temp->llink=Pop(s);
			Push(s,temp);
		}
	}
	return(Pop(s));
}
























