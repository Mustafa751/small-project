package demo.demo.entities;

import javax.persistence.*;

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


    public contacts(Long id, String ime, String familiq, String registraciq,String otkude,String polica,String nachalna_data,String kraina_data,String suma,String egn,String telefon) {
        this.id = id;
        this.ime = ime;
        this.familiq = familiq;
        this.registraciq = registraciq;
        this.otkude=otkude;
        this.polica=polica;
        this.nachalna_data=nachalna_data;
        this.kraina_data=kraina_data;
        this.suma=suma;
        this.egn=egn;
        this.telefon=telefon;

    }

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getFamiliq() {
        return familiq;
    }

    public String getRegistraciq() {
        return registraciq;
    }

    public String getOtkude(){return otkude;}

    public String getPolica() {
        return polica;
    }

    public String getNachalna_data() {
        return nachalna_data;
    }

    public String getKraina_data() {
        return kraina_data;
    }

    public String getSuma() {
        return suma;
    }

    public String getEgn() {
        return egn;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setFamiliq(String familiq) {
        this.familiq = familiq;
    }

    public void setRegistraciq(String registraciq) {
        this.registraciq = registraciq;
    }

    public void setOtkude(String otkude) {
        this.otkude = otkude;
    }

    public void setPolica(String polica) {
        this.polica = polica;
    }

    public void setNachalna_data(String nachalna_data) {
        this.nachalna_data = nachalna_data;
    }

    public void setKraina_data(String kraina_data) {
        this.kraina_data = kraina_data;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public void setSuma(String suma) {
        this.suma = suma;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public contacts() {
    }

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
