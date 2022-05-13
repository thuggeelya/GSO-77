package org.example;

public class Fraction implements Comparable<Fraction> {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new NumberFormatException("Denominator cannot be null!");
        }
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private Fraction simplify(Fraction fraction) {
        if (fraction.getNumerator() == 1) {
            return fraction;
        }

        int gcd = calculateCommonDivider(fraction.getNumerator(), fraction.getDenominator());
        return new Fraction(fraction.getNumerator() / gcd, fraction.getDenominator() / gcd);
    }

    private int calculateCommonDenominator(Fraction fraction) {
        return Math.abs(this.getDenominator() * fraction.getDenominator()) / calculateCommonDivider(this.getDenominator(), fraction.getDenominator());
    }

    private int calculateCommonDivider(int a, int b) {
        if (b == 0) {
            return a;
        }

        return calculateCommonDivider(b, a % b);
    }

    public String add(Fraction fraction) {
        return (resultFractionForSumOrSub(this, fraction, '+').getNumerator() != 0)
                ? resultFractionForSumOrSub(this, fraction, '+').toString()
                : "0";
    }

    public String multiply(Fraction fraction) {
        Fraction temp = simplify(new Fraction(this.getNumerator() * fraction.getNumerator(), this.getDenominator() * fraction.getDenominator()));
        return temp.getNumerator() != 0 ? temp.toString() : "0";
    }

    public String subtract(Fraction fraction) {
        return resultFractionForSumOrSub(this, fraction, '-').getNumerator() != 0
                ? resultFractionForSumOrSub(this, fraction, '-').toString()
                : "0";
    }

    public String divide(Fraction fraction) {
        var f1 = simplify(this);
        var f2 = simplify(fraction);

        if (fraction.getNumerator() == 0) {
            throw new NumberFormatException("Denominator cannot be null!");
        }

        Fraction temp = simplify(new Fraction(this.getNumerator() * fraction.getDenominator(), this.getDenominator() * fraction.getNumerator()));

        if (f1.compareTo(f2) == 0) {
            return "1";
        }

        return temp.toString();
    }

    private Fraction resultFractionForSumOrSub(Fraction f1, Fraction f2, char action) {
        f1 = simplify(f1);
        f2 = simplify(f2);
        int commonDenominator = calculateCommonDenominator(f2);
        int aNumerator = f1.getNumerator() * (commonDenominator / f1.getDenominator());
        int bNumerator = f2.getNumerator() * (commonDenominator / f2.getDenominator());

        return switch (action) {
            case '-' -> simplify(new Fraction(aNumerator - bNumerator, commonDenominator));
            case '+' -> simplify(new Fraction(aNumerator + bNumerator, commonDenominator));
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction f = simplify(this);
        Fraction fraction = simplify((Fraction) o);
        return f.numerator == fraction.numerator && f.denominator == fraction.denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        return this.getDenominator() == o.getDenominator() ?
                Integer.compare(this.getNumerator(), o.getNumerator()) :
                Integer.compare(this.getDenominator(), o.getDenominator());
    }

    @Override
    public String toString() {
        return simplify(this).numerator + "/" + simplify(this).denominator;
    }
}
