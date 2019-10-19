package com.matteopasotti.magicmotion.gallery.model

object FactoryOutlet {

    fun makeShoesList(): List<Shoe> {
        return listOf(
            Shoe(
                url = "https://i7.pngguru.com/preview/864/719/596/jumpman-air-" +
                        "jordan-nike-shoe-reebok-jordan.jpg",
                name = "Nike AF-1 Shadow",
                descr = "The Nike Air Force 1 AF-1 puts a fun, playful twist on a classic design. " +
                        "Using a layered approach, double the branding and an exaggerated midsole," +
                        " it highlights AF-1 DNA.",
                price = "£94.95"
            ),

            Shoe(
                url = "https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/" +
                        "vf4nffms4zmfcmrt6ty2/af-1-shadow-shoe-M8SqJM.jpg",
                name = "Nike AF-1 Shadow V2",
                descr = "The Nike Air Force 1 AF-1 puts a fun, " +
                        "playful twist on a classic design. Using a layered approach, " +
                        "double the branding and an exaggerated midsole, it highlights AF-1 DNA.",
                price = "£94.95"
            ),

            Shoe(
                url = "https://c.static-nike.com/a/images/t_PDP_864_v1/" +
                        "f_auto,b_rgb:f5f5f5/m0ij9dajomij3egnfkgz/" +
                        "air-jordan-1-jester-xx-low-laced-se-shoe-T57QcL.jpg",
                name = "Air Jordan 1 Jester XX Low Laced SE",
                descr = "The Nike Air Force 1 AF-1 puts a fun, " +
                        "playful twist on a classic design. Using a layered approach, " +
                        "double the branding and an exaggerated midsole, it highlights AF-1 DNA.",
                price = "£94.95"
            )

        )
    }
}