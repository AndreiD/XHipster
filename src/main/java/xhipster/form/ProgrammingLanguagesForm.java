package xhipster.form;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguagesForm {

  @NotBlank
  @Size(min = 5, max = 100, message = "Please enter the name.")
  private String name;

  @NotBlank
  @Size(min = 5, max = 255, message = "Please enter the description.")
  private String description;
}

