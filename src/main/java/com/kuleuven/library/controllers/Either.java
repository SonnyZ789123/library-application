package com.kuleuven.library.controllers;

public class Either<L, R> {
    public L left;
    public R right;

    public Either(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left != null;
    }

    public boolean isRight() {
        return right != null;
    }

    public static <L, R> Either<L, R> left(L l) {
        return new Either<>(l, null);
    }

    public static <L, R> Either<L, R> right(R r) {
        return new Either<>(null, r);
    }

}
