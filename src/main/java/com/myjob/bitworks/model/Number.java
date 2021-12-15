package com.myjob.bitworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numbers")
public class Number {

    @Column(name = "req")
    private Integer requestedX;

    @Id
    @Column(name = "id")
    private Integer primeNumber;

    public Integer getPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(Integer primeNumber) {
        this.primeNumber = primeNumber;
    }

    public Integer getRequestedX() {
        return requestedX;
    }

    public void setRequestedX(Integer requestedX) {
        this.requestedX = requestedX;
    }

    @Override
    public String toString() {

        return "{" + '\n' +
                "  'requested-x': " + requestedX + '\n' +
                "  'prime-number': " + primeNumber + '\n' +
                "}";
    }

    public int compareTo(Number anotherInteger) {
        return compare(this.primeNumber, anotherInteger.primeNumber);
    }

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
