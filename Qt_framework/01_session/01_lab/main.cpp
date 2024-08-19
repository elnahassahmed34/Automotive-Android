#include <QCoreApplication>
#include <iostream>
#include <QDebug>
#include <QString>
#include "qtclass.h"
#include "mobile.h"

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);
    qtclass qt;
    Mobile mob;

    QObject::connect(&mob, &Mobile::ring, &qt, &qtclass::answer );

    QString caller = "John Doe";
    mob.call(caller);  // Emit the signal

    return a.exec();
}
