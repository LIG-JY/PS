#include <stdio.h>
#include <string.h>

#define LENGTH (100) /* 단어의 길이는 최대 100 */
#define TRUE (1)
#define FALSE (0)

static size_t res = 0;

int main(void)
{
    size_t N;
    size_t i;
    char buffer[LENGTH + 1];
    char alphabet_is_exist[26] = {FALSE,};
    int is_group_word;

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
        perror("File read failure");
        return 1;
    }

    if (sscanf(buffer, "%zd", &N) != 1) {
        fprintf(stderr, "Error: Failed to parse number from buffer\n");
        return 1;
    };

    for (i = 0; i < N; ++i) {
        const char* ptr;

        if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
            perror("File read failure");
            return 1;
        }

        is_group_word = TRUE;
        ptr = buffer;
        /* 알파벳 존재 여부 배열 초기화 */
        memset(alphabet_is_exist, FALSE, 26);

        while (*ptr != '\0' && *ptr != '\n') {
            const char ch = *ptr;
            if (alphabet_is_exist[ch - 'a'] == FALSE) { /* 처음 등장한 경우 */
                alphabet_is_exist[ch - 'a'] = TRUE;
            } else { /* 중복으로 등장한 경우 */
                if (*(ptr - 1) != ch) {  /* 중복으로 등장했는데, 연속으로 문자가 등장하지 않은 경우 */
                    is_group_word = FALSE;
                    break;
                }
            }
            ++ptr;
        }

        if (is_group_word == TRUE) {
            ++res;
        }
    }
    printf("%zd", res);

    return 0;
}
