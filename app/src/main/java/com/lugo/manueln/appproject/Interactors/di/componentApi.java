package com.lugo.manueln.appproject.Interactors.di;

import com.lugo.manueln.appproject.Interactors.ModuleAlbums;
import com.lugo.manueln.appproject.Interactors.ModulePhotos;
import com.lugo.manueln.appproject.Interactors.ModulePostComplete;
import com.lugo.manueln.appproject.Interactors.ModulePosts;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = moduleApi.class)
public interface componentApi {

    void inject(ModulePosts modulePosts);
    void inject(ModulePostComplete modulePostComplete);
    void inject(ModuleAlbums moduleAlbums);
    void inject(ModulePhotos modulePhotos);

}
