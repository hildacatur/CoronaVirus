package com.example.coronavirus.interactor;

public interface MainInteractor {
    interface ListenerInteractor<T> {
        void onSuccess(Object data);
        void onError(String message);

    }

    void getMainInteractor(ListenerInteractor<Object> listenerInteractor);
}

