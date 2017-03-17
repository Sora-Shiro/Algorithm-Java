/*
给定一个double类型的浮点数base和int类型的整数exponent。
求base的exponent次方。
 */

public class Solution {
  public double Power(double base, int exponent) {
      if(exponent == 0) return 1;
      double result = base;
      int exp = exponent;
      if(exponent < 0) {
          exp = -exp;
      }
      while(--exp != 0) {
          result *= base;
      }
      if(exponent < 0) {
          result = 1 / result;
      }
      return result;
  }
}