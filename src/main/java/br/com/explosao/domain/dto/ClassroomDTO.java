package br.com.explosao.domain.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ClassroomDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    @Size(max = 128,  message = "Classroom Name characters should not be bigger then 128 ")
    @NotBlank
    String classroomName;
    @Min(value = 1, message = "Week days should be between 1 and 7")
    @Max(value = 7, message = "Week days should be between 1 and 7")
    @NotNull
    Integer weekDay;
    @Size(max = 5, message = "Classroom Time characters should not be bigger then 8 and should respect this pattern (^\\d{2}:\\d{2}$)")
    @Pattern(regexp = "(^\\d{2}:\\d{2}$)", flags = Pattern.Flag.UNICODE_CASE)
    @NotBlank
    String classroomTime;
    @Size(max = 5, message = "Classroom Time characters should not be bigger then 8 and should respect this pattern (^\\d{2}:\\d{2}$)")
    @Pattern(regexp = "(^\\d{2}:\\d{2}$)", flags = Pattern.Flag.UNICODE_CASE)
    @NotBlank
    String classroomEndTime;
    @Size(max = 128, message = "Professor Name characters should not be bigger then 128")
    String professorName;
    Boolean status;
    LocalDateTime updatedAt;
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

    public String getClassroomEndTime() {
        return classroomEndTime;
    }

    public void setClassroomEndTime(String classroomEndTime) {
        this.classroomEndTime = classroomEndTime;
    }

    @Override
    public String toString() {
        return "ClassroomDTO{" +
                "id=" + id +
                ", classroomName='" + classroomName + '\'' +
                ", weekDay=" + weekDay +
                ", classroomTime='" + classroomTime + '\'' +
                ", classroomEndTime='" + classroomEndTime + '\'' +
                ", professorName='" + professorName + '\'' +
                ", status=" + status +
                ", updatedAt=" + updatedAt +
                ", insertedAt=" + insertedAt +
                '}';
    }
}
