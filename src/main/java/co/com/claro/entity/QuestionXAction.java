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
@Table(name = "PREGUNTA_X_ACCION")
@IdClass(QuestionXActionId.class)
public class QuestionXAction {

    @Id
    @SequenceGenerator(name = "questionxaction_id_generator", sequenceName = "questionxaction_id_seq")
    @GeneratedValue(generator = "questionxaction_id_generator")
    @Getter @Setter
    private Long id;

    @Id
    @Column(name = "ID_PREGUNTA", length = 15)
    @Getter @Setter
    private Long idPregunta;

    @Id
    @Column(name = "NUMERO_ACCION", length = 20)
    @Getter @Setter
    private String numeroAccion;

    @Column(name = "APO_TIP_ID", length = 2)
    @Getter @Setter
    private String apoTipId;

    @Column(name = "APO_NUM_ID", length = 15)
    @Getter @Setter
    private Long apoNumId;

    @Column(name = "RESPUESTA", length = 20)
    @Getter @Setter
    private String respuesta;

    @Column(name = "OBSERVACION", length = 80)
    @Getter @Setter
    private String observacion;

    @Column(name = "FEC_RESPUESTA")
    @Getter @Setter
    private Date fecRespuesta;

    @Column(name = "IP_RESPUESTA", length = 20)
    @Getter @Setter
    private String ipRespuesta;

    @JoinColumn(name = "PREGUNTAS_ASAMBLEA.ID_PREGUNTA")
    @Getter @Setter
    @ManyToOne
    private AssemblyQuestions assemblyQuestionsId;

    @JoinColumns({
            @JoinColumn(name = "ACCIONISTAS.TIP_ID"),
            @JoinColumn(name = "ACCIONISTAS.NUM_ID"),
            @JoinColumn(name = "ACCIONISTAS.NUMERO_ACCION")
    })
    @Getter @Setter
    @ManyToOne
    private ShareHolder shareHolderId;
}
