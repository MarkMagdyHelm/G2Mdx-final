package com.example.dev_2.g2mdx.Fragments.CardFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dev_2.g2mdx.Click;
import com.example.dev_2.g2mdx.Home;
import com.example.dev_2.g2mdx.R;
import com.squareup.picasso.Picasso;

public class RecyclerAdapter1 extends
        RecyclerView.Adapter<RecyclerAdapter1.ViewHolder> implements Click{

    private String[] titles  ;
    private String[] details;
    private String[] images;
    private Context context;


    public RecyclerAdapter1(String[] titels, String[] detals, String[] img, Context context) {
        this.titles=titels;
        this.details=detals;
        this.images=img;
        this.context = context;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout1, viewGroup, false);

        ImageView i=v.findViewById(R.id.item_image);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }
public  String imgUrl;
    @Override
    public void onBindViewHolder(final RecyclerAdapter1.ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.hid.setText("http://shaleh4u.com/photos/"+images[i]);
        Picasso.
                with(context).
                load("http://shaleh4u.com/photos/"+images[i]).
                into( viewHolder.itemImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((Home)context).onButtonClick(viewHolder.itemTitle.getText().toString(),viewHolder.itemDetail.getText().toString(),viewHolder.hid.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;

    }

    @Override
    public void onButtonClick(String about) {

    }

    @Override
    public void onButtonClick(String about, String detal, String imag) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public TextView hid;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage =
                    (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle =
                    (TextView)itemView.findViewById(R.id.item_title);
            hid =
                    (TextView)itemView.findViewById(R.id.Answers);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);
        }


    }
}