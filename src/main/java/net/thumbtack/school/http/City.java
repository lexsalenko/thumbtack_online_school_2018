package net.thumbtack.school.http;

public class City {
    private int id;
    private String capital_city_name;

    public City(int id, String capital_city_name) {
        this.id = id;
        this.capital_city_name = capital_city_name;
    }

    public City(String capital_city_name) {
        this.id = 0;
        this.capital_city_name = capital_city_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return capital_city_name;
    }

    public void setName(String capital_city_name) {
        this.capital_city_name = capital_city_name;
    }
}
