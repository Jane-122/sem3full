#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node
{
	int info;
	struct node *llink;
	struct node *rlink;
};

typedef struct node* NODE;

NODE createBST(NODE root, int item)
{
	if (root==NULL)
	{
		root=(struct node*)malloc(1*sizeof(struct node));
		root->info=item;
		root->llink=root->rlink=NULL;
		return root;
	}

	else if (item<root->info)
		root->llink=createBST(root->llink,item);
	else if (item>root->info)
		root->rlink=createBST(root->rlink,item);
	else
		printf("Duplicates not allowed\n");
	return root;
}

void inorderTraversal(NODE root) {
    if (root != NULL) {
        inorderTraversal(root->llink);
        printf("%d ", root->info);
        inorderTraversal(root->rlink);
    }
}

// Main function
int main() {
    NODE root = NULL;
    int choice, value;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Insert a value into the BST\n");
        printf("2. Display the in-order traversal of the BST\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                root = createBST(root, value);
                break;
            case 2:
                printf("In-order traversal of BST: ");
                inorderTraversal(root);
                printf("\n");
                break;
            case 3:
                printf("Exiting program...\n");
                exit(0);
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }

    return 0;
}
























