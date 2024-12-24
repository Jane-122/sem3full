#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *llink;
	struct node *rlink;
	int lthread;
	int rthread;
}

typedef struct node* NODE;

//finding inorder successor without stack
NODE insucc(NODE node)
{
	NODE temp=node->rlink;
	if (node->rthread===FALSE)
		while (temp->lthread==FALSE)
			temp=temp->llink;
	return temp;
}

//inorder traversal of threaded bt
void inorder(NODE head) {
    if (head==NULL) return; // Handle empty tree

    // Find the leftmost node to start traversal
    NODE temp = head;
    while (temp->lthread!=FALSE) {
        temp = temp->llink;
    }

    // Perform inorder traversal until we return to the head
    while (temp != head) {
        printf("%d ", temp->info);
        temp = insucc(temp);
    }
}


