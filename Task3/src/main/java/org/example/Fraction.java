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
            zeroDenominatorException();
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

    public int getSimpleNumerator() {
        return simpleNumerator;
    }

    public int getSimpleDenominator() {
        return simpleDenominator;
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

    public String add(Fraction fraction) {
        return (resultFractionForSumOrSub(this, fraction, '+').getNumerator() != 0)
                ? resultFractionForSumOrSub(this, fraction, '+').toSimpleString()
                : "0";
    }

    public String multiply(Fraction fraction) {
        Fraction temp = new Fraction(Math.multiplyExact(this.getSimpleNumerator(), fraction.getSimpleNumerator()), Math.multiplyExact(this.getSimpleDenominator(), fraction.getSimpleDenominator()));
        return temp.getNumerator() != 0 ? temp.toSimpleString() : "0";
    }

    public String subtract(Fraction fraction) {
        return resultFractionForSumOrSub(this, fraction, '-').getNumerator() != 0
                ? resultFractionForSumOrSub(this, fraction, '-').toSimpleString()
                : "0";
    }

    public String divide(Fraction fraction){
        if (fraction.getSimpleNumerator() == 0) {
            zeroDenominatorException();
        }

        Fraction temp = new Fraction(Math.multiplyExact(this.getSimpleNumerator(), fraction.getSimpleDenominator()), Math.multiplyExact(this.getSimpleDenominator(), fraction.getSimpleNumerator()));

        if (this.compareTo(fraction) == 0) {
            return "1";
        }

        return temp.toSimpleString();
    }

    private Fraction resultFractionForSumOrSub(Fraction f1, Fraction f2, char action) {
        int commonDenominator = calculateCommonDenominator(f2);

        int aNumerator = Math.multiplyExact(f1.getSimpleNumerator(), (commonDenominator / f1.getSimpleDenominator()));
        int bNumerator = Math.multiplyExact(f2.getSimpleNumerator(), (commonDenominator / f2.getSimpleDenominator()));

        return switch (action) {
            case '-' -> new Fraction(Math.subtractExact(aNumerator, bNumerator), commonDenominator);
            case '+' -> new Fraction(Math.addExact(aNumerator, bNumerator), commonDenominator);
            default -> throw new RuntimeException("Unexpected value: " + action);
        };
    }

    private void zeroDenominatorException() {
        throw new IllegalArgumentException("Denominator cannot be zero!");
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
        return Objects.hash(numerator, denominator, simpleNumerator, simpleDenominator);
    }

    @Override
    public int compareTo(Fraction o) {
        return this.getSimpleDenominator() == o.getSimpleDenominator() ?
                Long.compare(this.getSimpleNumerator(), o.getSimpleNumerator()) :
                Long.compare(this.getSimpleDenominator(), o.getSimpleDenominator());
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public String toSimpleString() {
        return this.simpleNumerator + "/" + this.simpleDenominator;
    }
}