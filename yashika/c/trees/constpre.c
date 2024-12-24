#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 10

struct node {
    int info;
    struct node *llink;
    struct node *rlink;
};

typedef struct node* NODE;

NODE newNode(int item) {
    NODE temp = (NODE)malloc(sizeof(struct node));
    temp->info = item;
    temp->llink = temp->rlink = NULL;
    return temp;
}

int search(int inorder[], int start, int end, int value) {
    for (int i = start; i <= end; i++) {
        if (inorder[i] == value)
            return i;
    }
    return -1;
}

NODE buildTree(int preorder[], int inorder[], int *preIndex, int start, int end) {
    if (start > end)
        return NULL;

    int rootVal = preorder[*preIndex];
    (*preIndex)++;

    NODE root = newNode(rootVal);

    if (start == end)
        return root;

    int inorderIndex = search(inorder, start, end, rootVal);

    root->llink = buildTree(preorder, inorder, preIndex, start, inorderIndex - 1);
    root->rlink = buildTree(preorder, inorder, preIndex, inorderIndex + 1, end);

    return root;
}

void display(NODE root, int level) {
    if (root == NULL) return;

    display(root->rlink, level + 1);
    
    for (int i = 0; i < level; i++)  
        printf("  ");
    printf("%d\n", root->info);
    
    display(root->llink, level + 1);
}

void preorderTraversal(NODE root) {
    if (root == NULL)
        return;

    printf("%d ", root->info);
    preorderTraversal(root->llink);
    preorderTraversal(root->rlink);
}

void inorderTraversal(NODE root) {
    if (root == NULL)
        return;

    inorderTraversal(root->llink);
    printf("%d ", root->info);
    inorderTraversal(root->rlink);
}

int main() {
    int preorder[] = { 40, 30, 22, 11, 9, 23, 45, 48, 50 };
    int inorder[] = { 9, 11, 22, 23, 30, 40, 45, 48, 50};

    int n = sizeof(preorder) / sizeof(preorder[0]);
    int preIndex = 0;

    NODE root = buildTree(preorder, inorder, &preIndex, 0, n - 1);

    printf("The constructed tree is:\n");
    display(root, 0);

    printf("\nPreorder Traversal of the constructed tree:\n");
    preorderTraversal(root);
    printf("\n");

    printf("Inorder Traversal of the constructed tree:\n");
    inorderTraversal(root);
    printf("\n");

    return 0;
}
