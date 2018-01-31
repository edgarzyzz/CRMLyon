package com.ninja.mexico.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ninja.mexico.model.Visit;
import com.ninja.mexico.ui.activity.R;

import java.util.ArrayList;

/**
 * Created by jorge on 20/01/2018.
 */

public class VisitAdapter extends BaseAdapter {
    ArrayList<Visit> visitArrayList;
    Context context;

    public VisitAdapter(ArrayList<Visit> visitArrayList, Context context) {
        this.visitArrayList = visitArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return visitArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return visitArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Visit visitActual =  visitArrayList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_visit, viewGroup, false);

        }

        TextView txtCompanyItemVisit = convertView.findViewById(R.id.txtCompanyItemVisit);
        TextView  txtDateItemVisit = convertView.findViewById(R.id.txtDateItemVisit);
        TextView  txtAdressItemVisit = convertView.findViewById(R.id.txtAdressItemVisit);
        txtCompanyItemVisit.setText(visitActual.getCompanyName());
        txtDateItemVisit.setText(visitActual.getScheduledDate());
        txtAdressItemVisit.setText(visitActual.getAdress());


        return convertView;

    }
}
