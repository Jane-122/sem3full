#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    char info;
    struct node *rlink;
    struct node *llink;
} NODE;

NODE* insertFront(char item, NODE* head) {
    NODE* newNode = (NODE*)malloc(sizeof(NODE));
    newNode->info = item;
    newNode->rlink = head->rlink;
    newNode->llink = head;
    head->rlink->llink = newNode;
    head->rlink = newNode;

    return head;  // head remains unchanged
}

NODE* insertRear(char item, NODE* head) {
    NODE* newNode = (NODE*)malloc(sizeof(NODE));
    NODE* temp = head->llink;

    newNode->info = item;
    newNode->rlink = head;
    newNode->llink = temp;
    temp->rlink = newNode;
    head->llink = newNode;

    return head;
}

NODE* deleteFront(NODE* head) {
    if (head->rlink == head) {
        printf("List is empty.\n");
        return head;
    }

    NODE* temp = head->rlink;
    head->rlink = temp->rlink;
    temp->rlink->llink = head;

    printf("Deleted node: %c\n", temp->info);
    free(temp);

    return head;
}

NODE* deleteRear(NODE* head) {
    if (head->llink == head) {
        printf("List is empty.\n");
        return head;
    }

    NODE* temp = head->llink;
    head->llink = temp->llink;
    temp->llink->rlink = head;

    printf("Deleted node: %c\n", temp->info);
    free(temp);

    return head;
}

void displayWord(NODE* head) {
    if (head->rlink == head) {
        printf("List is empty.\n");
        return;
    }

    NODE* temp = head->rlink;
    printf("The word is: ");
    while (temp != head) {
        printf("%c", temp->info);
        temp = temp->rlink;
    }
    printf("\n");
}

int palindrome(NODE* head) {
    if (head->rlink == head) {
        return 1; // An empty list is considered a palindrome
    }

    NODE* left = head->rlink;
    NODE* right = head->llink;

    while (left != right && left->llink != right) {
        if (left->info != right->info) {
            return 0; // Not a palindrome if characters don't match
        }
        left = left->rlink;
        right = right->llink;
    }

    return 1; // Palindrome if all characters match
}

int main() {
    NODE* head = (NODE*)malloc(sizeof(NODE));  // Create header node locally in main
    head->info = '\0';  // Header node has no meaningful data
    head->rlink = head;  // Points to itself when empty
    head->llink = head;

    int ch;
    char item;

    while (1) {
        printf("1-Insert front\n2-Delete front\n3-Insert rear\n4-Delete rear\n5-Display\n6-Check Palindrome\n7-Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch(ch) {
            case 1:
                printf("Enter character to insert at front: ");
                getchar();  // To consume the newline character left by scanf
                scanf("%c", &item);
                head = insertFront(item, head);
                break;

            case 2:
                head = deleteFront(head);
                break;

            case 3:
                printf("Enter character to insert at rear: ");
                getchar();  // To consume the newline character left by scanf
                scanf("%c", &item);
                head = insertRear(item, head);
                break;

            case 4:
                head = deleteRear(head);
                break;

            case 5:
                displayWord(head);
                break;

            case 6:
                if (palindrome(head)) {
                    printf("The word is a palindrome.\n");
                } else {
                    printf("The word is not a palindrome.\n");
                }
                break;

            case 7:
                exit(0);

            default:
                printf("Invalid choice.\n");
        }
    }

    return 0;
}

