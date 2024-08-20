#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QQmlContext>
#include <QObject>

class LoginHandler : public QObject {
    Q_OBJECT
public:
    explicit LoginHandler(QObject *parent = nullptr) : QObject(parent) {}

    Q_INVOKABLE void verifyLogin(const QString &username, const QString &password) {
        if (username == "user" && password == "password") {
            emit loginSuccess();
        } else {
            emit loginFailed();
        }
    }

signals:
    void loginSuccess();
    void loginFailed();
};

int main(int argc, char *argv[]) {
    QGuiApplication app(argc, argv);

    QQmlApplicationEngine engine;

    LoginHandler loginHandler;
    engine.rootContext()->setContextProperty("loginHandler", &loginHandler);

    const QUrl url(u"qrc:/Main.qml"_qs);
    QObject::connect(&engine, &QQmlApplicationEngine::objectCreated,
                     &app, [url](QObject *obj, const QUrl &objUrl) {
                         if (!obj && url == objUrl)
                             QCoreApplication::exit(-1);
                     }, Qt::QueuedConnection);

    engine.load(url);

    return app.exec();
}

#include "main.moc"
