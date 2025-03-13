#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define ROWS 3
#define COLS 3

void sum(int** arr) {
    int total = 0;
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            total += arr[i][j];
        }
    }
    printf("배열의 합은 %d\n", total);
}

void find_max(int** arr) {
    int max = arr[0][0];
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            if (arr[i][j] > max) {
                max = arr[i][j];
            }
        }
    }
    printf("배열의 최대값은 %d\n", max);
}
void find_min(int** arr) {
    int min = arr[0][0];
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            if (arr[i][j] < min) {
                min = arr[i][j];
            }
        }
    }
    printf("배열의 최소값은 %d\n", min);
}

// 배열 원소를 모두 제곱하는 함수
void square(int** arr) {
    printf("배열의 제곱값은\n");
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            printf("%d ", arr[i][j] * arr[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int arr[ROWS][COLS] = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8}
    };
    int* ptr[ROWS];
    for (int i = 0; i < ROWS; i++) {
        ptr[i] = arr[i];
    }
    void (*operations[])(int**) = { sum, find_max, find_min, square };
    int choice;
    while (1) {
        printf("연산 방법을 선택하기\n(0: 합, 1: 최대값, 2: 최소값, 3: 제곱, -1: 종료): ");
        scanf("%d", &choice);

        if (choice == -1) {
            printf("프로그램을 종료합니다.\n");
            break;
        }

        if (choice < 0 || choice > 3) {
            printf("잘못된 입력입니다. 다시 선택하세요.\n");
            continue;
        }

        // 함수 포인터를 사용하여 연산 실행
        operations[choice](ptr);
    }

    return 0;
}
