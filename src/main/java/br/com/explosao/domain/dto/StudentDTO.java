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
    @Size(max = 128,  message = "Student Phone List characters should not be bigger then 128 ")
    String phoneList;
    @Size(max = 128,  message = "Student Guardian Name characters should not be bigger then 128 ")
    String guardianName;
    String guardianSignature;
    @Size(max = 32,  message = "Classroom Name characters should not be bigger then 128 ")
    String cpf;
    @Size(max = 32,  message = "Classroom Registration characters should not be bigger then 128 ")
    String registration;
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

    public String getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(String phoneList) {
        this.phoneList = phoneList;
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneList='" + phoneList + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianSignature='" + guardianSignature + '\'' +
                ", cpf='" + cpf + '\'' +
                ", registration='" + registration + '\'' +
                ", birthday=" + birthday +
                ", updatedAt=" + updatedAt +
                ", insertedAt=" + insertedAt +
                '}';
    }
}
