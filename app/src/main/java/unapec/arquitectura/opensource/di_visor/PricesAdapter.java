package unapec.arquitectura.opensource.di_visor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 17/03/2018.
 */

public class PricesAdapter extends RecyclerView.Adapter<PricesAdapter.PriceVH>{

    public PricesAdapter(List<Price> data) {
        this.mData = data;
    }

    private List<Price> mData;

    @Override
    public PriceVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_price,parent,false);
        return new PriceVH(view);
    }

    @Override
    public void onBindViewHolder(PriceVH holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData==null? 0 : mData.size();
    }

    class PriceVH extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_price;
        ImageView iv_logo;

        public PriceVH(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price = itemView.findViewById(R.id.tv_price);
            iv_logo = itemView.findViewById(R.id.iv_logo);
        }

        public void bind(Price price) {
            iv_logo.setImageResource(price.getImageResource());
            tv_title.setText(price.getBank());
            String text = "RD$ %.2f";
            tv_price.setText(String.format(text,((float)price.getPrice())));
        }
    }

}
