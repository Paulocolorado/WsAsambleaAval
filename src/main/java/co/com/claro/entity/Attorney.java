package co.com.claro.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "APODERADO")
@IdClass(AttorneyId.class)
public class Attorney {

    @Id
    @Column(name = "TIP_ID", length = 2)
    @Getter @Setter
    private String tipId;

    @Id
    @Column(name = "NUM_ID", length = 15)
    @Getter @Setter
    private Long numId;

    @Column(name = "NOMBRES_APELLIDOS", length = 100)
    @Getter @Setter
    private String nombresApellidos;

    @Column(name = "CORREO", length = 100)
    @Getter @Setter
    private String correo;

    @Column(name = "AUTORIZACION")
    @Getter @Setter
    private boolean autorizacion;

    @Column(name = "CERTIFICADO",length = 10240)
    @Getter @Setter
    private String certificado;

    @Column(name = "FECHA_ULTIMO_ACCESO")
    @Getter @Setter
    private Date fechaUltimoAcceso;

    @OneToMany(mappedBy = "attorneyId", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Getter @Setter
    private List<AttorneyXShareHolder> attorneyXShareHolderList;


}
