package com.example.w3d4exer.exeptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class InvalidId extends RuntimeException{

    public InvalidId(String message) {
        super(message);
    }
}
