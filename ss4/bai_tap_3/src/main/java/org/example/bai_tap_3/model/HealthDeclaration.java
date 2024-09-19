package org.example.bai_tap_3.model;

public class HealthDeclaration {
    private String name;
    private String birthYear;
    private String gender;
    private String nationality;
    private String passport;
    private String departureDate;
    private String returnDate;
    private String province;
    private String address;
    private String phone;
    private String email;
    private String fever;
    private String vomit;
    private String cough;
    private String diarrhea;
    private String exposure;
    private String contact;

    public HealthDeclaration() {
    }

    public HealthDeclaration(String name, String birthYear, String gender, String nationality, String passport, String departureDate, String returnDate, String province, String address, String phone, String email, String fever, String vomit, String cough, String diarrhea, String exposure, String contact) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.nationality = nationality;
        this.passport = passport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.province = province;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.vomit = vomit;
        this.cough = cough;
        this.diarrhea = diarrhea;
        this.exposure = exposure;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit = vomit;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(String diarrhea) {
        this.diarrhea = diarrhea;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
