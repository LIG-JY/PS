#include<bits/stdc++.h>

using namespace std;
// linked list
const int MX = 1000000;
int prv[MX];
int nxt[MX];
char value[MX];
int unused = 1;
const int DUMMY = 0;

int main() {
    // array initialization
    fill(prv, prv + MX, -1);
    fill(nxt, nxt + MX, -1);
    // input string
    char s[MX];
    scanf("%s", s);
    int length = (int) strlen(s);
    // make linked list and head dummy node addr: 0
    int cursor = DUMMY;
    for (int i = 0; i < length; ++i)
    {
        // make new node
        value[unused] = s[i];
        prv[unused] = cursor;
        nxt[unused] = -1;
        nxt[cursor] = unused;
        cursor = nxt[cursor];
        unused++;
    }
    int m;
    scanf("%d", &m);
    while (m--)
    {
        char cmd;
        scanf(" %c", &cmd);
        switch (cmd)
        {
            case 'L':
                if (prv[cursor] != -1)
                {
                    cursor = prv[cursor];
                }
                break;
            case 'D':
                if (nxt[cursor] != -1)
                {
                    cursor = nxt[cursor];
                }
                break;
            case 'B':
                // Exclude delete dummy node
                if (prv[cursor] != -1)
                {
                    nxt[prv[cursor]] = nxt[cursor];
                    // Exclude delete last node
                    if (nxt[cursor] != -1)
                    {
                        prv[nxt[cursor]] = prv[cursor];
                    }
                    cursor = prv[cursor];
                }
                break;
            case 'P':
                char dat;
                scanf(" %c", &dat);
                value[unused] = dat;
                prv[unused] = cursor;
                nxt[unused] = nxt[cursor];
                if (nxt[cursor] != -1)
                {
                    prv[nxt[cursor]] = unused;
                }
                nxt[cursor] = unused;
                cursor = unused;
                unused++;
                break;
        }
    }

    int current = DUMMY;
    while (nxt[current] != -1)
    {
        current = nxt[current];
        printf("%c", value[current]);
    }
    return 0;
}