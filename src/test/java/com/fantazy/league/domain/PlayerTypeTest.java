package com.fantazy.league.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class PlayerTypeTest {

    @Test
    public void name() {
        List<String> types = asList("BATSMAN", "ALL_ROUNDER");
        Arrays.stream(PlayerType.values()).forEach(type ->
                assertTrue(types.contains(type.name()))
        );
    }
}