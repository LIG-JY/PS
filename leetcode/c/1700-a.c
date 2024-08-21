#include <stdio.h>
#include <stdlib.h>

/*
 * 1700. Number of Students Unable to Eat Lunch
 * */

int countStudents(int* students, int studentsSize, int* sandwiches, int sandwichesSize)
{
    int top = 0;
    int front = 0;
    int rear = 0;
    int queue_size = studentsSize;
    int res = 0;
    int max_revolution_count = 0;

    int* ring_queue = malloc(sizeof(int) * studentsSize);
    for (int i = 0; i < studentsSize; ++i) {
        ring_queue[i] = students[i];
    }

    while (queue_size > 0 && top < sandwichesSize) {

        if (sandwiches[top] == ring_queue[front]) {
            ++top;  // pop
            front = (front + 1) % studentsSize; // dequeue
            --queue_size;
            ++res;
            max_revolution_count = 0;
        } else {
            if (max_revolution_count == queue_size) {
                break;
            }
            int student = ring_queue[front];
            front = (front + 1) % studentsSize; // dequeue
            ring_queue[rear] = student;
            rear = (rear + 1) % studentsSize;
            ++max_revolution_count;
        }
    }

    free(ring_queue);

    return studentsSize - res;
}

int main(void)
{
    int students[6] = { 1,1,0,0 };
    int sandwiches[6] = { 0,1,0,1 };
    int res = countStudents(students, 6, sandwiches, 6);
    printf("%d", res);

    return 0;
}
