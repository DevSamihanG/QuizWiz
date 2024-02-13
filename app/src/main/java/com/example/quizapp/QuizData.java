package com.example.quizapp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class QuizData {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                Arrays.asList("London", "Paris", "Berlin", "Madrid"), 1));
        // Sports
        questions.add(new Question("Which country won the FIFA World Cup in 2018?",
                Arrays.asList("Brazil", "Germany", "France", "Argentina"), 2));

        questions.add(new Question("Who is the all-time leading goal scorer in men's international football?",
                Arrays.asList("Lionel Messi", "Cristiano Ronaldo", "Pele", "Ali Daei"), 3));

        questions.add(new Question("Which sport uses the terms 'love', 'deuce', and 'advantage'?",
                Arrays.asList("Tennis", "Basketball", "Golf", "Swimming"), 0));

        questions.add(new Question("Who played the role of Harry Potter in the film series?",
                Arrays.asList("Daniel Radcliffe", "Rupert Grint", "Emma Watson", "Tom Felton"), 0));

        questions.add(new Question("Which singer is known as the 'Queen of Pop'?",
                Arrays.asList("Madonna", "Beyonce", "Taylor Swift", "Rihanna"), 0));

        questions.add(new Question("Who is the youngest self-made billionaire according to Forbes?",
                Arrays.asList("Mark Zuckerberg", "Kylie Jenner", "Jeff Bezos", "Elon Musk"), 1));

        questions.add(new Question("What is the fastest land animal?",
                Arrays.asList("Cheetah", "Lion", "Gazelle", "Leopard"), 0));

        questions.add(new Question("Which bird is known for its ability to mimic human speech?",
                Arrays.asList("Parrot", "Crow", "Owl", "Penguin"), 0));

        questions.add(new Question("What is the largest living species of lizard?",
                Arrays.asList("Komodo dragon", "Monitor lizard", "Gecko", "Iguana"), 0));

        questions.add(new Question("Who is the CEO of Tesla and SpaceX?",
                Arrays.asList("Bill Gates", "Tim Cook", "Elon Musk", "Jeff Bezos"), 2));

        questions.add(new Question("What does CPU stand for in the context of computers?",
                Arrays.asList("Central Processing Unit", "Computer Processing Unit", "Central Power Unit", "Central Program Unit"), 0));

        questions.add(new Question("Which company developed the Android operating system?",
                Arrays.asList("Apple", "Microsoft", "Google", "Samsung"), 2));

        questions.add(new Question("What is the chemical symbol for water?",
                Arrays.asList("H2O", "CO2", "O2", "NaCl"), 0));

        questions.add(new Question("Who wrote the famous novel 'To Kill a Mockingbird'?",
                Arrays.asList("Harper Lee", "J.K. Rowling", "Stephen King", "George Orwell"), 0));

        questions.add(new Question("Which planet is known as the 'Red Planet'?",
                Arrays.asList("Mars", "Jupiter", "Venus", "Mercury"), 0));

        questions.add(new Question("What is the capital of Japan?",
                Arrays.asList("Tokyo", "Beijing", "Seoul", "Bangkok"), 0));
        return questions;
    }
}
