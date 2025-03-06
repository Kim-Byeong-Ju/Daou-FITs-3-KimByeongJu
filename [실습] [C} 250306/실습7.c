#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>


int main() {
    int age;
    char gender;
    double height;

    printf("성별은? (남자라면 M 여자라면 F) ");
	scanf("%c", &gender);
	printf("나이는? ");
	scanf("%d", &age);
	printf("키는? ");
	scanf("%lf", &height);
	printf("\n==================\n");
	printf("성별: %c\n", gender);
	printf("나이: %d\n", age);
	printf("성별: %.1lfcm\n", height);
	return 0;
}
