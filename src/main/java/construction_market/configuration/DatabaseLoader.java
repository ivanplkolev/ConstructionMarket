package construction_market.configuration;


import construction_market.entities.*;
import construction_market.entities.categories.CategoryЕ;
import construction_market.entities.categories.OfferParamE;
import construction_market.entities.categories.PredefinedValuesE;
import construction_market.entities.categories.SearchParameterE;
import construction_market.repositories.CategoryRepo;
import construction_market.repositories.SearchParamRepo;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final SearchParamRepo searchParamRepo;

    @Autowired
    public DatabaseLoader(
            CategoryRepo categoryRepo,
            SearchParamRepo searchParamRepo,
            UserRepo userRepo) {

        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.searchParamRepo = searchParamRepo;
    }

    @Override
    public void run(String... strings) throws Exception {


        SearchParameterE parameterEprice = searchParamRepo.save(new SearchParameterE("Цена", null));

        SearchParameterE parameterE1 = searchParamRepo.save(new SearchParameterE("Кубатура изкопана земна маса/ ден", null));
        SearchParameterE parameterE2 = searchParamRepo.save(new SearchParameterE("Кубатура на коша", null));

        SearchParameterE parameterE3 = searchParamRepo.save(new SearchParameterE("Товароподемност", null));
        SearchParameterE parameterE4 = searchParamRepo.save(new SearchParameterE("Дължина на стрелата", null));
        SearchParameterE parameterE5 = searchParamRepo.save(new SearchParameterE("Работен периметър", null));

        SearchParameterE parameter6 = searchParamRepo.save(new SearchParameterE("Вид плочки", Arrays.asList(new PredefinedValuesE("Гранитогрес"),
                new PredefinedValuesE("Фаянс"),
                new PredefinedValuesE("Теракот"))));
        SearchParameterE parameter7 = searchParamRepo.save(new SearchParameterE("Квадратура на ден", null));

        CategoryЕ zemekopni_1_1 = new CategoryЕ("Верижни багери", null, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ zemekopni_1_2 = new CategoryЕ("Колесни багери", null, null, CategoryЕ.TYPE_MACHINES);

        List<CategoryЕ> zemekopniList_1 = Arrays.asList(zemekopni_1_1, zemekopni_1_2);

        CategoryЕ excavators = new CategoryЕ("Багври", zemekopniList_1, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ zemekopni_2 = new CategoryЕ("Челни товарачи", null, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ zemekopni_3 = new CategoryЕ("Сондиращи машини", null, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ zemekopni_4 = new CategoryЕ("Челни товарачи", null, null, CategoryЕ.TYPE_MACHINES);


        List<CategoryЕ> zemekopniList = Arrays.asList(excavators, zemekopni_2, zemekopni_3, zemekopni_4);
        CategoryЕ zemekopni = new CategoryЕ("Земекопни Машини", zemekopniList,
                Arrays.asList(searchParamRepo.findById(parameterE1.getId()), searchParamRepo.findById(parameterE2.getId())),
                CategoryЕ.TYPE_MACHINES);
        CategoryЕ transportni = new CategoryЕ("Транспортни", null, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ boqdisvane = new CategoryЕ("За боядисване", null, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ concreetlaying = new CategoryЕ("Полагане На бетон", null, null, CategoryЕ.TYPE_MACHINES);
        CategoryЕ cranes = new CategoryЕ("Кранове", null,
                Arrays.asList(searchParamRepo.findById(parameterE3.getId()), searchParamRepo.findById(parameterE4.getId()),
                        searchParamRepo.findById(parameterE5.getId())), CategoryЕ.TYPE_MACHINES);
        CategoryЕ vik = new CategoryЕ("ВиК", null, null, CategoryЕ.TYPE_MACHINES);
        List<CategoryЕ> subcategoriesList = Arrays.asList(zemekopni, transportni, boqdisvane, concreetlaying, cranes, vik);
        CategoryЕ machinesRoot = categoryRepo.save(new CategoryЕ("Всички",
//                null,
                subcategoriesList,
                Arrays.asList(searchParamRepo.findById(parameterEprice.getId())),
                CategoryЕ.TYPE_MACHINES));


        //type requesting projects

        CategoryЕ plochki = new CategoryЕ("Лепене на плочки", null,
                Arrays.asList(searchParamRepo.findById(parameter6.getId()), searchParamRepo.findById(parameter7.getId())),
                CategoryЕ.TYPE_SERVICES);
        CategoryЕ painting = new CategoryЕ("Боядисване", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ spaklovki = new CategoryЕ("Шпакловки", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ wallpapers = new CategoryЕ("Лепене на тапети", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ wholeFinishingWorks = new CategoryЕ("Цялостни довършителни работи", null, null, CategoryЕ.TYPE_SERVICES);

        List<CategoryЕ> projectCategories2 = new ArrayList<>();
        projectCategories2.add(new CategoryЕ("Поставяне на контакти", null, null, CategoryЕ.TYPE_SERVICES));
        projectCategories2.add(new CategoryЕ("Полагане на кабели", null, null, CategoryЕ.TYPE_SERVICES));
        projectCategories2.add(new CategoryЕ("Поставяне на осветителни тела", null, null, CategoryЕ.TYPE_SERVICES));


        CategoryЕ finishingWorks = new CategoryЕ("Довършителни работи", Arrays.asList(plochki, painting, spaklovki, wallpapers, wholeFinishingWorks), null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ roofServices = new CategoryЕ("Ремонт на покриви", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ rawBuilding = new CategoryЕ("Груб Строеж", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ vikServices = new CategoryЕ("ВиК", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ el = new CategoryЕ("Електро", projectCategories2, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ transportServices = new CategoryЕ("Транспортни", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ handTransport = new CategoryЕ("Хамалски", null, null, CategoryЕ.TYPE_SERVICES);
        CategoryЕ excavatings = new CategoryЕ("Изкопи", null, Arrays.asList(searchParamRepo.findById(parameterE1.getId())), CategoryЕ.TYPE_SERVICES);
        CategoryЕ projectsRoot = categoryRepo.save(new CategoryЕ("All",
                Arrays.asList(finishingWorks, roofServices, rawBuilding, vikServices, el, transportServices, handTransport, excavatings),
                Arrays.asList(searchParamRepo.findById(parameterEprice.getId())), CategoryЕ.TYPE_SERVICES));




        UserE user1 = this.userRepo.save(new UserE("ivan", "1234", "Ivan", "Kolev", "ikolev@abv.bg", null));
        UserE user2 = this.userRepo.save(new UserE("manol", "1234", "Ivan", "Manolov", "imanolov@abv.bg", null));
        UserE user3 = this.userRepo.save(new UserE("mitko", "1234", "Dimityr", "Bogoev", "dbogoev@abv.bg", null));
        UserE user4 = this.userRepo.save(new UserE("petko", "1234", "Petko", "Karolev", "pkarolev@abv.bg", null));
        UserE user5 = this.userRepo.save(new UserE("stoyan", "1234", "Stoyan", "Yanin", "syanin@abv.bg", null));
        UserE user6 = this.userRepo.save(new UserE("kaloqn", "1234", "Kaloqn", "Sutrov", "ksutrov@abv.bg", null));
        UserE user7 = this.userRepo.save(new UserE("vasil", "1234", "Vasil", "Kamburov", "vkamburov@abv.bg", null));
        UserE user8 = this.userRepo.save(new UserE("petar", "1234", "Petyr", "Kolev", "pkolev@abv.bg", null));
        UserE user9 = this.userRepo.save(new UserE("kosio", "1234", "Konstantion", "Dimitrov", "kdimitrov@abv.bg", null));
        UserE user10 = this.userRepo.save(new UserE("trol", "1234", "Petko", "Konstantinov", "pkonstantinov@abv.bg", null));


        OfferE offer1_1 = new OfferE("Bager", "Bagera e golqm i moshten i e kato nov", "0988933188", null, null, categoryRepo.findById(excavators.getId()).get(),
                Arrays.asList(new OfferParamE(searchParamRepo.findById(parameterE1.getId()), null, 100), new OfferParamE(searchParamRepo.findById(parameterE2.getId()), null, 5)));
        OfferE offer1_2 = new OfferE("BetonPompa", "Betonpompata e zapazena i raboti dobre", "0888314522", null, null, categoryRepo.findById(concreetlaying.getId()).get(), null);

        OfferE offer1_3 = new OfferE("Boqdisvam steni", "Boqdisvam s lateks interiorni steni visoko kachestvo", "0883410072", null, null, categoryRepo.findById(painting.getId()).get(), null);
        OfferE offer2_1 = new OfferE("Remont na pokrivi", "Bagera e golqm i moshten i e kato nov", "0878191834", null, null, categoryRepo.findById(roofServices.getId()).get(), null);
        OfferE offer2_2 = new OfferE("Remont na uluci", "Bagera e golqm i moshten i e kato nov", "0878355108", null, null, categoryRepo.findById(roofServices.getId()).get(), null);
        OfferE offer2_3 = new OfferE("Izvyrshvam izkopni deinosti", "Spravqm se dobre na nai niskite ceni", "0898750100", null, null, categoryRepo.findById(excavatings.getId()).get(),
                Arrays.asList(new OfferParamE(parameterE1, null, 100), new OfferParamE(searchParamRepo.findById(parameterEprice.getId()), null, 200)));

        ConversationE conversationE1_1_2 = new ConversationE(user2);
        MessageE messageE1_1_2_0 = new MessageE("Zdraveite, \n svoboden li e bagera", LocalDateTime.of(2019, 8, 01, 12, 00), true, true);
        MessageE messageE1_1_2_1 = new MessageE("Zdraveite, \n da svoboden e", LocalDateTime.of(2019, 8, 01, 12, 05), false, true);
        List<MessageE> messageEList1_1_2 = Arrays.asList(messageE1_1_2_0, messageE1_1_2_1);
        conversationE1_1_2.setMessageEList(messageEList1_1_2);
        List<ConversationE> conversationEList1_1 = Arrays.asList(conversationE1_1_2);

        offer1_1.setConversationEList(conversationEList1_1);

        List<OfferE> offerEList1 = Arrays.asList(offer1_1, offer1_2, offer1_3);
        user1.setOfferEList(offerEList1);

        List<OfferE> offerEList2 = Arrays.asList(offer2_1, offer2_2, offer2_3);
        user2.setOfferEList(offerEList2);


        EventE event1_1_1 = new EventE(LocalDate.of(2019, 9, 1), user2, null);


        AgreementDetailE agreementDetailE1_1_2_1 = new AgreementDetailE("i 30 kvadrata", 10);
        AgreementDetailE agreementDetailE1_1_2_2 = new AgreementDetailE("i 40 kubika oshte", 50);
        List<AgreementDetailE> agreementDetailEList1_1_2 = Arrays.asList(agreementDetailE1_1_2_1, agreementDetailE1_1_2_2);
        AgreementE agreementE1_1_2 = new AgreementE(false, agreementDetailEList1_1_2, 500);
        event1_1_1.setAgreementE(agreementE1_1_2);

        offer1_1.setEventEList(Arrays.asList(event1_1_1));


        this.userRepo.saveAndFlush(user1);
        this.userRepo.save(user2);

    }
}
