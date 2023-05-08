package br.com.explosao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(name = "NAME")
    String name;
    @Column(name = "PHONE_NUMBER")
    String phoneNumber;
    @Column(name = "GUARDIAN_PHONE_NUMBER")
    String guardianPhoneNumber;
    @Column(name = "GUARDIAN_NAME")
    String guardianName;
    @Column(name = "GUARDIAN_SIGNATURE")
    String guardianSignature;
    @Column(name = "CPF")
    String cpf;
    @Column(name = "REGISTRATION")
    String registration;
    @Column(name = "BIRTHDAY")
    LocalDateTime birthday;
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;
    @Column(name = "INSERTED_AT")
    LocalDateTime insertedAt;
    @Column(name = "ADDRESS")
    String address;
    @Column(name = "CITY")
    String city;
    @Column(name = "NEIGHBORHOOD")
    String neighborhood;
    @Column(name = "STUDENT_NOTES")
    String studentNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianSignature() {
        return guardianSignature;
    }

    public void setGuardianSignature(String guardianSignature) {
        this.guardianSignature = guardianSignature;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(LocalDateTime insertedAt) {
        this.insertedAt = insertedAt;
    }

    public String getGuardianPhoneNumber() {
        return guardianPhoneNumber;
    }

    public void setGuardianPhoneNumber(String guardianPhoneNumber) {
        this.guardianPhoneNumber = guardianPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStudentNotes() {
        return studentNotes;
    }

    public void setStudentNotes(String studentNotes) {
        this.studentNotes = studentNotes;
    }

    @PrePersist
    private void prePersistFunction(){
        this.updatedAt = LocalDateTime.now();
        this.insertedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdateFunction(){
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", guardianPhoneNumber='" + guardianPhoneNumber + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianSignature='" + guardianSignature + '\'' +
                ", cpf='" + cpf + '\'' +
                ", registration='" + registration + '\'' +
                ", birthday=" + birthday +
                ", updatedAt=" + updatedAt +
                ", insertedAt=" + insertedAt +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", studentNotes='" + studentNotes + '\'' +
                '}';
    }
}


