#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main() {
    int rows = 3, cols = 4;

    //2차원 배열 동적할당
    int** arr = (int**)calloc(rows, sizeof(int*));
    for (int i = 0; i < rows; i++) {
        arr[i] = (int*)calloc(cols, sizeof(int));
    }

    //값입력과 출력
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            arr[i][j] = i * cols + j;
            printf("%d\t", arr[i][j]);
        }
        printf("\n");
    }
    //메모리 해제하기
    for (int i = 0; i < rows; i++) {
        free(arr[i]);
    }
    return 0;
}