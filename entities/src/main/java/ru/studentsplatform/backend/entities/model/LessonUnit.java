package ru.studentsplatform.backend.entities.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "lesson_unit")
public class LessonUnit {
    @Id
    @Column(name = "lesson_unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonUnitId;

    @Column(name = "start_time",nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Time startTime;

    @Column(name = "end_time",nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Time endTime;

    @Column(name = "audience",nullable = false)
    private String audience;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "lessonUnit",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Set<Lesson> lessons;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getLessonUnitId() {
        return lessonUnitId;
    }

    public void setLessonUnitId(Long lessonUnitId) {
        this.lessonUnitId = lessonUnitId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}