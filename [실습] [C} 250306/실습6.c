// 6-1

#include <stdio.h>

int main() {
	char gender;
	int age;
	float height;
	printf("성별은? 남자라면 M 여자라면 F >>");
	scanf("%c", &gender);
	getchar();
	printf("나이는?  >>");
	scanf("%d", &age);
	getchar();
	printf("키는? >>");
	scanf("%f", &height);
	getchar();
	printf("\n=============\n");
	printf("성별: %c\n", gender);
	printf("나이: %d\n", age);
	printf("키: %.1fcm\n", height);
	return 0;
}

// 6-2
int main() {
	char name[10]; // 배열은 같은 자료형을 연속 기억공간에 저장한 것
	// 배열명은 배열의 시작주소이다. 그래서, scnaf_s에서 주소 기호를 붙이지 않아도 된다.
	printf("이름은?");
	// 문자열 : 한 글자 이상의 문자열 "a\0" char name[10]
	/*gets(name);
	puts(name);*/
	scanf_s("%s", name, 10);
	printf("%s \n", name);
	getchar(); // 엔터키를 입력받아서 버퍼에서 제거
	char gender;
	printf("성별은 m, f >>");
	gender = getchar();
	putchar(gender);
	return 0;
}

// 6-3
int main() {
	int a, b;
	printf("숫자 두개를 입력하세요: ");
	scanf("%d %d", &a, &b);
	printf("합계: %d\n", a + b);

	int c, d, e;
	printf("숫자 세개를 입력하세요: ");
	scanf("%d %d %d", &c, &d, &e);
	printf("합계: %d\n", c + d + e);
	return 0;
}