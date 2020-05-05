package com.lugo.manueln.appproject.Interactors.WebService;

import com.lugo.manueln.appproject.objects.Album;
import com.lugo.manueln.appproject.objects.Comments;
import com.lugo.manueln.appproject.objects.Photo;
import com.lugo.manueln.appproject.objects.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPostApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPostComplete(@Path("id") int postId);

    @GET("posts/{id}/comments")
    Call<List<Comments>> getCommentsFilter(@Path("id") int postId);

    @GET("albums")
    Call<List<Album>> getAlbums();

    @GET("albums/{idAlbum}/photos")
    Call<List<Photo>> getPhotosAlbum(@Path("idAlbum") int albumId);
}
