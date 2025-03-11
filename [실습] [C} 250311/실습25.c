#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <time.h>
int main()
{
	int score[6] = { 99,89,98,88,85 };
	int* pscore, i, sum = 0;
	pscore = score;
	if (pscore + 2 == score + 2 && pscore + 2 == &score[2])
		printf("두 번째 요소의 주소가 모두 같다\n");
	if (*(pscore + 2) == *(score + 2) && *(pscore + 2) == score[2])
		printf("두 번째 요소의 값도 모두 같다\n");
	printf("포인터 변수 pscore의 값(배열 주소) : %p\n", pscore);
	printf("배열 이름 score의 값(배열 주소) : %p\n", score);
	printf("포인터 변수 pscore의 값(배열 주소)의 주소 : %p\n", &pscore);
	printf("배열 이름 score의 값(배열 주소) : %p\n", &score);
	for (i = 0; i < 5; i++) {
		sum += *pscore++;
	}
	printf("포인터 변수를 이용한 합계는 %d\n", sum);
	return 0;
}