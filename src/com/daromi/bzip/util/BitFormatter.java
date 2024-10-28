package com.daromi.bzip.util;

public final class BitFormatter {

  private static final int BITS_IN_INT = 32;

  private static final int BITS_IN_HEX_DIGIT = 4;

  private static final int HEX_DIGITS_IN_INT = 8;

  private static final int BINARY_GROUP_SIZE = 4;

  private static final int HEX_GROUP_SIZE = 2;

  private BitFormatter() {}

  public static String toBinaryString(final int value) {
    return toBinaryString(value, " ");
  }

  public static String toBinaryString(final int value, final String separator) {
    if (separator == null) {
      throw new IllegalArgumentException("separator cannot be null");
    }

    final var sb = new StringBuilder();

    for (int i = BITS_IN_INT - 1; i >= 0; i--) {
      final var bit = (value >> i) & 0b1;

      sb.append(bit);

      if (i > 0 && i % BINARY_GROUP_SIZE == 0) {
        sb.append(separator);
      }
    }

    return sb.toString();
  }

  public static String toHexString(final int value) {
    return toHexString(value, " ");
  }

  public static String toHexString(final int value, final String separator) {
    if (separator == null) {
      throw new IllegalArgumentException("separator cannot be null");
    }

    final var sb = new StringBuilder();

    for (int i = HEX_DIGITS_IN_INT - 1; i >= 0; i--) {
      final var hex = (value >> BITS_IN_HEX_DIGIT * i) & 0xF;

      sb.append(Character.forDigit(hex, 16));

      if (i > 0 && i % HEX_GROUP_SIZE == 0) {
        sb.append(separator);
      }
    }

    return sb.toString();
  }
}
