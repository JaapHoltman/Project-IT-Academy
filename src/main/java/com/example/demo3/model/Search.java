package com.example.demo3.model;

public class Search {


    String search;

    public Search() {
    }

    public Search(String search) {

        this.search = search;
    }


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Search{" +
                "search='" + search + '\'' +
                '}';
    }
}
