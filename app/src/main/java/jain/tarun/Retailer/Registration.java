package jain.tarun.Retailer;

/**
 * Created by atul on 27/3/17.
 */

public class Registration {

    public String Nameofcompany;
    public double latitude;
    public double longitude;
    public String licence;
    public String phone;
    public String username;
    public String password;

    public Registration(String Nameofcompany, double latitud, double longitude, String licence, String phone, String username, String password)
    {
       this.username=username;
        this.Nameofcompany=Nameofcompany;
        this.latitude=latitud;
        this.longitude=longitude;
        this.licence=licence;
        this.phone=phone;
        this.password=password;
    }


}
