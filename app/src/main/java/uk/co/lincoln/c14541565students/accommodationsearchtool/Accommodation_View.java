package uk.co.lincoln.c14541565students.accommodationsearchtool;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Accommodation_View extends Activity{

    Button AVHome_button;
    Button AVContacts_button;
    Button mapview_button;

    ListView listView;
    SearchView searchView;

    String[] names =
            {"The Student Village: The complex is made up of 17 contemporary buildings of self-catered apartments, each one housing five to eight students. In total there are 1,037 furnished student bedrooms. Some apartments have rooms designed specifically for students with disabilities, Standard Price: £4,285.44, En-suite Price: £4,991.31, En-suite rooms available, Fully fitted kitchen, Disabled access, Laundrette facilities, 24-hour on-campus security, Free internet telephone service, Bicycle storage",
            "Brayford Quay: Short walk to city centre amenities. 402 en-suite bed spaces comprising of self-contained studios and five/six bedroom flats. Rent is all inclusive of utility bills, WIFI internet and gym membership. Super Deluxe En-suite: £5,428.00. Standard En-suite: £5,060.00 Standard square En-suite: £4,876.00 .Wi-Fi and broadband internet, Common Room, Gym, Laundrette, Evening Security Team support/CCTV and Out of Hours Call Desk cover. Flat facilities - kitchen/ communal area including TV with Freeview",
            "Hayes Wharf: Hayes Wharf House is a purpose-built student residence overlooking the Brayford Pool campus. Its 224 en-suite bedrooms are provided in shared apartments of two to five bedrooms. En-suite: £5520-£5856. En-suite plus room £6000-£6336. All residents benefit from all-inclusive utility bills, up to 100 Mb Wi-Fi, regular social events at Pavilion House, bike storage, on-site laundry facilities, and secure fob entry to the building.",
            "The Junxion: Located in the city centre, just opposite the university, The Junxion offers 569 en-suite bedrooms provided in four, five or six-bedroom apartments with fully fitted living areas. En-suite plus room £5,448.00. Designed around a central courtyard, facilities include a lounge, laundrette and cash machines. All apartments have leather sofas, 32” LCD televisions, free TV licence for the TV set provided, Freeview and dishwashers. Contents insurance and broadband internet in all bedrooms is included in the rent.",
            "Park Court: Located close to the Brayford Pool campus and a two-minute walk from the city centre, Park Court is a purpose built development offering 289 en-suite study bedrooms arranged as four and five-bedroom apartments with a shared fully fitted kitchen. En-suite: £4,416.00. Facilities include WiFi and Broadband, IPTV, a lounge with 50” Plasma TV, Freeview and DVD player, contents insurance, CCTV and secure fob entry system, on-site laundry facilities and limited on-site parking available.",
            "The Pavillions: Pavillion House is adjacent to the University’s Sports and Recreation Centre. The accommodation provides 1,329 en-suite bed spaces ranging from self-contained studio flats to six-bedroom apartments. En-suite: £5136-5760. Studios: £6120-£9435. Facilities include leather sofas, 32” LCD televisions with free TV licence and Freeview. There is also an on-site launderette. Contents insurance and broadband internet in all bedrooms is included.",
            "Aqua House: Aqua House is situated on the north bank of the Fossdyke canal, on Harvey Street, less than half a mile from the city centre and the main Brayford Pool campus. Small Single Non En-suite: £3,120.00. Large Single Non En-suite: £3,50.00. Large Double Non En-suite: £3,792.00. The building consists of 75 study bedrooms with television and wireless internet access. Kitchens, bathrooms and laundry facilities are shared.",
            "Brayford Court: This secure, purpose-built development of 22 apartments each containing between three and six bedrooms is situated on Carholme Road, only a few minutes walk from the main Brayford Pool campus. Prices for 3,4,5 and 6 Bed Apartments: £4,345.00. Prices for 2 Bed Apartments: £4,840.00. Prices for 1 Bedroom Apartment: £7,150.00. Each kitchen is fully equipped and includes crockery and cutlery. Bedrooms have wireless internet access.",
            "Catherdral Street Apartments: This development of 94 study bed spaces comprises 24 apartments. Apartments range in size from two to six bedrooms with shared kitchens and shower rooms. Prices for 3 Bed Non En-suite: £4,176.00. Prices for 4 Bed Non En-suite: £3,888.00. Prices for 5 Bed Non En-suite: £3,840.00. Each apartment has its own separate lounge with flat screen TV. Inclusive high speed broadband (20Mbps as standard with upgrade option), free Apple TV in every apartment, TV licence, possessions insurance and all bills are included.",
            "College Mews: Located close to the Brayford campus, College Mews has 25 en-suite study bedrooms which have shared kitchens. Standard En-suite: £4,320.00. Large En-suite: £4,560.00. On-site laundry facilities. Free broadband internet.",
            "Danesgate House: Danesgate House is a recently refurbished development with 249 rooms all of which are en-suite. Apartments range in size from 4-16 bedrooms and also includes some studio apartments. En-suite in 4 Bed Cluster: £5,152.00. En-suite in 5 Bed Cluster: £5,152.00. En-suite in 10 Bed Cluster: £4,876.00. All the rooms come with large beds, WiFi, modern en-suites. The shared living area comes complete with sofas and a flat screen TV, along with 100MB WIFI. ",
            "Hayes House: Hayes House is a purpose built student property, providing 39 en-suite rooms within 7 apartments. The building is ideally located only yards away from the main Brayford Pool campus and the City Centre making it an ideal place for both undergraduate and post graduate students to study. En-suite: £5,088.00. Each apartment has its own fully furnished and equipped kitchen and lounge , 32 inch flat screen TV and a dishwasher. The study rooms all have wired and wireless internet, TV points and ¾ beds.",
            "Park View: Park View provides priority accommodation for Nursing students. Located within 15 minutes’ walk of the Brayford Pool Campus, it offers 52 rooms some en-suite. Small Non En-suite: £3,456.00. Standard Non En-suite: £4,608.00. En-suite: £4,944.00. Car parking is available, 60\\TV in Lounge, Aerials to Bedrooms, All Bills Included, Internet ports to Bedrooms, Lounge, TV Rental Available, Wireless Broadband.",
            "The Gateway: Located off Ruston Way, is a brand new development in Lincoln that provides 519 rooms ranging from en-suite bedrooms in cluster flats to studio apartments. En-suite Cluster rooms: £111pw. Studio rooms: £132pw. Each studio apartment contains its own kitchen, sleeping area and ensuite bathroom. The flats comprise six or seven en-suite bedrooms with a communal kitchen. It is situated just a couple of minutes away from the University and five minutes’ walk from the city centre.",
            "St Mark's House: Opened in 2013, St Mark’s House is situated within two minutes’ walk from the main campus. Located on St Mark’s Street,this development offers studio, twin and en-suite shared apartments for undergraduate,postgraduate and international students. From £107 per week, all inclusive. It is inclusive of all utilities, contents insurance and internet.",
            "Saul House: A student development in the heart of the city, designed exclusively for postgraduate, mature and international students. This development is located on Ruston Way and provides 69 fully fitted student rooms within 23 flats of three bedrooms each. Price: £112.00pwk. Each flat contains a fully equipped kitchen, living area and en-suite bathroom. Saul House is located just a couple of minutes away from the University and five minutes’ walk from the city centre."};
    int[] img =
            {R.drawable.accommodationoncampus, R.drawable.brayfordquay, R.drawable.hayeswharf, R.drawable.junxion, R.drawable.parkcourts,
            R.drawable.pavillions, R.drawable.aquahouse, R.drawable.brayfordcourt, R.drawable.cathedralstreet, R.drawable.collegemews,
            R.drawable.danesgate, R.drawable.hayeshouse, R.drawable.parkview, R.drawable.gateway, R.drawable.stmarks, R.drawable.saulhouse};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation__view);

        setTitle("Lincoln Accommodation Search Tool");

        TextView accommodation_pdf = (TextView) findViewById(R.id.accommodation_pdf);
        String linkText = "Visit the <a href='https://www.lincoln.ac.uk/home/media/universityoflincoln/globalmedia/documents/University,of,Lincoln,Accommodation,Prices,16-17,(website,04-03-16).pdf'>Accommodation Prices</a> web page.";
        accommodation_pdf.setText(Html.fromHtml(linkText));
        accommodation_pdf.setMovementMethod(LinkMovementMethod.getInstance());

        AVHome_button = (Button) findViewById(R.id.AVHome_button);
        AVContacts_button = (Button) findViewById(R.id.AVContacts_button);
        mapview_button = (Button) findViewById(R.id.mapview_button);

        listView = (ListView) findViewById(R.id.Results_listView);
        searchView = (SearchView) findViewById(R.id.Results_searchView);

        final Adapter adapter = new Adapter(this, getInformation());
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        ActionBar actionBar = getActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }

    public void HomeonClick(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

    public void ContactsonClick(View v){
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }

    public void mapviewOnClick(View v){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    private ArrayList<Accommodation_Info> getInformation(){
        ArrayList<Accommodation_Info> information = new ArrayList<Accommodation_Info>();
        Accommodation_Info I;

        for(int i=0; i<names.length;i++){
            I = new Accommodation_Info(names[i], img[i]);
            information.add(I);
        }

        return information;
    }

}
