package com.ue.charactersidebar.my;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ue.charactersidebar.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by hujiang on 2017/4/5.
 */

public class MySectionVBinder extends ItemViewBinder<MySection,MySectionVBinder.ViewHolder>{

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View layoutView=inflater.inflate(R.layout.item_my_section,parent,false);
        return new ViewHolder(layoutView);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MySection item) {
        holder.mSectionHeaderTv.setText(item.letter);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mSectionHeaderTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mSectionHeaderTv= (TextView) itemView.findViewById(R.id.section_header_tv);
        }
    }
}
