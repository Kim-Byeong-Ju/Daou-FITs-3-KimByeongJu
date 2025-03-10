#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int compute_total_salary();
int compute_tax(int amount);
// 세금 내역서 출력
void display_tax_returns(int tot_salary, int tax_target, int tax);
int salary;
int main(){
	int exemption = 10000000;
	int total_salary, tax_target, tax;
	printf("월 급여는? ");
	scanf("%d", &salary);
	total_salary = compute_total_salary();
	tax_target = total_salary - exemption;
	tax = compute_tax(tax_target);
	display_tax_returns(total_salary, tax_target, tax);
	return 0;
}
int compute_total_salary() {
	int bonus_rate = 300;
	return (salary * 12) + (int)(salary * bonus_rate * 0.01);
}

int compute_tax(int amount) {
	int tax_rate;
	if (salary >= 5000000) {
		tax_rate = 5;
	}
	else if (salary >= 2500000) {
		tax_rate = 3;
	}
	else {
		tax_rate = 2;
	}
	return (int)(amount * tax_rate * 0.01);
}

void display_tax_returns(int total_salary, int tax_target, int tax) {
	printf("\n >>> 세금 내역서 <<< \n");
	printf("-------------------------- \n");
	printf("연 급여          :%8d원 \n", total_salary);
	printf("세금 부과 대상액 :%8d원 \n", tax_target);
	printf("최종 세금 부과액 :%8d원 \n", tax);

}