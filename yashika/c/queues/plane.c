#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_QUEUE_SIZE 5
#define SIMULATION_TIME 100  // Total simulation time (units)
#define LANDING_PRIORITY 1  // Landing has higher priority
#define TAKEOFF_PRIORITY 2  // Takeoff has lower priority

// Structure to store plane information
typedef struct {
    int id;
    int wait_time;  // Time the plane has been waiting
    int type;       // 1 = Landing, 2 = Takeoff
} Plane;

// Define Queue using typedef
typedef struct {
    Plane queue[MAX_QUEUE_SIZE];
    int front;
    int rear;
} Queue;

// Function prototypes
void initQueue(Queue* q);
int isQueueEmpty(Queue* q);
int isQueueFull(Queue* q);
void enqueue(Queue* q, Plane plane);
Plane dequeue(Queue* q);
void processRunway(int timeUnit, Queue* landingQueue, Queue* takeoffQueue);
void printStatistics();

// Statistics variables
int landedCount = 0, tookOffCount = 0, refusedCount = 0;
int totalLandingWaitTime = 0, totalTakeoffWaitTime = 0;
int totalIdleTime = 0;

// Initialize the queue
void initQueue(Queue* q) {
    q->front = q->rear = 0;
}

// Check if the queue is empty
int isQueueEmpty(Queue* q) {
    return q->front == q->rear;
}

// Check if the queue is full
int isQueueFull(Queue* q) {
    return (q->rear + 1) % MAX_QUEUE_SIZE == q->front;
}

// Enqueue a plane into the queue
void enqueue(Queue* q, Plane plane) {
    if (isQueueFull(q)) {
        refusedCount++;
    } else {
        q->queue[q->rear] = plane;
        q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
    }
}

// Dequeue a plane from the queue
Plane dequeue(Queue* q) {
    Plane plane = q->queue[q->front];
    q->front = (q->front + 1) % MAX_QUEUE_SIZE;
    return plane;
}

// Process the runway for one unit of time
void processRunway(int timeUnit, Queue* landingQueue, Queue* takeoffQueue) {
    // Check if there is a plane to land
    if (!isQueueEmpty(landingQueue)) {
        Plane plane = dequeue(landingQueue);
        totalLandingWaitTime += plane.wait_time;
        plane.wait_time = 0;  // Reset wait time after landing
        landedCount++;
        printf("Time %d: Plane %d landed.\n", timeUnit, plane.id);
    }
    // If no plane is landing, check if a plane can take off
    else if (!isQueueEmpty(takeoffQueue)) {
        Plane plane = dequeue(takeoffQueue);
        totalTakeoffWaitTime += plane.wait_time;
        plane.wait_time = 0;  // Reset wait time after takeoff
        tookOffCount++;
        printf("Time %d: Plane %d took off.\n", timeUnit, plane.id);
    }
    // If no planes are landing or taking off, the runway is idle
    else {
        totalIdleTime++;
    }

    // Simulate the arrival of planes at random times (for demonstration purposes)
    if (rand() % 2 == 0 && !isQueueFull(landingQueue)) {
        Plane plane = {rand() % 1000, 0, 1};  // Landing plane
        enqueue(landingQueue, plane);
    }

    if (rand() % 2 == 0 && !isQueueFull(takeoffQueue)) {
        Plane plane = {rand() % 1000, 0, 2};  // Takeoff plane
        enqueue(takeoffQueue, plane);
    }

    // Increment waiting times of planes in the queues
    for (int i = landingQueue->front; i != landingQueue->rear; i = (i + 1) % MAX_QUEUE_SIZE) {
        landingQueue->queue[i].wait_time++;
    }
    for (int i = takeoffQueue->front; i != takeoffQueue->rear; i = (i + 1) % MAX_QUEUE_SIZE) {
        takeoffQueue->queue[i].wait_time++;
    }
}

// Print statistics after simulation ends
void printStatistics() {
    printf("\nSimulation Results:\n");
    printf("Planes Landed: %d\n", landedCount);
    printf("Planes Took Off: %d\n", tookOffCount);
    printf("Planes Refused: %d\n", refusedCount);
    printf("Total Idle Time: %d\n", totalIdleTime);
    printf("Average Landing Wait Time: %.2f\n", (landedCount > 0) ? (float)totalLandingWaitTime / landedCount : 0);
    printf("Average Takeoff Wait Time: %.2f\n", (tookOffCount > 0) ? (float)totalTakeoffWaitTime / tookOffCount : 0);
    printf("Average Runway Idle Time: %.2f\n", (float)totalIdleTime / SIMULATION_TIME);
}

// Main program
int main() {
    srand(time(0));  // Seed for random number generation

    Queue landingQueue, takeoffQueue;
    initQueue(&landingQueue);
    initQueue(&takeoffQueue);

    // Simulation loop for each unit of time
    for (int timeUnit = 1; timeUnit <= SIMULATION_TIME; timeUnit++) {
        processRunway(timeUnit, &landingQueue, &takeoffQueue);
    }

    // After simulation, print statistics
    printStatistics();
    return 0;
}
