package com.example.coronavirus.View;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.coronavirus.R;
import com.example.coronavirus.model.TimelineItem;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

import java.text.DecimalFormat;
import java.util.List;

public class CustomMarkerView extends MarkerView {

    TextView tvUpdate, tvDate, tvDeaths;

    public CustomMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        tvUpdate = (TextView) findViewById(R.id.update);
        tvDate = (TextView) findViewById(R.id.date);
        tvDeaths = (TextView) findViewById(R.id.deaths);
    }

    public void refreshContent(Entry e, Highlight h, List<TimelineItem> timeLine) {
//        super.refreshContent(e, h);
//        int index = Math.round(e.getX());
//        String update = timeLine.get(index).getUpdatedAt();
//        String s = update.substring(0,1).toUpperCase() + update.substring(1);
//        Log.d("", "updateeeee    " + update);
//
//        DecimalFormat formatter = new DecimalFormat("#,###,###");
//        String date = formatter.format(timeLine.get(index).getDate());
//        String deaths = formatter.format(timeLine.get(index).getDeaths());

        tvUpdate.setText("X : " +e.getX()+ "\n" + "Y : "+e.getY());
//        tvUpdate.setText(s);
//        tvDate.setText(date);
//        tvDeaths.setText(deaths);
    }
}
