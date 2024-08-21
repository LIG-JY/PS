#include <stdio.h>

/*
 * 1700. Number of Students Unable to Eat Lunch
 * */

int countStudents(int* students, int studentsSize, int* sandwiches, int sandwichesSize)
{
    int count[2] = { 0, };  // count of each type of student

    for (int i = 0; i < studentsSize; ++i) {
        ++count[students[i]];
    }

    for (int i = 0; i < sandwichesSize; ++i) {  // iterate stack
        if (count[sandwiches[i]] == 0) {
            return sandwichesSize - i;
        }
        --count[sandwiches[i]];
    }

    return 0;
}

int main(void)
{
    int students[6] = { 1, 1, 0, 0 };
    int sandwiches[6] = { 0, 1, 0, 1 };
    int res = countStudents(students, 6, sandwiches, 6);
    printf("%d", res);

    return 0;
}
