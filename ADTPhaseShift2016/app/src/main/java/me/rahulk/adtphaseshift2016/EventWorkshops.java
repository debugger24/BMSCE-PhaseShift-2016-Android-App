package me.rahulk.adtphaseshift2016;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import me.rahulk.adtphaseshift2016.adapter.EventAdapter;


public class EventWorkshops extends Fragment {

    public EventWorkshops() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_event_workshops, container, false);
        ListView listView = (ListView) rootview.findViewById(R.id.lstEvent);

        final ArrayList<Event> eventArrayList = new ArrayList<>();

        eventArrayList.add(new Event(1,"Automation - IOT & Architecture","Architecture",true,"nil","Nil","Nil","MESH Hall","24th Sep 2016","3 PM to 5 PM","Vaishnavi S","9019362228","Representatives from two automation company in the industry conducting the seminar based on the theme of ‘Internet Of Things’"));
        eventArrayList.add(new Event(2,"Panel Discussion","Architecture",true,"nil","Nil","Nil","Library Auditorium","23rd Sep 2016","2 PM to 4 PM","Rachana H","9740146274","4-5 architects discuss based on a given topic.\n" +
                "Topic: Contemporary Architecture / Sustainable Architecture"));
        eventArrayList.add(new Event(7,"Astrophotography workshop","Astronomy Club",false,"50/person","Nil","Nil","PG �6003(EE)","24th Sep 2016","10 AM to 1 PM","Akshatha","9945489210","2-3 hour session on the basics of Astrophotography by Mr. Johann Nishat. Learn to capture star trails, deep sky objects and explore the possibilities of applying IOT in astrophotography! Get your Cameras (preferred, not compulsory)."));
        eventArrayList.add(new Event(12,"Molecular Simulations using GROMACS","Bioechnology",false,"100/Head","Nil","Nil","Bio Informatics Lab","24th Sep 2016","10 AM to 4 PM","Avinash K","9741500191","-Gromacs is a molecular dynamics package primarily designed for simulations of proteins, lipids and nucleic acids. \n" +
                "- Workshop involves hands on session on molecular assemblies of liposomes.\n" +
                "-Workshop will follow after a free seminar on the tool. Concepts of IOT may be included in the seminar by the resource person."));
        eventArrayList.add(new Event(18,"Workshop on CFD","Chemical",true,"150/person","Nil","Nil","Chem Lab, 3rd Floor","23rd Sep 9 AM to","24th Sep 5 PM","Shubham","9482100864","Hands on workshop to learn ANSYS from experienced industry personnel. The event will help students understand the uses of computational fluid dynamics and its applications in Internet of things."));
        eventArrayList.add(new Event(24,"Life saving applications of laser scanning","Civil",false,"250/person","Nil","Nil","MV Hall","23rd Sep 2016","10 AM to 2 PM","Manoj V","9538575812","One day workshop on “Life saving applications of laser scanning” in civil engineering perspective will be taught by Ansari Precision Instruments Pvt. Ltd. In case of floods, landslides,during defense, etc. laser scanning technology plays a very important role in identifying people,strategic points in surveying or any particular object. The data monitoring of which will require Internet. Students are required to bring their laptops."));
        eventArrayList.add(new Event(25,"Retrofitting & Maintainance of Structures Using Smart IOT Devices","Civil & ISE",false,"150/person","Nil","Nil","PG EC-6002","24th Sep 2016","9 AM to 2 PM","Nyamgouda","7411858821","In collaboration with Information Science Department.A workshop on maintenance of Buildings using smart devices. Gives an idea of maintenance of buildings using smart devices."));
        eventArrayList.add(new Event(26,"Android App Development Embedded with IoT","Computer Science",false,"250/person","Nil","Nil","CS Lab","24th Sep 2016","10 AM to 5 PM","Ranjini R","8123244404","Content of the workshop:\n" +
                "Cypress BLE Solution Overview\n" +
                "BLE Architecture Overview\n" +
                "Cypress BLE Modules\n" +
                "Set Up and Install PSoC Creator\n" +
                "CySmart Tool\n" +
                "Android Architecture\n" +
                "Developing Android Application to communicate with BLE\n" +
                "Storing the data to google form through Android App\n" +
                "Participants will have to get Laptops, Android Phones."));
        eventArrayList.add(new Event(28,"Current Trends & Opportunites in IoT","Computer Science",true,"100/person","Nil","Nil","PG CS-5004","23rd Sep 2016","3 PM to 5 PM","Nidhi","9845505253","This workshop covers\n" +
                "1. Drawbacks(Security issues) in IoT\n" +
                "2. Current technological trends in IoT\n" +
                "3. Scope for growth(Research opportunities) in IoT\n" +
                "Details:Cloud computing has become an integral part of IoT and performance of sensors largely depending on the performance of cloud. However,due to various challenges in cloud computing such as high latency, intermittent communications,bandwidth and energy constraints, etc., a new paradigm called fog computing is shaping up lately.Moreover, Many of such applications such as remote sensing, AR, VR based communication,etc., require very low latency communication with higher degree of reliability and availability.For such highly demanding applications Tactile Internet has been envisioned. In addition, all these advanced technologies require very sophisticated security and privacy mechanisms in place.Thus in this workshop we plan to start with Fog Computing and Communication –which is more relevant for IoT or Sensor Networks and then proceed towards\n" +
                "Tactile Internet – as the way forward for our future, and the end plan to take up the security/privacy challenges related to IoT frameworks."));
        eventArrayList.add(new Event(29,"IoT & its Applications using Arduino","Computer Science",false,"250/person","Nil","Nil","CS Lab","23rd Sep 2016","10 AM to 5 PM","Sumedha","9663523435","Contents of Workshop :\n" +
                "Introduction to Internet of Things (IoT)\n" +
                "Applications\n" +
                "IoT device Prototype developing using\n" +
                "a.Sensor\n" +
                "b.Actuators\t\n" +
                "Arduino Architecture\n" +
                "Prototype making using Arduino\n" +
                "a.Home automation using Bluetooth\n" +
                "b.Fire alarm alert\n" +
                "c.Smart irrigation system\n" +
                "d.Smart lighting\n" +
                "e.Reverse parking system\n" +
                "f.Weather monitoring\n" +
                "g.Identification system using RFID\n" +
                "h.Infrared Red technique"));
        eventArrayList.add(new Event(34,"Workshop on understanding Business Architecture in IoT context","Computer Science",true,"100/person","Nil","Nil","PG CS-5001","23rd 10 AM - 1 PM","24th 2 PM - 5 PM","Nidhi Jagadeesha","9845505253","Details: A Workshop on Understanding Business Architecture in IoT Context to bring Human Value.  A Case Study on Concept of Design & Architecture to meet this expectation. Get a Glimpse of What Industry perceives as “VALUE from Technology”. It has Work Bench to learn hands on.\n" +
                "Outcomes: IASA Global will identify young innovators, who can nurture with BMSCE and Industry collaborators in the next few years of their journey to become Professionals in Information Technology, Applied Engineering, Industry Business Modeling and Process with Innovation Themes (IoT, Cloud etc.) & Business Value and Capability Mapping. It’s a Cross Engineering student benefit. It’s meant for both UG and PG Students.\n" +
                "Things participants should carry: Laptops.\n"));
        eventArrayList.add(new Event(36,"IoT with Intel Edison","EEE and EIE",true,"100/person","Nil","Nil","IT Computer Lab","24th Sep 2016","10 AM to 4 PM","Deeksha","8553928159","Hands on Workshop followed by encouragement of students to pitch their project ideas and submit via registration form to student yatra team of Intel.\n" +
                "Workshop Followed By Competition. Intel have come up with new microcontroller based boards called ‘Edison’ which designed for expert makers, entrepreneurs, and some industrial IOT applications. This workshop will be hands on with resource persons from Intel conducting the workshop."));
        eventArrayList.add(new Event(38,"IoT in Application of Renewables Workshop","Electrical and Electronics",false,"100/person","Nil","Nil","Library Auditorium","24th Sep 2016","10 AM to 5 PM","Kavya R","9686302812","The participants will be exposed to smart energy systems like smart meters etc.The workshop is organized by a pioneer in the field,Fluxgen Technologies,a start-up ranked among top 50 start-ups of the country.The real life applications of these concepts is infinite,and incorporation of IoT,learnt during the course of the workshop can be applied to other fields also.In addition participants will also be awarded certificates by the organizers."));
        eventArrayList.add(new Event(39,"Machine Learning","Electrical and Electronics",true,"100/person","Nil","Nil","BSN Hall","23rd Sep 2016","10 AM to 5 PM","Sachin K","9060630130","In today's world of IoT and 'Smart systems', it is becoming increasingly popular to add on to the user experience with technology, an element of machine learning, which comprises of techniques like pattern recognition, artificial intelligence to name a few.\n" +
                "This workshop will provide the students an introduction to the world of machine learning, and consequently teach them about the concept of probability theorems, neural networks and data structures, and their applications to develop algorithms for real-life data using suitable programming languages like Python, Java and Julia."));
        eventArrayList.add(new Event(41,"Workshop on Wireless Sensor Networks","Electronics and Communication",false,"200/Team of 3","Nil","Nil","DSP Lab, EC Block 2nd floor","24th Sep 2016","11 AM to 5 PM","Bharath R","8792458460","Resource  person: Intel and Nihon Communications.\n" +
                "The content of the workshop will be:\n" +
                "Interfacing the sensors to a control unit\n" +
                "Communication of real time data from sensors to control unit.\n" +
                "Introduction to Bluemix Cloud Platform\n" +
                "Introduction to IoT application demo.\n" +
                "Tools required for WSN deployment\n" +
                "Cloud storage and analytics.\n" +
                "The workshop will begin with a talk by Intel on IoT and its applications.\n" +
                "The hands on workshop  will be conducted by Nihon Communications."));
        eventArrayList.add(new Event(42,"Workshop on IOT by Mediatek","Electronics and Communication",true,"200/Team of 3","Nil","Nil","Eyantra Lab","24th Sep 2016","11 AM to 5 PM","Jayprakash","9632024724","The students will have a hands on experience with the working of IoT. The various aspects of IoT like hardware, cloud platform and the application device will be discussed. \n" +
                "The LinkitOne Board will be used to interface various other modules like WiFi, GPS and GSM. \n" +
                "It will also explore the different ways to send data to the cloud and show some action on the application device. \n" +
                "Receiving sensor values/data from the application device and reacting to it will be another domain of interest. \n" +
                "Overall workshop aims to teach the students everything that one needs to know about IoT.\n" +
                "Teams of 3, first come first serve. Max teams – 20"));
        eventArrayList.add(new Event(49,"LaTeX Workshop","BMSCE IEEE",false,"200/person","Nil","Nil","BSN Hall","24th Sep 2016","2 PM to 5 PM","Srinivas S","8884171828","LaTex is a free program for mankind scientific and technical documents and is the standard for professional in many STEM fields. Its purpose is to make it easy to write elegant technical documents. All participants will bring their personal laptop. Software will be provided."));
        eventArrayList.add(new Event(56,"IO SQL Workshop","Information Science",false,"100/person","2000 INR","Nil","PG block IS-4002","23rd Sep 3 PM to","24th Sep 5 PM","Jigar","9408849704","An easy way to learn your way around IoT clouds. Attend our Workshop on basics of IOT, SQL, Knowledge about IoT cloud DBMS and queries.  A quiz will be conducted on the contents of the workshop and the winner is given Rs. 2000."));
        eventArrayList.add(new Event(60,"Hands-on Workshop on IoT Applications","Information Science",false,"500/Team of 5","Nil","Nil","nan","23rd 3 PM - 5 PM and","24th 9 AM - 5 PM","Amarnath KV","9980770631","Come and learn IoT applications with Arduino, Raspberry Pi and cutting edge App Integrated Beacon Technology with our hands on workshop on Internet of Things with Ellipsonic. All components and equipment will be provided on a use and return basis.The participants are expected in teams of 5."));
        eventArrayList.add(new Event(61,"Workshop on 'Invest like Warren Buffet'","MBA",false,"100/person","Nil","Nil","MBA classroom 1(PG block 2nd floor)","23rd Sep 2016","11 AM to 1 PM","Madhuri S","9066642452","An Introduction on Warren Buffet and Pillars of Investment and how IoT can be used to make better investments decisions."));
        eventArrayList.add(new Event(62,"High Growth Job Roles for Engineers","MBA",false,"100/person","Nil","NIl","PG block 3rd floor - MBA classroom 2","24th Sep 2016","11 AM to 1 PM","Aishwarya G","7259389543","Industry awareness workshop on data analytics, consulting, market research, digital marketing and IoT."));
        eventArrayList.add(new Event(68,"Workshop on Recent advances in IoT","MCA",false,"50/person","Nil","Nil","nan","nan","nan","Nagashree BA","8904641443","Today IoT is the main force driving change in industries and society. IoT will be the smart technology of tomorrow and 2020 will be the year of IoT. IoT will be seen as the catalyst responsible for leveling the playing field between humans and machines. The objective of the workshop is to explore the recent advances in Internet of Things (IoT). Content: Introduction to IoT Architecture and Technologies.Exploring various use cases of IoT.Current trends in IoT.The future of IoT."));
        eventArrayList.add(new Event(76,"Workshop on Home Automation","Mechanical Engineering",false,"50","Nil","Nil","Mesh hall","24th Sep 2016","10 AM to 1 PM","Shubam","8088439668","This workshop will help participants to get to know about Iot in this field. Mr Aravindan will be briefing them about the current trends in this sector and demonstrate some of the models with his kits."));
        eventArrayList.add(new Event(84,"Project Race","Telecommunication",true,"250/Team of 4-5","Free Kits","Free Kits","MC lab, telecom dept","sepcial","special","Sushmitha","7406997920","The Internet of things can change the way citizens live, travel, and take care of each other. Arduino has been part of the conversation since early on. Teams of 4-5 members will perform in two rounds, first round is a common project to the all the teams followed by second round in which only 3 teams will be selected will be comprise of a little more advanced projects .In both rounds Arduino kits ,user manual and all necessary components are provided to all the teams . First two winners will get to take away their kits with them."));
        eventArrayList.add(new Event(85,"H.A.M","Telecommunication",true,"250/Team of 2-3","Nil","Nil","AC Lab, telecom dept","24th Sep 2016","9 AM to 4 PM","Suman","9980551187","What is the first thing that we do with internet.? communicate. HAM radio is all about the same thing in a more basic way, hence to overcome all its limitations   IOT is the way out. the participants are given an opportunity to learn how to design their own FM receiver in a group of 2-3 which are formed on spot with the basic components provided being R, L, C Components, speaker and an Arduino Kit."));
        eventArrayList.add(new Event(91,"SENSOR TO CLOUD CONNECTIVITY","Electronics & Intrumentation",true,"250/Team of 4-5","Internship","Nil","RK hall","Sepcial","Sepcial","Neha M","8197328283","Interface sensors to cloud by using different communication modules for IoT and INDUSTRIAL INTERNET OF THINGS (IIOT).\n" +
                "Day 1:​ Theory on sensors and communication on with hands on experience to establish IOT framework , Temperature, humidity and CO2 Sensors and Emergency lighting will be used as basic hands on for sensors to communication  modules. IoT demo with Roomba vacuum cleaner – A Multiple sensor , iot enabled moving cart to showcase a complete IoT solution in IoT\n" +
                "Day 2 :​ From gateway to cloud Theory and hands on exercise. ,Web based SCADA widget’s will be built as hands on exercise one Telamon gateway from Sunlux shall be provided for the event.\n" +
                "The event shall have a competition in the second half of  DAY 2 for giving a solution with sensor to cloud connectivity based on workshop learning. Use of Object Oriented Programming / C Programming or  modelling software to interface various types of sensors. Teams of 4 or 5."));


        EventAdapter eventAdapter = new EventAdapter(getContext(), eventArrayList);
        listView.setAdapter(eventAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), EventDetails.class);
                intent.putExtra("details", eventArrayList.get(position));
                getActivity().startActivity(intent);
            }
        });

        return rootview;
    }
}
