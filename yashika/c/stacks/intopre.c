#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define MAX 50

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

int is_operator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
}

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

void reverse(char *str) {
    int start = 0;
    int end = strlen(str) - 1;
    while (start < end) {
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        start++;
        end--;
    }
}

void infix_to_postfix(char *infix, char *postfix) {
    Stack stack;
    init(&stack);
    int i = 0, j = 0;

    while (infix[i] != '\0') {
        char ch = infix[i];

        if (isalnum(ch)) {
            postfix[j++] = ch;
        } else if (ch == '(') {
            push(&stack, ch);
        } else if (ch == ')') {
            while (!is_empty(&stack) && peek(&stack) != '(') {
                postfix[j++] = pop(&stack);
            }
            if (!is_empty(&stack) && peek(&stack) == '(') {
                pop(&stack);
            }
        } else if (is_operator(ch)) {
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

    while (!is_empty(&stack)) {
        postfix[j++] = pop(&stack);
    }
    postfix[j] = '\0';
}

void infix_to_prefix(char *infix, char *prefix) {
    reverse(infix);

    for (int i = 0; infix[i] != '\0'; i++) {
        if (infix[i] == '(') {
            infix[i] = ')';
        } else if (infix[i] == ')') {
            infix[i] = '(';
        }
    }

    char postfix[MAX];
    infix_to_postfix(infix, postfix);

    reverse(postfix);
    strcpy(prefix, postfix);
}

int main() {
    char infix[MAX], prefix[MAX];

    printf("Enter infix expression: ");
    scanf("%s", infix);

    infix_to_prefix(infix, prefix);

    printf("Prefix expression: %s\n", prefix);

    return 0;
}
