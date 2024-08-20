import QtQuick 2.15
import QtQuick.Controls 2.15
import com.example 1.0

ApplicationWindow {
    visible: true
    width: 640
    height: 480
    title: qsTr("Counter App")

    Counter {
        id: counter
        onCountReached: {
            messageLabel.text = "Count reached 5!"
        }
    }

    Text {
        id: messageLabel
        text: "Counting..."
        anchors.centerIn: parent
        font.pixelSize: 24
    }
}
