package Model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private String address;
    private String businessDomain;
    private String url;
    private int rating;
    private List<JobAd> jobAds;

    public Company(String name, String address, String businessDomain, String url, int rating) {
        this.name = name;
        this.address = address;
        this.businessDomain = businessDomain;
        this.url = url;
        this.rating = rating;

        jobAds = new ArrayList<JobAd>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBusinessDomain() {
        return businessDomain;
    }

    public String getUrl() {
        return url;
    }


    public String toString(){
        return "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Domain: " + businessDomain + "\n" +
                "Url: " + url + "\n" +
                "Rating: " + rating + "\n" +
                "Number of ads: " + jobAds.size();
    }
}
