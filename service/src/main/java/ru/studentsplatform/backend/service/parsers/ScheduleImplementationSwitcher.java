package ru.studentsplatform.backend.service.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.studentsplatform.backend.service.parsers.spbu.SpbuScheduleResolver;

@Service
public class ScheduleImplementationSwitcher {

    private UniversityScheduleResolver universityScheduleResolver;

    private final SpbuScheduleResolver spbuScheduleResolver;

    private String realisationForUniversity = "СПБГУ";

    public ScheduleImplementationSwitcher(SpbuScheduleResolver spbuScheduleResolver){
        this.spbuScheduleResolver = spbuScheduleResolver;
    }

    /**
     * Изменяет реализацию интерфейса UniversityScheduleResolver на основе параметра.
     * @param universityName Сокращённое название университета, для которого будет производится поиск расписания.
     */
    public UniversityScheduleResolver setRealisation(String universityName){
        realisationForUniversity = universityName;
        switchRealisation();
        return universityScheduleResolver;
    }

    /**
     * Возвращает текущую реализацию UniversityScheduleResolver.
     */
    public UniversityScheduleResolver getRealisation(){
        return universityScheduleResolver;
    }

    /**
     * Внутренний механизм переключения реализации на основе switch, в который передается имя ВУЗа.
     */
    private void switchRealisation(){
        switch (realisationForUniversity){
            case "СПБГУ":
                universityScheduleResolver = spbuScheduleResolver;
                break;
        }
    }




}