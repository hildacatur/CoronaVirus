package com.example.coronavirus.presenter;

import com.example.coronavirus.model.Data;
import com.example.coronavirus.model.TimelineItem;

import org.json.JSONException;

import java.util.List;

public interface MainView {
//    void dataMainView(List<TimelineItem> dataTimeLine);
    void dataMainView(Object dataJson);

    void dataMainViewLine(Object data);

//    void dataMainViewLine(Object dataLine);


//    void dataTimeline(List<TimelineItem> dataTimeLine);
}
