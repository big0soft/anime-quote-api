package com.bigosoft.animequotes.anime_quotes_rest_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;
    private String characterName;

    @ManyToOne(fetch = FetchType.LAZY
            , cascade = CascadeType.REMOVE)
    @JoinColumn(name = "anime_id")
    @ToString.Exclude
    private AnimeEntity animes;

    private String characterImage;

//    @JsonManagedReference
    @OneToMany(mappedBy = "character")
    @ToString.Exclude  // "character" should match the field name in QuoteEntity
    private List<QuoteEntity> quotes;


    public CharacterEntity(String characterName, List<QuoteEntity> quotes) {
        this.characterName = characterName;
        this.quotes = quotes;
    }

    public CharacterEntity(String characterName, AnimeEntity animes, String characterImage) {
        this.characterName = characterName;
        this.animes = animes;
        this.characterImage = characterImage;
    }

    public CharacterEntity(String characterName, String characterImage, List<QuoteEntity> quotes) {
        this.characterName = characterName;
        this.characterImage = characterImage;
        this.quotes = quotes;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CharacterEntity that = (CharacterEntity) o;
        return Objects.equals(getCharacterId(), that.getCharacterId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
