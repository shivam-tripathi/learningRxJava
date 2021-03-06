package com.rxjava.app.packt.chapter02;

import io.reactivex.rxjava3.core.Observable;

public class Ch02_01 {
  public static void main(String[] args) {
    Observable<String> source = Observable.create(emitter -> {
      try {
        emitter.onNext("One");
        emitter.onNext("Two");
        emitter.onNext("Three");
        emitter.onNext("Eleven");
        emitter.onComplete();
      } catch (Exception e) {
        emitter.onError(e);
      }
    });
    source.map(String::length)
      .filter(i -> i >= 5)
      .subscribe(x -> System.out.println("RECEIVED: " + x), Throwable::printStackTrace)
      .dispose();
  }
}
