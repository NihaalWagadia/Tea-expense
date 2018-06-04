package com.example.nihaa_000.chaiwalla;
//package admin.lokacart.ict.mobile.com.adminapp.membersearchadapter;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.nihaa_000.chaiwalla.R;

        import java.util.ArrayList;
        //  import admin.lokacart.ict.mobile.com.adminapp.R;
       // import admin.lokacart.ict.mobile.com.adminapp.productsearchadapter.LcSearchAdapter1;

/**
 * Created by clicker on 18/1/18.
 */

public class ExtraClass extends BaseAdapter
{
    Context mContext;
    LayoutInflater inflater;
    TextView textView;
    ArrayList<TPrice> tprice;

    public ExtraClass(Context context, ArrayList<TPrice> list)
    {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        tprice = list;
    }

    public class ViewHolder
    {
        TextView name;
        ImageView imageView;
    }

    @Override
    public int getCount() {
        return tprice.size();
    }

    @Override
    public TPrice getItem(int position) {
        return tprice.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ExtraClass.ViewHolder holder;
        if (view == null)
        {
            holder = new ExtraClass.ViewHolder();
            view = inflater.inflate(R.layout.rowlayout, null);
//            holder.name = (TextView) view.findViewById(R.id.product_name);
//            holder.imageView=(ImageView) view.findViewById(R.id.ivSelected);
              holder.name = (TextView) view.findViewById(R.id.txt_tea);

            view.setTag(holder);
        } else
        {
            holder = (ExtraClass.ViewHolder) view.getTag();
        }
        TPrice teaprice1 = getItem(position);
        holder.name.setText(teaprice1.getName());

        return view;
    }



}
