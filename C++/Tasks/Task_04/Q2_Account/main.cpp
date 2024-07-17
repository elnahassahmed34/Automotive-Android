#include <iostream>
#include "Account.h"

int main()
{
    Account a1(1000);
    Account a2(2000);

    a1.displayStatus();
    a2.displayStatus();

    a1.makeDeposit(500);
    a2.makeDeposit(1000);

    a1.displayStatus();
    a2.displayStatus();

    if (!a1.makeWithdrawal(2000))
    {
        std::cout << "Insufficient funds for withdrawal in account 1" << std::endl;
    }

    a1.displayStatus();
    a2.displayStatus();

    Account::displayAccountsInfos();

    return 0;
}
