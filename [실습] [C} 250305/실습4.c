#include <stdio.h>

int main() {
	printf("%c\n", 'a');
	printf("%c\n", 97);
	printf("%c\n", '\141');
	printf("%c\n", '\x61');

	printf("삐음 : %c\n", '\a');
	printf("단일 인용부호 : %c\n", '\'');
	printf("abcdef\b\b\b\b");
	printf("%s\n", "ghijk");
	
	char a = 'c';
	int b = 10;
	float c = 1.5f;
	printf("문자열: %c\n", a);
	printf("정수형: %d\n", b);
	printf("실수형: %.2lf\n", c);
	return 0;
}