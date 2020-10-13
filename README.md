# Migration from JUnit 4 to 5

This `Remember Me` app has been created to help you understand the difference between JUnit 4 and JUnit 5.

## JUnit 5

See documentation [JUnit 5](https://junit.org/junit5/) 

## Exercise 1 : Migration of dependencies

See https://junit.org/junit5/docs/current/user-guide/#running-tests-build-maven 
- Use `org.junit.vintage` to insure compatibility with JUnit 4.
- Add JUnit Jupiter to maven dependency to have new JUnit tools 
- Upgrade your maven surefire dependency to 2.22+

## Exercise 2 : Migration a simple test class to JUnit 5

- Migrate the `BookmarkCreatorTest` class from JUnit 4 to 5

## Exercise 3 : new Assertions features of JUnit 5

- Migrate assertions of `BookmarkTest` class to JUnit 5
- Remove `@Rule` annotation and use `assertThrows` instead. See https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
- Use `assertAll` to do soft assertions. See https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/api/Assertions.html#assertAll(org.junit.jupiter.api.function.Executable...)

## Exercise 4 : Make test parameterized

- Migrate `BookmarkTest` tests as parameterized tests
- Make test parameterized for value : space, empty string and tabulation
- Use @ValueSource to inject value as argument of the test methods. see https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests

## Exercise 5 : Make test parameterized

- Make test parameterized for values : url and name
- Replace @Test by @ParameterizedTest
- Use @CsvSource to inject value as argument of the test methods. see https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-CsvSource
- Name the test with values of CSV input


## Exercise 6 : Migrate parameterized test with custom objects

- Migrate `BookmarksFinderTest` parameterized tests to JUnit 5

## Exercise 7: Share setup on few tests and not on full class

- Create share setup between tests `should_retrieve_all_bookmarks` and `should_retrieve_bookmark_by_url` of class `BookmarkRepositoryTest` 
- Use `@Nested` to tag inner class for JUnit https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested

## Exercise 8: Implement your own Parameter Resolver

- In the class test `BookmarkRepositoryTest` modify the test `should_save_bookmark` to use a parameter resolver

## Exercise 9: Use generic shared test

- In the class `BookmarkTest` you can implement the interface `EqualityTest` and use generic test without writing them every time
- Implement the both methods `aValue` and `aDifferentValue` with two different objects and the check of equality will be implemented by the interface

# Credits

This repository is a fork of the [Remember me](https://gitlab.com/crafts-records/remember-me/-/tree/master) repository.
The exercises come from the talk of [JUnit : il serait temps de passer la 5ème !](https://www.youtube.com/watch?v=EfxwS54hdkM) of [Juliette de Rancourt](https://twitter.com/ju_derancourt) and [Julien Topçu](https://twitter.com/JulienTopcu)
