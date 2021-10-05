package hellojpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    /*DEFAULT ORDINAL -> 웬만하면 ORDINAL X*/
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    /*필드와 컬럼 매핑 x*/
    @Transient
    private String temp;


}
