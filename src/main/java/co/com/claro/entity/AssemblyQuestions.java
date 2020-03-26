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
@Table(name = "PREGUNTAS_ASAMBLEA")
public class AssemblyQuestions {

    @Id
    @SequenceGenerator(name = "questions_id_generator", sequenceName = "questions_id_seq")
    @GeneratedValue(generator = "questions_id_generator")
    @Getter @Setter
    private Long id;

    @Column(name = "PREGUNTA",length = 500)
    @Getter @Setter
    private String pregunta;

    @Column(name = "DESC_PREGUNTA", length = 500)
    @Getter @Setter
    private String descPregunta;

    @Column(name = "OBSERVACIONES",length = 150)
    @Getter @Setter
    private String observaciones;

    @Column(name = "ESTADO", length = 1)
    @Getter @Setter
    private String estado;

    @Column(name = "FEC_CREA")
    @Getter @Setter
    private Date fehCrea;

    @Column(name = "USER_CREA",length = 20)
    @Getter @Setter
    private String userCrea;

    @Column(name = "FEC_MODIFICA")
    @Getter @Setter
    private Date fehModifica;

    @Column(name = "USER_MOD", length = 20)
    @Getter @Setter
    private String userMod;
}
