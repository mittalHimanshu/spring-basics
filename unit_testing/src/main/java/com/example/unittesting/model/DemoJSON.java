package com.example.unittesting.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoJSON {
    private @Getter @Setter
    String name;
    private @Getter @Setter
    String rollNo;
}
