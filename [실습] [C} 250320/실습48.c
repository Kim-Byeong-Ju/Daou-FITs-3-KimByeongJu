#define CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <errno.h>
#include <string.h>

int main(void) {

    FILE* f = fopen("D:\\TestFile.txt", "wb");

    char str[] = "C 프로그래밍";

    if (f) {
        fwrite(str, 1, sizeof(str) - 1, f);
        fclose(f);
    } else {
        printf("Error: %d, %s", errno, strerror(errno));
    }
}