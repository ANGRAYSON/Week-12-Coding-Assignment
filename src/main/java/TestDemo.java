import java.util.Random;

public class TestDemo {

  // 2. Create a class named "TestDemo" under src/main/java in the default package
  // a.Create an instance method (not static) named addPositive.
  // It should take two int parameters and return an int
  // public int addPositive(int a, int b) {}
  // b.If both parameters are positive (greater than zero) return the sum of the parameters.
  // If either parameter is zero or negative, throw an IllegalArgumentException with
  // the message "Both parameters must be positive!".
  // IllegalArgumentException is in the java.lang package so you won't need an import statement.

  public int addPositive(int a, int b) {
    if (a <= 0 || b <= 0) {
      throw new IllegalArgumentException("Both parameters must be positive!");
    }
    return a + b;
  }

  // 5. In TestDemo.java, add another method named randomNumberSquared. This method obtains a
  // random int between 1 and 10 and then returns the square of the number
  // a. randomNumberSquared should return an int and not take any parameters.
  // c. randomNumberSquared should return the value obtained from getRandomInt multiplied by itself.
  public int randomNumberSquared() {
    int number = getRandomInt();
    return number * number;
  }

  // b. It should call another method in the same class named getRandomInt. This method takes no
  // parameters
  // and must be package visibility so that the test can see it
  int getRandomInt() {
    Random random = new Random();
    return random.nextInt(10) + 1;
  }
}
