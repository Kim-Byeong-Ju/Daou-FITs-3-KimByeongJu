#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <time.h>
int main()
{
	int score = 100;
	int* pscore, ** ppscore, *** pppscore;
	pscore = &score;
	ppscore = &pscore;
	pppscore = &ppscore;
	printf("포인터 변수 *pscore의 값은 %d\n", *pscore);
	printf("포인터 변수 **ppscore의 값은 %d\n", **ppscore);
	printf("포인터 변수 ***pppscore의 값은 %d\n", ***pppscore);
	printf("==================================================\n");
	printf("int 변수 score의 주소는 %p\n", &score);
	printf("포인터 변수 pscore의 값(주소)은 %p\n", pscore);
	printf("==================================================\n");
	printf("포인터 변수 pscore의 주소는 %p\n", &pscore);
	printf("포인터 변수 ppscore의 값(주소)은 %p\n", ppscore);
	printf("==================================================\n");
	printf("포인터 변수 ppscore의 주소는 %p\n", &ppscore);
	printf("포인터 변수 pppscore의 값은 %p\n", pppscore);
	return 0;
}