package com.example.lv_music.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lv_music.Model.Advertisement;
import com.example.lv_music.Model.ApiResponse;
import com.example.lv_music.Model.Song;
import com.example.lv_music.Repository.AdvertisementRepository;
import com.example.lv_music.Repository.SongRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private SongRepository mSongRepository;
    private MutableLiveData<ApiResponse<List<Song>>> mAllSongs;
    private MutableLiveData<ApiResponse<Song>> mSong;
    private AdvertisementRepository mAdvertisementRepository;
    private MutableLiveData<ApiResponse<List<Advertisement>>> mAllAdvertisements;

    public MainViewModel(){
        mSongRepository = SongRepository.getInstance();
        mAllSongs = new MutableLiveData<>();
        mSong = new MutableLiveData<>();

        mAdvertisementRepository = AdvertisementRepository.getInstance();
        mAllAdvertisements = new MutableLiveData<>();
    }

    public void fetchAllSongs(){
        mSongRepository.getAllSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<ApiResponse<List<Song>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull ApiResponse<List<Song>> listApiResponse) {
                        mAllSongs.setValue(listApiResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("BBB", "Error : " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ApiResponse<List<Song>>> getResponseAllSongs(){
        return mAllSongs;
    }

    public void fetchSong(Integer id){
        mSongRepository.getSong(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<ApiResponse<Song>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull ApiResponse<Song> songApiResponse) {
                        mSong.setValue(songApiResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("BBB", "Error : " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ApiResponse<Song>> getResponseSong(){
        return mSong;
    }

    public void fetchAllAdvertisements(){
        mAdvertisementRepository.getAllAdvertisements()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<ApiResponse<List<Advertisement>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull ApiResponse<List<Advertisement>> listApiResponse) {
                        mAllAdvertisements.setValue(listApiResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("BBB", "Error : " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ApiResponse<List<Advertisement>>> getResponseAllAdvertisements(){
        return mAllAdvertisements;
    }
}