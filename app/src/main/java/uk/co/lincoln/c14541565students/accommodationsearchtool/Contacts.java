    package uk.co.lincoln.c14541565students.accommodationsearchtool;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Button;

import java.util.ArrayList;

import javax.crypto.spec.DESedeKeySpec;


    public class Contacts extends Activity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    Button home_button;
    Button contacts_button;

    private SearchView Contacts_searchView;
    private MyListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Accommodation> accommodationList = new ArrayList<Accommodation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        home_button = (Button) findViewById(R.id.home_button);
        contacts_button = (Button) findViewById(R.id.contacts_button);

        ActionBar actionBar = getActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        Contacts_searchView = (SearchView)findViewById(R.id.Contacts_searchView);
        Contacts_searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        Contacts_searchView.setIconifiedByDefault(false);
        Contacts_searchView.setOnQueryTextListener(this);
        Contacts_searchView.setOnCloseListener(this);

        displayList();

        expandAll();
    }

    private void expandAll()
    {
        int count = listAdapter.getGroupCount();
        for(int i = 0; i < count; i++)
        {
            myList.expandGroup(i);
        }
    }

    private void displayList()
    {
       loadSomeData();

       myList = (ExpandableListView) findViewById(R.id.Contacts_listView);

       listAdapter = new MyListAdapter(Contacts.this, accommodationList);

       myList.setAdapter(listAdapter);
    }

    private void loadSomeData()
    {
        ArrayList<Details> detailsList = new ArrayList<Details>();
        Details details = new Details("The Student Village", "Lincoln Courts, Campus Way, Lincoln, LN6 7GF"
                ,"01522-886214","mball@lincoln.ac.uk", "https://www.lincoln.ac.uk/home/accommodation/oncampus/");
        detailsList.add(details);

        Accommodation accommodation = new Accommodation("On Campus", detailsList);
        accommodationList.add(accommodation);

        detailsList = new ArrayList<Details>();
        details = new Details("Brayford Quay", "Newland, Lincoln, LN1 1YA"
                , "015222-46460","salesenquiries@wearehomesforstudents.com", "http://www.wearehomesforstudents.com/property/brayfordquay/");
        detailsList.add(details);
        details = new Details("Hayes Wharf House", "Holmes Rd, Lincoln, LN1 1RF", "01522-930068",
                "hayeswharfhouse@prodigy-living.co.uk.", "https://www.prodigy-living.co.uk/hayes-wharf-house");
        detailsList.add(details);
        details = new Details("The Juxion", "Brayford Wharf E, Lincoln, LN5 7BG", "01522-548562",
                "junxionenquiries@mezzino.co.uk", "http://www.mezzino.co.uk/the_junxion.php");
        detailsList.add(details);
        details = new Details("Park Court", "50 Park St, Lincoln, LN1 1UR", "01522-877777",
                "tsl@touchstonestudentliving.co.uk", "http://www.touchstonestudentliving.co.uk/locations/lincoln/park-court/");
        detailsList.add(details);
        details = new Details("Pavilion House", "The Pavilions Student Village, Ruston Way, Lincoln, LN6 7BQ", "01522-525757",
                "pavilionhouse@prodigy-living.co.uk", "https://www.prodigy-living.co.uk/pavilion-house");
        detailsList.add(details);

        accommodation = new Accommodation("Partnership Halls", detailsList);
        accommodationList.add(accommodation);

        detailsList = new ArrayList<Details>();
        details = new Details("Aqua House", "Harvey St, Lincoln, LN1 1TE", "08453313317",
                "", "http://www.aquahouselincoln.co.uk/");
        detailsList.add(details);
        details = new Details("Brayford Court", "57-59 Carholme Rd, Lincoln, LN2 1RS", "01522-780020",
                "enquiries@lighthouse-properties.co.uk", "http://www.brayfordcourt.co.uk/");
        detailsList.add(details);
        details = new Details("Catherdral Street Apartments", "Cathedral Street, Lincoln, LN2 5HH",
                "01432367276", "", "http://www.condorproperties.co.uk/");
        detailsList.add(details);
        details = new Details("College Mews", "2 Holmes Rd, Lincoln, LN1 1RF", "01522885580",
                "enquiries@lincsproperties.co.uk","http://www.lincsproperties.co.uk/");
        detailsList.add(details);
        details = new Details("Danesgate House", "49 Clasketgate, Lincoln, LN2 1LA", "01522543838",
                "DanesgateHouse@wearehomesforstudents.com", "http://www.wearehomesforstudents.com/property/danesgate-house/");
        detailsList.add(details);
        details = new Details("Hayes House", "Holmes Rd, Lincoln, LN1 1RF", "01522930068", " hayeswharfhouse@prodigy-living.co.uk",
                "https://www.prodigy-living.co.uk/cities/lincoln/hayes-wharf-house");
        detailsList.add(details);
        details = new Details("Park View", "High St, Lincoln, LN5 8BG", "01522220800",
                "info@unittlettings.com", "http://www.unitylettings.com/listings/park-view-5-lincoln/");
        detailsList.add(details);

        accommodation = new Accommodation("University Associate Halls", detailsList);
        accommodationList.add(accommodation);

        detailsList = new ArrayList<Details>();
        details = new Details("Lincoln Student Pad", "Residential Services , University of Lincoln, Brayford Pool, Lincoln, LN6 7TS",
                "", "", "http://www.lincolnstudentpad.co.uk/Accommodation");
        detailsList.add(details);

        accommodation = new Accommodation("Private Sector Shared House Scheme", detailsList);
        accommodationList.add(accommodation);

        detailsList = new ArrayList<Details>();
        details = new Details("The Gateway", "Ruston Way, Lincoln, LN6 7DB", "01522837115", "", "http://www.lincoln.ac.uk/home/accommodation/");
        detailsList.add(details);
        details = new Details("St Mark's House", "St. Mark Street, Lincoln, LN5 7AZ", "", "", "http://www.lincoln.ac.uk/home/accommodation/");
        detailsList.add(details);
        details = new Details("Saul House", "Saul house, Ruston Way, Lincoln, LN6 7FQ", "01522797307", "info@aps-properties.com", "http://www.aps-properties.com/Pages/Saul_House");
        detailsList.add(details);

        accommodation = new Accommodation("University Accommodation Agency", detailsList);
        accommodationList.add(accommodation);


    }

    public void onHomeClick(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

    public void buttonOnClick(View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }
}


