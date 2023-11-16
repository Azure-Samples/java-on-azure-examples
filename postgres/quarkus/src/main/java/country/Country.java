package country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @SequenceGenerator(
            name = "countries_id_seq",
            sequenceName = "countries_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "countries_id_seq")
    private Integer id;

    @Column(name = "long_name", length = 255, unique = true)
    private String name;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
