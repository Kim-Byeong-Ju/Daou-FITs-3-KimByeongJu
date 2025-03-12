#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main()
{
	int sum = 10, score[] = { 99,80,91,78,85 };
	int* psum, * pscore1, * pscore2;
	psum = &sum;
	pscore1 = score;
	pscore2 = score;
	++pscore2;
	pscore2++;
	printf("변수 sum의 값 : %d \n", sum); // 10
	printf("포인터 변수 *psum의 값 : %d \n", *psum); // 10
	printf("포인터 변수 *psum+1의 값 : %d \n", *psum+1); // 11
	printf("포인터 변수 ++*psum의 값 : %d \n", ++*psum); // 11
	printf("포인터 변수 *(psum+1)의 값 : %d \n", *(psum+1)); // 알 수 없는 수
	printf("포인터 변수 *++psum의 값 : %d \n", *++psum); // 알 수 없는 수
	printf("=========================================================\n");
	printf("포인터 변수 *pscore1의 값 : %d \n", *pscore1); // 99
	printf("포인터 변수 *pscore1+1의 값 : %d \n", *pscore1+1); // 100
	printf("포인터 변수 *(pscore1+1)의 값 : %d \n", *(pscore1+1)); // 80
	printf("포인터 변수 *pscore2-*pscore1의 값 : %d \n", *pscore2-*pscore1); // 91-99 = -8
	printf("포인터 변수 pscore2-pscore1의 값 : %d \n", pscore2-pscore1); // 2
	printf("포인터 변수 pscore2의 값 : %d \n", pscore2); // 주소값
	printf("포인터 변수 pscore1의 값 : %d \n", pscore1); // 주소값
	return 0;
}