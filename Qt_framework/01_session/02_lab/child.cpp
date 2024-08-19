#include "child.h"
#include <QDebug>

Child::Child(QObject *parent)
    : QObject{parent}
{

}

Child::~Child()
{
    qDebug() << "Destructor of Child";
}
