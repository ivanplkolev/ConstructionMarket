package construction_market.configuration;


import construction_market.controllers.OfferSearchSpecification;
import construction_market.entities.*;
import construction_market.entities.categories.CategoryE;
import construction_market.entities.categories.predefined.PredefinedOfferParamE;
import construction_market.entities.categories.predefined.PredefinedValuesE;
import construction_market.entities.categories.predefined.SearchParameterForPredefinedValuesE;
import construction_market.entities.categories.value_parameters.OfferParamE;
import construction_market.entities.categories.value_parameters.SearchParameterE;
import construction_market.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final SearchParamRepo searchParamRepo;
    private final PredefinedSearchParamRepo predefinedSearchParamRepo;
    private final OfferRepo offerRepo;
    private final PredefinedValueRepo predefinedValueRepo;
    private final EventRepo eventRepo;

    @Autowired
    public DatabaseLoader(
            CategoryRepo categoryRepo,
            SearchParamRepo searchParamRepo,
            PredefinedSearchParamRepo predefinedSearchParamRepo,
            OfferRepo offerRepo,
            PredefinedValueRepo predefinedValueRepo,
            UserRepo userRepo, EventRepo eventRepo) {

        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.searchParamRepo = searchParamRepo;
        this.predefinedSearchParamRepo = predefinedSearchParamRepo;
        this.offerRepo = offerRepo;
        this.predefinedValueRepo = predefinedValueRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public void run(String... strings) throws Exception {


        SearchParameterE parameterEprice = searchParamRepo.save(new SearchParameterE("Цена"));

        SearchParameterE parameterE1 = searchParamRepo.save(new SearchParameterE("Кубатура изкопана земна маса/ ден"));
        SearchParameterE parameterE2 = searchParamRepo.save(new SearchParameterE("Кубатура на коша"));

        SearchParameterE parameterE3 = searchParamRepo.save(new SearchParameterE("Товароподемност"));
        SearchParameterE parameterE4 = searchParamRepo.save(new SearchParameterE("Дължина на стрелата"));
        SearchParameterE parameterE5 = searchParamRepo.save(new SearchParameterE("Работен периметър"));

        SearchParameterForPredefinedValuesE parameter6 = predefinedSearchParamRepo.save(new SearchParameterForPredefinedValuesE("Вид плочки",
                Arrays.asList(new PredefinedValuesE("Гранитогрес"), new PredefinedValuesE("Фаянс"), new PredefinedValuesE("Теракот"))));
        SearchParameterE parameter7 = searchParamRepo.save(new SearchParameterE("Квадратура на ден"));

        PredefinedValuesE adres1 = new PredefinedValuesE("София");
        PredefinedValuesE adres2 = new PredefinedValuesE("Бургас");
        PredefinedValuesE adres3 = new PredefinedValuesE("Пловдив");
        PredefinedValuesE adres4 = new PredefinedValuesE("Монтана");
        PredefinedValuesE adres5 = new PredefinedValuesE("Варна");
        PredefinedValuesE adres6 = new PredefinedValuesE("Велико Търново");

        SearchParameterForPredefinedValuesE parameterAdres = predefinedSearchParamRepo.save(new SearchParameterForPredefinedValuesE("Адрес",
                Arrays.asList(adres1, adres2, adres3, adres4, adres5, adres6)));


        CategoryE zemekopni_1_1 = new CategoryE("Верижни багери", null, null, null, null);
        CategoryE zemekopni_1_2 = new CategoryE("Колесни багери", null, null, null, null);

        List<CategoryE> zemekopniList_1 = Arrays.asList(zemekopni_1_1, zemekopni_1_2);

        CategoryE excavators = new CategoryE("Багври", zemekopniList_1, null, null, null);
        CategoryE zemekopni_2 = new CategoryE("Челни товарачи", null, null, null, null);
        CategoryE zemekopni_3 = new CategoryE("Сондиращи машини", null, null, null, null);
        CategoryE zemekopni_4 = new CategoryE("Челни товарачи", null, null, null, null);


        List<CategoryE> zemekopniList = Arrays.asList(excavators, zemekopni_2, zemekopni_3, zemekopni_4);
        CategoryE zemekopni = new CategoryE("Земекопни Машини", zemekopniList,
                Arrays.asList(searchParamRepo.findById(parameterE1.getId()), searchParamRepo.findById(parameterE2.getId())),
                null, null);
        CategoryE transportni = new CategoryE("Транспортни", null, null, null, null);
        CategoryE boqdisvane = new CategoryE("За боядисване", null, null, null, null);
        CategoryE concreetlaying = new CategoryE("Полагане На бетон", null, null, null, null);
        CategoryE cranes = new CategoryE("Кранове", null,
                Arrays.asList(searchParamRepo.findById(parameterE3.getId()), searchParamRepo.findById(parameterE4.getId()),
                        searchParamRepo.findById(parameterE5.getId())), null, null);
        CategoryE vik = new CategoryE("ВиК", null, null, null, null);
        List<CategoryE> subcategoriesList = Arrays.asList(zemekopni, transportni, boqdisvane, concreetlaying, cranes, vik);
        CategoryE machinesRoot = categoryRepo.save(new CategoryE("Всички",
                subcategoriesList,
                Arrays.asList(searchParamRepo.findById(parameterEprice.getId())),
                CategoryE.TYPE_MACHINES,
                Arrays.asList(predefinedSearchParamRepo.findById(parameterAdres.getId()))));


        //type requesting projects

        CategoryE plochki = new CategoryE("Лепене на плочки", null, null, null, null);
        CategoryE painting = new CategoryE("Боядисване", null, null, null, null);
        CategoryE spaklovki = new CategoryE("Шпакловки", null, null, null, null);
        CategoryE wallpapers = new CategoryE("Лепене на тапети", null, null, null, null);
        CategoryE wholeFinishingWorks = new CategoryE("Цялостни довършителни работи", null, null, null, null);

        List<CategoryE> projectCategories2 = new ArrayList<>();
        projectCategories2.add(new CategoryE("Поставяне на контакти", null, null, null, null));
        projectCategories2.add(new CategoryE("Полагане на кабели", null, null, null, null));
        projectCategories2.add(new CategoryE("Поставяне на осветителни тела", null, null, null, null));


        CategoryE finishingWorks = new CategoryE("Довършителни работи", Arrays.asList(plochki, painting, spaklovki, wallpapers, wholeFinishingWorks), null, null, null);
        CategoryE roofServices = new CategoryE("Ремонт на покриви", null, null, null, null);
        CategoryE rawBuilding = new CategoryE("Груб Строеж", null, null, null, null);
        CategoryE vikServices = new CategoryE("ВиК", null, null, null, null);
        CategoryE el = new CategoryE("Електро", projectCategories2, null, null, null);
        CategoryE transportServices = new CategoryE("Транспортни", null, null, null, null);
        CategoryE handTransport = new CategoryE("Хамалски", null, null, null, null);
        CategoryE excavatings = new CategoryE("Изкопи", null, Arrays.asList(searchParamRepo.findById(parameterE1.getId())), null, null);
        CategoryE servicesRoot = categoryRepo.save(new CategoryE("Всички",
                Arrays.asList(finishingWorks, roofServices, rawBuilding, vikServices, el, transportServices, handTransport, excavatings),
                Arrays.asList(searchParamRepo.findById(parameterEprice.getId())), CategoryE.TYPE_SERVICES,
                Arrays.asList(predefinedSearchParamRepo.findById(parameterAdres.getId()))));


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
                Arrays.asList(new OfferParamE(searchParamRepo.findById(parameterE1.getId()), 100), new OfferParamE(searchParamRepo.findById(parameterE2.getId()), 5)),
                Arrays.asList(new PredefinedOfferParamE(predefinedSearchParamRepo.findById(parameterAdres.getId()),
                        predefinedValueRepo.findById(adres1.getId()))));
        OfferE offer1_2 = new OfferE("BetonPompa", "Betonpompata e zapazena i raboti dobre", "0888314522", null, null, categoryRepo.findById(concreetlaying.getId()).get(), null,
                Arrays.asList(new PredefinedOfferParamE(predefinedSearchParamRepo.findById(parameterAdres.getId()),
                        predefinedValueRepo.findById(adres5.getId()))));

        OfferE offer1_3 = new OfferE("Boqdisvam steni", "Boqdisvam s lateks interiorni steni visoko kachestvo", "0883410072", null, null, categoryRepo.findById(painting.getId()).get(), null,
                Arrays.asList(new PredefinedOfferParamE(predefinedSearchParamRepo.findById(parameterAdres.getId()),
                        predefinedValueRepo.findById(adres2.getId()))));
        OfferE offer2_1 = new OfferE("Remont na pokrivi", "Pokrivi smenqm keremidi i pravq izolacii", "0878191834", null, null, categoryRepo.findById(roofServices.getId()).get(), null,
                Arrays.asList(new PredefinedOfferParamE(predefinedSearchParamRepo.findById(parameterAdres.getId()),
                        predefinedValueRepo.findById(adres2.getId()))));
        OfferE offer2_2 = new OfferE("Remont na uluci", "Smenqm s PVC i medni uluci", "0878355108", null, null, categoryRepo.findById(roofServices.getId()).get(), null,
                Arrays.asList(new PredefinedOfferParamE(predefinedSearchParamRepo.findById(parameterAdres.getId()),
                        predefinedValueRepo.findById(adres2.getId()))));
        OfferE offer2_3 = new OfferE("Izvyrshvam izkopni deinosti", "Spravqm se dobre na nai niskite ceni", "0898750100", null, null, categoryRepo.findById(excavatings.getId()).get(),
                Arrays.asList(new OfferParamE(searchParamRepo.findById(parameterE1.getId()), 100),
                        new OfferParamE(searchParamRepo.findById(parameterEprice.getId()), 200)),
                Arrays.asList(new PredefinedOfferParamE(predefinedSearchParamRepo.findById(parameterAdres.getId()),
                        predefinedValueRepo.findById(adres1.getId()))));

        ConversationE conversationE1_1_2 = new ConversationE(user2);
        MessageE messageE1_1_2_0 = new MessageE("Zdraveite, \n svoboden li e bagera", LocalDateTime.of(2019, 8, 01, 12, 00), true, true);
        MessageE messageE1_1_2_1 = new MessageE("Zdraveite, \n da svoboden e", LocalDateTime.of(2019, 8, 01, 12, 05), false, true);
        List<MessageE> messageEList1_1_2 = Arrays.asList(messageE1_1_2_0, messageE1_1_2_1);
        conversationE1_1_2.setMessageEList(messageEList1_1_2);
        List<ConversationE> conversationEList1_1 = Arrays.asList(conversationE1_1_2);

        offer1_1.setConversationEList(conversationEList1_1);


        offerRepo.save(offer1_1);
        List<OfferE> offerEList1 = Arrays.asList(offerRepo.findById(offer1_1.getId()), offer1_2, offer1_3);
        user1.setOfferEList(offerEList1);

        offerRepo.save(offer2_1);
        List<OfferE> offerEList2 = Arrays.asList(offerRepo.findById(offer2_1.getId()), offer2_2, offer2_3);
        user2.setOfferEList(offerEList2);

        this.userRepo.saveAndFlush(user1);
        this.userRepo.save(user2);

        AgreementDetailE agreementDetailE1_1_2_1 = new AgreementDetailE("i 30 kvadrata", 10);
        AgreementDetailE agreementDetailE1_1_2_2 = new AgreementDetailE("i 40 kubika oshte", 50);
        List<AgreementDetailE> agreementDetailEList1_1_2 = Arrays.asList(agreementDetailE1_1_2_1, agreementDetailE1_1_2_2);
        AgreementE agreementE1_1_2 = new AgreementE(AgreementE.STATUS_NEW, agreementDetailEList1_1_2, 500);

        this.eventRepo.save(new EventE(offerRepo.findById(offer1_1.getId()),
                LocalDate.of(2019, 10, 16), user2, agreementE1_1_2, LocalDate.of(2019, 10, 17), ""));

        this.eventRepo.save(new EventE(offerRepo.findById(offer2_1.getId()),
                LocalDate.of(2019, 10, 15), user1, null, LocalDate.of(2019, 10, 30), ""));


//        runTestes();
    }


    private void runTestes() {

        String searchInput = "";
        Long cat = categoryRepo.findByName("Изкопи").getId();
        Map<Long, Integer> mins = new HashMap<>();
        Map<Long, Integer> maxs = new HashMap<>();

        mins.put(1L, 1222);
//        maxs.put(1L, 100);


        OfferSearchSpecification specification = new OfferSearchSpecification(searchInput, cat, mins, maxs, null);

        List<OfferE> offers = offerRepo.findAll(specification);


        offers.forEach(a -> System.out.println(a.getTitle()));
    }
}
