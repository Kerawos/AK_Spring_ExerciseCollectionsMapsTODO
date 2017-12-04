package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.services.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    private static Library library;

    @BeforeClass
    public static void start() {
        library = new Library();
    }

    @AfterClass
    public static void stop() throws Exception {
        library = null;
    }

    @Test
    public void test() throws Exception {
        assertNotNull(library.createArticleList());
        assertNotNull(library.createWriterList());

        List<Writer> actual = new ArrayList<>();
        actual.add(new Writer("Johny",  Arrays.asList(new Article("Fast Cars", 3004))));
        actual.add(new Writer("Olecia",  Arrays.asList(new Article("Fast Cars", 3004))));
        actual.add(new Writer("Kogijaszi",  Arrays.asList(new Article("Fast Cars", 3004))));

        List<Writer> expected = new ArrayList<>();
        expected = library.getWriters("Fast Cars");
        testArray(actual, expected);

        actual.clear();
        actual.add(new Writer("Ana",  Arrays.asList(new Article("Mount and Horses", 3002))));
        actual.add(new Writer("Reksio",  Arrays.asList(new Article("Mount and Horses", 3002))));
        actual.add(new Writer("Kogijaszi",  Arrays.asList(new Article("Mount and Horses", 3002))));
        actual.add(new Writer("Enzo",  Arrays.asList(new Article("Mount and Horses", 3002))));
        expected.clear();
        expected = library.getWriters("Mount and Horses");
        testArray(actual, expected);


        actual.clear();
        actual.add(new Writer("Johny",  Arrays.asList(new Article("Pirates", 3001))));
        actual.add(new Writer("Elvis",  Arrays.asList(new Article("Pirates", 3001))));
        actual.add(new Writer("Michaliv",  Arrays.asList(new Article("Pirates", 3001))));
        actual.add(new Writer("Kogijaszi",  Arrays.asList(new Article("Pirates", 3001))));
        expected.clear();
        expected = library.getWriters("Pirates");
        testArray(actual, expected);
    }

    private void testArray(List<Writer> actualList, List<Writer> expectedList) {
        assertEquals(actualList.size(), expectedList.size());
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(actualList.get(i).getName(), expectedList.get(i).getName());
        }
    }
}

