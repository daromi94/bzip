package com.daromi.bzip.util;

public final class BitFormatter {

  private static final int BINARY_GROUP_SIZE = 4;

  private static final int HEX_GROUP_SIZE = 2;

  private BitFormatter() {}

  public static String toBinaryString(final int value) {
    return toBinaryString(value, " ");
  }

  public static String toBinaryString(final int value, final String sep) {
    if (sep == null) {
      throw new IllegalArgumentException("separator cannot be null");
    }

    final var sb = new StringBuilder();

    for (int i = 31; i >= 0; i--) {
      final var bit = (value >> i) & 0b1;

      sb.append(bit);

      if (i > 0 && i % BINARY_GROUP_SIZE == 0) {
        sb.append(sep);
      }
    }

    return sb.toString();
  }

  public static String toHexString(final int value) {
    return toHexString(value, " ");
  }

  public static String toHexString(final int value, final String sep) {
    if (sep == null) {
      throw new IllegalArgumentException("separator cannot be null");
    }

    final var sb = new StringBuilder();

    for (int i = 7; i >= 0; i--) {
      final var hex = (value >> 4 * i) & 0xF;

      sb.append(Character.forDigit(hex, 16));

      if (i > 0 && i % HEX_GROUP_SIZE == 0) {
        sb.append(sep);
      }
    }

    return sb.toString();
  }
}
