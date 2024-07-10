#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void)
{
    /* 원형 큐 풀이 */
    int N;
    int K;
    char buffer[10];
    int* q = NULL;
    int q_size;
    int q_count;
    size_t q_front;
    size_t q_back;
    int step;

    fgets(buffer, 11, stdin);
    sscanf(buffer, "%d%d", &N, &K);
    q = malloc(sizeof(int) * N);
    if (q == NULL) {
        return 1;
    }
    /* q에 1~N 넣기 */
    q_size = N; /* 큐의 용량 */
    q_count = 0; /* 큐에 있는 원소의 개수 */
    q_front = 0;
    q_back = 0;
    for (step = 1; step <= N; ++step) {
        q[q_count++] = step;
        q_back = (q_back + 1) % q_size;
    }
    /* q가 빌 때 까지 반복 */
    printf("%c", '<');
    step = 1;
    while (q_count > 0) {
        if (step == K) {
            if (q_count > 1) {
                printf("%d, ", q[q_front]);
            } else {
                printf("%d", q[q_front]);
            }
            q_front = (q_front + 1) % q_size;
            --q_count;
            step = 1;
        } else {
            q[q_back] = q[q_front];
            q_back = (q_back + 1) % q_size;
            q_front = (q_front + 1) % q_size;
            ++step;
        }
    }
    printf("%c", '>');
    free(q);

    return 0;
}
