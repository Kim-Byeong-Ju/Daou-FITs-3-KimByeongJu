#include <stdio.h>
#include <malloc.h>
int* GetStack() {
    static int a = 1;
    return &a;
}

int* GetHeap() {
    int* p = malloc(sizeof(int));
    *p = 2;
    return p;
}
int main(void) {

    int* p1 = GetStack();
    int* p2 = GetHeap();
    printf("%d, %d", *p1, *p2);
    free(p2);

}