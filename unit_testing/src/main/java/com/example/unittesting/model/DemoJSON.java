package com.example.unittesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class DemoJSON {
    private @Getter @Setter
    String name;
    private @Getter @Setter
    String rollNo;
}
