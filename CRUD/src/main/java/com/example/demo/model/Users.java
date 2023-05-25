<<<<<<< HEAD
package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.DocFlavor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    private String name;
    private Integer age;
    private String email;
    private String alumniCode;

    public static String alumniCode(String name, Integer age, Integer alumniCode){
        String yearBirth = Integer.toString(age);
        return yearBirth + name + alumniCode;
    }
}
=======
package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.DocFlavor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    private String name;
    private Integer age;
    private String email;
    private String alumniCode;

    public static String alumniCode(String name, Integer age, Integer alumniCode){
        String yearBirth = Integer.toString(age);
        return yearBirth + name + alumniCode;
    }
}
>>>>>>> 19cc393ae34b61a5909073c85c20bdf019ca868f
