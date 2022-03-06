package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void legendaryItems() {
        Item[] items = new Item[] { new Item("Sulfuras", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras", app.items[0].name);
        assertEquals(80, app.items[0].quality);
    }



    @Test
    void agedcheeseItems() {
        Item[] items = new Item[] { new Item("Aged Brie", 4, 42) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(43, app.items[0].quality);
    }


    @Test
    void backstage_passesItemsShouldStayUnder50for10days() {
        Item[] items = new Item[] { new Item("Backstage passes", 4, 49) };
        GildedRose app = new GildedRose(items);
        for ( int i = 0 ; i < 10 ; i ++ ){
            app.updateQuality();
        }

        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstage_passesItemsShouldhavequalityfor15days() {
        Item[] items = new Item[] { new Item("Backstage passes", 15, 19 ) };
        GildedRose app = new GildedRose(items);
        for ( int i = 0 ; i < 15 ; i ++ ){
            app.updateQuality();
        }

        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void backstage_passesItemsShouldhavequalityfor16days() {
        Item[] items = new Item[] { new Item("Backstage passes", 15, 19 ) };
        GildedRose app = new GildedRose(items);
        for ( int i = 0 ; i < 16 ; i ++ ){
            app.updateQuality();
        }

        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemsShouldhavequalityfor15days() {
        Item[] items = new Item[] { new Item("Conjured", 5, 49 ) };
        GildedRose app = new GildedRose(items);
        for ( int i = 0 ; i < 15 ; i ++ ){
            app.updateQuality();
        }

        assertEquals("Conjured", app.items[0].name);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void conjuredItemsShouldhavequalityAt0For15days() {
        Item[] items = new Item[] { new Item("Conjured", 5, 12 ) };
        GildedRose app = new GildedRose(items);
        for ( int i = 0 ; i < 15 ; i ++ ){
            app.updateQuality();
        }

        assertEquals("Conjured", app.items[0].name);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void dummYItemsShouldhavequalityAt0For15days() {
        Item[] items = new Item[] { new Item("Dummy", 5, 12 ) };
        GildedRose app = new GildedRose(items);
        for ( int i = 0 ; i < 15 ; i ++ ){
            app.updateQuality();
        }

        assertEquals("Dummy", app.items[0].name);
        assertEquals(0, app.items[0].quality);
    }


}
