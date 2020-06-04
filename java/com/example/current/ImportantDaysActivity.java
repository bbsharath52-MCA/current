package com.example.current;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ImportantDaysActivity extends AppCompatActivity {

    ListView listView;
    String date[] = {"-----DATE-----","Jan 1","Jan 15","Jan 23","Jan 26","Jan 26","Jan 28","Jan 28","Jan 30","","",
            "Feb 4","Feb 5","Feb 6","Feb 12","Feb 12","Feb 14","Feb 20","Feb 21","Feb 22","Feb 23","","",
            "Mar 4","Mar 8","Mar 13","Mar 13","Mar 15","Mar 20","Mar 20","Mar 21","Mar 21","Mar 21","Mar 22","Mar 23","Mar 24","Mar 24","Mar 25","Mar 27","","",
            "April 2","April 7","April 17","April 18","April 22","April 23","April 25","April 29","","",
            "May 1","May 3","May 4","May 8","May 9","May 11","May 12","May 14","May 15","May 17","May 21","May 31","","",
            "June 4","June 5","June 7","June 8","June 12","June 14","June 17","June 20","June 23","June 23","June 26","June 27","","",
            "July 1","July 11","July 12","July 18","July 28","July 30","","",
            "August 3","August 5","August 9","August 12","August 15","August 23","August 29","","",
            "September 5","September 7","September 8","September 14","September 16","September 21","September 25","September 27","","",
            "October 1","October 2","October 3","October 4","October 5","October 8","October 9","October 11","October 12","October 14","October 15","October 16","October 17","October 20","October 24","October 31","","",
            "November 1","November 5","November 9","November 14","November 16","November 17","November 17","November 18","November 19","November 20","November 21","November 21","November 25","November 26","November 30","","",
            "December 1","December 2","December 2","December 3","December 3","December 4","December 5","December 7","December 9","December 10","December 10","December 11","December 14","December 18","December 19","December 20","December 29","-----",
    };
    String event[] = {"-----EVENT-----","Global Family Day","Army Day","Netaji Subhash Chandra Bose’s birth anniversary","Republic Day","International Customs day","Birth anniversary of Lala Lajpat Rai","Data Protection Day","World Leprosy Eradication Day","","",
            "World Cancer Day","Kashmir Day","International Day against Female Genital Mutilation","Darwin Day","World Day of the Sick","Valentine’s Day","World Day of Social Justice","International Mother Language Day","World Scout Day","World Peaces and Understanding Day","","",
            "World Day of the Fight Against Sexual Exploitation"," International Womens’ Day","World Kidney Day","World Rotaract Day","World Consumer Rights Day","International Day of the Francophonie","World Day of Theatre for Children and Young People","World Sleep Day","World Forestry Day","International Day for the Elimination of Racial Discrimination"," World Water Day","World Meteorological Day"," World TB Day","International Day for Achievers","International Day of Remembrance – Victims of Slavery and Transatlantic Slave Trade","World Drama Day","","",
            "World Austism Awareness Day","World Health Day","World Haemophilia Day","World heritage Day","Earth Day","World Book and Copyright Day","World Malaria Day","International Dance Day","","",
            "International Labour day","Press Freedom Day","Coal Miners day","World Red Cross day","Victory Day","National Technology Day","International Nurses day","World Migratory day","International Day of the Family","World Information Society Day","Anti-Terrorism Day","World No Tobacco Day","","",
            "International day of Innocent Children Victims of Aggression"," World Environment Day","International Level Crossing Awareness Day","World oceans Day","World Day against Child Labour","World Blood Donor day","World Day to Combat Desertification and Drought","World Refugee Day","United Nations Public Service Day"," International widow’s day","International Day against Drug Abuse and IIlicit Trafficking","International Diabetes Day","","",
            "National doctor’s Day","World Population Day","Malala Day","Nelson Mandela International Day","World Nature Conservation day","International Day of Friendship","","",
            "Independence Day of Niger","Independence Day of Upper Volta","International day of the World’s Indigenous People","International Youth Day","Independence Day (India )"," Internatinal Day for the Remembrance of the Slave Trade and its Abolition"," National Sports Day ( Birthday of Dhyan Chand )","","",
            "Teacher’s Day (Dr. Radhakrishnan’s Birth Day)","  Forgiveness Day","International Literacy Day","Hindi day,World First Aid Day","World Ozone Day","International Day of Peace, World Alzheimer’s day","Social Justice Day"," World Tourism Day","","",
            "International Day of Older Persons","International day of Non-Violence","World Nature Day, World Habitat Day","World Animal Day","World Teacher’s Day","Indian Airforce Day","World Post Day","International Girl Child Day", "World Arthritis Day","World Standards Day","World Students Day","World Food day","International Day for the Eradication of Poverty","World Statistics Day","United Nations Day","World Thrift Day","","",
            "world vegan Day","World Radiography Day","World Services Day","Children’s Day (Birth Anniversary of Jawaharlal Nehru)"," International Day for Endurance"," International students Day","National Journalism Day","World Adult Day","World Citizen Day","Universal Children’s Day","World Television Day","World Fisheries day","World Non-veg Day","Law Day"," Flag Day","","",
            "World AIDS Day","World Computer Literacy Day","International Day for the Abolition of Slavery"," International Day of People with Disability","World Conservation Day","Navy Day","International Volunteer Day for Economic and Social Development","International Civil Aviation Day","The International Day Against Corruption","International Day of Broadcasting","Human Rights Day"," International Mountain Day","World Energy Day","International Migrants Day","Goa’s Liberation Day","International Human Solidarity Day"," International Biodiversity Day","-----",
    };
    String theme[] = {"-----THEME-----","","","","Sangat and Pangat","A secure business environment for economic development","","","Zero disabilities in boys and girls","","",
            "Reduce the illness and related deaths by 2020","","End FGM","","","","Workers on the move: the quest for social justice","Linguistic diversity and multilingualism: keystones of sustainability and peace","impact","","","",
            "Press for Progress","","","Making Digital Marketplaces Fairer","","","","Forests and Sustainable Cities","Promoting tolerance, inclusion, unity and respect for diversity in the context of combating racial discrimination."," Nature for Water","Weather-ready, climate-smart","Wanted: Leaders for a TB-free world","","Remember Slavery: Triumphs and Struggles for Freedom and Equality","","","","",
            "Empowering women and girls with autism","Universal Health Coverage: Everyone, Everywhere","Sharing Knowledge makes us stronger","Heritage for Generations","End Plastic Pollution","Reading: It’s my right!"," Ready to beat Malaria","","","",
            "Uniting Workers for Social and Economic Advancement","Keeping Power in Check: Media, Justice and The Rule of Law","","Memorable smiles from around the world","","Science and Technology for a Sustainable Future","Nurses A Voice to Lead – Health is a Human right","","Families and inclusive societies","Enabling the positive use of Artificial Intelligence for All","","","","",
            "","Beat Plastic Pollution","","Main focus - to prevent plastic pollution and encourage solutions for a healthy ocean","Main Focus on child labour and the action and efforts needed to eliminate it","Be there for someone else. Give blood. Share life","","Now More Than Ever, We Need to Stand with Refugees’. Celebrated to celebrate the courage, strength and perseverance of millions of refugees","Transforming governance to realize the Sustainable Development Goals","","","","","",
            "Zero tolerance to violence against doctors and clinical establishment","Family Planning is a Human Right","the day of Malala’s Birth was declared as Malala Day by UN General Secretary Ban-Ki-Moon on her 16th Birthday","The Nelson Mandela Foundation is dedicating this year's Mandela Day to 'Action Against Poverty","Earth provides enough to satisfy every man’s needs, but not every man’s greed","","","",
            "","","Indigenous peoples’ migration and movement","","","","Birthday of legendary hockey player Dhyan Chand","","",
            "","","Literacy and Skill Development","","Keep cool and Carry on : The Montreal Protocol","The Right to peace- The Universal Declaration of Human Rights AT 70,     To create Awareness about Alzheimer","","Tourism and the digital transformation","","",
            "Celebrating Older Human Rights Champions","","","","The Right To Education Means Right T A Qualified Teacher","","","With Her-Skilled Girl Force","","","","Our Actions Are Our Future. A 0 Hunger World By2030 Is Possible","Coming Together With Those Farthest Behind To Build An Inclusive World of Universal Respect for Human Rights and Dignity","","","","","",
            "Be Veg Be Healthy","","","","","","","","","Children Are Taking Over And Turning The World Blue","","","","","","","",
            "Know Your Status","To increase awareness of 'Digital divide' and increase access to information technology for disadvantaged communities."," To fighting against slavery and considers bonded labour, forced labour, the worst forms of child labour and trafficking people as modern forms of slavery","Empowering persons with disabilities and ensuring inclusiveness and equality","To protect environment, wildlife and limited natural resources","Indian Navy, Mission-deployed and Combat-ready","","Working together to ensure no Country is left Behind","Together, We Are United Against Corruption","To celebrate the recent Development in Broadcast which are direct satellite broadcasting and the internet as means of reaching foreign, rather than a domestic, audience","Stand Up For Human Rights","#MountainsMatter","To appoint professional, qualified and energetic managers and auditors who have expertise in policy-making, financial management and implementation of energy-related projects","Migration with Dignity","","To maintain international peace and security"," ","-----"

};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_capital_currency);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        ImportantDaysActivity.MyAdapter adapter = new ImportantDaysActivity.MyAdapter(this, date, event, theme);
        listView.setAdapter(adapter);

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rdate[];
        String revent[];
        String rtheme[];

        MyAdapter (Context c, String date[], String event[], String theme[]) {
            super(c, R.layout.row, R.id.tv1, date);
            this.context = c;
            this.rdate = date;
            this.revent = event;
            this.rtheme = theme;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View important_days = layoutInflater.inflate(R.layout.row, parent, false);
            TextView D = important_days.findViewById(R.id.tv1);
            TextView E = important_days.findViewById(R.id.tv2);
            TextView T = important_days.findViewById(R.id.tv3);

            // now set our resources on views
            D.setText(rdate[position]);
            E.setText(revent[position]);
            T.setText(rtheme[position]);

            return important_days;
        }
    }
}
