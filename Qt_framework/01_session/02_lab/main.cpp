#include <QCoreApplication>
#include "child.h"
#include "parent.h"
#include <QObject>
#include <QDebug>

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    Parent* p = new Parent();
    Child* c = new Child(p); // Pass the parent object when creating the child

    delete p; // This will automatically delete the child as well

    return a.exec();
}
