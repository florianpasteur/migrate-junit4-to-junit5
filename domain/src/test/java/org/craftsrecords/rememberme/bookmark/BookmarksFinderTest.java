package org.craftsrecords.rememberme.bookmark;

import org.craftsrecords.rememberme.api.FindBookmarks;
import org.craftsrecords.rememberme.stubs.InMemoryBookmarks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;

// TODO - Exercise 6: Remove deprecated @RunWith annotation
@RunWith(Parameterized.class)
public class BookmarksFinderTest {

    private static Bookmarks bookmarks;

    // TODO - Exercise 6: Remove deprecated @Parameter annotation and field
    @Parameter
    public String tag;

    // TODO - Exercise 6: Remove deprecated @Parameter annotation and field
    @Parameter(1)
    public Bookmark[] expected;

    @Test // TODO - Exercise 6: Change to @ParameterizedTest
    // TODO - Exercise 6: Use @MethodSource that refers to testCases method
    public void should_find_bookmarks_by_tag() {
        // TODO - Exercise 6: make bookmarks and tag as parameters
        FindBookmarks findBookmarks = new BookmarksFinder(bookmarks);
        Collection<Bookmark> bookmarks = findBookmarks.by(tag);

        assertThat(bookmarks).containsExactlyInAnyOrder(expected);
    }

    @Parameters // TODO - Exercise 6:  Remove deprecated @Parameters annotation
    // TODO - Exercise 6: Make test cases return Stream<Arguments>
    public static Collection<Object[]> testCases() {
        bookmarks = new InMemoryBookmarks();

        Bookmark junit = saveBookmark("https://junit.org", "JUnit", "tests");
        Bookmark cucumber = saveBookmark("https://cucumber.io", "Cucumber", "tests", "bdd");
        Bookmark bdd = saveBookmark("https://en.wikipedia.org/wiki/BDD", "BDD", "bdd", "methodo");

        // TODO - Exercise 6: Make test cases return Stream<Arguments> and instantiate each argument
        return Arrays.asList(new Object[][]{
                {"tests", new Bookmark[]{junit, cucumber}},
                {"bdd", new Bookmark[]{cucumber, bdd}},
                {"methodo", new Bookmark[]{bdd}}
        });
    }

    private static Bookmark saveBookmark(String url, String name, String... tags) {
        Bookmark bookmark = Bookmark.create(url, name, asList(tags));
        return bookmarks.save(bookmark);
    }

}
