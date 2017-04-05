package com.ue.charactersidebar.my;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ue.charactersidebar.R;
import com.ue.charactersidebar.common.Contact;
import com.ue.charactersidebar.common.GlideUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by hujiang on 2017/4/5.
 */

public class ContactVBinder extends ItemViewBinder<Contact, ContactVBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View layoutView = inflater.inflate(R.layout.item_my_contact, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Contact item) {
        GlideUtils.displayNative(holder.sectionIv,item.resId);
        holder.sectionNameTv.setText(item.name);
    }

     static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView sectionIv;
        TextView sectionNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            sectionIv= (ImageView) itemView.findViewById(R.id.section_iv);
            sectionNameTv= (TextView) itemView.findViewById(R.id.section_name_tv);
        }
    }
}
