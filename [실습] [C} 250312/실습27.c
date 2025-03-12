#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <math.h>
int max(int, int);
int min(int, int);
int main(){
	int (*fpm)(int, int);
	int num1, num2, flag;
	printf("두 개의 숫자를 입력 >>");
	scanf_s("%d %d", &num1, &num2);
	printf("구하려는 것은(1. 최대값, 2. 최소값)");
	scanf_s("%d", &flag);
	if (flag == 1) {
		fpm = max;		
	}
	else {
		fpm = min;
	}
	printf(" %d\n", fpm(num1, num2));
	return 0;
}

int max(int a, int b) { return (a > b) ? a : b; };
int min(int a, int b) { return (a > b) ? b : a; };