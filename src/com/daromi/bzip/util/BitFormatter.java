package com.daromi.bzip.util;

public final class BitFormatter {

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
      final var bit = (value >> i) & 1;

      sb.append(bit);

      if (i > 0 && i % 4 == 0) {
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

    return sb.toString();
  }
}
