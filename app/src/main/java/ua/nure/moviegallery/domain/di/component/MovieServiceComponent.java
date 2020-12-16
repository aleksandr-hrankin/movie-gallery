package ua.nure.moviegallery.domain.di.component;

import javax.inject.Singleton;
import dagger.Component;
import ua.nure.moviegallery.MainActivity;
import ua.nure.moviegallery.domain.di.module.MovieServiceModule;

@Singleton
@Component(modules = {MovieServiceModule.class})
public interface MovieServiceComponent {
    void inject(MainActivity mainActivity);
}
