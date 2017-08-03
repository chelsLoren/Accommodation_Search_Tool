package uk.co.lincoln.c14541565students.accommodationsearchtool;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Chelsey on 10/03/2016.
 */
public class MyListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<Accommodation> accommodationList;
    private ArrayList<Accommodation> originalList;

    public MyListAdapter(Context context, ArrayList<Accommodation> accommodationList){
        this.context = context;
        this.accommodationList = new ArrayList<Accommodation>();
        this.accommodationList.addAll(accommodationList);
        this.originalList = new ArrayList<Accommodation>();
        this.originalList.addAll(accommodationList);
    }

    @Override
    public int getGroupCount() {
        return accommodationList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Details> detailsList = accommodationList.get(groupPosition).getDetailsList();

        return detailsList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return accommodationList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Details> detailsList = accommodationList.get(groupPosition).getDetailsList();

        return detailsList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Accommodation accommodation = (Accommodation) getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.group_row, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.heading);
        heading.setText(accommodation.getName().trim());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Details details = (Details) getChild(groupPosition, childPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_row, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.Name);
        TextView address = (TextView) convertView.findViewById(R.id.Address);
        TextView telephone = (TextView) convertView.findViewById(R.id.Telephone);
        TextView email = (TextView) convertView.findViewById(R.id.Email);
        TextView website = (TextView) convertView.findViewById(R.id.Website);

        name.setText(details.getName().trim());
        address.setText(details.getAddress().trim());
        telephone.setText(details.getTelephone().trim());
        email.setText(details.getEmail().trim());
        website.setText(details.getWebsite().trim());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){
        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(accommodationList.size()));
        accommodationList.clear();

        if(query.isEmpty()){
            accommodationList.addAll(originalList);
        }else{
            for (Accommodation accommodation: originalList)
            {
               ArrayList<Details> detailsList = accommodation.getDetailsList();
               ArrayList<Details> newList = new ArrayList<Details>();
                for (Details details: detailsList)
                {
                    if(details.getName().toLowerCase().contains(query) ||
                            details.getAddress().toLowerCase().contains(query) ||
                            details.getEmail().toLowerCase().contains(query) ||
                            details.getWebsite().toLowerCase().contains(query) ||
                            details.getTelephone().toLowerCase().contains(query))
                    {
                        newList.add(details);
                    }
                }
                if(newList.size() > 0)
                {
                    Accommodation nAccommodation = new Accommodation(accommodation.getName(), newList);
                    accommodationList.add(nAccommodation);
                }
            }
        }

        Log.v("MyListAdapter", String.valueOf(accommodationList.size()));
        notifyDataSetChanged();
    }
}

