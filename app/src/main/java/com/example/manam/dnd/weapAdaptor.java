package com.example.manam.dnd;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.example.manam.dnd.Weapons.addWeap;

/**
 * Created by manam on 8/16/2017.
 */

public class weapAdaptor extends RecyclerView.Adapter<weapAdaptor.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    static List<WeapInfo> weapData;
    String namee;
    String bon;
    String dam;
    WeapInfo weapInfo;


    public weapAdaptor(Context context, List<WeapInfo> weapData){
        this.context=context;
        inflater = LayoutInflater.from(context);
        this.weapData = weapData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.weapinfo,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        final WeapInfo current = Weapons.data.get(position);
        //weapData.remove(0);

        holder.name.setText(current.name);
        holder.atkBonus.setText(current.atkBonus);
        holder.damage.setText(current.damage);
        holder.delete.setImageResource(current.iconId);
        holder.weapInf.setImageResource(current.infoId);
        holder.delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(context,"Deleted " + holder.name.getText(), Toast.LENGTH_SHORT).show();
                removeItem(holder.getAdapterPosition());
            }
        });

        addWeap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(position, current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return weapData.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView atkBonus;
        TextView damage;
        ImageButton delete;
        ImageButton weapInf;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.weapName);
            atkBonus = (TextView) itemView.findViewById(R.id.atkBonus);
            damage = (TextView) itemView.findViewById(R.id.damage);
            delete = (ImageButton) itemView.findViewById(R.id.delButton);
            weapInf = (ImageButton) itemView.findViewById(R.id.infoButton);
        }

    }


    public void removeItem(int position){
        weapData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, weapData.size());
    }

    public void addItem(int position, WeapInfo info){
        Weapons.data.add(position,info);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, Weapons.data.size());
    }



}