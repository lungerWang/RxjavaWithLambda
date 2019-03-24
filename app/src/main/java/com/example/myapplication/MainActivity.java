package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create 写法1
//        Observable.create((ObservableOnSubscribe<Integer>)  emitter -> {
//            emitter.onNext(101);
//            emitter.onNext(222);
//            emitter.onError(new RuntimeException("nimabi"));
//            emitter.onComplete();
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d("wbl", "onSubscribe");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d("wbl", "onNext" + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d("wbl", "onError" + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d("wbl", "onComplete");
//            }
//        });

        //create写法2
//        Observable.create(emitter -> {
//            emitter.onNext(101);
//            emitter.onNext(222);
//            //emitter.onError(new RuntimeException("nimabi"));
//            emitter.onComplete();
//        }).subscribe(number -> Log.d("wbl", "accept " + number),
//                throwable -> Log.d("wbl", "onError" + throwable.getMessage()),
//                () -> Log.d("wbl", "onComplete"),
//        );

        //zip
//        Observable.zip(getStringObservable(),
//                getIntegerObservable(),
//                getStringObservable2(),
//                (str, num, str2) -> str + num + str2).subscribe(result -> Log.d("wbl", result));

        //map
//        Single.create(emitter -> emitter.onSuccess(520))
//                .map(number -> number + "yangpeifang")
//                .subscribe(result -> Log.d("wbl", "result = " + result));

        //flatMap
//          Observable.just("Hi ")
//                  .flatMap(hi -> {
//                      List<String> list = new ArrayList<>();
//                      for (int i = 0; i < 30; i++) {
//                          list.add(hi + i);
//
//                      }
//                      int delayTime = (int) (1 + Math.random() * 10);
//                      return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
//                  }).subscribe(s -> Log.d("wbl", s));

        //doOnNext
//        Observable.just("13")
//                .doOnNext(s -> Log.d("wbl", "存储 - " + s))
//                .subscribe(s -> Log.d("wbl", "消费 - " + s));
    }

    private Observable<String> getStringObservable(){
        return Observable.just("kangkang", "rose", "kat");
    }

    private Observable<Integer> getIntegerObservable(){
        return Observable.just(1, 2, 3, 4, 5);
    }

    private Observable<String> getStringObservable2(){
        return Observable.just("a", "b", "c");
    }

}