package com.example.vegeplanting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Vegetable.db";
    public static final String TABLE_NAME = "vegetable_table";
    public static final String PLAN_TABLE = "plan_table";
    public static final String NOTE_TABLE = "note_table";
    public static final String CALENDAR_TABLE = "calendar_table";
    public static final int version = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, VEGENAME TEXT, DESCRIPTION TEXT)");
        db.execSQL("CREATE TABLE " + PLAN_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, VEGENAME TEXT, DATEPLANTED TEXT, IMAGE BLOB, VEGECOUNT TEXT, HARVESTDATE TEXT)");
        db.execSQL("CREATE TABLE " + CALENDAR_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATEPLANTED TEXT, HARVESTDATE TEXT, VEGEID INTEGER, DESCRIPTION TEXT)");
        db.execSQL("CREATE TABLE " + NOTE_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, VEGENAME TEXT, NOTEDATE TEXT, NOTE TEXT, VEGEID INTEGER)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (VEGENAME,DESCRIPTION) VALUES ('EGGPLANT','DESCRIPTION\n\n" +
                "Eggplant, Solanum melongena, is a tropical, herbaceous, perennial plant, closely related to tomato, in the family Solanaceae which is grown for its edible fruit. The plants has a branching stem and simple, long, flat. coarsely lobed leaves which are green in color and are arranged alternately on the branches. The leaves can measure 10 to 20 cm (4–8 in) long and 5 to 10 cm (2–4 in) broad. The plant produces purple flowers which are 3–5 cm (1.2–2.0 in) in diameter. The fruit is a large, fleshy ovoid berry which can reach 40 cm (15.7 in) in length, with glossy smooth skin and numerous small seeds. The color of the fruit is variable and can be white, green, yellow, purple or black. Eggplants can reach up to 1.5 m (4.9 ft) in height and although they are perennial plants, they are most commonly grown as annuals. Eggplant may also be referred to as aubergine or guinea squash and originates from the Indian subcontinent.\n" +
                "\n\n\n" +
                "USES\n\n" +
                "Eggplant is usually cooked before consumption and is eaten as a vegetable.\n" +
                "\n\n\n" +
                "PROPAGATION\n\n" +
                "Basic requirements Eggplants are warm-season crops which require a long growing season.They grow best in regions where the daytime temperature is between 26 and 32°C (80–90°F) and night time temperatures around 21°C (70°F). In addition, eggplant is a sun loving plant and should be positioned in an area that receives full sunlight. Plants will perform best when planted in a fertile soil with a pH between 6.3 and 6.8. Sowing seeds In cold areas and regions with a short growing season it is necessary to start eggplant indoors or in a glasshouse. In addition, eggplant will often perform much better in colder areas if planted in containers or grown under row covers as this helps to keep the soil warm. Seeds should be sown indoors 6 to 8 weeks before the last frost date. Sow seeds thickly in seed trays containing good quality sterile seed starting mix to a depth of 6 mm (0.25 in). Keep the trays moist and provide bottom heat by placing on a heat mat or in a warm area of the house. Seedling should be potted into larger pots when they have two sets of true leaves. Transplanting Eggplant seedlings can be transplanted after hardening-off and when all danger of frost has passed in your area. Seedlings should be spaced 45–60 cm (18–24 in) apart, depending on variety, allowing a further 60–90 cm (24–36 in) between rows. General care and maintenance Eggplant may benefit from the addition of mulch to conserve soil moisture and maintain a higher soil temperature. Row covers will help to increase the temperature around the plants in cooler climates and during cool spells in otherwise warm areas. The row covers should be removed to allow pollinators to access the plants during flowering. Eggplant should be provided with a steady water supply for optimum development of fruit and the soil around the plants should not be allowed to dry out but should also not be wet. Plants can be laden with numerous fruit and the use of stakes and supports can help to support the plants before harvest. Harvesting Eggplant fruits are ready to harvest while the flesh is still firm and seeds are small and tightly packed. The skin of the fruit should be firm, glossy and dark purple. Over ripe fruit will contain darker seeds and will taste bitter. Harvest the fruit as soon as it is ripe to ensure maximum productivity. The fruit should be removed from the plant by cutting the calyx (green stem above the fruit) with a sharp knife.')," +

                "('TOMATO','DESCRIPTION\n\n" +
                "Tomato, Lycopersicum esculentum (syn. Solanum lycopersicum and Lycopersicon lycopersicum) is an herbaceous annual in the family Solanaceae grown for its edible fruit. The plant can be erect with short stems or vine-like with long, spreading stems. The stems are covered in coarse hairs and the leaves are arranged spirally. The tomato plant produces yellow flowers, which can develop into a cyme of 3–12, and usually a round fruit (berry) which is fleshy, smoothed skinned and can be red, pink, purple, brown, orange or yellow in color. The tomato plant can grow 0.7–2 m (2.3–6.6 ft) in height and as an annual, is harvested after only one growing season. Tomato may also be referred to as love apple and originates from South America.\n" +
                "\n\n\n" +
                "USES\n\n" +
                "Tomato fruit can be eaten raw or cooked and is used in many dishes. The fruit may also be processed into juice, soup, ketchup, puree, paste or powder.\n" +
                "\n\n\n" +
                "PROPAGATION\n\n" +
                "Requirements Tomatoes grow very well in warm areas at temperatures between 21 and 24°C (69.8–75.2°F). They require a deep, loamy, well-draining soil with a pH between 5.5 and 6.8. If soil drainage is a problem then tomatoes can be planted in a raised bed. Like all fruiting plants, tomatoes require full sun for most of the day. Tomato varieties Determinate (“bush”) tomatoes have been purposefully bred to grow vertically and remain relatively compact. The plant will stop growing once fruit begins developing on the terminal shoot and all the fruits ripen at around the same time. In contrast, indeterminate (“vining”) tomato varieties spread laterally and will continue to grow and produce fruit until frosts begin the the Fall. Indeterminate varieties can produce fruit all season and fruits will develop and ripen at different times. Heirloom tomatoes are generally open-pollinated varieties which have been conserved over many generations due to certain desirable characteristics such as flavor. Hybrid tomatoes are the product of cross-pollination between two parents with desirable characteristics such as high yield, early maturation, improved flavor or resistance to certain diseases. Sowing seeds In most cases, tomato seeds should be started indoors 6–8 weeks before last Spring frost. Seeds can be direct seeded in areas with a long growing season. Seeds should be sown in flats or cell trays using a sterile seedling mix. Plant seeds to a depth of 0.6 cm (1/4 in) and water lightly. If cells are being used, plant several seeds in each cell and thin to 1 seedling after germination. Position trays in a bright South facing window or under fluorescent lighting. The optimum soil temperature for germination is 21–32°C (70–90°F). A heat mat can be used to warm the flats if required. Seedlings should emerge within 6-14 days and after the seedlings has developed the first set of true leaves then they can be moved to a larger (3-4 in) pot and moved to a cooler temperature (16–21°C/60–70°F). Transplanting Tomato seedlings are ready to be transplanted once they are 15–25 cm (6–10 in) in height and have 3–5 true leaves assuming all danger of frost has passed. Beginning approximately 7-10 days before transplanting, plants should be set outside to harden off (see https://www.plantvillage.com/posts/264). The transplanting site should be prepared by working in a balanced fertilizer according to the guidelines on the product label. Transplants should be spaced 76–123 cm (30–48 in) apart with a between row spacing of 123 cm (48 in). It is common practice to plant tomatoes in trenches on their side (see https://www.plantvillage.com/posts/833-tomato) as tomato stems will sprout roots along their length when buried. Avoid over-fertilizing transplants, particularly with nitrogen, at this stage of growth as it will promote growth of foliage rather than fruits. Water plants lightly at base instead of overhead as wet foliage is more prone to diseases and the buried stem needs time to adapt and sprout roots. It is important that tomato plants receive even watering to prevent the development of blossom end rot, drip or soaker hoses work best and mulching around the plants helps to conserve soil moisture. Stakes, Cages and Trellises Staking, caging or trellising tomatoes supports the plants and helps to keep fruit off of the ground as well as increasing air circulation around the foliage which helps to prevent disease. The type of support system used depends on the type of tomatoes being grown. Determinate tomatoes have short or medium length vines and stop growing once fruit develops on the terminal branches. Determinates can be staked or caged but do not adapt to trellises. The position of the fruit means that little heavy pruning is required. In contrast, indeterminate tomatoes grow indefinitely and require a support system to prevent them trailing along the ground. The amount of pruning required depends on the support system being utilized - vines require only light pruning when caged, moderate pruning when staked and heavy pruning when using a trellis.\n')," +

                "('OKRA','DESCRIPTION\n\n" +
                "Okra, Abelmoschus esculentus, is an herbaceous annual plant in the family Malvaceae which is grown for its edible seed pods. Okra plants have small erect stems that can be bristly or hairless with heart-shaped leaves. The leaves are 10–20 cm (4–8 in) long with 5–7 lobes The plant produces flowers with five white to yellow petals which are 4–8 cm (1.6–3.1 in) in diameter. The seed pod is a capsule up to 25 cm (10 in) long, containing numerous seeds. Okra can grow 1.2–1.8 m (4–6 ft) tall and as an annual plant, survives only one growing season. Okra may also be referred to as ladys fingers and is believed to have originated in Ethiopia." +
                "\n\n\n" +
                "USES\n\n" +
                "The young seed pods are eaten fresh or cooked as a vegetable. The seeds can be used to extract oil. Okra fiber can be used in paper production." +
                "\n\n\n" +
                "PROPAGATION\n\n" +
                "Basic requirements Okra is a heat loving plant, growing best in southern climates in a well draining, light sandy to medium loams. Soils should be high in organic matter with a pH between 5.8 to 6.8. If planting in clay soil, transplants are recommended due to the difficulty encountered in seedling emerging from the heavy soil. The plant should be grown in an area of high sunlight and grows best in hot temperatures. Soil temperatures should be at least 18.3°C (65°F) with optimal growth of the plants occurring at soil temperatures between 23.9–32.3°C (75–90°F). Propagation Okra is typically propagated from seed. Soaking seeds in water overnight prior to planting helps the plants to germinate. In the home garden, seeds should be sown at a depth of 2.5 cm (1 in) leaving 25–45 cm (10–18 in) between rows only after the soil has reached a temperature of 18°C (65°F). In commercial okra production, seeds are planted in rows spaced 0.65–1.0 m (26–40 in) apart. Okra seed is commonly planted at a rate of 10 lb per acre but this quantity is vastly reduced by the use of precision planting methods. Seedlings are thinned to a final spacing of 15.0–22.5 cm (6–9 in) when they are 4–6 weeks old to produce the final plant stand. General care and maintenance Okra requires a moist soil for optimum development. Water should be applied at a rate of 1.5 inches every 10 days is recommended in hotter areas. In cooler climates, plants require less water as it tends to cool the plants and restrict their growth. Okra benefits from the addition of nitrogen and phosphorous. Growers generally apply ammonium phosphate fertilizer that contain both nutrients at a rate of 100 lb per acre prior to planting seed. Chicken manure may be spread in place of chemical fertilizer 1 week prior to planting. An additional side dressing of 40–60 lb of nitrogen can be applied 6 weeks after planting. Due to the long period over which okra is harvested, weeds can become a problem and require management. in the home garden, weeds can be removed by careful cultivation of the soil around the plants. Applications of appropriate herbicides may be required in commercial production. Harvesting Pods are usually ready for harvesting 2 months after planting. Okra pods are generally ready to harvest 4 to 6 days after flowering and pods should be harvested every 2–3 days when they have reached 7.6–15.2 cm (3–5 in) in length. Pods can be removed from the plant by cutting with a sharp knife or by snapping from the plant.')," +

                "('STRING BEANS','DESCRIPTION\n\n" +
                "A herbaceous crop, pole sitao has trifoliate leaves. The flowers are in pairs and borne on the axil of the leaf which vary in color depending on the variety. Calyxes are generally green and purple. It is a viny annual crop that produces 30-60 cm long pods which hang in pairs with many seeds. Pods are either green, dark green, light green or purple. They are quick growing and every other day harvesting is often necessary. Pole sitao is an important crop in Asian countries like Malaysia, Thailand, Indonesia and the Plippines. It is also considered as one of the most important vegetables in certain parts of Taiwan and China.\n" +
                "In the Philippines, pole sitao is the most popularly produced vegetable among edible legumes because the pods, young shoots as well as the beans are available throughout the year. It is grown in home gardens, on dikes around paddy fields, under partially shaded areas as a companion crop or commercial crop.\n" +
                "The succulent young pods of pole sitao are eaten as whole pods and only need very light cooking. It can also be a good supplement to infant food whether cooked singly or mixed with other vegetables. The young leaves, shoots and sprouted seedlings can also be utilized as vegetables. Juices from the leaves are used for some medicinal properties.\n" +
                "Bureau of Agricultural Statistics (BAS), 2010 showed that the total land area planted to pole sitao is 14, 681 hectares with a total volume of production of 119, 453.02 metric tons. Central Luzon has the highest volume of production (32%), followed by Cagayan Valley (15%) and Davao Region (11%).\n" +
                "Pole sitao is a good source of protein, vitamin A, thiamin, riboflavin, iron, phosphorous and potassium. It is also a very good source of vitamin C, folate, magnesium and manganese.')," +

                "('SQUASH','Description\n" +
                "Squash is the collective name given to several species of plant in the genus Cucurbita, including C. maxima, C. mixta , C. moschata and C. pepo, which are widely grown for their edible fruit. Squash plants are are herbaceous annual plants which are either trailing vines or bush-like in morphology. Vines generally have large, lobed leaves and long vines which can climb by attaching to surfaces with their tendrils. Bushes generally take up less space than the sprawling vine types and may have prickly leaves. Squash plants produce yellow or orange flowers and green, white or yellow fruit in a variety of shapes and sizes with smooth or ridged skin. Vining squash varieties can reach several meters in length and, as annuals, survive only one growing season. Squash originate from North and Central America and are referred to by their cultivar name e.g. acorn squash, butternut squash, spaghetti squash, zucchini, banana squash, hubbard squash and buttercup squash.\n" +
                "\n\n\n" +
                "USES\n\n" +
                "Squash fruit can be cooked and eaten as a vegetable. Some varieties are grown as ornamentals.\n" +
                "\n\n\n" +
                "PROPAGATION\n\n" +
                "Basic requirements Squash is a warm-season crop, requiring lots of sun and good drainage to develop optimally and growing best at temperatures between 18 and 25°C (65–75°F). Squash will yield best if grown in a fertile, well-draining soil, rich in organic matter and with a pH between 6.5 and 7.5. Squash should be planted in full sun and provided with ample soil moisture due to their shallow root system. Vining varieties can grow to very large sizes and require a good deal of space. Smaller bush varieties are available for more modest spaces. Propagation Squash is propagated from seed and can be direct seeded or sown indoors and transplanted. If direct seeding,seeds should be sown after the last frosts and when the soil has warmed to at least 15.6°C (60°F). Sow 1–2 seeds 1.3–2.5 cm (0.5–1.0 in) deep, at least 90 cm (~3 ft) apart if growing bush varieties and 120–150 cm (4–5 ft) apart if growing vining varieties. Allow a further 1–3 m (6–10 ft) between rows depending on the variety. If transplanting, seeds should be sown 3–4 weeks before the last frost date in your area and transplanted before the plants develop their second set of true leaves. Seeds in sown both indoors and out require lightly moist soil for germination, care should be taken to avoid overwatering. Seeds should germinate in 5–10 days depending on the soil temperature. General care and maintenance Squash vines are sprawling and require plenty space to grow. Vines can be trained to grow on a trellis or fence. Squash also require a continuous supply of water and where drip irrigation is not being used, plants should be watered deeply once per week, providing at least an inch of water. Shallow watering or watering less frequently encourages a shallow root system. Mulches can be used to conserve soil moisture and black polyethylene mulch has the advantage of warming the soil. All squash varieties produce both male and female flowers (monoecious) and are pollinated by insects such as bees. Harvesting Squash is ready to harvest when the rind is hard and cannot be punctured with a fingernail. The skin of mature fruits is dull and dry in appearance, especially when compared with the shiny skin of an immature fruit.\n')," +

                "('PARSLEY','DESCRIPTION\n\n" +
                "Parsley is a hardy, biennial that is grown and treated like an annual.  It is the most widely grown herb for both garnish and flavoring.  There are two distinct types of parsley:  moss-curled and flat-leaf. Moss-curled forms a rosette of leaves that are finely cut and tightly curled.  It is often used for garnish.  Flat-leaf produces a rosette of leaves that are flat and is the preferred parsley for cooking as it has more flavor." +
                "\n\n\n" +
                "USES\n\n" +
                "Parsley is often seen used as a garnish.  It also has the unique ability to blend with the flavors of other herbs.  It is used to flavor stews, soups and other vegetables.')," +

                "('WATER SPINACH','INTRODUCTION\n\n" +
                "Water Spinach (Ipomoea aquatica) is a member of the Convolvulaceae (Morning glory) family and the same genus as the sweet potato (Ipomoea batatas). Water spinach is an herbaceous aquatic or semi-aquatic perennial plant of the tropics and subtropics. It has a creeping growth habit but may grow erect in water. There are two major cultivars of water spinach. Ching Quat, also known as “green stem” water spinach, has narrow leaves and white flowers and is usually grown in moist soils. Pak Quat, also known as “white stem” water spinach, has arrow-shaped leaves and pink flowers and is grown in aquatic conditions, similar to rice.\n" +
                "Almost all parts of the young plant tissue are edible, but the tender shoot tips and younger leaves are preferred. Other names of water spinach include: water convolvulus, swamp cabbage (English); kankon, you-sai (Japanese); ong tsoi, weng cai (Cantonese); toongsin tsai (Mandarin); kang kong (Filipino, Malaysian); kang kung, rau muong (Vietnamese); pak bung (Thai); batata acquatica, cancon (Portuguese).\n" +
                "Ipomoea aquatica is a federal noxious weed in the United States. Under authority of the Federal Noxious Weed Act, the USDA Animal and Plant Health Inspection Service (APHIS) prohibits the importation and interstate movement of this species, except under a USDA-issued noxious weed permit. Water spinach is on the federal noxious weed list because it becomes an established weed in fresh water-ways in tropical climates. It has become an established weed in several southern states in the United States.\n" +
                "The UMass Extension Vegetable Team has worked with federal and state regulators to create a permitting system for the legal growth and sale of water spinach in Massachusetts. Since water spinach is extremely sensitive to frost, it does not pose a threat to water systems in Massachusetts. To find out about growing this crop legally in the United States, contact the APHIS web site for more information.\n" +
                "\n\n\n" +
                "PRODUCTION\n\n" +
                "Water spinach is a frost sensitive plant. Optimal temperatures for growth are between 75° and 85° F and chilling injury can occur below 50° F. The cultivar Ching Quat is grown in moist soils, often in beds. Direct seed or transplants may be used. Many Asian growers in Massachusetts will soak the seed until germination to ensure the seed is viable. Growers plant in beds with 6 – 10 seeds per foot in rows that are 6 – 8 inches wide. Plant stems are not strong, but plants grown in beds support each other and produce longer stems with less branching, which is what the market prefers.\n" +
                "Water spinach needs much more water than most other vegetable crops. This increased irrigation can leach out readily available nutrients, so it is recommended to use slow-release forms of fertility. Harvest of the entire plant can be made 50 to 60 days after planting. Plants are harvested by cutting the stem close to the ground and then nitrogen is applied to encourage re-growth. Shoots regrow readily and in Massachusetts, growers will get two to three cuttings of water spinach before frost. The cultivar Pak Quat requires the same aquatic environment as paddy rice, meaning it can’t be grown viably in New England.')," +

                "('LETTUCE','DESCRIPTION\n\n" +
                "Lettuce, Lactuca sativa, is a leafy herbaceous annual or biennial plant in the family Asteraceae grown for its leaves which are used as a salad green. The lettuce plant can vary greatly in size, shape and leaf type but generally, the leaves of the plant form a dense head or loose rosette. The stem of the plant is short, with larger leaves arranged at the bottom and becoming progressively smaller further up the stem. Leaves can be smooth or curly and are usually green or red in color. The lettuce plant can grow to a height of 30–100 cm (12–40 in) in height and is typically grown as an annual, harvested after only one growing season. Lettuce may be referred to as garden lettuce and is believed to originate from Asia Minor and the Middle East.\n" +
                "\n\n\n" +
                "USES\n\n" +
                "Lettuce is primarily eaten raw as a salad green. Some varieties can be cooked and eaten as a vegetable.\n" +
                "\n\n\n" +
                "PROPAGATION\n\n" +
                "Requirements Lettuce is a cool season crop which will grow optimally at daytime temperatures of 15–20°C (59–68°F). The plant can be grown in a wide range of soils as long as it is fertile and moisture retaining due to the small root system of the plant. It is often grown in alkaline soil (pH greater than 7.0) but will not tolerate acid soil. Heat tolerant varieties can be grown over the summer months and care should be taken to protect the leaves from strong sun by shading or covering to prevent the plants from bolting. Sowing seeds Lettuce seeds can be sown directly in the garden or field as soon as the soil can be worked as the seeds will germinate at temperatures of 4.4°C (40°F) and above and seedlings will tolerate a light frost. Seeds should be sown 0.3–0.6 cm (1/8–1/4 in) deep and 2.5 cm (1 in) apart, leaving 50 cm (20 in) between rows. Cover the seeds lightly, tamp the soil and water the seeds. Seedlings should emerge in 2–15 days. When the plants have 2–3 true leaves then they should be thinned to a final spacing of 25–45 cm (10 to 18 in) depending on the variety. Plant new seeds every 2–3 weeks for a continuous harvest. Transplants Sow seeds in seedling trays in a sterile seed starting mix at a rate of approximately 3–4 seeds per inch (2.5 cm). Young plants can be potted up into larger pots or cell trays when they are about 2 weeks old. Plant transplants in the garden after hardening off, spacing plants 25–45 cm (10 to 18 in) (depending on variety) and allowing 50 cm (20 in) between rows. Plant new seeds every 2–3 weeks for a continuous harvest.')," +

                "('BOTTLE GOURD','DESCRIPTION\n\n" +
                "Bottle gourd can vary in size shape and length depending on how it is grown and when it is harvested. It can be short and round, uniformly cylindrical, curved, bulbous, or extremely long and thin. Its skin is most often smooth though there are some varieties that are covered in fine hairs. Its coloring can vary from a light green or chartreuse to dark green. The interior flesh is creamy white with petite seeds that when young are tender and edible but when more mature become hard and should be removed prior to consumption. Young bottle gourd squash offers a mild flavor reminiscent of summer squash and cucumber with a firm texture.\n" +
                "\n\n\n" +
                "SEASONS/AVAILABILITY\n\n" +
                "Bottle gourd is found growing year-round in tropical climates.\n" +
                "\n\n\n" +
                "CURRENT FACTS\n\n" +
                "Bottle gourd, botanically a part of Lagenaria siceraria is a vine and a member of the Cucurbitaceae family. When young it is utilized as a vegetable in preparations similar to that for squash and once mature it can be dried and hollowed out to make utensils, musical instruments and vessels. The Bottle gourd has a rich history and was one of the first cultivated plants in the world. It is known today by many different names throughout the world, most notably as a Calabash, Opo, Cucuzza and Long melon.')," +

                "('BITTER MELON','DESCRIPTION\n\n" +
                "This herbaceous, tendril-bearing vine grows up to 5 m (16 ft) in length. It bears simple, alternate leaves 4–12 cm (1.6–4.7 in) across, with three to seven deeply separated lobes. Each plant bears separate yellow male and female flowers. In the Northern Hemisphere, flowering occurs during June to July and fruiting during September to November.\n" +
                "The fruit has a distinct warty exterior and an oblong shape. It is hollow in cross-section, with a relatively thin layer of flesh surrounding a central seed cavity filled with large, flat seeds and pith. The fruit is most often eaten green, or as it is beginning to turn yellow. At this stage, the fruit flesh is crunchy and watery in texture, similar to cucumber, chayote or green bell pepper, but bitter. The skin is tender and edible. Seeds and pith appear white in unripe fruits; they are not intensely bitter and can be removed before cooking.\n" +
                "Some sources claim the flesh (rind) becomes somewhat tougher and more bitter with age, but other sources claim that at least for the common Chinese variety the skin does not change and bitterness decreases with age. The Chinese variety are best harvested light green possibly with a slight yellow tinge or just before. The pith becomes sweet and intensely red; it can be eaten uncooked in this state, and is a popular ingredient in some Southeast Asian salads.\n" +
                "When the fruit is fully ripe, it turns orange and soft, and splits into segments which curl back to expose seeds covered in bright red pulp.\n" +
                "\n\n\n" +
                "VARIATIES\n\n" +
                "Bitter melon comes in a variety of shapes and sizes. The cultivar common in China is 20–30 cm (7.9–11.8 in) long, oblong with bluntly tapering ends and pale green in colour, with a gently undulating, warty surface. The bitter melon more typical of India has a narrower shape with pointed ends, and a surface covered with jagged, triangular \"teeth\" and ridges. It is green to white in colour. Between these two extremes are any number of intermediate forms. Some bear miniature fruit of only 6–10 cm (2.4–3.9 in) in length, which may be served individually as stuffed vegetables. These miniature fruit are popular in Bangladesh, India, Pakistan, Nepal and other countries in South Asia. The sub-continent variety is most popular in Bangladesh and India.')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PLAN_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + NOTE_TABLE);
    }

    public Cursor getDescription(String name) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE VEGENAME ='" + name + "'", null);
        return cursor;
    }

    public Cursor getPlan(String sql) {
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void deletePlan(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "DELETE FROM " + PLAN_TABLE + " WHERE ID=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();
    }

    public void insertPlanWithImage(String vegetableName, String datePlanted, byte[] image, String vegeCount, String harvestDate) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO " + PLAN_TABLE + " VALUES(NULL,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, vegetableName);
        statement.bindString(2, datePlanted);
        statement.bindBlob(3, image);
        statement.bindString(4, vegeCount);
        statement.bindString(5, harvestDate);

        statement.executeInsert();
    }

    public void insertNote(String vegename, String note, String dateOfNote, int vegeid) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO " + NOTE_TABLE + " VALUES(NULL,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, vegename);
        statement.bindString(2, dateOfNote);
        statement.bindString(3, note);
        statement.bindDouble(4, (double) vegeid);

        statement.executeInsert();
    }

    public Cursor getNote(String sql) {
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void updateNote(String note, int id, int vegeid) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE " + NOTE_TABLE + " SET NOTE=? WHERE ID=? AND VEGEID=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1, note);
        statement.bindDouble(2, (double) id);
        statement.bindDouble(3, (double) vegeid);

        statement.execute();
        database.close();
    }

    public void deleteNote(int id, int vegeid) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "DELETE FROM " + NOTE_TABLE + " WHERE ID=? AND VEGEID=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);
        statement.bindDouble(2, (double) vegeid);

        statement.execute();
        database.close();
    }

    public void insertCalendar(String datePlanted, String harvestDate, int vegeID, String description) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO " + CALENDAR_TABLE + " VALUES(NULL,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, datePlanted);
        statement.bindString(2, harvestDate);
        statement.bindDouble(3, vegeID);
        statement.bindString(4, description);

        statement.executeInsert();
    }

    public Cursor checkIfAlreadyInsert(String sql){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    public void deleteCalendar(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "DELETE FROM " + CALENDAR_TABLE + " WHERE VEGEID=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();
    }
    public void deleteNote2(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "DELETE FROM " + NOTE_TABLE + " WHERE VEGEID=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();
    }

    public Cursor getCalendarEvent(String sql){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery(sql,null);
    }


    public void deleteEvent(int id, int vegeid) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "DELETE FROM " + CALENDAR_TABLE + " WHERE ID=? AND VEGEID=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);
        statement.bindDouble(2, (double) vegeid);

        statement.execute();
        database.close();
    }
//    public Cursor getAllPlan() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT * FROM " + PLAN_TABLE;
//        Cursor cursor = db.rawQuery(query, null);
//
//        return cursor;
//    }

//    public boolean insertPlan(String vegetableName, String datePlanted) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("VEGENAME", vegetableName);
//        contentValues.put("DATEPLANTED", datePlanted);
//
//        long result = db.insert(PLAN_TABLE, null, contentValues);
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }


}
