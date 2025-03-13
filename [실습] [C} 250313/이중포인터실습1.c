#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define MAX_SIZE 5

int main() {
    int row, col;
    int arr[MAX_SIZE][MAX_SIZE]; // 최대 크기의 2차원 배열
    int* ptr[MAX_SIZE]; // 각 행을 가리키는 포인터 배열

    // 행과 열의 크기 입력받기 (최대 5x5)
    printf("행과 열의 수를 입력하세요? ");
    scanf("%d %d", &row, &col);

    if (row > MAX_SIZE || col > MAX_SIZE || row <= 0 || col <= 0) {
        printf("잘못된 입력입니다. 행과 열은 최대 %d x %d 입니다.\n", MAX_SIZE, MAX_SIZE);
        return 1;
    }

    // 배열 값 자동 입력 (각 행에 i * 10 + j 저장)
    printf("배열의 초기값은 자동으로 입력됩니다.\n");
    for (int i = 0; i < row; i++) {
		     // 포인터 배열 초기화 (각 행의 시작 주소 저장)
		    ptr[i] = arr[i];
        for (int j = 0; j < col; j++) {
            ptr[i][j] = i * 10 + j;
            printf("%d ", ptr[i][j]);
        }
        printf("\n");
    }

    // 삭제할 행 입력받기
    int deleteRow;
    printf("삭제하려는 행의 인덱스 번호를 입력하세요? ");
    scanf("%d", &deleteRow);

    if (deleteRow < 0 || deleteRow >= row) {
        printf("잘못된 행 번호입니다.\n");
        return 1;
    }

    // 행 삭제 (deleteRow 이후의 행들을 한 칸씩 위로 이동)
    for (int i = deleteRow; i < row - 1; i++) {
        ptr[i] = ptr[i + 1]; // 포인터 배열의 참조 변경
    }
    row--; // 실제 행 개수를 하나 줄임

    // 수정된 배열 출력
    printf("수정된 배열 출력\n");
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            printf("%d ", ptr[i][j]);
        }
        printf("\n");
    }

    return 0;
}
