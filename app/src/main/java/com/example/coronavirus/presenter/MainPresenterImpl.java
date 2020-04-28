package com.example.coronavirus.presenter;

import android.content.Context;
import android.util.Log;

import com.example.coronavirus.interactor.MainInteractor;
import com.example.coronavirus.interactor.MainInteractorImpl;
import com.example.coronavirus.model.Data;
import com.example.coronavirus.model.TimelineItem;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainPresenterImpl implements MainPresenter{

    MainView mainView;
    List<Data> dataList;
    Context context;
    MainInteractor interactor;

    public MainPresenterImpl(MainView view, Context context) {
        this.mainView = view;
        this.context = context;
        dataList = new ArrayList<>();
        interactor = new MainInteractorImpl();
    }

    @Override
    public void dataMainPresenter() {
        interactor.getMainInteractor(new MainInteractor.ListenerInteractor<Object>() {
            @Override
            public void onSuccess(Object data) {
                List<TimelineItem> dataTimeLine = new ArrayList<>();
                Log.d("", "DATAAAAAA   " + data);
//                List<Data> dataRes = new ArrayList<>();
//                Log.d("", "DATAAAAAARESSSS   " + dataRes);

                mainView.dataMainView(data);
//                mainView.dataTimeline(data);
            }

            @Override
            public void onError(String message) {

            }
        });
    }


    @Override
    public void filteredChart(ArrayList<String> filteredBar) {
        interactor.getMainInteractor(new MainInteractor.ListenerInteractor<Object>() {
            @Override
            public void onSuccess(Object data) {
                List<TimelineItem> dataTimeLine = new ArrayList<>();

                mainView.dataMainViewLine(data);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

//    @Override
//    public void filteredChart(ArrayList<String> forLegend) {
//        interactor.getMainInteractor(new MainInteractor.ListenerInteractor<Object>() {
//            public void onSuccess(Object dataLine) {
////                List<TimelineItem> dataTimeLine = new ArrayList<>();
//
////                mainView.dataMainViewLine(dataLine);
//            }
//
//            @Override
//            public void onError(String message) {
//
//            }
//        });
//    }


}
