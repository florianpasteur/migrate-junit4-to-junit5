package org.craftsrecords.rememberme.repository;

import org.craftsrecords.rememberme.bookmark.Bookmark;
import org.craftsrecords.rememberme.bookmark.Bookmarks;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;

// TODO Exercise 7.1: Try using @DisplayNameGeneration with a DisplayNameGenerator.ReplaceUnderscores.class
// to have a better test report display
// See https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator

@DataJpaTest
// TODO Exercise 7: Use @ExtendWith instead of @RunWith
// See https://junit.org/junit5/docs/current/user-guide/#extensions-registration-declarative
@RunWith(SpringRunner.class)
public class BookmarkRepositoryTest {

    @Autowired
    private JpaBookmarkRepository jpaBookmarkRepository;

    private Bookmarks bookmarks;
    private Bookmark bookmark;

    @Before
    public void set_up() {
        bookmarks = new BookmarkRepository(jpaBookmarkRepository);
        // TODO Exercise 8: Remove this bookmark instantiation and
        // inject a bookmark as a parameter in `should_save_bookmark` test
        // Now you can use another @ExtendWith annotation and use a custom ParameterResolver
        // Go to the class `BookmarkParameterResolver` and implement the resolver
        bookmark = Bookmark.create("http://www.test.com", "test", singleton("tag"));
    }

    // TODO Exercise 8: Add a bookmark as parameter of this test
    @Test
    public void should_save_bookmark() {
        Bookmark saved = bookmarks.save(bookmark);
        assertThat(saved).isEqualTo(bookmark);
    }

    // TODO Exercise 7: Create a inner class with a setup (@BeforeEach) method
    // and move the tests in this inner class
    // Use @Nested to tell to junit to look for test here
    // see https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested
    // TODO Exercise 7.1:
    // You can use a @DisplayName annotation to name the the output string in the test report
    // See https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names
    @Test
    public void should_retrieve_bookmark_by_url() {
        // TODO Exercise 7: Make this setup common in a nested class
        jpaBookmarkRepository.save(BookmarkEntity.from(bookmark));

        Optional<Bookmark> retrieved = bookmarks.getBy(bookmark.getUrl());
        assertThat(retrieved).hasValue(bookmark);
    }

    @Test
    public void should_retrieve_all_bookmarks() {
        // TODO Exercise 7: Make this setup common in a nested class
        jpaBookmarkRepository.save(BookmarkEntity.from(bookmark));

        Collection<Bookmark> retrieved = bookmarks.getAll();
        assertThat(retrieved).contains(bookmark);
    }

}
