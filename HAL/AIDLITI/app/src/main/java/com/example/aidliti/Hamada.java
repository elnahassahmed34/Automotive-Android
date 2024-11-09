package com.example.aidliti;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class Hamada extends Service {
    public Hamada() {
    }

    IBinder binder = new IHamada.Stub() {
        @Override
        public String whatIsYourName() throws RemoteException {
            return "My name is nahass";
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}