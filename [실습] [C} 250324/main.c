#include <stdio.h>
#include "account.h"
int main() {
	Account myAccount;

	createAccount(&myAccount, 1001, 500.0);
	deposit(&myAccount, 200.0);
	withdraw(&myAccount, 100.0);

	printAccountInfo(&myAccount);
	return 0;
}