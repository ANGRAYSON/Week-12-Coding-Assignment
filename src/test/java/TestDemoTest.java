import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

  // 4.In TestDemoTest.java, add a private instance variable of type TestDemo named testDemo.
  private TestDemo testDemo;

  // a.In the setUp method, create the TestDemo object. This will ensure that a new TestDemo
  // object is created before each test.
  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo();
  }


  // b.Change "@Test" to "@ParameterizedTest"
  // c.Change the name of method "test" to "assertThatTwoPositiveNumbersAreAddedCorrectly"
  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,
      boolean expectException) {
    if (!expectException) {
      assertEquals(expected, (testDemo.addPositive(a, b)));
    } else {
      assertThatThrownBy(() -> testDemo.addPositive(a, b))
          .isInstanceOf(IllegalArgumentException.class);
    }

  }

  // 4 - j.Add the parameter source method.
  static Stream<Arguments> argumentsForAddPositive() {
    return Stream.of(arguments(2, 4, 6, false), arguments(0, 2, 2, true), arguments(2, 0, 2, true),
        arguments(-2, 4, 2, true), arguments(4, -2, 2, true), arguments(8, 2, 10, false));

  }

  // 6. Write a test for randomNumberSquared in TestDemoTest.java. Since you don't know what
  // getRandomInt will return
  // (that's the point of random, after all), you will need to mock it out and supply a known value.
  // a. Create a method with @Test called assertThatNumberSquaredIsCorrect
  @Test
  void assertThatNumberSquaredIsCorrect() {
    TestDemo mockDemo = spy(testDemo);
    doReturn(3).when(mockDemo).getRandomInt();
    int threeSquared = mockDemo.randomNumberSquared();
    assertEquals(9, threeSquared); // had to use assertEquals in place of assertThat. assertThat
                                   // would not work
  }

}
