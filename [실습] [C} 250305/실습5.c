#include <stdio.h>

int main() {
	int std_no, kor, world, math;
	double avg;

	std_no = 2013901;
	kor = 89;
	world = 100;
	math = 95;

	avg = (kor + world + math) / 3.0;

	printf("%-6s: %d \n", "학번", std_no);
	printf("=========================\n");
	printf("%-6s: %4d(점) \n", "국어", kor);
	printf("%-6s: %4d(점) \n", "세계사", world);
	printf("%-6s: %4d(점) \n", "수학", math);
	printf("=========================\n");
	printf("%-6s: %7.2lf(점) \n", "평균", avg);
	return 0;
}