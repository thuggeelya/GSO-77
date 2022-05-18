package org.example;

import java.util.Objects;

public class Fraction implements Comparable<Fraction> {

    private final int numerator;
    private final int denominator;
    private final int simpleNumerator;
    private final int simpleDenominator;

    public Fraction(int numerator, int denominator)  {
        this.numerator = numerator;

        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }

        this.denominator = denominator;
        this.simpleNumerator = simplify(numerator, denominator)[0];
        this.simpleDenominator = simplify(numerator, denominator)[1];
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int[] simplify(int numerator, int denominator) {
        if (numerator == 1) {
            return new int[]{numerator, denominator};
        }

        int gcd = calculateCommonDivider(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    private int calculateCommonDenominator(Fraction fraction) {
        return Math.abs(Math.multiplyExact(this.getDenominator(), fraction.getDenominator()) / calculateCommonDivider(this.getDenominator(), fraction.getDenominator()));
    }

    private int calculateCommonDivider(int a, int b) {
        if (b == 0) {
            return a;
        }

        return calculateCommonDivider(b, a % b);
    }

    public Fraction add(Fraction fraction) {
        return resultFractionForSumOrSub(this, fraction, '+');
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(Math.multiplyExact(this.simpleNumerator, fraction.simpleNumerator), Math.multiplyExact(this.simpleDenominator, fraction.simpleDenominator));
    }

    public Fraction subtract(Fraction fraction) {
        return resultFractionForSumOrSub(this, fraction, '-');
    }

    public Fraction divide(Fraction fraction){
        return new Fraction(Math.multiplyExact(this.simpleNumerator, fraction.simpleDenominator), Math.multiplyExact(this.simpleDenominator, fraction.simpleNumerator));
    }

    private Fraction resultFractionForSumOrSub(Fraction f1, Fraction f2, char action) {
        int commonDenominator = calculateCommonDenominator(f2);

        int aNumerator = Math.multiplyExact(f1.simpleNumerator, (commonDenominator / f1.simpleDenominator));
        int bNumerator = Math.multiplyExact(f2.simpleNumerator, (commonDenominator / f2.simpleDenominator));

        return switch (action) {
            case '-' -> new Fraction(Math.subtractExact(aNumerator, bNumerator), commonDenominator);
            case '+' -> new Fraction(Math.addExact(aNumerator, bNumerator), commonDenominator);
            default -> throw new RuntimeException("Unexpected value: " + action);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fraction f = this;
        Fraction fraction = (Fraction) o;
        return (f.numerator == fraction.numerator) && (f.denominator == fraction.denominator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public int compareTo(Fraction o) {
        return this.simpleDenominator == o.simpleDenominator ?
                Long.compare(this.simpleNumerator, o.simpleNumerator) :
                Long.compare(this.simpleDenominator, o.simpleDenominator);
    }

    @Override
    public String toString() {
        return this.numerator == 0 ? "0" : (this.numerator == this.denominator) ? "1" : this.numerator + "/" + this.denominator;
    }
}