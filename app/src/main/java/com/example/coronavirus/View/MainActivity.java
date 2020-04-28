package com.example.coronavirus.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.coronavirus.R;
import com.example.coronavirus.model.TimelineItem;
import com.example.coronavirus.presenter.MainPresenter;
import com.example.coronavirus.presenter.MainPresenterImpl;
import com.example.coronavirus.presenter.MainView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    BarChart barChart;
    TextView tvUpdate, tvNegara, tvCode, tvPopulation, tvDeaths, tvConfirmed, tvRecovered, todayDeath, todayConfirmed;
    LinearLayout customLegend;
    ArrayList<String> filteredBar;
    ArrayList<BarEntry> BARENTRY ;
    Boolean isFilter;
    int colorClassArray[] = {Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA};
    String[] legendName ={"Death", "Confirmed", "Active", "Recovered"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this, this);
        mainPresenter.dataMainPresenter();
//        mainPresenter.timeLinePresenter();
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        barChart = (BarChart) findViewById(R.id.chart);
        tvUpdate = (TextView) findViewById(R.id.tvUpdate);
        tvPopulation = (TextView) findViewById(R.id.tvPopulation);
        tvNegara = (TextView) findViewById(R.id.tvNegara);
        tvCode = (TextView) findViewById(R.id.tvId);
        tvDeaths = (TextView) findViewById(R.id.deaths);
        tvConfirmed = (TextView) findViewById(R.id.confirmed);
        tvRecovered = (TextView) findViewById(R.id.recovered);
        todayDeath = (TextView) findViewById(R.id.todayDeath);
        todayConfirmed = (TextView) findViewById(R.id.todayConfirmed);
        customLegend = (LinearLayout) findViewById(R.id.customLegend);
        isFilter = false;
    }

    @Override
    public void dataMainView(final Object dataJson) {



        Log.d("", "DATAFROMMMM    "   + dataJson);
        List<BarEntry> entries = new ArrayList<>();
        ArrayList<String> forLegend = new ArrayList<>();
//        Log.d("", "LEGENDDDDD     " + deathsLegend);

        BARENTRY = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(new Gson().toJson(dataJson));
            JSONObject jsData = jsonObject.getJSONObject("data");
            JSONObject jsToday = jsData.getJSONObject("today");
            JSONObject jsLatestData = jsData.getJSONObject("latest_data");
            Log.d("","TERAHERRRRR   " + jsLatestData);



            JSONArray jsTimeline = jsData.getJSONArray("timeline");
            JSONObject jsArrayTimeLine = jsTimeline.getJSONObject(0);
            Log.d("", "HEEEEEEEE    " + jsTimeline);

            int population = jsData.getInt("population");
            int death = jsArrayTimeLine.getInt("deaths");
            int confirm = jsArrayTimeLine.getInt("confirmed");
            int recovererd = jsArrayTimeLine.getInt("recovered");

            int Tdeath = jsToday.getInt("deaths");
            int Tconfirmed = jsToday.getInt("confirmed");

            tvUpdate.setText(jsData.getString("updated_at"));
            tvPopulation.setText(Integer.toString(population));
            tvNegara.setText(jsData.getString("name"));
            tvCode.setText(jsData.getString("code"));

            tvDeaths.setText(Integer.toString(death));
            tvConfirmed.setText(Integer.toString(confirm));
            tvRecovered.setText(Integer.toString(recovererd));

            todayDeath.setText(Integer.toString(Tdeath));
            todayConfirmed.setText(Integer.toString(Tconfirmed));


            for (int a=0; a<jsArrayTimeLine.length(); a++){

                JSONObject jsonObjectO = (JSONObject) jsTimeline.get(a);
                Log.d("", "KAPTENNN   " + jsonObjectO);
                Log.d("", "ARGHHHHH   " + a);

                String date = jsonObjectO.getString("date");
                int deaths = jsonObjectO.getInt("deaths");
                int confirmed = jsonObjectO.getInt("confirmed");
                int active = jsonObjectO.getInt("active");
                int recovered = jsonObjectO.getInt("recovered");
                float deathsFloat = Float.valueOf(deaths);
                float confirmedFloat = Float.valueOf(confirmed);
                float activeFloat = Float.valueOf(active);
                float recoveredFloat = Float.valueOf(recovered);

//                entries.add(new BarEntry(a, deathsFloat));
                entries.add(new BarEntry(a, new float[]{deathsFloat, confirmedFloat, activeFloat, recoveredFloat}));
//                dates.add(date);
//                BARENTRY.add(new BarEntry(a, (float)jsArrayTimeLine).get)
//                deathsLegend.add(jsArrayTimeLine.get(a).getDeaths);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] colors = new int[]{Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA};

        BarDataSet dataSet = new BarDataSet( entries, "Rate Corona Victims");
        Log.d("", "DATASETTTT    " + dataSet);
        dataSet.setValueTextSize(10f);
        dataSet.setColors(colors);

        Legend legend = barChart.getLegend();
        legend.setEnabled(true);

        LegendEntry[]  legendEntries = new LegendEntry[4];
        for (int i=0; i<legendEntries.length; i++){
            LegendEntry entry = new LegendEntry();
            entry.formColor = colorClassArray[i];
            entry.label = String.valueOf(legendName[i]);
            legendEntries[i] = entry;
        }
        legend.setCustom(legendEntries);

//         Controlling left side of y axis
        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setGranularity(1f);

        BarData data = new BarData(dataSet);
        barChart.setData(data);

        data.setValueFormatter(new LargeValueFormatter());
        barChart.animateX(2500);
        barChart.invalidate();
        barChart.getAxisRight().setEnabled(true);
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                CustomMarkerView markerView = new CustomMarkerView(MainActivity.this,R.layout.marker);
                barChart.setMarker(markerView);
                List<TimelineItem> timeLine = new ArrayList<>();
                markerView.refreshContent(e, h, timeLine);
            }

            @Override
            public void onNothingSelected() {

            }
        });

        if (isFilter.equals(false)){
            showCustomLegend(forLegend);
        }
    }

    @Override
    public void dataMainViewLine(Object data) {
        try {
            JSONArray jsonArray = new JSONArray(new Gson().toJson(data));
            Log.d("", "COKKK    " + jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showCustomLegend(ArrayList<String> forLegend) {
        customLegend.removeAllViews();
        int legendPerLine = 2;
        int numLegend = forLegend.size();
        int pos = 0;
        try {
            while (numLegend > 0){
                LinearLayout horizontal = new LinearLayout(this);
                horizontal.setOrientation(LinearLayout.HORIZONTAL);
                horizontal.setGravity(Gravity.START);

                LinearLayout.LayoutParams horizontalParam;

                horizontalParam = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                horizontalParam.setMargins(20, 10, 20, 4);

                horizontalParam.gravity = Gravity.START | Gravity.CENTER_VERTICAL;

                horizontal.setLayoutParams(horizontalParam);

                for (int a = 0; a < legendPerLine; a++){
                    if (numLegend <= 0)
                        break;

                    //INDIKATOR WARNA
                    final TextView productColor = new TextView(this);
//                    productColor.setBackgroundColor(colors.get(pos));
                    productColor.setGravity(Gravity.START);
//                    productColor.setId(R.id.layout_1);

                    RelativeLayout.LayoutParams colorLayoutParam = new RelativeLayout.LayoutParams(30,30);
                    colorLayoutParam.setMargins(0, 2, 30, 2); //left top right bot
                    colorLayoutParam.addRule(RelativeLayout.CENTER_VERTICAL);

                    //TEXT LEGEND
                    final CheckedTextView productName = new CheckedTextView(this);
                    productName.setText(forLegend.get(pos).substring(0, 1).toUpperCase() + forLegend.get(pos).substring(1));
                    productName.setTextColor(Color.rgb(0, 0, 0));
                    productName.setTextSize(15);

                    productName.setOnClickListener(customClickLegend(productName,forLegend.get(pos)));

                    RelativeLayout relativeLayout = new RelativeLayout(this);

                    RelativeLayout.LayoutParams productLayoutParam = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    productLayoutParam.addRule(RelativeLayout.RIGHT_OF, productColor.getId());

                    LinearLayout.LayoutParams rowParam = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    rowParam.setMargins(20, 0, 10, 8);
                    rowParam.weight = 5f;
                    rowParam.gravity = Gravity.CENTER_VERTICAL;

                    relativeLayout.setLayoutParams(rowParam);

                    relativeLayout.addView(productColor, colorLayoutParam);
                    relativeLayout.addView(productName, productLayoutParam);
                    horizontal.addView(relativeLayout);
                    numLegend--;
                    pos++;

                }
                customLegend.addView(horizontal);

            }
        } catch (Exception e) {
            Log.d("CUSTOMM", "CUSTOMM : " + e.getMessage());
        }
    }
    View.OnClickListener customClickLegend(final CheckedTextView view, final String name){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFilter = true;
                if (view.isChecked()) {
                    view.setChecked(false);
                    view.setPaintFlags(view.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG) & (~Paint.FAKE_BOLD_TEXT_FLAG) & (~Paint.UNDERLINE_TEXT_FLAG));
                    filteredBar.remove(name);
                } else {
                    view.setChecked(true);
                    view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG | Paint.UNDERLINE_TEXT_FLAG);
                    filteredBar.add(name);
                }
                Log.d("filteredbar",""+filteredBar);
                Log.d("NAMEEEEEEEE     ",""+name);
                Log.d("VIEEWWWWWWW     ",""+view);
                mainPresenter.filteredChart(filteredBar);
//                filteredBar.clear();
            }
        };
    }

}
