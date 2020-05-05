package com.lugo.manueln.appproject.Interfaces;

import com.lugo.manueln.appproject.Views.AlbumsFragment;
import com.lugo.manueln.appproject.Views.MenuFragment;
import com.lugo.manueln.appproject.Views.PhotosFragment;
import com.lugo.manueln.appproject.Views.PostCompleteFragment;
import com.lugo.manueln.appproject.Views.PostsFragment;

public interface loadfragments extends PostsFragment.OnFragmentInteractionListener,PostCompleteFragment.OnFragmentInteractionListener,AlbumsFragment.OnFragmentInteractionListener,PhotosFragment.OnFragmentInteractionListener, MenuFragment.OnFragmentInteractionListener {
}
