#include <stdio.h>
#include <string.h>

#define LENGTH (50 + 1) /* 괄호문자 최대 50개, 개행문자 1개 */
#define EMPTY (-1)
#define TRUE (1)
#define FALSE (0)

int main(void)
{
    size_t i;
    size_t n;
    char buffer[LENGTH + 1]; /* 널문자 자리까지 1자리 추가 */

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) {  /* fgets는 count - 1만큼 읽어오기 때문에, 널문자를 제외하고 LENGTH개 읽어옴 */
        return 1;
    }

    if (sscanf(buffer, "%zd", &n) != 1) {
        return 1;
    }

    for (i = 0; i < n; ++i) {
        if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
            return 1; /* 마지막 줄은 '\n' 없이 바로 '\0'으로 끝남, fgets가 널문자를 넣어주기 때문 */
        }

        {
            const char* p = buffer;
            int top = EMPTY;
            int valid = TRUE;

            /* 괄호 문자를 순회하며 검사 */
            while (*p != '\n' && *p != '\0') {
                if (*p == '(') {
                    ++top;
                } else {
                    if (top == EMPTY) {
                        valid = FALSE;
                        break;
                    } else {
                        --top;
                    }
                }
                ++p;
            }
            if (top == EMPTY && valid == TRUE) {
                printf("%s\n", "YES");
            } else {
                printf("%s\n", "NO");
            }
        }
    }

    return 0;

}
