package com.example.aidliti;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Hamada extends Service {
    public Hamada() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}