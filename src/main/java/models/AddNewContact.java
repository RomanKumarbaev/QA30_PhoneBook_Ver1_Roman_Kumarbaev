package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AddNewContact {

    String name;
    String lastname;
    String phone;
    String email;
    String address;
    String description;

}
