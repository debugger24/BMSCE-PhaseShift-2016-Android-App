package me.rahulk.adtphaseshift2016;

import java.io.Serializable;

/**
 * Created by rahulcomp24 on 10/09/16.
 */
public class Event implements Serializable{
    private int id;
    private String title;
    private String department;
    private boolean bmsce;
    private String prize1;
    private String prize2;
    private String coordinator;
    private String coordinatorNumber;
    private String regFees;
    private String venue;
    private String date;
    private String time;
    private String description;
    private String eventCover;
    private String eventIcon;

    public Event(int id, String title, String department, boolean bmsce, String regFees, String prize1, String prize2, String venue, String date, String time, String coordinator, String coordinatorNumber, String description) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.bmsce = bmsce;
        this.regFees = regFees;
        this.prize1 = prize1;
        this.prize2 = prize2;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.coordinator = coordinator;
        this.coordinatorNumber = coordinatorNumber;
        this.description = description;

    }

    public int getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public boolean getBMSCE() {
        return bmsce;
    }

    public String getPrize1() {
        return prize1;
    }

    public String getPrize2() {
        return prize2;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public String getCoordinatorNumber() {
        return coordinatorNumber;
    }

    public String getRegFees() {
        return regFees;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
