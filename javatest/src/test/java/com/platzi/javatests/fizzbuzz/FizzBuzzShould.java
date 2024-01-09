package com.platzi.javatests.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzShould {

  @Test
  public void do_fizz_3(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(3);

    Assert.assertEquals(result, "Fizz");
  }

  @Test
  public void do_fizz_6(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(6);

    Assert.assertEquals(result, "Fizz");
  }

  @Test
  public void do_buzz_5(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(5);

    Assert.assertEquals(result, "Buzz");
  }

  @Test
  public void do_buzz_10(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(10);

    Assert.assertEquals(result, "Buzz");
  }

  @Test
  public void do_fizzbuzz_15(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(15);

    Assert.assertEquals(result, "FizzBuzz");
  }

  @Test
  public void do_fizzbuzz_30(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(30);

    Assert.assertEquals(result, "FizzBuzz");
  }

  @Test
  public void returns_number_2(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(2);

    Assert.assertEquals(result, "2");
  }

  @Test
  public void returns_number_16(){
    FizzBuzz fizzBuzz = new FizzBuzz();

    String result = fizzBuzz.calculateFizzBuzz(16);

    Assert.assertEquals(result, "16");
  }
}
