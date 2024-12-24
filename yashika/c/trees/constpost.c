#include <stdio.h>
#include <stdlib.h>

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

NODE buildTree(int inorder[], int postorder[], int *postIndex, int start, int end) {
    if (start > end)
        return NULL;

    int rootVal = postorder[*postIndex];
    (*postIndex)--;

    NODE root = newNode(rootVal);

    if (start == end)
        return root;

    int inorderIndex = search(inorder, start, end, rootVal);

    root->rlink = buildTree(inorder, postorder, postIndex, inorderIndex + 1, end);
    root->llink = buildTree(inorder, postorder, postIndex, start, inorderIndex - 1);

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

void postorderTraversal(NODE root) {
    if (root == NULL)
        return;

    postorderTraversal(root->llink);
    postorderTraversal(root->rlink);
    printf("%d ", root->info);
}

void inorderTraversal(NODE root) {
    if (root == NULL)
        return;

    inorderTraversal(root->llink);
    printf("%d ", root->info);
    inorderTraversal(root->rlink);
}

int main() {
    int inorder[] = {46,77,79,78,75,82,90,95,85,80};
    int postorder[] = {46,75,77,78,79,80,82,85,90,95};

    int n = sizeof(inorder) / sizeof(inorder[0]);
    int postIndex = n - 1;

    NODE root = buildTree(inorder, postorder, &postIndex, 0, n - 1);

    printf("The constructed tree is:\n");
    display(root, 0);

    printf("\nPostorder Traversal of the constructed tree:\n");
    postorderTraversal(root);
    printf("\n");

    printf("Inorder Traversal of the constructed tree:\n");
    inorderTraversal(root);
    printf("\n");

    return 0;
}
