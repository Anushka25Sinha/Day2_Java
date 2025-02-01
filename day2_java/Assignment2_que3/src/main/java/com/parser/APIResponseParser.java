package com.parser;

public class APIResponseParser {

    public static Book parse(String response) {
        Book book = new Book();

        book.setTitle(parse(response, "<title>", "<"));

        book.setAuthor(parse(response, "<name>", "<"));

        book.setPublicationYear(Integer.parseInt(parse(response, "<original_publication_year type=\"integer\">", "<")));

        book.setAverageRating(Double.parseDouble(parse(response, "<average_rating>", "<")));

        book.setRatingsCount(Integer.parseInt(parse(response, "<ratings_count type=\"integer\">", "<").replace(",", "")));

        book.setImageUrl(parse(response, "<image_url>", "<"));

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int start = response.indexOf(startRule) + startRule.length();
        int end = response.indexOf(endRule, start);
        return response.substring(start, end).trim();
    }


    private static String parse(String response, String[] startRules, String endRule) {
        int start = 0;
        for (String rule : startRules) {
            start = response.indexOf(rule, start) + rule.length();
        }
        int end = response.indexOf(endRule, start);
        return response.substring(start, end).trim();
    }

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>" +
                "</best_book>" +
                "</work>";

        Book parsedBook = APIResponseParser.parse(response);
        System.out.println("Title: " + parsedBook.getTitle());
        System.out.println("Author: " + parsedBook.getAuthor());
        System.out.println("Publication Year: " + parsedBook.getPublicationYear());
        System.out.println("Average Rating: " + parsedBook.getAverageRating());
        System.out.println("Ratings Count: " + parsedBook.getRatingsCount());
        System.out.println("Image URL: " + parsedBook.getImageUrl());
    }
}

