package ru.studentsplatform.backend.service.parsers.spbu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpbuScheduleFinderTest {
    private static SpbuScheduleFinder scheduleFinder;

    @BeforeAll
    public static void initAll() {
        scheduleFinder = new SpbuScheduleFinder();
    }

    @Test
    public void getLinkByGroupNameTest() {
        String Url = scheduleFinder.findScheduleLink("Biology", "19.Б01-Б");

        assertEquals(Url, "https://timetable.spbu.ru/BIOL/StudentGroupEvents/Primary/247986");
    }

    @Test
    public void wrongDataResponseTest() {
        String response = scheduleFinder.findScheduleLink("someString", "someString");
        assertEquals(response, "URL not found!");
    }
}