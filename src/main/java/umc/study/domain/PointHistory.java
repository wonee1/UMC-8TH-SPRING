package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.PointSource;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PointSource source;

    @Column(nullable = false)
    private Integer amount;

    @Column(length = 255)
    private String description;

    private LocalDateTime createdAt;

    @ManyToOne
    private User user;
}
