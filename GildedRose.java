package com.gildedrose;

class GildedRose {

    static int  ctr ;
    {
        ctr = 0 ;
    }
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras")) {
                System.out.println("sulfuras case");
            }
            else{
                items[i].sellIn = items[i].sellIn -1 ;

                if ( (items[i].quality < 50 ) &&  (items[i].quality >  0 )) {

                        if (( !items[i].name.contains("Conjured") )
                            && ( !items[i].name.contains("Aged Brie"))
                            &&  ( !items[i].name.contains("Backstage passes"))
                        ){
                            items[i].quality = items[i].quality -1;
                        }
                        else {
                            if ( (items[i].name.contains("Conjured")) )
                            {
                                items[i].quality = items[i].quality -2;
                            }

                            if   (items[i].name.contains("Aged Brie"))
                            {
                                items[i].quality = items[i].quality + 1;
                            }
                            if ( (items[i].name.contains("Backstage passes")) )
                            {
                                items[i].quality = items[i].quality + 1;
                                if( items[i].sellIn < 10){
                                    items[i].quality = items[i].quality + 1;
                                    if( items[i].sellIn < 5){
                                        items[i].quality = items[i].quality + 1;
                                    }
                                }
                                if( items[i].sellIn < 0){
                                    items[i].quality = 0 ;
                                }
                            }
                        }



                    }
                    else {
                        if ( items[i].quality >= 51 ){
                            items[i].quality = 50 ;
                        }
                        if ( items[i].quality < 0 ){
                            items[i].quality = 0 ;
                        }

                    }


            }

        }
    }
}
