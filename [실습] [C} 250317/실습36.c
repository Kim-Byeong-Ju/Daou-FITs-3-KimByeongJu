#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	union year {
		int year;
		int grade;
	};
	typedef struct student {
		char name[20];
		char sex;
		int stid;
		union year y;
	} ST;
	ST st1 = { "kdhong", 'm', 1508001 };
	st1.y.grade = 4;
	printf("%s 학생은 %d학년입니다\n", st1.name, st1.y);
	printf("%s 학생은 %d학년입니다\n", st1.name, st1.y.grade);
	printf("%s 학생은 %d학년입니다\n", st1.name, st1.y.year);
	st1.y.year = 1;
	printf("%s 학생은 %d학년입니다\n", st1.name, st1.y);
	printf("%s 학생은 %d학년입니다\n", st1.name, st1.y.grade);
	printf("%s 학생은 %d학년입니다\n", st1.name, st1.y.year);

}