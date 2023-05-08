package br.com.explosao.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;

    @Size(max = 128,  message = "Student Name characters should not be bigger then 128 ")
    @NotBlank
    String name;
    @Size(max = 32,  message = "Student Phone characters should not be bigger then 128 ")
    String phoneNumber;
    @Size(max = 128,  message = "Student Guardian Name characters should not be bigger then 128 ")
    String guardianName;
    String guardianSignature;
    @Size(max = 32,  message = "Guardian phone number characters should not be bigger then 128 ")
    String guardianPhoneNumber;
    @Size(max = 32,  message = "Student Name characters should not be bigger then 32 ")
    String cpf;
    @Size(max = 32,  message = "Student Registration characters should not be bigger then 32 ")
    String registration;
    String address;
    String city;
    String neighborhood;
    String studentNotes;
    String birthday;
    LocalDateTime updatedAt;
    LocalDateTime insertedAt;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianSignature='" + guardianSignature + '\'' +
                ", guardianPhoneNumber='" + guardianPhoneNumber + '\'' +
                ", cpf='" + cpf + '\'' +
                ", registration='" + registration + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", studentNotes='" + studentNotes + '\'' +
                ", birthday='" + birthday + '\'' +
                ", updatedAt=" + updatedAt +
                ", insertedAt=" + insertedAt +
                '}';
    }
}
