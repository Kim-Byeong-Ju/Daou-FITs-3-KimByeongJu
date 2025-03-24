#pragma once
#ifndef ACCOUNT_H
#define ACCOUNT_H
typedef struct {
	int account_number;
	double balance;
}Account;
void createAccount(Account* acc, int number, double initial_balance);
void deposit(Account* acc, double amount);
void withdraw(Account* acc, double amount);
void printAccountInfo(const Account* acc);
#endif