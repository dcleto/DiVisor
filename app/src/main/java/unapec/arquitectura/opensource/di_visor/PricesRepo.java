package unapec.arquitectura.opensource.di_visor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Daniel on 17/03/2018.
 */

public class PricesRepo {

    public static List<Price> getSalePrices (){
        ArrayList<Price> priceList = new ArrayList();
        priceList.add(new Price(48.35,"Popular",R.drawable.popular));
        priceList.add(new Price(48.50,"BanReservas",R.drawable.banreservas));
        priceList.add(new Price(48.24,"BHD",R.drawable.bhd));
        priceList.add(new Price(48.60,"Asociacion Popular",R.drawable.asociacion));
        priceList.add(new Price(48.57,"Banesco",R.drawable.banesco));
        priceList.add(new Price(48.40,"Santa Cruz",R.drawable.santacruz));
        priceList.add(new Price(48.28,"Vimenca",R.drawable.vimenca));
        priceList.add(new Price(48.47,"Scotia Bank",R.drawable.scotia));
        Collections.sort(priceList, new Comparator<Price>() {
            @Override
            public int compare(Price price, Price t1) {
                return price.getPrice()> t1.getPrice()?1:-1;
            }

        });
        return priceList;
    }

    public static List<Price> getBuyPrices (){
        ArrayList<Price> priceList = new ArrayList();
        priceList.add(new Price(47.35,"Popular",R.drawable.popular));
        priceList.add(new Price(47.50,"BanReservas",R.drawable.banreservas));
        priceList.add(new Price(47.24,"BHD",R.drawable.bhd));
        priceList.add(new Price(47.60,"Asociacion Popular",R.drawable.asociacion));
        priceList.add(new Price(47.57,"Banesco",R.drawable.banesco));
        priceList.add(new Price(47.40,"Santa Cruz",R.drawable.santacruz));
        priceList.add(new Price(47.28,"Vimenca",R.drawable.vimenca));
        priceList.add(new Price(47.47,"Scotia Bank",R.drawable.scotia));
        Collections.sort(priceList, new Comparator<Price>() {
            @Override
            public int compare(Price price, Price t1) {
                return price.getPrice()> t1.getPrice()?1:-1;
            }

        });
        return priceList;
    }

}
