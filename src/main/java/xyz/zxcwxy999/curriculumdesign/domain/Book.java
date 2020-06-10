package xyz.zxcwxy999.curriculumdesign.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    int id;
    String name;
    String author;
    String publishing;
    String price;
}
