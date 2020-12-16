package ua.nure.moviegallery.domain;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider {
    public static Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    public static Scheduler io() {
        return Schedulers.io();
    }

    public static Scheduler computation() {
        return Schedulers.computation();
    }
}
