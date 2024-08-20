import QtQuick 2.15
import QtQuick.Controls 2.15

ApplicationWindow {
    visible: true
    width: 400
    height: 300
    title: "Login Example"

    Column {
        anchors.centerIn: parent

        TextField {
            id: usernameField
            placeholderText: "Username"
        }

        TextField {
            id: passwordField
            placeholderText: "Password"
            echoMode: TextInput.Password
        }

        Button {
            text: "Login"
            onClicked: {
                loginHandler.verifyLogin(usernameField.text, passwordField.text)
            }
        }

        Text {
            id: statusText
            color: "red"
            anchors.horizontalCenter: parent.horizontalCenter
        }

        Connections {
            target: loginHandler
            onLoginSuccess: {
                statusText.text = "Login successful!"
                statusText.color = "green"
            }
            onLoginFailed: {
                statusText.text = "Login failed!"
                statusText.color = "red"
            }
        }
    }
}
