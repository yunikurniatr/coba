package org.yuni.chemicalnote.api;

import org.yuni.chemicalnote.UnsurwApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("unsurpt.json")
    Call<List<UnsurwApi>> getUnsur();
}
