package com.example.current;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.current.CountryCapitalCurrencyActivity.MyAdapter;

import com.google.firebase.auth.FirebaseAuth;

public class CountryCapitalCurrencyActivity extends AppCompatActivity {

    ListView listView;
    String country[] = {"-----COUNTRY-----","Afghanistan","Algeria","Argentina","Australia","Austria","Bangladesh","Belgium","Belarus","Bhutan","Brazil","Canada","China","Czech Republic","Denmark","Egypt","Ethiopia","Malaysia","Maldives","Mexico","Mozambique","Nepal","Netherlands","New Zealand","Norway","Pakistan","Philippines","Poland","Portugal","Romania","Russia","Saudi Arabia","Singapore","Slovakia","South Africa","Switzerland","Tanzania","Thailand","United Arab Emirates","Ukraine","U.K.","U.S.A","Uruguay","Zimbabwe","Finland","France","Germany","Greece","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Japan","North Korea","South Korea","Liechtenstein","Luxembourg","Myanmar","Sweden"};
    String capital[] = {"-----CAPITAL-----","Kabul","Algiers","Buenos Aires","Canberra","Vienna","Dhaka","Brussels","Minsk","Thimphu","Brasilia","Ottawa","Beijing","Prague","Copenhagen","Cairo","Addis Ababa","Kuala Lumpur","Male","Mexico City","Maputo","Kathmandu","Amsterdam","Wellington","Oslo","Islamabad","Manila","Warsaw","Lisbon","Bucharest","Moscow","Riyadh","Singapore City","Bratislava","Pretoria","Bern","Dodoma","Bangkok","Abu Dhabi","Kyiv","London","Washington D.C.","Montevideo","Harare","Helsinki","Paris","Berlin","Athens","Budapest","Reykjavik","New Delhi","Jakarta","Tehran","Baghdad","Dublin","Jerusalem","Rome","Tokyo","Pyongyang","Seoul","Vaduz","Luxembourg","Rangoon","Stockholm"};
    String currency[] = {"-----CURRENCY-----","Afghani","Dinar","Peso","Australian Dollar","Euro","Taka","Euro","Ruble","Ngultrum","Real","Canadian Dollae", "Yuan","Koruna or Crown","Krone","Egyptian Pound","Birr","Ringgit","Maldivian Rufiyaa","Peso","Metical","Nepalese Rupee","Euro","New Zealand Dollar", "Krone","Pakistani Rupee","Peso","Zloty","Euro","Leu","Ruble","Rial(SAR)","Singapore Dollar","Euro","Rand","Swiss Franc","Shilling","Baht","Dirham","Hyrvnia","Pound Sterling","Dollar","Peso","US Dollar","Euro","Euro","Euro","Euro","Forint","Krona","Rupee","Rupiah","Rial","Iraqi Dinar","Euro","Shekel","Euro","Yen","Won","Won","Swiss Franc","Euro","Kyat","Krona"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_capital_currency);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, country, capital, currency);
        listView.setAdapter(adapter);

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rcountry[];
        String rcapital[];
        String rcurrency[];

        MyAdapter (Context c, String country[], String capital[], String currency[]) {
            super(c, R.layout.row, R.id.tv1, country);
            this.context = c;
            this.rcountry = country;
            this.rcapital = capital;
            this.rcurrency = currency;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView cty = row.findViewById(R.id.tv1);
            TextView cap = row.findViewById(R.id.tv2);
            TextView cur = row.findViewById(R.id.tv3);

            // now set our resources on views
            cty.setText(rcountry[position]);
            cap.setText(rcapital[position]);
            cur.setText(rcurrency[position]);

            return row;
        }
    }
}
