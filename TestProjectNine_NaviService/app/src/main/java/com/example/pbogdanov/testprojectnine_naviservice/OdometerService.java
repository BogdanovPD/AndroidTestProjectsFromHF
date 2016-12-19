package com.example.pbogdanov.testprojectnine_naviservice;

import android.Manifest;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;

public class OdometerService extends Service {

    private final IBinder binder = new OdometerBinder();
    private static double distanceInMeters;
    private static Location lastLocation = null;


    @Override
    public void onCreate() {
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (lastLocation == null) {
                    lastLocation = location;
                }
                distanceInMeters += location.distanceTo(lastLocation);
                lastLocation = location;
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        }
        catch (SecurityException e){

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public double getMiles() {
        return this.distanceInMeters / 1609.344;
    }

    public class OdometerBinder extends Binder{
        OdometerService getOdometer(){
            return OdometerService.this;
        }
    }
}
