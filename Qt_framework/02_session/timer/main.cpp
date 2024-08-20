#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QObject>
#include <QTimer>

class Counter : public QObject {
    Q_OBJECT
public:
    Counter() : count(0) {
        timer = new QTimer(this);
        connect(timer, &QTimer::timeout, this, &Counter::incrementCount);
        timer->start(1000); // 1 second interval
    }

signals:
    void countReached();

private slots:
    void incrementCount() {
        count++;
        if (count == 5) {
            emit countReached();
            timer->stop();
        }
    }

private:
    int count;
    QTimer *timer;
};

int main(int argc, char *argv[]) {
    QGuiApplication app(argc, argv);

    qmlRegisterType<Counter>("com.example", 1, 0, "Counter");

    QQmlApplicationEngine engine;
    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));

    return app.exec();
}

#include "main.moc"
