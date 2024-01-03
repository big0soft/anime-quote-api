package com.bigosoft.animequotes.anime_quotes_rest_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Quote")
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int quoteId;

    @Column(name = "quote")
    private String quoteBody;


//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.REMOVE
            , fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private CharacterEntity character;


    public QuoteEntity(String quoteBody) {
        this.quoteBody = quoteBody;
    }

    public QuoteEntity(String quoteBody, CharacterEntity character) {
        this.quoteBody = quoteBody;
        this.character = character;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        QuoteEntity that = (QuoteEntity) o;
        return Objects.equals(getQuoteId(), that.getQuoteId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
