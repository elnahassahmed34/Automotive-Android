#include "qtclass.h"
#include <QDebug>

qtclass::qtclass(QObject *parent)
    : QObject{parent}
{
}

void qtclass::answer(const QString &name) {
    qDebug() << "Answering call from" << name;
}
