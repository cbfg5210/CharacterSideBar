/*
 * Copyright (C) 2016 CaMnter yuanyu.camnter@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ue.charactersidebar.easy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.camnter.easyrecyclerview.widget.EasyRecyclerView;
import com.ue.charactersidebar.R;
import com.ue.charactersidebar.common.Contact;
import com.ue.charactersidebar.common.EasyFloatingImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：LetterSectionActivity
 * Created by：CaMnter
 * Time：2016-04-12 22:42
 */
public class LetterSectionActivity extends AppCompatActivity implements EasyRecyclerViewSidebar.OnTouchSectionListener{
    private EasyRecyclerViewSidebar imageSidebar;
    private TextView imageFloatingTv;
    private EasyFloatingImageView imageFloatingIv;

    public SectionAdapter adapter;
    private EasyRecyclerView imageSectionRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_section);
        setTitle("LetterSectionActivity");
        this.initViews();
        this.initData();
    }


    private void initViews() {
        this.imageSectionRv = (EasyRecyclerView) this.findViewById(R.id.section_rv);
        this.imageSidebar = (EasyRecyclerViewSidebar) this.findViewById(R.id.section_sidebar);
        this.imageFloatingTv = (TextView) this.findViewById(R.id.section_floating_tv);
        this.imageFloatingIv = (EasyFloatingImageView) this.findViewById(R.id.section_floating_iv);
        RelativeLayout imageFloatingRl = (RelativeLayout) this.findViewById(
                R.id.section_floating_rl);

        this.adapter = new SectionAdapter();
        if (this.imageSectionRv != null) {
            this.imageSectionRv.setAdapter(this.adapter);
        }

        this.imageSidebar.setFloatView(imageFloatingRl);
        this.imageSidebar.setOnTouchSectionListener(this);
    }


    private void initData() {
        this.adapter.setList(this.getData());
        this.adapter.notifyDataSetChanged();
        this.imageSidebar.setSections(this.adapter.getSections());
    }


    /**
     * On touch letter section
     *
     * @param sectionIndex sectionIndex
     * @param letterSection letterSection
     */
    @Override public void onTouchLetterSection(int sectionIndex, EasySection letterSection) {
        this.imageFloatingTv.setVisibility(View.VISIBLE);
        this.imageFloatingIv.setVisibility(View.INVISIBLE);
        this.imageFloatingTv.setText(letterSection.letter);
        this.scrollToPosition(this.adapter.getPositionForSection(sectionIndex));
    }


    private void scrollToPosition(int position) {
        this.imageSectionRv.getLinearLayoutManager().scrollToPositionWithOffset(position, 0);
    }


    public static List<Contact>getData(){
        Map<String, String> letter2Name = new HashMap<>();
        Map<String, String> letter2Pinyin = new HashMap<>();
        String[] letterArray = { "C", "D", "F", "H", "K", "P", "Q", "R", "U", "X" };

        List<Contact> letterSectionList = new ArrayList<>();

        letter2Name.put("C", "CaMnter");
        letter2Name.put("D", "drakeet");
        letter2Name.put("F", "Fython");
        letter2Name.put("H", "Harry Chen");
        letter2Name.put("K", "Kaede Akatsuki");
        letter2Name.put("P", "Peter Cai");
        letter2Name.put("Q", "Qixingchen");
        letter2Name.put("R", "Randy");
        letter2Name.put("U", "undownding");
        letter2Name.put("X", "xingrz");

        letter2Pinyin.put("C", "camnter");
        letter2Pinyin.put("D", "drakeet");
        letter2Pinyin.put("F", "fython");
        letter2Pinyin.put("H", "harrychen");
        letter2Pinyin.put("K", "kaedeakatsuki");
        letter2Pinyin.put("P", "petercai");
        letter2Pinyin.put("Q", "qixingchen");
        letter2Pinyin.put("R", "randy");
        letter2Pinyin.put("U", "undownding");
        letter2Pinyin.put("X", "xingrz");

        for (String letter : letterArray) {
            Contact contacts = new Contact();
            contacts.name = letter2Name.get(letter);
            contacts.pinyin = letter2Pinyin.get(letter);
            Contact contacts1 = new Contact();
            contacts1.name = letter + "lingyi";
            contacts1.pinyin = letter.toLowerCase() + "lingyi";
            contacts1.resId = 0;
            Contact contacts2 = new Contact();
            contacts2.name = letter + "linger";
            contacts2.pinyin = letter.toLowerCase() + "linger";
            contacts2.resId = 0;
            letterSectionList.add(contacts);
            letterSectionList.add(contacts1);
            letterSectionList.add(contacts2);
        }
        return letterSectionList;
    }
}
