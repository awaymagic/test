package com.away.test.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author wei.guo
 * @date 2023/12/3
 */
@Data
@Builder
public class OrderCase {

    private int type;

    private String name;

    private List<String> traces;

    public void append(String message) {
        this.traces.add(message);
    }

}
