package com.ue.charactersidebar.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ue.charactersidebar.R;
import com.ue.charactersidebar.common.Contact;
import com.ue.charactersidebar.common.EasyFloatingImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MyLetterSectionActivity extends AppCompatActivity {

    @BindView(R.id.section_rv)
    RecyclerView sectionRv;
    @BindView(R.id.section_sidebar)
    MyRecyclerViewSidebar sectionSidebar;
    @BindView(R.id.section_floating_iv)
    EasyFloatingImageView sectionFloatingIv;
    @BindView(R.id.section_floating_tv)
    TextView sectionFloatingTv;
    @BindView(R.id.section_floating_rl)
    RelativeLayout sectionFloatingRl;

    private MultiTypeAdapter contactAdapter;
    private Items items;
    private List<MySection>mySectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_letter_section);
        ButterKnife.bind(this);

        sectionRv.setLayoutManager(new LinearLayoutManager(this));
        contactAdapter=new MultiTypeAdapter();
        contactAdapter.register(MySection.class,new MySectionVBinder());
        contactAdapter.register(Contact.class,new ContactVBinder());
        sectionRv.setAdapter(contactAdapter);

        initData();

        contactAdapter.setItems(items);
        contactAdapter.notifyDataSetChanged();

        sectionSidebar.setSections(mySectionList);
        sectionSidebar.setFloatView(sectionFloatingRl);
        sectionSidebar.setOnTouchSectionListener(new MyRecyclerViewSidebar.OnTouchSectionListener() {
            @Override
            public void onTouchLetterSection(MySection letterSection) {
                sectionFloatingTv.setVisibility(View.VISIBLE);
                sectionFloatingIv.setVisibility(View.INVISIBLE);
                sectionFloatingTv.setText(letterSection.letter);
                ((LinearLayoutManager)sectionRv.getLayoutManager()).scrollToPositionWithOffset(letterSection.position, 0);
            }
        });
    }

    public void initData(){
        String[] letterArray = {"A","B","C", "D","E","F", "H", "K", "P", "Q", "R", "U", "X" };

        items=new Items();
        mySectionList=new ArrayList<>();
        for(int i=0,len=letterArray.length;i<len;i++){
            MySection mySection=new MySection(letterArray[i],items.size());
            items.add(mySection);
            items.addAll(getContacts(letterArray[i]));
            mySectionList.add(mySection);
        }
    }

    public List<Contact> getContacts(String letter){
        List<Contact>contactList=new ArrayList<>();
        contactList.add(new Contact(0,letter+"ling"));
        contactList.add(new Contact(0,letter+"qing"));
        contactList.add(new Contact(0,letter+"ying"));
        return contactList;
    }
}
