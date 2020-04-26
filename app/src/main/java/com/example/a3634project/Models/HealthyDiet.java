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

    // data obtained from https://spoonacular.com/academy/which-diet-is-best-for-me
    public static ArrayList<HealthyDiet> getHealthyDiet() {
        ArrayList<HealthyDiet> healthyDiets = new ArrayList<>();
        healthyDiets.add(new HealthyDiet("Paleo","This diet is based on the belief that the best diet will align with how our ancient ancestors ate, before agricultural and industrial developments led to widespread changes in the typical human diet. Following a Paleo diet means following a clean eating diet, since ancient man definitely didn't have access to Oreos, Lunchables, or Lunchables with Oreos. The strictest form of the Paleo diet goes further, however, limiting additional foods that most would still consider clean. These foods are outlined in the list below.","Meat (especially grass fed), fish, eggs, vegetables, some oils (e.g. coconut and olive oil), and in smaller quantities, fruit, nuts, sweet potatoes.","Legumes, grains, dairy, refined sugar, processed foods"));
        healthyDiets.add(new HealthyDiet("Ketogenic","If the body does not have enough glucose, its preferred source of energy, it breaks down fat for energy instead. This process releases molecules known as ketones. \"Ketosis\" refers to this state of increased ketones in the blood. Low carb diets can cause ketosis, because carbohydrates are broken down into glucose during digestion. Thus, restricting carbohydrates reduces the amount of available glucose and creates the need for the body to get energy from other sources.4\n" +
                "\n" +
                "The ketogenic diet is a low carb diet specifically intended to produce ketosis in the body. Rather than focusing on eliminating specific foods, the ketogenic diet pays close attention to the ratio of carbohydrates, protein, and fat consumed. Commonly, followers of a ketogenic diet consume 60-75% calories from fat, 15-30% calories from protein, and 5-10% calories from carbs.\n" +
                "\n" +
                "The Atkins diet is a famous low carb diet divided into four phases. The first three phases are designed to help a person lose weight, while the final phase is devoted to maintaining one's goal weight. The principle of ketosis is key to weight loss using the Atkins diet, but unlike the ketogenic diet, lists of \"acceptable foods\" are key.","Foods high in fat and/or protein but low in carbohydrates.","Foods high in carbohydrates, especially processed foods."));
        healthyDiets.add(new HealthyDiet("Gluten Free","Following a gluten free diet means eliminating gluten, the proteins found in wheat and some other grains. There are no other requirements, so a gluten free diet is not necessarily a healthy diet, since you could easily load up on gluten free pasta, cookies, and crackers. This is why a gluten free diet mostly makes sense if you truly have a gluten allergy or insensitivity, or if you cut out gluten while centering your diet around unprocessed foods.","Everything that doesn't contain gluten","Gluten-containing grains, such as wheat, barley, and rye, as well as any foods made from them"));
        healthyDiets.add(new HealthyDiet("Grain Free","The difference between gluten free and grain free is simple: a gluten free diet avoids grains that contain gluten, while a grain free diet avoids all grains, even those that do not contain gluten. This means a grain free diet is a gluten free diet (because it does not include wheat or gluten-containing grains), but a gluten free diet is not necessarily a grain free diet (because it can include grains that do not contain gluten, such as rice and corn.)\n" +
                "\n" +
                "It is difficult to find grain free processed foods, so going grain free could lead to a more healthful diet. However, if you don't have allergies that require a grain free diet, there is evidence to suggest whole grains can have beneficial health effects when eaten in the recommended quantities.","Everything that isn't a grain. Nut flours, chickpea flour, coconut flour, and potato starch are similar to grain-containing flours and starches, but are grain free. Amaranth, quinoa, and buckwheat are often excluded, even though they are technically not grains, but seeds. They are often called pseudo-grains.","Grains of any kind, including wheat, rye, barley, corn, rice, oats"));
        healthyDiets.add(new HealthyDiet("Pescetarian","This diet includes just about everything except beef, poultry, pork, and other animal meats. As the name suggests, they do eat fish and other seafood. They may or may not eat eggs and dairy.","Fish, seafood, fruit, vegetables, grains","Meat"));
        healthyDiets.add(new HealthyDiet("Vegetarian","This diet excludes all meat, fish, and animal by-products that require the animal to be killed (such as broth made from bones or gelatin). It is typically rich in legumes (e.g. beans and lentils), grains, fruits, vegetables, nuts, and seeds. Vegetarians who eat eggs but not dairy are known as ovo vegetarians while vegetarians who eat dairy but not eggs are known as lacto vegetarians.","Legumes, grains, fruit, vegetables, nuts, seeds, and often eggs, dairy, and honey","Meat, seafood, bone broth, gelatin"));
        healthyDiets.add(new HealthyDiet("Vegan","This diet excludes all animal products, including meat, fish, dairy, eggs, and honey. Like the vegetarian diet, the vegan diet is centered around legumes, grains, fruits, vegetables, nuts, and seeds.","Legumes, grains, fruit, vegetables, nuts, seeds","Meat, seafood, bone broth, gelatin, eggs, dairy, honey"));
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
