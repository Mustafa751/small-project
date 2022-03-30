package demo.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contacts")
public class contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ime")
    private String ime;
    @Column(name="familiq")
    private String familiq;
    @Column(name="registraciq")
    private String registraciq;
    @Column(name="otkude")
    private String otkude;
    @Column(name="polica")
    private String polica;
    @Column(name="nachalna_data")
    private String nachalna_data;
    @Column(name="kraina_data")
    private String kraina_data;
    @Column(name="suma")
    private String suma;
    @Column(name="egn")
    private String egn;
    @Column(name="telefon")
    private String telefon;

    @Override
    public String toString() {
        return "contacts{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", familiq='" + familiq + '\'' +
                ", registraciq='" + registraciq + '\'' +
                ", otkude='" + otkude + '\'' +
                ", polica='" + polica + '\'' +
                ", nachalna_data='" + nachalna_data + '\'' +
                ", kraina_data='" + kraina_data + '\'' +
                ", suma='" + suma + '\'' +
                ", egn='" + egn + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
