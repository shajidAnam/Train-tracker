package com.example.traintracker;

import java.util.ArrayList;
import java.util.List;

public class Train {
    String t_name,Offday,departureStation,destinationStation,departureTime,arrivalTime;
    int t_no;

    public Train(String t_name, String Offday, String departureStation, String destinationStation, String departureTime, String arrivalTime, int t_no) {
        this.t_name = t_name;
        this.Offday = Offday;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.t_no = t_no;
    }

    public String trainDetail(){


        return ("Train Name: "+t_name+"\n"+"Train No: "+t_no);
    }
    public String trainDescription(){


        return ("Departure Station:"+departureStation+"\t"+"Destination Station: "+destinationStation+"\n"+"Departure Time: "+departureTime+"\t"+"Arrival Time: "+arrivalTime);
    }
}
class Trains {
    List<Train> trains = new ArrayList();
    public void AddTrain(Train train){
        trains.add(train);
    }
    public List<Train> GetTrains()
    {
        return trains;
    }
}

