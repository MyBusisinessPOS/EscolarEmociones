package com.example.escolar;

import android.app.Application;

import com.example.escolar.database.DaoHelper;

public class App extends Application {
    private DaoHelper dbController;
    private static App _INSTANCE = null;
    @Override
    public void onCreate() {
        super.onCreate();
        _INSTANCE = this;
        /*** ----- Obtenemos el singleton ------ ****/
        dbController = DaoHelper.getSingleton();

        /** Inicia el Helper **/
        dbController.init(_INSTANCE, "hola1_db");
    }
}
