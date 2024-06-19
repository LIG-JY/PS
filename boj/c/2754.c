#include <stdio.h>
#include <string.h>
#include <assert.h>

#define LENGTH (2)

int main(void)
{
    char line[LENGTH + 1];

    if (fgets(line, LENGTH + 1, stdin) == NULL) {
        return 1;
    }

    {
        double score;
        char grade_letter = line[0];
        char grade_modifier = line[LENGTH - 1];
        assert(line[LENGTH] == '\0');

        switch (grade_letter) {
        case 'A':
            score = 4.0;
            break;

        case 'B':
            score = 3.0;
            break;

        case 'C':
            score = 2.0;
            break;

        case 'D':
            score = 1.0;
            break;
        case 'F':
            score = 0.0;
            goto print;
            break;

        default:
            assert(0);
            break;
        }

        switch (grade_modifier) {
        case '+':
            score += 0.3;
            break;

        case '0':
            break;

        case '-':
            score -= 0.3;
            break;

        default:
            assert(0);
            break;
        }
    print:
        printf("%.1f", score);
    }

    return 0;
}
