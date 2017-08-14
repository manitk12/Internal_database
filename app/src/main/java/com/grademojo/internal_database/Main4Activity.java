package com.grademojo.internal_database;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.RippleDrawable;
import android.icu.math.BigDecimal;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {


    private CardView main_Container ,main_Container_2 ,main_Container_3 ,first_Card_view ,second_Card_view ,third_Card_view;

    private Boolean aBoolean;

    private static final int DECIMAL_SCALE = 1;
    float Memory = 65f, used, used_2,memort_1 = 85f , used_3 , memory_3= 50f;

    private PieChart pieChart1 ,pieChart2,pieChart3;
    private PieDataSet dataSet, dataSet1, dataSet2;
    private View context;







    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        main_Container = (CardView) findViewById(R.id.main_container);
        main_Container_2 = (CardView) findViewById(R.id.main_container1);
        main_Container_3 = (CardView) findViewById(R.id.main_container2);
        first_Card_view = (CardView) findViewById(R.id.first_card_view);
        second_Card_view = (CardView) findViewById(R.id.second_card_view);
        third_Card_view = (CardView) findViewById(R.id.third_card_view);

        pieChart1 = (PieChart) findViewById(R.id.pie_chart1);
        pieChart2 = (PieChart) findViewById(R.id.pie_chart2);
        pieChart3 = (PieChart) findViewById(R.id.pie_chart3);






        context = findViewById(R.id.view);


        pieChart1.getDescription().setEnabled(false);

        pieChart2.setUsePercentValues(true);
        pieChart2.getDescription().setEnabled(false);

        pieChart3.setUsePercentValues(true);
        pieChart3.getDescription().setEnabled(false);





        pieChart1.setHoleColor(ContextCompat.getColor(context.getContext(),R.color.grey_color));
        pieChart2.setDrawHoleEnabled(true);
        pieChart2.setHoleColor(ContextCompat.getColor(context.getContext(),R.color.grey_color));
        pieChart3.setDrawHoleEnabled(true);
        pieChart3.setHoleColor(ContextCompat.getColor(context.getContext(),R.color.grey_color));


        pieChart1.setCenterText("650");
        pieChart1.setCenterTextColor(ContextCompat.getColor(context.getContext(),R.color.white));
        pieChart1.setCenterTextSize(30f);
        pieChart2.setCenterText("85%");
        pieChart2.setCenterTextColor(ContextCompat.getColor(context.getContext(),R.color.white));
        pieChart2.setCenterTextSize(30f);

        pieChart3.setCenterText("50%");
        pieChart3.setCenterTextColor(ContextCompat.getColor(context.getContext(),R.color.white));
        pieChart3.setCenterTextSize(70f);


        //pieChart.setTransparentCircleColor(ContextCompat.getColor(context.getContext(), R.color.new_grey));
//        pieChart1.setTransparentCircleAlpha(110);
        pieChart1.setHoleRadius(90f);
        pieChart1.setTransparentCircleRadius(61f);
        pieChart2.setTransparentCircleAlpha(110);
        pieChart2.setHoleRadius(85f);
        pieChart2.setTransparentCircleRadius(61f);

        pieChart3.setTransparentCircleAlpha(110);
        pieChart3.setHoleRadius(95f);
        pieChart3.setTransparentCircleRadius(61f);


        pieChart1.setRotationAngle(0);
        pieChart1.setRotationEnabled(true);

        pieChart2.setRotationAngle(0);
        pieChart2.setRotationEnabled(true);

        pieChart3.setRotationAngle(0);
        pieChart3.setRotationEnabled(true);




        // Highlight means make that "pie" section a bit bigger on click
        pieChart1.setHighlightPerTapEnabled(false);
        pieChart2.setHighlightPerTapEnabled(false);
        pieChart3.setHighlightPerTapEnabled(false);




        Memory = new BigDecimal(Memory).setScale(DECIMAL_SCALE).floatValue();
        memort_1 = new BigDecimal(memort_1).setScale(DECIMAL_SCALE).floatValue();
        memory_3 = new BigDecimal(memory_3).setScale(DECIMAL_SCALE).floatValue();


        used = 100.0f - Memory ;
        used = new BigDecimal(used).setScale(DECIMAL_SCALE, BigDecimal.ROUND_FLOOR).floatValue();


        used_2 = 100.0f - memort_1 ;
        used_2 = new BigDecimal(used_2).setScale(DECIMAL_SCALE, BigDecimal.ROUND_FLOOR).floatValue();

        used_3 = 100.0f - memory_3 ;
        used_3 = new BigDecimal(used_3).setScale(DECIMAL_SCALE, BigDecimal.ROUND_FLOOR).floatValue();



        // Need an ArrayList of "PieEntry"
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        if(used > 0){
            entries.add(new PieEntry(used, ""));
        }

        if(Memory > 0){
            entries.add(new PieEntry(Memory, ""));
        }


        ArrayList<PieEntry> entries_1 = new ArrayList<PieEntry>();

        if(used_2 > 0){
            entries_1.add(new PieEntry(used_2, ""));
        }

        if(memort_1 > 0){
            entries_1.add(new PieEntry(memort_1, ""));
        }

        ArrayList<PieEntry> entries_2 = new ArrayList<PieEntry>();

        if(used_3 > 0){
            entries_2.add(new PieEntry(used_3, ""));
        }

        if(memory_3 > 0){
            entries_2.add(new PieEntry(memory_3, ""));
        }








        dataSet = new PieDataSet(entries, "");
        dataSet1 = new PieDataSet(entries_1,"");
        dataSet2 = new PieDataSet(entries_2,"");







        if(used == 0f){


            if(Memory == 0f){

            }else{


            }

        }else if(Memory == 0f){


        }else{

            dataSet.setColors(ContextCompat.getColor(context.getContext(), R.color.orange),ContextCompat.getColor(context.getContext(), R.color.green));
            dataSet.setValueLineColor(ContextCompat.getColor(context.getContext(),R.color.blue));
        }



        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(0f);




        pieChart1.setData(data);









        pieChart1.animateY(1400, Easing.EasingOption.EaseInQuad);



        if(used_2 == 0f){


            if(memort_1 == 0f){
                dataSet1.setColors(ContextCompat.getColor(context.getContext(), R.color.grey));
            }else{

                dataSet1.setColors(ContextCompat.getColor(context.getContext(), R.color.grey));
            }

        }else if(memort_1 == 0f){


        }else{

            dataSet1.setColors(ContextCompat.getColor(context.getContext(), R.color.green),ContextCompat.getColor(context.getContext(), R.color.orange));
        }



        PieData data1 = new PieData(dataSet1);

        data1.setValueFormatter(new PercentFormatter());

        data1.setValueTextSize(0f);



        pieChart2.setData(data1);


        pieChart2.highlightValues(null);


        pieChart2.invalidate();



        pieChart2.animateY(1400, Easing.EasingOption.EaseInElastic);


        if(used_3 == 0f){


            if(memory_3 == 0f){
                dataSet2.setColors(ContextCompat.getColor(context.getContext(), R.color.grey));
            }else{

                dataSet2.setColors(ContextCompat.getColor(context.getContext(), R.color.grey));
            }

        }else if(memory_3 == 0f){


        }else{

            dataSet2.setColors(ContextCompat.getColor(context.getContext(), R.color.green),ContextCompat.getColor(context.getContext(), R.color.orange));
        }



        PieData data2 = new PieData(dataSet2);

        data2.setValueFormatter(new PercentFormatter());

        data2.setValueTextSize(0f);



        pieChart3.setData(data2);


        pieChart3.highlightValues(null);


        pieChart3.invalidate();



        pieChart3.animateY(1400, Easing.EasingOption.EaseInElastic);






        aBoolean = false;











        main_Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                    RelativeLayout.LayoutParams lps = (RelativeLayout.LayoutParams) first_Card_view.getLayoutParams();

                    lps.addRule(RelativeLayout.ALIGN_START, R.id.frame_no);
                    lps.addRule(RelativeLayout.ALIGN_END, R.id.frame_no);
                    lps.addRule(RelativeLayout.ALIGN_TOP, R.id.frame_no);
                    lps.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.frame_no);



            }
        });


    }
}
