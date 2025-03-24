#include<stdio.h>

#define ONE

#ifdef !ONE
    int a = 1;
#else
    int a = 2;
#endif

int main() {
    printf("a: %d", a);
}