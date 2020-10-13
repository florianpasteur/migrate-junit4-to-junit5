package org.craftsrecords.rememberme.bookmark;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;

public class BookmarkTest {

    // TODO - Exercise 3: Remove @Rule annotation and use assertThrows instead
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    // TODO - Exercise 3: Do not forget to update package import of @Test annotation
    @Test
    public void should_create_the_bookmark() {
        String url = "http://www.test.com";
        String name = "Some name";
        Set<String> tags = singleton("tag");
        Bookmark createdBookmark = Bookmark.create(url, name, tags);

        // TODO - Exercise 3: Use assertAll to make all next assertions as soft assertions
        // (see https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/api/Assertions.html#assertAll(org.junit.jupiter.api.function.Executable...))
        assertThat(createdBookmark.getUrl()).isEqualTo(url);
        assertThat(createdBookmark.getName()).isEqualTo(name);
        assertThat(createdBookmark.getTags()).isEqualTo(tags);
    }

    // TODO - Exercise 3: Do not forget to update package import of @Test annotation
    @Test
    public void should_not_accept_empty_or_blank_name() {
        // TODO - Exercise 3: Use assertThrows instead
        // (see https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/api/Assertions.html#assertThrows(java.lang.Class,org.junit.jupiter.api.function.Executable))
        exception.expect(IllegalArgumentException.class);
        Bookmark.create("http://www.test.com", "  ", emptySet());
    }

    // TODO - Exercise 4: Migrate the test should_not_accept_empty_or_blank_name to a ParameterizedTest
    // Make test parameterized for value : space, empty string and tabulation
    // Replace @Test by @ParameterizedTest
    // Use @ValueSource to inject value as argument of the test methods. @ValueSource can take and a strings array
    // see https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
    // You can add @NullSource to inject null value

    // TODO - Exercise 5: Migrate the test should_create_the_bookmark to a ParameterizedTest
    // Make test parameterized for values : url and name
    // Replace @Test by @ParameterizedTest
    // Use @CsvSource to inject value as argument of the test methods. @ValueSource can take and a strings array
    // see https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-CsvSource
    // You can name the test by giving a format string as argument of ParameterizedTest (ex @ParameterizedTest(name = "Create bookmark {0} for {1}"))


}
