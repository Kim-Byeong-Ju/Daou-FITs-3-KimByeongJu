#include <stdio.h>
#include "account.h"
#include <stdio.h>
#include "account.h"
void createAccount(Account* acc, int number, double initial_balance) {
	acc->account_number = number;
	acc->balance = initial_balance;
}
void deposit(Account* acc, double amount) {
	if (amount > 0) {
		acc->balance += amount;
	}
}
void withdraw(Account* acc, double amount) {
	if (amount > 0 && acc->balance >= amount) {
		acc->balance -= amount;
	}
}
void printAccountInfo(const Account* acc) {
	printf("���¹�ȣ: %d, �ݾ�: %.2f\n", acc->account_number, acc->balance);
}
