package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MissionStatus status;

    @Column(length = 100)
    private String codeSubmitted;

    private LocalDateTime assignedAt;

    private LocalDateTime completedAt;

    @OneToOne(mappedBy = "userMission")
    private Review review;
}
