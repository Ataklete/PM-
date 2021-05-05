package miu.edu.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.validation.constraints.Min;


@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Email {
     @NotNull
    private String name;
     @NotNull
     @javax.validation.constraints.Email
    private String email;
     @NotNull
     @Min(10)
    private  String feedback;
//    private  String  attachmentsPath;
}
