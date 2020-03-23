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
@Table(name = "ACCIONISTAS")
@IdClass(ShareHolderId.class)
public class ShareHolder {

    @Id
    @Column(name = "TIP_ID", length = 2)
    @Getter @Setter
    private String tipId;

    @Id
    @Column(name = "NUM_ID", length = 15)
    @Getter @Setter
    private Long numId;

    @Id
    @Column(name = "NUMERO_ACCION", length = 20)
    @Getter @Setter
    private String numeroAccion;

    @Column(name = "NOMBRES_APELLIDOS", length = 100)
    @Getter @Setter
    private String nombresApellidos;

    @Column(name = "CORREO", length = 100)
    @Getter @Setter
    private String correo;

    @Column(name = "APODERADO")
    @Getter @Setter
    private boolean apoderado;

    @Column(name = "SALDO_TOTAL", length = 15, scale = 3)
    @Getter @Setter
    private Double saldoTotal;

    @Column(name = "IP_ACCESO", length = 20)
    @Getter @Setter
    private String ipAcceso;

    @Column(name = "FECHA_ULTIMO_ACCESO")
    @Getter @Setter
    private Date fechaUltimoAcceso;

    @Column(name = "FECHA_CREACION")
    @Getter @Setter
    private Date fechaCreacion;

    @Column(name = "AUTORIZA")
    @Getter @Setter
    private boolean autoriza;

    @Column(name = "MODERADOR")
    @Getter @Setter
    private boolean moderador;

    @Column(name = "PREGUNTAS")
    @Getter @Setter
    private String Preguntas;

}
