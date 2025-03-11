#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include<windows.h>

int main()
{
	double d = 100.0;
	double* dpoint = &d;
	printf("변수 d의 값: %f\n", d);
	printf("변수 d의 주소 값: %p\n", &d);
	printf("dpoint의 주소 값: %p\n", dpoint);
	printf("dpoint가 가리키는 값: %f\n", *dpoint);
	printf("변수 d의 크기: %d\n", sizeof(d));
	printf("변수 d의 주소의 크기: %d\n", sizeof(&d));
	printf("dpoint의 크기: %d\n", sizeof(dpoint));
	printf("dpoint의 주소의 크기: %d\n", sizeof(*dpoint));
	return 0;
}