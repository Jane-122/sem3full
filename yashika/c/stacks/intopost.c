#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define MAX 50

// Define operator precedence
int precedence(char op) {
    switch (op) {
        case '+':
        case '-': return 1;
        case '*':
        case '/': return 2;
        case '^': return 3;
        default: return 0;
    }
}

// Check if a character is an operator
int is_operator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
}

// Stack structure and functions
typedef struct {
    char data[MAX];
    int top;
} Stack;

void init(Stack *s) {
    s->top = -1;
}

int is_empty(Stack *s) {
    return s->top == -1;
}

int is_full(Stack *s) {
    return s->top == MAX - 1;
}

void push(Stack *s, char ch) {
    if (is_full(s)) {
        printf("Stack overflow\n");
        exit(1);
    }
    s->data[++(s->top)] = ch;
}

char pop(Stack *s) {
    if (is_empty(s)) {
        printf("Stack underflow\n");
        exit(1);
    }
    return s->data[(s->top)--];
}

char peek(Stack *s) {
    if (is_empty(s)) {
        return '\0';
    }
    return s->data[s->top];
}

// Infix to Postfix conversion
void infix_to_postfix(char *infix, char *postfix) {
    Stack stack;
    init(&stack);
    int i = 0, j = 0;

    while (infix[i] != '\0') {
        char ch = infix[i];

        if (isalnum(ch)) { // If operand, add to postfix
            postfix[j++] = ch;
        } else if (ch == '(') { // If '(', push to stack
            push(&stack, ch);
        } else if (ch == ')') { // If ')', pop until '('
            while (!is_empty(&stack) && peek(&stack) != '(') {
                postfix[j++] = pop(&stack);
            }
            if (!is_empty(&stack) && peek(&stack) == '(') {
                pop(&stack); // Discard the '('
            }
        } else if (is_operator(ch)) { // If operator
            while (!is_empty(&stack) && precedence(peek(&stack)) >= precedence(ch)) {
                postfix[j++] = pop(&stack);
            }
            push(&stack, ch);
        } else {
            printf("Invalid character in expression: %c\n", ch);
            exit(1);
        }
        i++;
    }

    // Pop remaining operators
    while (!is_empty(&stack)) {
        postfix[j++] = pop(&stack);
    }
    postfix[j] = '\0'; // Null-terminate the postfix string
}

// Main function
int main() {
    char infix[MAX], postfix[MAX];

    printf("Enter infix expression: ");
    scanf("%s", infix);

    infix_to_postfix(infix, postfix);

    printf("Postfix expression: %s\n", postfix);

    return 0;
}