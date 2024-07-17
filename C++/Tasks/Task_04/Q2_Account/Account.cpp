#include <iostream>
#include <ctime>
#include "Account.h"

using namespace std;

int Account::m_noOfAccounts = 0;
int Account::m_totalAmount = 0;
int Account::m_totalNbDeposits = 0;
int Account::m_totalNbWithdrawals = 0;

Account::Account(int initial_deposit)
    : m_accountIndex(m_noOfAccounts), m_amount(initial_deposit), m_noOfDeposits(0), m_noOfWithdrawals(0)
{
    m_noOfAccounts++;
    m_totalAmount += initial_deposit;
}

Account::~Account()
{
    m_noOfAccounts--;
    m_totalAmount -= m_amount;
}

int Account::getNoOfAccounts()
{
    return m_noOfAccounts;
}

int Account::getTotalAmount()
{
    return m_totalAmount;
}

int Account::getNbDeposits()
{
    return m_totalNbDeposits;
}

int Account::getNoOfWithdrawals()
{
    return m_totalNbWithdrawals;
}

void Account::displayAccountsInfos()
{
    m_displayTimestamp();
    cout << "accounts: " << getNoOfAccounts() << "; total: " << getTotalAmount()
         << "; deposits: " << getNbDeposits() << "; withdrawals: " << getNoOfWithdrawals() << endl;
}

void Account::makeDeposit(int deposit)
{
    m_amount += deposit;
    m_totalAmount += deposit;
    m_noOfDeposits++;
    m_totalNbDeposits++;
}

bool Account::makeWithdrawal(int withdrawal)
{
    if (withdrawal > m_amount)
    {
        return false;
    }
    m_amount -= withdrawal;
    m_totalAmount -= withdrawal;
    m_noOfWithdrawals++;
    m_totalNbWithdrawals++;
    return true;
}

int Account::checkAmount() const
{
    return m_amount;
}

void Account::displayStatus() const
{
    m_displayTimestamp();
    cout << "index: " << m_accountIndex << "; amount: " << m_amount
         << "; deposits: " << m_noOfDeposits << "; withdrawals: " << m_noOfWithdrawals << endl;
}

void Account::m_displayTimestamp()
{
    time_t now = time(0);
    tm *ltm = localtime(&now);
    cout << "[" << 1900 + ltm->tm_year
         << (ltm->tm_mon + 1 < 10 ? "0" : "") << 1 + ltm->tm_mon
         << (ltm->tm_mday < 10 ? "0" : "") << ltm->tm_mday
         << "_" << (ltm->tm_hour < 10 ? "0" : "") << ltm->tm_hour
         << (ltm->tm_min < 10 ? "0" : "") << ltm->tm_min
         << (ltm->tm_sec < 10 ? "0" : "") << ltm->tm_sec << "] ";
}
