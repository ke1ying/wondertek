package com.miu.web.lambda;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lambdaOne {

    public static void main(String[] args) {
        Double min = Double.MIN_VALUE;
        System.out.println("最小值:" + min);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        List<Point> pointList = new ArrayList<>();
        
    }

}

@Data
class User {
    private Double a;
    private Double b;
}
