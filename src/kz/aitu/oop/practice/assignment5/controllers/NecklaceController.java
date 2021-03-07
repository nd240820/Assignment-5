package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Stone;
import kz.aitu.oop.practice.assignment5.entities.Necklace;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepository;

import java.util.List;

public class NecklaceController {
    private final IStoneRepository repo;

    public NecklaceController(IStoneRepository repo) {
        this.repo = repo;
    }


    public String getAllStones() {

        /*
        outputting all records from database by calling method from repo class
         */
        List<Stone> stones = repo.getAllStones();

        return stones.toString();
    }
    public String getAllNecklaces() {

        /*
        outputting all records from database by calling method from repo class
         */
        List<Necklace> necklaces = repo.getAllNecklaces();

        return necklaces.toString();
    }
}