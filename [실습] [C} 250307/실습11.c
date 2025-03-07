#include <stdio.h>
int cal(int n, int m);
int main() {
	int n;
	int m;
	printf("가감승제를 원하는 두 수를 입력하세요 : ");
	scanf("%d %d", &n, &m);
	cal(n, m);
	return 0;
}

int cal(int n, int m) {
	printf("%d + %d = %d\n", n, m, n + m);
	printf("%d - %d = %d\n", n, m, n - m);
	printf("%d * %d = %d\n", n, m, n * m);
	printf("%d / %d = %f", n, m, (double)n / m);
}


#define CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int mul(int n);

int main() {
	int n;
	printf("구구단 몇 단? ");
	scanf_s("%d", &n);
	mul(n);
	return 0;
}

int mul(int n) {
	for (int i = 1; i <= 9; i++) {
		printf("%d X %d = %d\n", n, i, n * i);
	}

}



#define CRT_SECURE_NO_WARNINGS
#include <stdio.h>
void change(char *str);

int main() {
	char str[100];
	printf("문자를 입력해주세요 ");
	scanf_s("%99[^\n]", str, (unsigned int)sizeof(str));
	change(str);
	printf("결과: %s", str);
	return 0;
}

void change(char *str) {
	while (*str) {
		if (*str >= 'a' && *str <= 'z') {
			*str = *str - ('a' - 'A');
		}
		else if (*str >= 'A' && *str <= 'Z') {
			*str = *str + ('a' - 'A');
		}
		str++;
	}
 }
