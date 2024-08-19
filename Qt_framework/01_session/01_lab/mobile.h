#ifndef MOBILE_H
#define MOBILE_H

#include <QObject>
#include <QString>

class Mobile : public QObject
{
    Q_OBJECT

public:
    explicit Mobile(QObject *parent = nullptr);
    void call(const QString &name);  // Corrected to use a reference instead of a pointer

signals:
    void ring(const QString &name);  // Signal to emit the caller's name
};

#endif // MOBILE_H
