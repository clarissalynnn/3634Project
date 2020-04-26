package com.example.a3634project.Models;

import java.util.ArrayList;

public class QuizQuestion {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;
    private String explanation;

    public QuizQuestion(String question, String option1, String option2, String option3, String option4, int answerNr, String explanation) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.explanation = explanation;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getAnswer() {
        return answerNr;
    }

    public String getExplanation() {
        return explanation;
    }

    // questions adapted from https://www.ncagr.gov/cyber/kidswrld/nutrition/NutritionQuiz.html
    public static ArrayList<QuizQuestion> getQuestions() {
        ArrayList<QuizQuestion> question = new ArrayList<>();
        question.add(new QuizQuestion("Which of the following is NOT true about water?", "Drinking water boosts metabolism", "85% of human brain tissue is water", "A good rule of thumb is to drink 10-12 glasses of water per day", "Water reduces kidney stones", 3, "There is no evidence to show that drinking 10-12 glasses of water is necessary. Generally, nutritionists recommend we follow the \"8x8\" rule, which is to drink eight 8-ounce glasses of water per day.\n" +
                "\n" +
                "Drinking more water does indeed boost metabolism - especially if your glass is icy cold. Your body must work to warm the water up, burning a few extra calories in the process.\n" +
                "\n" +
                "As for other benefits of water, 85% of your brain tissue is water, which means that if you're dehydrated, both your body and your mind will be stressed.\n"));
        question.add(new QuizQuestion("According to the USDA's famous Food Pyramid, we need 2-3 servings of which food group every day?", "Milk, cheese, and yogurt products", "Vegetables", "Cereal, bread, rice, or pasta", "A & B only", 1, "The USDA's famous Food Pyramid confirms that we need 2-3 daily servings from the milk, yogurt, and cheese group; 2-3 daily servings from the meat, poultry, fish, dry beans, eggs, and nuts group; 3-5 daily servings of vegetables; 2-4 servings from the fruit class; 6-11 daily servings from the bread, cereal, rice, and pasta category, and to use fats, oils, and sweets very sparingly."));
        question.add(new QuizQuestion("How many Australian adults would you guess are overweight or obese?", "Nearly 50% of all Australian adults are overweight or obese", "Nearly 60% of all Australian adults are overweight or obese", "Nearly 70% of all Australian adults are overweight or obese", "Nearly 80% of all Australian adults are overweight or obese", 3, ""));
        question.add(new QuizQuestion("From which foods can we get carbohydrates?", "Milk products and fruits", "Whole grain breads and cereals", "Table sugar, starchy vegetables, and legumes", "All of the above", 4, "Carbohydrates are called \"simple\" or \"complex,\" depending on how fast your body digests and absorbs the sugar. You get simple carbohydrates from fruits, milk products, and table sugar. Complex carbohydrates include whole grain breads and cereals, starchy vegetables, and legumes. Complex carbohydrates and some simple carbohydrates provide vitamins, minerals, and fiber. Products made with refined sugar provide little nutrition. It is wise to limit these products."));
        question.add(new QuizQuestion("People with a body mass index (BMI) value of ________ or more are considered obese.", "20", "25", "29", "30", 4, "BMI values between 18.5 and 24.9 are considered to be a \"normal\" or \"healthy\" weight. BMI values between 25 and 29.9 are considered \"overweight,\" while BMI values of 30 and above are considered \"obese.\" BMIs above 25 are unhealthy and have been shown to increase the risk of certain chronic diseases. BMIs under 18.5 are considered \"underweight.\""));
        question.add(new QuizQuestion("Which is not a grain product?", "Pasta", "Oatmeal", "Cornflakes", "Beans", 4, "Food made from wheat, rice, oats, corn, or another cereal is a grain product. Bread, pasta, oatmeal, cornflakes, and grits may not seem like it, but they are all grain products. Beans, on the other hand, fall into the protein category, alongside meats."));
        question.add(new QuizQuestion("Which of these foods offers more proteins per 100 grams?", "Ground Chuck", "Chicken Breast", "Mince Pork", "Caterpillars", 4, "Caterpillars, a delicacy in most corners of the world (except Europe, the United States and Canada), has about 28 grams of protein per 100 grams. Ground chuck offers about 24 grams; chicken breast has about 23 grams."));
        question.add(new QuizQuestion("Which of these is off limits if you are a vegan?", "Broccoli", "Soy Milk", "Honey", "Tofu", 3, "Vegans abstain from eating any animal product or byproduct, like dairy and meat. This also includes honey, produced by bees, which are also animals."));
        question.add(new QuizQuestion("Which of these cannot be consumed a vegetarian diet?", "Milk", "Meat Substitutes", "Gelatin", "Agar Agar", 3, "Gelatin is not vegetarian as it is derived from boiling cow/pig skin, tendons or bones in with water, agar agar however, is a vegan friendly substitute derived from seaweed"));
        question.add(new QuizQuestion("What cannot be eaten by a lacto-vegeratarian?", "Milk", "Cheese", "Eggs", "Butter", 3, "Lacto vegetarians eat milk and dairy products in addition to vegetables. Cheese and butter are dairy products, while eggs are not."));
        question.add(new QuizQuestion("Which of these is not considered a nutrient?", "Vitamins", "Minerals", "Fiber", "Fats", 3, "Dietary fiber is not a nutrient, but it is necessary to regulate digestion with the help of cellulose, which is NOT broken down and digested in the human body."));
        question.add(new QuizQuestion("Which of these is required on the food label?", "Total Carbohydrate", "Sugars", "Iron", "All of the above", 4, ""));
        question.add(new QuizQuestion("Citrus fruits are an excellent source of _______?", "Calcium", "Vitamin C", "Vitamin B", "Calories", 2, ""));
        return question;
    }
}
