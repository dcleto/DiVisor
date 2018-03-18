package unapec.arquitectura.opensource.di_visor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecycler = findViewById(R.id.recycler);

        mRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        String action = getIntent().getStringExtra("ACTION");
        if(action.equals("Comprar")){
            mRecycler.setAdapter(new PricesAdapter(PricesRepo.getBuyPrices()));
        }
        else {
            mRecycler.setAdapter(new PricesAdapter(PricesRepo.getSalePrices()));
        }
    }
}
