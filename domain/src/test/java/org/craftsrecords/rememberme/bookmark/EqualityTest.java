package org.craftsrecords.rememberme.bookmark;

import org.assertj.core.api.Assertions;

// TODO Exercise 9: Use this interface in the Bookmark test and implement both methods
public interface EqualityTest<T> {

    T aNewValue();

    T aDifferentNewValue();

    // TODO Exercise 9: Uncomment @Test and import it from junit 5
    // @Test
    default void equalTest() {
        Assertions.assertThat(aNewValue()).isEqualTo(aNewValue());
        Assertions.assertThat(aNewValue().hashCode()).isEqualTo(aNewValue().hashCode());
    }

    // TODO Exercise 9: Uncomment @Test and import it from junit 5
    // @Test
    default void notEqualTest() {
        Assertions.assertThat(aNewValue()).isNotEqualTo(aDifferentNewValue());
        Assertions.assertThat(aNewValue().hashCode()).isNotEqualTo(aDifferentNewValue().hashCode());
    }
}
