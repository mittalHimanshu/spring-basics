package com.springBasics.giflib.data;

import com.springBasics.giflib.model.Gif;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
        new Gif("android-explosion", 1,  LocalDate.of(2019, 2, 23), "Himanshu", false),
        new Gif("ben-and-mike",3,  LocalDate.of(2017, 6, 25), "Ben", true),
        new Gif("book-dominos",1, LocalDate.of(2014, 7, 2), "Mike", false),
        new Gif("compiler-bot", 2, LocalDate.of(2019, 3, 27), "Compiler", true),
        new Gif("cowboy-coder",3, LocalDate.of(2014, 4, 15), "Cowboy", false),
        new Gif("infinite-andrew",1, LocalDate.of(5019, 9, 12), "Andrew", true)
    );

    public Gif findByName(String name){
        for(Gif gif: ALL_GIFS) {
            if(gif.getName().equals(name)){
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif: ALL_GIFS) {
            if(gif.getCategoryId() == id){
                gifs.add(gif);
            }
        }
        return gifs;
    }
}
