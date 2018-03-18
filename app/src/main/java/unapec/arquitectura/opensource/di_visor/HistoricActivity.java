package unapec.arquitectura.opensource.di_visor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HistoricActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private LineChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_historic);

        tvX = (TextView) findViewById(R.id.tvXMax);
        tvY = (TextView) findViewById(R.id.tvYMax);

        mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
        mSeekBarX.setOnSeekBarChangeListener(this);

        mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);
        mSeekBarY.setOnSeekBarChangeListener(this);

        mChart = (LineChart) findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);

        mChart.setDrawGridBackground(false);
        mChart.getDescription().setEnabled(false);
        mChart.setDrawBorders(false);

        mChart.getAxisLeft().setEnabled(true);
        mChart.getAxisRight().setEnabled(false);
        mChart.getAxisRight().setDrawAxisLine(false);
        mChart.getAxisRight().setDrawGridLines(false);
        mChart.getXAxis().setDrawAxisLine(false);
        mChart.getXAxis().setDrawGridLines(false);

        mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
         // enable touch gestures
        mChart.setTouchEnabled(true);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mSeekBarX.setProgress(20);
        mSeekBarY.setProgress(100);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         return true;
    }

    private int[] mColors = new int[] {
            ColorTemplate.VORDIPLOM_COLORS[0],
            ColorTemplate.VORDIPLOM_COLORS[1],
            ColorTemplate.VORDIPLOM_COLORS[2],
            ColorTemplate.VORDIPLOM_COLORS[3],
            ColorTemplate.VORDIPLOM_COLORS[4],
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        mChart.resetTracking();

        tvX.setText("" + (mSeekBarX.getProgress()));
        tvY.setText("" + (mSeekBarY.getProgress()));

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        ArrayList<Entry> valuesPopular = new ArrayList<Entry>();
        valuesPopular.add(new Entry(1,48.5f));
        valuesPopular.add(new Entry(2,47.5f));
        valuesPopular.add(new Entry(3,48.5f));
        valuesPopular.add(new Entry(4,47.5f));
        valuesPopular.add(new Entry(5,47.5f));
        LineDataSet popularDataSet = new LineDataSet(valuesPopular, "Popular ");


        ArrayList<Entry> valuesReservas = new ArrayList<Entry>();
        valuesReservas.add(new Entry(1,47.5f));
        valuesReservas.add(new Entry(2,48.5f));
        valuesReservas.add(new Entry(3,47.5f));
        valuesReservas.add(new Entry(4,48.5f));
        valuesReservas.add(new Entry(5,46.5f));
        LineDataSet reservasDataSet = new LineDataSet(valuesReservas, "Reservas ");


        ArrayList<Entry> valuesBhd = new ArrayList<Entry>();
        valuesBhd.add(new Entry(1,47.5f));
        valuesBhd.add(new Entry(2,49.5f));
        valuesBhd.add(new Entry(3,46.5f));
        valuesBhd.add(new Entry(4,48.5f));
        valuesBhd.add(new Entry(5,47.5f));
        LineDataSet bhdDataset = new LineDataSet(valuesBhd, "BHD ");


        ArrayList<Entry> valuesBanesco= new ArrayList<Entry>();
        valuesBanesco.add(new Entry(1,48.44f));
        valuesBanesco.add(new Entry(2,46.75f));
        valuesBanesco.add(new Entry(3,47.13f));
        valuesBanesco.add(new Entry(4,48.56f));
        valuesBanesco.add(new Entry(5,48.52f));
        LineDataSet banescoDataset = new LineDataSet(valuesBhd, "Banesco");

        ArrayList<Entry> valuesSantaCruz= new ArrayList<Entry>();
        valuesSantaCruz.add(new Entry(1,47.5f));
        valuesSantaCruz.add(new Entry(2,46.45f));
        valuesSantaCruz.add(new Entry(3,49.57f));
        valuesSantaCruz.add(new Entry(4,48.56f));
        valuesSantaCruz.add(new Entry(5,49.58f));
        LineDataSet santaCruzDataset = new LineDataSet(valuesSantaCruz, "Santa Cruz");

        int color = mColors[0];
        popularDataSet.setColor(color);
        popularDataSet.setCircleColor(color);
        popularDataSet.setLineWidth(2.5f);
        popularDataSet.setCircleRadius(4f);

        int color1 = mColors[1];
        reservasDataSet.setColor(color1);
        reservasDataSet.setCircleColor(color1);
        reservasDataSet.setLineWidth(2.5f);
        reservasDataSet.setCircleRadius(4f);

        int color2 = mColors[2];
        bhdDataset.setColor(color2);
        bhdDataset.setCircleColor(color2);
        bhdDataset.setLineWidth(2.5f);
        bhdDataset.setCircleRadius(4f);

        int color3 = mColors[3];
        banescoDataset.setColor(color3);
        banescoDataset.setCircleColor(color3);
        banescoDataset.setLineWidth(2.5f);
        banescoDataset.setCircleRadius(4f);

        int color4 = mColors[4];
        santaCruzDataset.setColor(color4);
        santaCruzDataset.setCircleColor(color4);
        santaCruzDataset.setLineWidth(2.5f);
        santaCruzDataset.setCircleRadius(4f);


        dataSets.add(popularDataSet);
        dataSets.add(reservasDataSet);
        dataSets.add(bhdDataset);
        dataSets.add(banescoDataset);
        dataSets.add(santaCruzDataset);

//
//        for (int z = 0; z < 3; z++) {
//
//            ArrayList<Entry> values = new ArrayList<Entry>();
//
//            for (int i = 0; i < mSeekBarX.getProgress(); i++) {
//                double val = (Math.random() * mSeekBarY.getProgress()) + 3;
//                values.add(new Entry(i, (float) val));
//            }
//
//            LineDataSet d = new LineDataSet(values, "DataSet " + (z + 1));
//            d.setLineWidth(2.5f);
//            d.setCircleRadius(4f);
//
//            int color = mColors[z % mColors.length];
//            d.setColor(color);
//            d.setCircleColor(color);
//            dataSets.add(d);
//        }

        // make the first DataSet dashed
//        ((LineDataSet) dataSets.get(0)).enableDashedLine(10, 10, 0);
//        ((LineDataSet) dataSets.get(0)).setColors(ColorTemplate.VORDIPLOM_COLORS);
//        ((LineDataSet) dataSets.get(0)).setCircleColors(ColorTemplate.VORDIPLOM_COLORS);

        LineData data = new LineData(dataSets);
        mChart.setData(data);
        mChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("VAL SELECTED",
                "Value: " + e.getY() + ", xIndex: " + e.getX()
                        + ", DataSet index: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}