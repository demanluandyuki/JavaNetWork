package com.joyfulmath.sample.javanetwork.androidbase.recycleview.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.joyfulmath.sample.javanetwork.R;

import java.util.ArrayList;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2016-03-10 14:19
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> mDatas;
    public RecycleAdapter(Context context,ArrayList<String> mStrings)
    {
        this.context = context;
        this.mDatas = mStrings;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == R.layout.item_list)
        {
            return new RecycleViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_list,parent,false));
        }
        else
        {
            return new RecycleViewHolder2(LayoutInflater.from(context)
                    .inflate(R.layout.item_list2,parent,false));
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == R.layout.item_list) {
            RecycleViewHolder holder1 = (RecycleViewHolder) holder;
            holder1.tv1.setText(mDatas.get(position));
            holder1.tv2.setText(mDatas.get(position) + " RecycleViewHolder");
        } else if(getItemViewType(position) == R.layout.item_list2)
        {
            RecycleViewHolder2 holder2 = (RecycleViewHolder2) holder;
            holder2.mBtn.setText(mDatas.get(position)+" RecycleViewHolder2");
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int position) {
        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemViewType(int position) {
        if(position%3 == 0)
        {
            return R.layout.item_list;
        }
        else
        {
            return R.layout.item_list2;
        }
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder
    {
        TextView    tv1;
        TextView    tv2;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv_1);
            tv2 = (TextView) itemView.findViewById(R.id.tv_2);
        }
    }


    class RecycleViewHolder2 extends RecyclerView.ViewHolder
    {

        Button mBtn;
        public RecycleViewHolder2(View itemView) {
            super(itemView);
            mBtn = (Button) itemView.findViewById(R.id.btn_new);
        }
    }

}
