package ru.academIT.babushkin.Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return from - to;
    }

    public boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    public Range getIntersection(Range range) {
        double max = Math.max(from, range.from);
        double min = Math.min(to, range.to);
        if (max >= min) {
            return null;
        } else {
            return new Range(max, min);
        }
    }

    public Range[] getUnion(Range range) {
        if (Math.max(from, range.from) > Math.min(to, range.to)) {
            return new Range[]{new Range(Math.min(from, range.from), Math.min(to, range.to)), new Range(Math.max(from, range.from), Math.max(to, range.to))};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (range.from > to || from > range.to) {
            return new Range[]{new Range(from, to)};
        } else if (range.from > from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else if (from >= range.from && range.to >= to) {
            return new Range[]{};
        } else if (from >= range.from && to > range.to) {
            return new Range[]{new Range(range.to, to)};
        } else {
            return new Range[]{new Range(from, range.from)};
        }
    }
}