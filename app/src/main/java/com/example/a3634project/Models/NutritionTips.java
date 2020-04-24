package com.example.a3634project.Models;

import com.example.a3634project.R;

import java.util.ArrayList;

public class NutritionTips {

    private String image;
    private String title;
    private String description;

    public NutritionTips(String image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<NutritionTips> getNutritionTips() {
        ArrayList<NutritionTips> nutritionTips = new ArrayList<>();
        nutritionTips.add(new NutritionTips("https://img.medscape.com/thumbnail_library/dt_190711_soda_sugary_drinks_800x450.jpg","Don’t drink sugar calories", "Sugary drinks are among the most fattening items you can put into your body.\n\n" +
                "This is because your brain doesn’t measure calories from liquid sugar the same way it does for solid food.\n\n" +
                "Therefore, when you drink soda, you end up eating more total calories.\n\n" +
                "Sugary drinks are strongly associated with obesity, type 2 diabetes, heart disease, and many other health problems.\n\n" +
                "Keep in mind that certain fruit juices may be almost as bad as soda in this regard, as they sometimes contain just as much sugar. Their small amounts of antioxidants do not negate the sugar’s harmful effects.\n\n"));
        nutritionTips.add(new NutritionTips("https://images-prod.healthline.com/hlcmsresource/images/AN_images/AN141-Nuts-In-Wooden-Bowl-732x549-thumb.jpg","Eat nuts", "Despite being high in fat, nuts are incredibly nutritious and healthy.\n\n" +
                "They’re loaded with magnesium, vitamin E, fiber, and various other nutrients.\n\n" +
                "Studies demonstrate that nuts can help you lose weight and may help fight type 2 diabetes and heart disease.\n\n" +
                "Additionally, your body doesn’t absorb 10–15% of the calories in nuts. Some evidence also suggests that this food can boost metabolism.\n\n" +
                "In one study, almonds were shown to increase weight loss by 62%, compared with complex carbs.\n\n"));
        nutritionTips.add(new NutritionTips("https://www.bbcgoodfood.com/sites/default/files/article/guide-image/2018/05/cartoon-of-processed-food-packages.jpg","Avoid processed junk food (eat real food instead)", "Processed junk food is incredibly unhealthy.\n\n" +
                "These foods have been engineered to trigger your pleasure centers, so they trick your brain into overeating — even promoting food addiction in some people.\n\n" +
                "They’re usually low in fiber, protein, and micronutrients but high in unhealthy ingredients like added sugar and refined grains. Thus, they provide mostly empty calories.\n\n"));
        nutritionTips.add(new NutritionTips("https://www.incimages.com/uploaded_files/image/970x450/getty_938993594_391384.jpg", "Don’t fear coffee", "Coffee is very healthy.\n" +
                "\n" +
                "It’s high in antioxidants, and studies have linked coffee intake to longevity and a reduced risk of type 2 diabetes, Parkinson’s and Alzheimer’s diseases, and numerous other illnesses.\n"));
        nutritionTips.add(new NutritionTips("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/fatty_fish_that_are_high_in_omega_3s_slideshow/493ss_thinkstock_rf_fish_market.jpg", "Eat fatty fish", "Fish is a great source of high-quality protein and healthy fat.\n" +
                "\n" +
                "This is particularly true of fatty fish, such as salmon, which is loaded with omega-3 fatty acids and various other nutrients.\n" +
                "\n" +
                "Studies show that people who eat the most fish have a lower risk of several conditions, including heart disease, dementia, and depression.\n"));
        nutritionTips.add(new NutritionTips("https://media.mnn.com/assets/images/2013/09/fiber-blocks-on-lentils.jpg.1440x960_q100_crop-scale_upscale.jpg", "Take care of your gut health with probiotics and fiber", "The bacteria in your gut, collectively called the gut microbiota, are incredibly important for overall health.\n" +
                "\n" +
                "A disruption in gut bacteria is linked to some of the world’s most serious chronic diseases, including obesity.\n" +
                "\n" +
                "Good ways to improve gut health include eating probiotic foods like yogurt and sauerkraut, taking probiotic supplements, and eating plenty of fiber. Notably, fiber functions as fuel for your gut bacteria.\n"));
        nutritionTips.add(new NutritionTips("https://healthwatchcenter.com/wp-content/uploads/2018/05/Causes-of-Drinking-Water-While-Eating-1024x683.jpg", "Drink some water, especially before meals", "Drinking enough water can have numerous benefits.\n" +
                "\n" +
                "Surprisingly, it can boost the number of calories you burn.\n" +
                "\n" +
                "Two studies note that it can increase metabolism by 24–30% over 1–1.5 hours. This can amount to 96 additional calories burned if you drink 8.4 cups (2 liters) of water per day.\n" +
                "\n" +
                "The optimal time to drink it is before meals. One study showed that downing 2.1 cups (500 ml) of water 30 minutes before each meal increased weight loss by 44%.\n"));
        nutritionTips.add(new NutritionTips("https://images.summitmedia-digital.com/yummyph/images/2016/12/14/AsianBBQPorkChops640.jpg", "Don’t overcook or burn your meat", "Meat can be a nutritious and healthy part of your diet. It’s very high in protein and contains various important nutrients.\n" +
                "\n" +
                "However, problems occur when meat is overcooked or burnt. This can lead to the formation of harmful compounds that raise your risk of cancer.\n" +
                "\n" +
                "When you cook meat, make sure not to overcook or burn it.\n"));
        nutritionTips.add(new NutritionTips("https://cdn1.yalemedicine.org/images/bf01fc25-4f28-4221-aa21-9ebed2a3cb84_tcm990-329590_w828_h466.jpg", "Take vitamin D3 if you don’t get much sun exposure", "Sunlight is a great source of vitamin D.\n" +
                "\n" +
                "Yet, most people don’t get enough sun exposure.\n" +
                "\n" +
                "In fact, about 41.6% of the U.S. population is deficient in this critical vitamin.\n" +
                "\n" +
                "If you’re unable to get adequate sun exposure, vitamin D supplements are a good alternative.\n" +
                "\n" +
                "Their benefits include improved bone health, increased strength, reduced symptoms of depression, and a lower risk of cancer. Vitamin D may also help you live longer.\n"));
        nutritionTips.add(new NutritionTips("https://www.heart.org/-/media/aha/h4gm/article-images/fruit-and-vegetables.jpg", "Eat vegetables and fruits", "Vegetables and fruits are loaded with prebiotic fiber, vitamins, minerals, and many antioxidants, some of which have potent biological effects.\n" +
                "\n" +
                "Studies show that people who eat the most vegetables and fruits live longer and have a lower risk of heart disease, type 2 diabetes, obesity, and other illnesses.\n"));
        nutritionTips.add(new NutritionTips("https://nonobsessivewoe.files.wordpress.com/2018/06/best-high-protein-foods-for-weight-loss-1.jpg", "Make sure to eat enough protein", "Eating enough protein is vital for optimal health.\n" +
                "\n" +
                "What’s more, this nutrient is particularly important for weight loss.\n" +
                "\n" +
                "High protein intake can boost metabolism significantly while making you feel full enough to automatically eat fewer calories. It can also reduce cravings and your desire to snack late at night.\n" +
                "\n" +
                "Sufficient protein intake has also been shown to lower blood sugar and blood pressure levels.\n"));
        nutritionTips.add(new NutritionTips("https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/324444_1100-1100x628.jpg", "Don’t smoke or do drugs, and only drink in moderation", "If you smoke or abuse drugs, tackle those problems first. Diet and exercise can wait.\n" +
                "\n" +
                "If you drink alcohol, do so in moderation and consider avoiding it completely if you tend to drink too much.\n"));
        nutritionTips.add(new NutritionTips("https://www.todayifoundout.com/wp-content/uploads/2016/04/olive-oil2.png", "Use extra virgin olive oil", "Extra virgin olive oil is one of the healthiest vegetable oils.\n" +
                "\n" +
                "It’s loaded with heart-healthy monounsaturated fats and powerful antioxidants that can fight inflammation.\n" +
                "\n" +
                "Extra virgin olive oil benefits heart health, as people who consume it have a much lower risk of dying from heart attacks and strokes.\n"));
        nutritionTips.add(new NutritionTips("https://postmediacanadadotcom.files.wordpress.com/2014/09/healthmatters_limiting_sugar_20140303.jpg", "Minimize your sugar intake", "Added sugar is one of the worst ingredients in the modern diet, as large amounts can harm your metabolic health.\n" +
                "\n" +
                "High sugar intake is linked to numerous ailments, including obesity, type 2 diabetes, heart disease, and many forms of cancer.\n"));
        nutritionTips.add(new NutritionTips("https://www.diagnosisdiet.com/files/content/food/carbohydrates/pre-launch/refined-carbohydrates.jpg", "Don’t eat a lot of refined carbs", "Not all carbs are created equal.\n" +
                "\n" +
                "Refined carbs have been highly processed to remove their fiber. They’re relatively low in nutrients and can harm your health when eaten in excess.\n" +
                "\n" +
                "Studies show that refined carbs are linked to overeating and numerous metabolic diseases.\n"));
        nutritionTips.add(new NutritionTips("https://i.dietdoctor.com/wp-content/uploads/2019/06/fat.jpg?auto=compress%2Cformat&w=800&h=561&fit=crop", "Don’t fear saturated fat", "Saturated fat has been controversial.\n" +
                "\n" +
                "While it’s true that saturated fat raises cholesterol levels, it also raises HDL (good) cholesterol and shrinks your LDL (bad) particles, which is linked to a lower risk of heart disease.\n" +
                "\n" +
                "New studies in hundreds of thousands of people have questioned the association between saturated fat intake and heart disease.\n"));
        nutritionTips.add(new NutritionTips("https://media.treehugger.com/assets/images/2018/06/transfats.jpg.860x0_q70_crop-scale.jpg", "Avoid artificial trans fats", "Artificial trans fats are harmful, man-made fats that are strongly linked to inflammation and heart disease.\n" +
                "\n" +
                "While trans fats have been largely banned in the United States and elsewhere, the U.S. ban hasn’t gone fully into effect — and some foods still contain them.\n"));
        nutritionTips.add(new NutritionTips("https://media.mnn.com/assets/images/2016/04/herbs-and-spices.jpg.1440x960_q100_crop-scale_upscale.jpg", "Use plenty of herbs and spices", "Many incredibly healthy herbs and spices exist.\n" +
                "\n" +
                "For example, ginger and turmeric both have potent anti-inflammatory and antioxidant effects, leading to various health benefits.\n" +
                "\n" +
                "Due to their powerful benefits, you should try to include as many herbs and spices as possible in your diet.\n"));
        nutritionTips.add(new NutritionTips("https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/03/hard-boiled-eggs.jpg", "Eat eggs, yolk and all", "Whole eggs are so nutritious that they’re often termed “nature’s multivitamin.”\n" +
                "\n" +
                "It’s a myth that eggs are bad for you because of their cholesterol content. Studies show that they have no effect on blood cholesterol in the majority of people.\n" +
                "\n" +
                "Additionally, a massive review in 263,938 people found that egg intake had no association with heart disease risk.\n" +
                "\n" +
                "Instead, eggs are one of the planet’s most nutritious foods. Notably, the yolk contains almost all of the healthy compounds.\n"));
        return nutritionTips;
    }
}
