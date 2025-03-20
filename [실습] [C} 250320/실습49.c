#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
int main() {
    FILE* f = fopen("D:\\TestFile.txt", "wb+");
    if (f) {
        fputc('A', f);

        fseek(f, 0, SEEK_SET);
        int c = fgetc(f);
        printf("read: %c", c);

        fclose(f);
    }
    else {
        printf("Error: %d, %s", errno, strerror(errno));
    }
    return 0;
}
