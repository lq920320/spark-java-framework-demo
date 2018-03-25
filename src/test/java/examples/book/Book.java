package examples.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuqian
 * @date 2018/3/25 10:27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private String author;
  private String title;
}
