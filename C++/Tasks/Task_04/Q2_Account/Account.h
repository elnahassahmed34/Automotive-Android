#ifndef _ACCOUNT_H_
#define _ACCOUNT_H_

class Account
{
public:
    using acc = Account;

    static int getNoOfAccounts(); // Returns the number of accounts
    static int getTotalAmount(); // Returns the total amount of all accounts
    static int getNbDeposits(); // Returns the number of deposits
    static int getNoOfWithdrawals(); // Returns the number of withdrawals
    static void displayAccountsInfos(); // Displays account statistics

    Account(int initial_deposit);
    ~Account();

    void makeDeposit(int deposit);
    bool makeWithdrawal(int withdrawal);
    int checkAmount() const;
    void displayStatus() const;

private:
    static int m_noOfAccounts;
    static int m_totalAmount;
    static int m_totalNbDeposits;
    static int m_totalNbWithdrawals;

    static void m_displayTimestamp(); // Displays the current timestamp

    int m_accountIndex;
    int m_amount;
    int m_noOfDeposits;
    int m_noOfWithdrawals;

    Account();
};

#endif /* _ACCOUNT_H_ */
