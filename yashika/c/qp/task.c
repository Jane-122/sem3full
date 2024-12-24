#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TASKS 100

typedef struct {
    int priority;
    char description[100];
} Task;

Task queue[MAX_TASKS];
int taskCount = 0;

void enqueueTaskWithPriority(int priority, const char *description) {
    if (taskCount >= MAX_TASKS) {
        printf("Queue is full! Cannot add more tasks.\n");
        return;
    }

    queue[taskCount].priority = priority;
    strcpy(queue[taskCount].description, description);
    taskCount++;

    for (int i = 0; i < taskCount - 1; i++) {
        for (int j = i + 1; j < taskCount; j++) {
            if (queue[i].priority < queue[j].priority) {
                Task temp = queue[i];
                queue[i] = queue[j];
                queue[j] = temp;
            }
        }
    }
}

void executeHighestPriorityTask() {
    if (taskCount == 0) {
        printf("No tasks to execute.\n");
        return;
    }

    printf("Executing task with priority %d: %s\n", queue[0].priority, queue[0].description);

    for (int i = 1; i < taskCount; i++) {
        queue[i - 1] = queue[i];
    }

    taskCount--;
}

void displayQueue() {
    if (taskCount == 0) {
        printf("No tasks in the queue.\n");
        return;
    }

    printf("Current task queue:\n");
    for (int i = 0; i < taskCount; i++) {
        printf("Task %d - Priority: %d, Description: %s\n", i + 1, queue[i].priority, queue[i].description);
    }
}

int main() {
    enqueueTaskWithPriority(5, "Task 1: Low priority task");
    enqueueTaskWithPriority(10, "Task 2: High priority task");
    enqueueTaskWithPriority(7, "Task 3: Medium priority task");

    displayQueue();

    executeHighestPriorityTask();
    executeHighestPriorityTask();
    executeHighestPriorityTask();

    executeHighestPriorityTask();

    return 0;
}
