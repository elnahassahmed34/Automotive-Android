#ifndef PARENT_H
#define PARENT_H

#include <QObject>

class Parent : public QObject
{
    Q_OBJECT

public:
    explicit Parent(QObject *parent = nullptr);  // Constructor with a default parent parameter

signals:

};

#endif // PARENT_H
