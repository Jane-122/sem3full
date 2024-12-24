#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *link;
};
typedef struct node *NODE;

NODE insertfront(int item, NODE first)
{
	NODE temp;
	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;
	temp->link=first;
	return temp;
}

void display(NODE first)
{
	NODE temp;
	if (first==NULL)
	{
		printf("list empty\n");
		return;
	}

	printf("linked list contents\n");

	temp=first;
	while(temp!=NULL)
	{
		printf("%d ",temp->info);
		temp=temp->link;
	}
	printf("\n");
}

int length(NODE first)
{
	NODE cur;
	int count=0;

	if (first==NULL) return 0;

	cur=first;
	while (cur!=NULL)
	{
		count++;
		cur=cur->link;
	}
	return count;
}

void main()
{
	NODE first=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert Front\n2-Display\n3-Length\n4-Exit\n");
		printf("Enter choice \n");
		scanf("%d",&ch);

		switch(ch)
		{
		case 1:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			first=insertfront(item,first);

			break;

		case 2:
			display(first);
			break;

		case 3:
			int n;
			n=length(first);
			printf("%d is length of linked list\n",n);
			break;

		default:
			exit(0);
		}
	}
}



