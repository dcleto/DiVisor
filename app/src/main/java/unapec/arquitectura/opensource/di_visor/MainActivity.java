package unapec.arquitectura.opensource.di_visor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner sp_coin;
    Spinner sp_action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_coin = findViewById(R.id.sp_coin);
        sp_action = findViewById(R.id.sp_action);
        ArrayAdapter<String> coinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Dolar", "Euro"});
        ArrayAdapter<String> actionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Comprar", "Vender"});
        coinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_coin.setAdapter(coinAdapter);
        sp_action.setAdapter(actionAdapter);

        findViewById(R.id.btn_consultar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("ACTION",(String)sp_action.getSelectedItem());
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_historic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HistoricActivity.class));
            }
        });
    }
}
