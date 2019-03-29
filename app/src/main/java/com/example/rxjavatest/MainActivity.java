package com.example.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Observable;

import io.reactivex.Observer;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer i) {
                        return (i % 2) == 0;
                    }
                })
                .map(new Func1<Integer, Integer>(){
                    @Override
                    public Integer call(Integer i){
                        return i * 10;
                    }
                }).subscribe(new Observer<Integer>(){
                    @Override
                    public void onNext(Integer integer){
                        Log.d("Hoge",integer.toString());
                    }

                    @Override
                    public void onCompleted(){
                        Log.d("Hoge", "completed");
                    }

                    @Override
                    public void onError(Throwable e){

                    }
        });
    }
}
