package com.example.a3634project.Models;

import java.util.ArrayList;

public class HealthyDiet {

    private String dietType;
    private String dietDescription;
    private String allowedIngredient;
    private String notAllowedIngredient;

    public HealthyDiet(String dietType, String dietDescription, String allowedIngredient, String notAllowedIngredient) {
        this.dietType = dietType;
        this.dietDescription = dietDescription;
        this.allowedIngredient = allowedIngredient;
        this.notAllowedIngredient = notAllowedIngredient;
    }

    public String getDietType() {
        return dietType;
    }

    public String getDietDescription() {
        return dietDescription;
    }

    public String getAllowedIngredient() {
        return allowedIngredient;
    }

    public String getNotAllowedIngredient() {
        return notAllowedIngredient;
    }
    public static ArrayList<HealthyDiet> getHealthyDiet() {
        ArrayList<HealthyDiet> healthyDiets = new ArrayList<>();
        //healthyDiets.add(new HealthyDiet("Omnivore (Average Diet)","A mixture of meat, fish, fruit, vegetables, grains, etc. It can be healthy if following a balanced whole food or so-called \"clean eating\" diet or unhealthy if eating the Standard American Diet.","Everything! Meat, fish, grains (except in special cases), eggs, dairy, nuts, seeds, vegetables, fruit, etc.","n/a"));
        //healthyDiets.add(new HealthyDiet("Clean Eating","Clean eating simply means eating natural foods instead of processed foods. Fresh fruits and vegetables, beans, lentils, nuts, eggs, plain dairy, unprocessed meat and fish, and less refined carbohydrates (e.g. brown rice, oats, quinoa) are all acceptable foods. Nutritionally empty foods, such as pasta, cereal, etc. made with wheat flour and most things you'll find in the salty or sweet snack aisles are out. If you've heard that tip about mostly shopping the perimeter of the supermarket and avoiding the aisles in the middle, it can definitely apply here.","All unprocessed foods. Meat, fish, produce, dairy, legumes, nuts, eggs, whole grains.","Processed foods. White flour products, products with added refined sugar, etc."));
        healthyDiets.add(new HealthyDiet("Paleo","This diet is based on the belief that the best diet will align with how our ancient ancestors ate, before agricultural and industrial developments led to widespread changes in the typical human diet. Following a Paleo diet means following a clean eating diet, since ancient man definitely didn't have access to Oreos, Lunchables, or Lunchables with Oreos. The strictest form of the Paleo diet goes further, however, limiting additional foods that most would still consider clean. These foods are outlined in the list below.","Meat (especially grass fed), fish, eggs, vegetables, some oils (e.g. coconut and olive oil), and in smaller quantities, fruit, nuts, sweet potatoes.","Legumes, grains, dairy, refined sugar, processed foods"));
        healthyDiets.add(new HealthyDiet("Ketogenic","If the body does not have enough glucose, its preferred source of energy, it breaks down fat for energy instead. This process releases molecules known as ketones. \"Ketosis\" refers to this state of increased ketones in the blood. Low carb diets can cause ketosis, because carbohydrates are broken down into glucose during digestion. Thus, restricting carbohydrates reduces the amount of available glucose and creates the need for the body to get energy from other sources.4\n" +
                "\n" +
                "The ketogenic diet is a low carb diet specifically intended to produce ketosis in the body. Rather than focusing on eliminating specific foods, the ketogenic diet pays close attention to the ratio of carbohydrates, protein, and fat consumed. Commonly, followers of a ketogenic diet consume 60-75% calories from fat, 15-30% calories from protein, and 5-10% calories from carbs.\n" +
                "\n" +
                "The Atkins diet is a famous low carb diet divided into four phases. The first three phases are designed to help a person lose weight, while the final phase is devoted to maintaining one's goal weight. The principle of ketosis is key to weight loss using the Atkins diet, but unlike the ketogenic diet, lists of \"acceptable foods\" are key.","Foods high in fat and/or protein but low in carbohydrates.","Foods high in carbohydrates, especially processed foods."));
        //healthyDiets.add(new HealthyDiet("Weight Watchers","The Weight Watchers program, unlike the other omnivorous diets we've discussed so far, has no rules about which foods you can and cannot eat. Instead, you are given an allotment of SmartPoints based on your age, gender, weight, and height. Using the formula they have developed, they determine how many SmartPoints any individual food, recipe, or restaurant meal has. You can decide how to \"spend\" your SmartPoints based on what you choose to eat, but you shouldn't exceed your daily points if you want to lose weight. Though they encourage healthy eating, the real goal with the Weight Watchers program (not surprisingly considering the name) is weight loss.","Everything!","Going over your daily/weekly SmartPoints allowance."));
        healthyDiets.add(new HealthyDiet("Gluten Free","Following a gluten free diet means eliminating gluten, the proteins found in wheat and some other grains. There are no other requirements, so a gluten free diet is not necessarily a healthy diet, since you could easily load up on gluten free pasta, cookies, and crackers. This is why a gluten free diet mostly makes sense if you truly have a gluten allergy or insensitivity, or if you cut out gluten while centering your diet around unprocessed foods.","Everything that doesn't contain gluten","Gluten-containing grains, such as wheat, barley, and rye, as well as any foods made from them"));
        healthyDiets.add(new HealthyDiet("Grain Free","The difference between gluten free and grain free is simple: a gluten free diet avoids grains that contain gluten, while a grain free diet avoids all grains, even those that do not contain gluten. This means a grain free diet is a gluten free diet (because it does not include wheat or gluten-containing grains), but a gluten free diet is not necessarily a grain free diet (because it can include grains that do not contain gluten, such as rice and corn.)\n" +
                "\n" +
                "It is difficult to find grain free processed foods, so going grain free could lead to a more healthful diet. However, if you don't have allergies that require a grain free diet, there is evidence to suggest whole grains can have beneficial health effects when eaten in the recommended quantities.","Everything that isn't a grain. Nut flours, chickpea flour, coconut flour, and potato starch are similar to grain-containing flours and starches, but are grain free. Amaranth, quinoa, and buckwheat are often excluded, even though they are technically not grains, but seeds. They are often called pseudo-grains.","Grains of any kind, including wheat, rye, barley, corn, rice, oats"));
        //healthyDiets.add(new HealthyDiet("GAPS Diet","The GAPS diet is a program based upon the Specific Carbohydrate Diet (SCD). It claims to heal the gut and help treat numerous psychological conditions, including autism, ADHD, and depression. While there is plenty of anecdotal evidence suggesting the diet can be helpful, especially for those with digestive conditions, scientific evidence is lacking. However, research on the SCD does exist and appears promising.","The foods you may eat depend on which stage of GAPS you are in. Stage 1 is the most restrictive, allowing just homemade broths/stocks, boiled fish and meats, several types of cooked vegetables and onions, garlic, ginger, honey, salt, pepper, and small amounts of fermented vegetable juice and homemade yogurt.","Again, depends on which GAPS stage you are in, but stage 1 does not allow raw vegetables, grilled meats, eggs, fresh or dried herbs and spices, nuts, butter, cheese, etc. By the time you reach the last stage, Full GAPS, many of these foods are allowed."));
        //healthyDiets.add(new HealthyDiet("Low FODMAP Diet","FODMAP stands for Fermentable Oligo-, Di-, Monosaccharides And Polyols. For those of us who aren't biochemists, these are carbohydrates found in fructose, lactose, wheat, garlic, onion, legumes, sugar alcohols, and stone fruit. Some individuals are sensitive to FODMAPs in the diet and experience unpleasant digestive side effects after consumption. For this reason, low FODMAP diets can be helpful for sufferers of IBS and other digestive disorders.","Foods low in FODMAPs. This includes meat, eggs, fish, lactose free dairy, some nuts, gluten-free grains, certain fruits and vegetables (e.g. bananas, blueberries, oranges, grapes, bell peppers, cucumber, kale, potatoes, tomatoes)","Foods high in FODMAPS. This includes high lactose dairy (like milk), cashews, pistachios, legumes, gluten-containing grains, apples, dried fruit, stone fruit, cauliflower, celery, mushrooms, onions, garlic, sugar alcohols (e.g. sorbitol, maltitol, xylitol)."));
        healthyDiets.add(new HealthyDiet("Pescetarian","This diet includes just about everything except beef, poultry, pork, and other animal meats. As the name suggests, they do eat fish and other seafood. They may or may not eat eggs and dairy.","Fish, seafood, fruit, vegetables, grains","Meat"));
        healthyDiets.add(new HealthyDiet("Vegetarian","This diet excludes all meat, fish, and animal by-products that require the animal to be killed (such as broth made from bones or gelatin). It is typically rich in legumes (e.g. beans and lentils), grains, fruits, vegetables, nuts, and seeds. Vegetarians who eat eggs but not dairy are known as ovo vegetarians while vegetarians who eat dairy but not eggs are known as lacto vegetarians.","Legumes, grains, fruit, vegetables, nuts, seeds, and often eggs, dairy, and honey","Meat, seafood, bone broth, gelatin"));
        healthyDiets.add(new HealthyDiet("Vegan","This diet excludes all animal products, including meat, fish, dairy, eggs, and honey. Like the vegetarian diet, the vegan diet is centered around legumes, grains, fruits, vegetables, nuts, and seeds.","Legumes, grains, fruit, vegetables, nuts, seeds","Meat, seafood, bone broth, gelatin, eggs, dairy, honey"));
        //healthyDiets.add(new HealthyDiet("Fruitarian","This diet is, as the name suggests, a fruit-based diet. In its purest form, fruitarianism is truly limited to consuming fruit, though some fruitarians eat vegetables, nuts, and seeds.","Fruit","Everything else (in the strictest cases)"));
        return healthyDiets;
    }

    public static HealthyDiet getDiet(String dietType){
        for(HealthyDiet diet : getHealthyDiet()){
            if(diet.getDietType().equals(dietType)){
                return diet;
            }
        }
        return null;
    }

}
