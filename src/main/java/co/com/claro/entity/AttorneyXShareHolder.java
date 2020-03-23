package co.com.claro.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "APODERADO_X_ACCIONISTAS")
public class AttorneyXShareHolder {
    @Id
    @SequenceGenerator(name = "AttorneyXShareHolder_id_generator",
            sequenceName = "AttorneyXShareHolder_id_seq")
    @GeneratedValue(generator = "AttorneyXShareHolder_id_generator")
    @Getter @Setter
    private Long id;

    @Column(name = "APO_TIP_ID", length = 2)
    @Getter @Setter
    private String apoTipId;

    @Column(name = "APO_NUM_ID", length = 15)
    @Getter @Setter
    private Long apoNumId;

    @Column(name = "ACC_TIP_ID", length = 2)
    @Getter @Setter
    private String accTipId;

    @Column(name = "ACC_NUM_ID", length = 15)
    @Getter @Setter
    private Long accNumId;

    @Column(name = "ACC_NUM_ACCION", length = 20)
    @Getter @Setter
    private String accNumAccion;

    @Column(name = "FEC_CREA")
    @Getter @Setter
    private Date fecCrea;

    @Column(name = "FEC_ULT_ACCESO")
    @Getter @Setter
    private Date fecUltAcceso;

    @Column(name = "IP_ULT_ACCESO", length = 20)
    @Getter @Setter
    private String ipUltAcceso;

    @JoinColumns({
            @JoinColumn(name = "APODERADO.TIP_ID" ),
            @JoinColumn(name = "APODERADO.NUM_ID")
    })
    @Getter @Setter
    @ManyToOne
    private Attorney attorneyId;
}
