package ua.nure.moviegallery;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import ua.nure.moviegallery.date.NetworkChangeReceiver;
import ua.nure.moviegallery.domain.di.component.DaggerMovieServiceComponent;
import ua.nure.moviegallery.domain.di.component.MovieServiceComponent;
import ua.nure.moviegallery.domain.di.module.MovieServiceModule;

public class App extends Application {
    private MovieServiceComponent movieServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initBroadcastReceiver();
        movieServiceComponent = DaggerMovieServiceComponent.builder()
                .movieServiceModule(new MovieServiceModule(this))
                .build();
    }

    private void initBroadcastReceiver() {
        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    public MovieServiceComponent getMovieServiceComponent() {
        return movieServiceComponent;
    }
}
