package br.com.explosao.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLASSROOM")
public class ClassroomEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @Column(name = "CLASSROOM_NAME")
    String classroomName;
    @Column(name = "WEEK_DAY")
    Integer weekDay;
    @Column(name = "CLASSROOM_TIME")
    String classroomTime;
    @Column(name = "CLASSROOM_END_TIME")
    String classroomEndTime;
    @Column(name = "PROFESSOR_NAME")
    String professorName;
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;
    @Column(name= "STATUS")
    Boolean status;
    @Column(name = "INSERTED_AT")
    LocalDateTime insertedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public String getClassroomTime() {
        return classroomTime;
    }

    public void setClassroomTime(String classroomTime) {
        this.classroomTime = classroomTime;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public String getClassroomEndTime() {
        return classroomEndTime;
    }

    public void setClassroomEndTime(String classroomEndTime) {
        this.classroomEndTime = classroomEndTime;
    }

    @Override
    public String toString() {
        return "ClassroomEntity{" +
                "id=" + id +
                ", classroomName='" + classroomName + '\'' +
                ", weekDay=" + weekDay +
                ", classroomTime='" + classroomTime + '\'' +
                ", classroomEndTime='" + classroomEndTime + '\'' +
                ", professorName='" + professorName + '\'' +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                ", insertedAt=" + insertedAt +
                '}';
    }
}





