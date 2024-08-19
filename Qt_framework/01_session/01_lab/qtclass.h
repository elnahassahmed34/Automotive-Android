#ifndef QTCLASS_H
#define QTCLASS_H

#include <QObject>
#include <QString>

class qtclass : public QObject
{
    Q_OBJECT

public:
    explicit qtclass(QObject *parent = nullptr);

public slots:
    void answer(const QString &name);  // Slot to handle the signal
};

#endif // QTCLASS_H
