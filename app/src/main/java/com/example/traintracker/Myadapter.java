package com.example.traintracker;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyviewHolder> {
    Context context;
    String[] trainName;
    Trains trains = new Trains();
    Dialog myDialogue;





    public Myadapter(Context context, String[] trainName) {
        this.context = context;
        this.trainName = trainName;


    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.viewdesign,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyviewHolder holder, final int position) {
        holder.textView.setText(trainName[position]);
        PopulateTrains();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopulateTrains();
                List<Train> trainsList = trains.GetTrains();
                final Train tr = trainsList.get(position);
                myDialogue=new Dialog(context);
                myDialogue.setContentView(R.layout.dialogue_train_details);
                 TextView train_name=myDialogue.findViewById(R.id.train_name_tv_ID);
                 TextView train_no=myDialogue.findViewById(R.id.train_no_tv_ID);
                 TextView departure_station=myDialogue.findViewById(R.id.train_departureStation_tv_ID);
                 TextView departure_time=myDialogue.findViewById(R.id.train_departureTime_tv_ID);
                 TextView arrival_station=myDialogue.findViewById(R.id.train_ArrivalStation_tv_ID);
                 TextView arrival_time=myDialogue.findViewById(R.id.train_ArrivalTime_tv_ID);
                 TextView train_offday=myDialogue.findViewById(R.id.train_offday_tv_ID);
                 Button tracking_btn=myDialogue.findViewById(R.id.sendMessage_btn_ID);

                 train_name.setText(tr.t_name);
                 train_no.setText("Train No: "+tr.t_no);
                 departure_station.setText("Departure Station: "+tr.departureStation);
                 departure_time.setText("Departure Time: "+tr.departureTime);
                 arrival_station.setText("Arrival Station: "+tr.destinationStation);
                 arrival_time.setText("Arrival Time: "+tr.arrivalTime);
                 train_offday.setText("Off-Day: "+tr.Offday);

                tracking_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int checkPermission= ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);

                        if (checkPermission== PackageManager.PERMISSION_GRANTED)
                        {

                            SmsManager smsManager=SmsManager.getDefault();
                            smsManager.sendTextMessage("16318",null,"tr "+tr.t_no,null,null);
                            Toast.makeText(context,"Message sent",Toast.LENGTH_LONG).show();



                        }
                        else
                        {
                            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.SEND_SMS},0);
                        }



                    }
                });





                myDialogue.show();




            }
        });

    }

    @Override
    public int getItemCount()
    {
        return trainName.length;
    }

    class MyviewHolder extends RecyclerView.ViewHolder  {
        TextView textView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.ViewDesignTxtViewID);

        }


    }

    public void PopulateTrains(){

        trains.AddTrain(new Train("Subarna Express","Friday ","Chittagong","Dhaka","06:40","13:00",701));
        trains.AddTrain(new Train("Subarna Express","Friday","Dhaka","Chittagong","15:00","21:45",702));
        trains.AddTrain(new Train("Mohanagar Goduli","No off day","Chittagong","Dhaka","15:00","22:10",703));
        trains.AddTrain(new Train("Mohanagar Provati","No off day","Dhaka","Chittagong","07:40","15:15",704));
        trains.AddTrain(new Train("Ekota Express","Tuesday","Dhaka","Dinajpur","10:00","19:40",705));
        trains.AddTrain(new Train("Ekota Express","Monday","Dinajpur","Dhaka","21:20","07:15",706));
        trains.AddTrain(new Train("Tista Express","Monday","Dhaka","Dewangong","07:20","12:55",707));
        trains.AddTrain(new Train("Tista Express","Monday","Dewangong","Dhaka","15:00","20:40",708));
        trains.AddTrain(new Train("Parabat  Express","Tuesday","Dhaka","Sylhet","06:40","13:35",709));
        trains.AddTrain(new Train("Parabat  Express","Tuesday","Sylhet","Dhaka","15:00","22:30",710));
        trains.AddTrain(new Train("Upukol Express","Wednesday","Noakhali","Dhaka","06:20","12:40",711));
        trains.AddTrain(new Train("Upukol Express","Tuesday","Dhaka","Noakhali","16:20","22:35",712));
        trains.AddTrain(new Train("Joyantika Express","No off day","Dhaka","Sylhet","12:00","19:50",717));
        trains.AddTrain(new Train("Joyantika Express","Tuesday","Sylhet","Dhaka","08:20","16:00",718));
        trains.AddTrain(new Train("Paharia Express","Monday","Chittagong","Sylhet","08:15","17:30",719));
        trains.AddTrain(new Train("Paharia Express","Saturday","Sylhet","Chittagong","10:15","20:00",720));
        trains.AddTrain(new Train("Mohanagar Provati","Sunday","Chittagong","Dhaka","07:00","14:20",721));
        trains.AddTrain(new Train("Mohanagar Goduli","Sunday","Dhaka","Chittagong","15:20","22:50",722));
        trains.AddTrain(new Train("Uddayan Express","Saturday","Chittagong","Sylhet","21:30","06:30",723));
        trains.AddTrain(new Train("Uddayan Express","Sunday","Sylhet","Chittagong","21:20","06:10",724));
        trains.AddTrain(new Train("Megna Express","No off day","Chittagong","Chandpur","17:00","22:10",729));
        trains.AddTrain(new Train("Megna Express","No off day","Chandpur","Chittagong","05:00","10:40",730));
        trains.AddTrain(new Train("Agnibina Express","No off day","Dhaka","Tarakandi","09:40","15:20",735));
        trains.AddTrain(new Train("Agnibina Express","No off day","Tarakandi","Dhaka","16:30","22:50",736));
        trains.AddTrain(new Train("Egarosindhur Provati","Wednesday","Dhaka","Kisoregonj","08:10","12:15",737));
        trains.AddTrain(new Train("Egarosindhur Provati","No off day","Kisoregonj","Dhaka","06:45","10:50",738));
        trains.AddTrain(new Train("Upaban Express","Wednesday","Dhaka","Sylhet","21:50","05:30",739));
        trains.AddTrain(new Train("Upaban Express","No off day","Sylhet","Dhaka","22:00","05:30",740));
        trains.AddTrain(new Train("Turna Express","No off day","Chittagong","Dhaka","23:00","06:35",741));
        trains.AddTrain(new Train("Turna Express","No off day","Dhaka","Chittagong","23:30","07:10",742));
        trains.AddTrain(new Train("Bharamaputra","No off day","Dhaka","Dewangong","18:00","00:10",743));
        trains.AddTrain(new Train("Bharamaputra","No off day","Dewangong","Dhaka","06:30","12:15",744));
        trains.AddTrain(new Train("Jamuna Express","No off day","Dhaka","BB_East","16:40","00:10",745));
        trains.AddTrain(new Train("Jamuna Express","No off day","BB_East","Dhaka","01:10","08:10",746));
        trains.AddTrain(new Train("Egarosindhur Goduli","No off day","Dhaka","Kisoregonj","18:30","23:10",749));
        trains.AddTrain(new Train("Egarosindhur Goduli","Wednesday","Kisoregonj","Dhaka","12:45","16:55",750));
        trains.AddTrain(new Train("Lalmoni Express","Friday","Dhaka","Lalmonirhat","22:10","08:20",751));
        trains.AddTrain(new Train("Lalmoni Express","Friday","Lalmonirhat","Dhaka","10:40","21:05",752));
        trains.AddTrain(new Train("Drutojan Express","Wednesday","Dhaka","Dinajpur","19:40","05:30",757));
        trains.AddTrain(new Train("Drutojan Express","Wednesday","Dinajpur","Dhaka","07:40","17:55",758));
        trains.AddTrain(new Train("Dolonchapa Express","No off day","Santahar","Dinajpur","13:30","20:30",767));
        trains.AddTrain(new Train("Dolonchapa Express","No off day","Dinajpur","Santahar","05:40","12:20",768));
        trains.AddTrain(new Train("Rangpur  Express","Sunday","Dhaka","Rangpur","09:00","19:00",771));
        trains.AddTrain(new Train("Rangpur  Express","Sunday","Rangpur","Dhaka","20:00","06:15",772));
        trains.AddTrain(new Train("Kalani  Express","Friday","Dhaka","Sylhet","16:00","22:45",773));
        trains.AddTrain(new Train("Kalani  Express","Friday","Sylhet","Dhaka","06:40","13:25",774));
        trains.AddTrain(new Train("Sirajgong  Express","Saturday","Sylhet","Dhaka","06:40","13:25",774));
        trains.AddTrain(new Train("Sirajgong  Express","Saturday","Sylhet","Dhaka","06:40","13:25",774));
        trains.AddTrain(new Train("Sirajgong  Express","Saturday","Sylhet","Dhaka","06:40","13:25",774));
        trains.AddTrain(new Train("Sirajgong  Express","Saturday","Sylhet","Dhaka","06:40","13:25",774));
        trains.AddTrain(new Train("Kapotaskh  Express","Wednesday","Khulna","Rajshahi","06:30","13:10",715));
        trains.AddTrain(new Train("Kapotaskh  Express","Wednesday","Rajshahi","Khulna","14:00","20:50",716));
        trains.AddTrain(new Train("Sundarban  Express","Friday","Khulna","Dhaka","19:30","05:50",725));
        trains.AddTrain(new Train("Sundarban  Express","Saturday","Dhaka","Khulna","06:20","16:20",726));
        trains.AddTrain(new Train("Rupsha  Express","Thrusday","Khulna","Saidpur","07:45","17:15",727));
        trains.AddTrain(new Train("Rupsha  Express","Thrusday","Saidpur","Khulna","07:45","18:00",728));
        trains.AddTrain(new Train("Barendra  Express","Sunday","Rajshahi","Chilahati","15:00","22:15",731));
        trains.AddTrain(new Train("Barendra  Express","Sunday","Chilahati","Rajshahi","05:30","12:35",732));
        trains.AddTrain(new Train("Titumir  Express","Wednesday","Rajshahi","Chilahati","06:30","13:40",733));
        trains.AddTrain(new Train("Titumir  Express","Wednesday","Chilahati","Rajshahi","14:20","22:00",734));
        trains.AddTrain(new Train("Simanta   Express","No off day","Khulna","Saidpur","21:00","06:20",747));
        trains.AddTrain(new Train("Simanta   Express","No off day","Saidpur","Khulna","19:00","04:30",748));
        trains.AddTrain(new Train("Silk city  Express","Sunday","Dhaka","Rajshahi","14:40","21:05",753));
        trains.AddTrain(new Train("Silk city  Express","Sunday","Rajshahi","Dhaka","07:20","13:45",754));
        trains.AddTrain(new Train("Madhumati  Express","Friday","Goalonda hat","Rajshahi","15:00","20:30",755));
        trains.AddTrain(new Train("Madhumati  Express","Friday","Rajshahi","Goalonda hat","07:00","12:30",756));
        trains.AddTrain(new Train("Padma   Express","Tuesday","Dhaka","Rajshahi","23:10","04:50",759));
        trains.AddTrain(new Train("Padma   Express","Tuesday","Rajshahi","Dhaka ","16:00","21:50",760));
        trains.AddTrain(new Train("Sagardari  Express","Monday","Khulna","Rajshahi ","14:50","21:40",761));
        trains.AddTrain(new Train("Sagardari  Express","Monday","Rajshahi","Khulna ","06:10","13:00",762));
        trains.AddTrain(new Train("Chittra   Express","Monday","Khulna","Dhaka ","08:30","18:20",763));
        trains.AddTrain(new Train("Chittra   Express","Monday","Dhaka","Khulna ","19:00","05:10",764));
        trains.AddTrain(new Train("Nilsagar","Monday","Dhaka Cantt","Chilahati ","08:25","18:15",765));
        trains.AddTrain(new Train("Nilsagar","Sunday","Chilahati","Dhaka Cantt ","21:20","07:50",766));
        trains.AddTrain(new Train("Dhumketue express","Tuesday","Dhaka","Rajshahi ","06:00","11:50",769));
        trains.AddTrain(new Train("Dhumketue express","Monday","Rajshahi","Dhaka ","23:20","04:50",770));
        trains.AddTrain(new Train("Moitree  express","No off day","Dhaka Cantt","Kolkata ","08:10","18:45",770));
        trains.AddTrain(new Train("Moitree  express","No off day","Kolkata","Dhaka Cantt ","07:10","18:05",770));
    }
}
