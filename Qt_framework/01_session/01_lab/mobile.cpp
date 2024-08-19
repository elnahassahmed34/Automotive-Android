#include "mobile.h"
#include <QDebug>

Mobile::Mobile(QObject *parent)
    : QObject{parent}
{
}

void Mobile::call(const QString &name) {
    qDebug() << "Calling" << name;
    emit ring(name);  // Emit the signal with the correct argument
}
