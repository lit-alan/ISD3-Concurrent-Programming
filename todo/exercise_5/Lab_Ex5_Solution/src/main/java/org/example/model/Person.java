package org.example.model;

public class Person {
    private String id;
    private String name;
    private int age;
    private String address;
    private boolean employed;
    private boolean hasFullDrivingLicence;

    public Person(String id, String name, int age, String address, boolean employed, boolean hasFullDrivingLicence) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.employed = employed;
        this.hasFullDrivingLicence = hasFullDrivingLicence;
    }

    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isHasFullDrivingLicence() {
        return hasFullDrivingLicence;
    }

    public void setHasFullDrivingLicence(boolean hasFullDrivingLicence) {
        this.hasFullDrivingLicence = hasFullDrivingLicence;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", employed=" + employed +
                ", hasFullDrivingLicence=" + hasFullDrivingLicence +
                '}';
    }
}
