package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.InquiryStatus;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private InquiryStatus status;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "inquiry")
    private InquiryAnswer answer;
}
