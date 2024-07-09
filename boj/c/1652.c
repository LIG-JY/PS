#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (100)

static void dispose(char** p, size_t n);

int main(void)
{
    size_t N;
    size_t i;
    size_t j;
    char buffer[LENGTH + 1];
    size_t len;
    char** room = NULL;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("input error!");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;

    if (sscanf(buffer, "%zd", &N) != 1) {
        perror("input error!");
        return 1;
    }

    room = malloc(sizeof(char*) * N);
    if (room == NULL) {
        dispose(room, 0);
        perror("input error!");
        return 1;
    }

    if (N == 1) {
        printf("%d %d", 0, 0);
        return 0;
    }

    for (i = 0; i < N; ++i) {
        if (fgets(buffer, (int)N + 2, stdin) == NULL) {
            dispose(room, N);
            perror("input error!");
            return 1;
        }
        if (buffer[N] == '\n') {
            buffer[N] = '\0';
        }
        {
            char* line = malloc(N + 1);
            if (line == NULL) {
                dispose(room, N);
                perror("input error!");
                return 1;
            }
            strcpy(line, buffer);
            room[i] = line;
        }
    }

    {
        int horizontal = 0;
        int vertical = 0;

        for (i = 0; i < N; ++i) {
            int size = 0;
            for (j = 0; j < N; ++j) {
                if (room[i][j] == '.') {
                    ++size;
                } else {
                    if (size >= 2) {
                        ++horizontal;
                    }
                    size = 0;
                }
            }
            if (size >= 2) {
                ++horizontal;
            }
        }

        for (j = 0; j < N; ++j) {
            int size = 0;
            for (i = 0; i < N; ++i) {
                if (room[i][j] == '.') {
                    ++size;
                } else {
                    if (size >= 2) {
                        ++vertical;
                    }
                    size = 0;
                }
            }
            if (size >= 2) {
                ++vertical;
            }
        }

        printf("%d %d", horizontal, vertical);
    }

    dispose(room, N);

    return 0;
}

static void dispose(char** p, size_t n)
{
    size_t i;

    for (i = 0; i < n; ++i) {
        free(p[i]);
        p[i] = NULL;
    }
    free(p);
}
