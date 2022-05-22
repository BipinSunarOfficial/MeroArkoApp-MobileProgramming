package com.example.meroarkoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter  extends BaseAdapter {
    private List<Product> productList = new ArrayList<>();
    private Context context;

    ListAdapter(List<Product> productList, Context mContext){
        this.productList.addAll(productList);
        context = mContext;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewData = layoutInflater.inflate(R.layout.adapter_product,null);
        ViewHolder holder = new ViewHolder(viewData);

        holder.txtTitle.setText(productList.get(position).getTitle());
        holder.txtDescription.setText(productList.get(position).getDescription());
        holder.txtUnit.setText(productList.get(position).getUnit());
        holder.txtPrice.setText(productList.get(position).getPrice());

        return viewData;
    }


    public  static class ViewHolder{
        public ViewHolder(View view)
        {
            txtTitle = view.findViewById(R.id.txtProductTitle);
            txtDescription = view.findViewById(R.id.txtProductDesc);
            txtUnit = view.findViewById(R.id.txtProductUnit);
            txtPrice = view.findViewById(R.id.txtProductPrice);
        }

        public TextView txtTitle,txtDescription,txtUnit,txtPrice;
    }
}
