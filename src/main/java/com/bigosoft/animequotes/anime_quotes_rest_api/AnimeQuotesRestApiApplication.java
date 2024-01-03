package com.bigosoft.animequotes.anime_quotes_rest_api;

import com.bigosoft.animequotes.anime_quotes_rest_api.entity.AnimeEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.entity.CharacterEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.entity.QuoteEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.service.AnimeService;
import com.bigosoft.animequotes.anime_quotes_rest_api.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AnimeQuotesRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeQuotesRestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AnimeService animeService, QuoteService quoteService) {
        return args -> {
//            quoteService.addQuote(getNarutoQuotes());
//            quoteService.addQuote(getSakuraQuotes());
//            quoteService.addQuote(getKakashiQuotes());
//            quoteService.addQuote(getSasKQuotes());

//            animeService.addAnime(getAnimeEntity());
        };
    }

    private AnimeEntity getAnimeEntity() {
        AnimeEntity anime = new AnimeEntity();
        anime.setAnimeImage("https://m.media-amazon.com/images/M/MV5BZGFiMWFhNDAtMzUyZS00NmQ2LTljNDYtMmZjNTc5MDUxMzViXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg");
        anime.setAnimeName("Naruto");
        anime.setCharacters(getCharacters());
        return anime;
    }

    private List<CharacterEntity> getCharacters() {
        return List.of(
                new CharacterEntity("Naruto", "https://animeyat.net/wp-content/uploads/2023/03/sayings-naruto-characters-1-1024x576.webp", getNarutoQuotes()),
                new CharacterEntity("SasK", "https://iqtabasat.com/uploads/authors/1664848774.jpg", getSasKQuotes()),
                new CharacterEntity("Kakashi", "https://animeyat.net/wp-content/uploads/2023/03/sayings-naruto-characters-8-1024x576.webp", getKakashiQuotes()),
                new CharacterEntity("Sakura", "https://animeyat.net/wp-content/uploads/2023/03/sayings-naruto-characters-4-1024x576.webp", getSakuraQuotes())
        );
    }

    private List<QuoteEntity> getSasKQuotes() {
        return List.of(
                new QuoteEntity("تكون بداية الهلاك ويصبح السجين متعطش للدماء.", getSaskCharacter()),
                new QuoteEntity("يكون أقوى عشر أضعاف على قوته الحقيقة.", getSaskCharacter()),
                new QuoteEntity("قد يفقد الشخص جسمه إلى الأبد.", getSaskCharacter())

        );
    }

    private CharacterEntity getSaskCharacter() {

        return new CharacterEntity("Sask"
                , getNarutoAnime()
                , "https://iqtabasat.com/uploads/authors/1664848774.jpg");
    }

    private AnimeEntity getNarutoAnime() {
        AnimeEntity anime = new AnimeEntity();
        anime.setAnimeImage("https://m.media-amazon.com/images/M/MV5BZGFiMWFhNDAtMzUyZS00NmQ2LTljNDYtMmZjNTc5MDUxMzViXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg");
        anime.setAnimeName("Naruto");
        return anime;
    }

    private List<QuoteEntity> getKakashiQuotes() {
        return List.of(
                new QuoteEntity("معرفة ما هو صحيح وتجاهله هذا تصرف الجبناء.", getKakashiCharacter()),
                new QuoteEntity("لا تخف لن أدع أحد من رفاقي يموت سأحميك مهما كلف الأمر.", getKakashiCharacter()),
                new QuoteEntity("حتى لو حصلت على إنتقامك لن يتبقى لك إلا الحزن.", getKakashiCharacter()),
                new QuoteEntity("ستجد حتمًا من سيمُد لك يد العون طالما لم تستسلم.", getKakashiCharacter())
        );
    }

    private CharacterEntity getKakashiCharacter() {
        return new CharacterEntity("Kakashi"
                , getNarutoAnime()
                , "https://animeyat.net/wp-content/uploads/2023/03/sayings-naruto-characters-8-1024x576.webp");
    }

    private List<QuoteEntity> getSakuraQuotes() {
        return List.of(
                new QuoteEntity("أولئك الذين لا يتبعون التعليمات هم الحثالة ولكن أتعلمون! الذين لا يهتمون بحياة أصدقائهم هم أسوأ من الحثالة ذاتها.", getSakuraCharacter()),
                new QuoteEntity("الرجل لن يكون رجلًا إن لم يمتلك ندبات قتال يتفاخر بها.", getSakuraCharacter()),
                new QuoteEntity("في اللحظة التي تعرَّف فيها الناس على الحب، فإنهم يخاطرون بحمل الكراهية.", getSakuraCharacter())
        );
    }

    private CharacterEntity getSakuraCharacter() {
        return new CharacterEntity("Sakura"
                , getNarutoAnime()
                , "https://animeyat.net/wp-content/uploads/2023/03/sayings-naruto-characters-4-1024x576.webp");
    }

    private List<QuoteEntity> getNarutoQuotes() {
        return List.of(
                new QuoteEntity("الرابطة التي أرتبطت بها معك لا أريد أن أقطعها ولا أريدها أن تنقطع", getNarutoCharacter()),
                new QuoteEntity("الأشخاص الذين يواصلون وضع حياتهم على المحك للدفاع عن إيمانهم وما يحبونه يُصبحون أبطالًا ويُخلد أسمهم في الأسطورة.", getNarutoCharacter()),
                new QuoteEntity("العمل الجاد والسعي المستمر لا قيمة له بالنسبة لأولئك الذين لا يؤمنون بأنفسهم.", getNarutoCharacter()),
                new QuoteEntity("لأنهم أنقذوني من نفسي، أنقذوني من وحدتي،كانوا أول من قبلني كما أنا عليه، إنهم أصدقائي.", getNarutoCharacter()),
                new QuoteEntity("إذا كنت لا تحب مصيرك، فلا تقبله.", getNarutoCharacter()),
                new QuoteEntity("عندما يحمي الناس شيئًا مميزًا حقًا لهم، يمكنهم حقًا أن يصبحوا أقوى ما يمكن أن يكونوا.", getNarutoCharacter()),
                new QuoteEntity("ألم الوحدة هو خارج هذا العالم تمامًا، أليس كذلك؟ لا أعرف لماذا، لكني أتفهّم مشاعرك كثيرًا، إنها مؤلمة في الواقع.", getNarutoCharacter())
        );
    }

    private CharacterEntity getNarutoCharacter() {
        return new CharacterEntity("Naruto"
                , getNarutoAnime()
                , "https://animeyat.net/wp-content/uploads/2023/03/sayings-naruto-characters-1-1024x576.webp");
    }

}
