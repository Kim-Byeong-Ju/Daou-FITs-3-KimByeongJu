#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX 100
#define MIN 0
int main() {
	typedef enum week{SUN, MON, TUE, WED, THU, FRI, SAT} WEEK;
	typedef enum family_name {KIM=100, LEE, PARK, JUNG, HONG} F_name;
	F_name fn = JUNG;
	printf("MAX=%d, MIN=%d\n", MAX, MIN);
	printf("SUN=%d\n", SUN);
	printf("MON=%d\n", MON);
	printf("TUE=%d\n", TUE);
	printf("WED=%d\n", WED);
	printf("THU=%d\n", THU);
	printf("FRI=%d\n", FRI);
	printf("SAT=%d\n", SAT);
	printf("JUNG은 %d번째 입니다\n", fn);

}