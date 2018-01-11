INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Biedronka', 0);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('ABC', 1);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Delikatesy Centrum', 1);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Lewiatan', 1);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Groszek', 1);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Euro Sklep', 1);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Lidl', 0);              
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Tesco', 0);             
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Carrefour', 0);        
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Kaufland', 0);          
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Auchan', 0);            
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Nasz Sklep', 1);        
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Makro Cash&Carry', 0);  
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Żabka', 1);             
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Polomarket', 1);        
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Selgros Cash&Carry', 0);
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Netto', 0);            
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('E.Leclerc', 0);         
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Piotr i Paweł', 1);     
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Stokrotka', 1);         
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Mila', 1);             
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('SPAR', 0);             
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Media Markt', 0);       
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Saturn', 0);         
INSERT INTO `store` (`name`, `comingFromPL`) VALUES ('Media Expert', 1);    

INSERT INTO `category` (`name`) VALUES ('Dom i ogród');
INSERT INTO `category` (`name`) VALUES ('Dziecko');
INSERT INTO `category` (`name`) VALUES ('Elektronika');
INSERT INTO `category` (`name`) VALUES ('Kultura i rozrywka');
INSERT INTO `category` (`name`) VALUES ('Moda');
INSERT INTO `category` (`name`) VALUES ('Motoryzacja');
INSERT INTO `category` (`name`) VALUES ('Sport i wypoczynek');
INSERT INTO `category` (`name`) VALUES ('Uroda i zdrowie');
INSERT INTO `category` (`name`) VALUES ('Żywność');

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Wyposażenie', 1);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Przybory kuchenne', 1);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Meble', 1);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Ogród', 1);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Akcesoria', 2);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Artykuły szkolne', 2);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Odzież i obuwie dziecięce', 2);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Dziecko - inne', 2);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Komputery', 3);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('RTV', 3);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('AGD', 3);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Telefony i akcesoria', 3);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Elektronika - inne', 3);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Gry planszowe', 4);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Gry komputerowe', 4);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Instrumenty', 4);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Kultura i rozrywka - inne', 4);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Odzież', 5);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Obuwie', 5);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Dodatki', 5);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Moda - inne', 5);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Czesci samochodowe', 6);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Opony', 6);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Motoryzacja - inne', 6);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Turystyka', 7);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Akcesoria sportowe', 7);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Siłownia i fitness', 7);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Sport i wypoczynek - inne', 7);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Makijaż', 8);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Kosmetyki pielęgnacyjne', 8);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Leki', 8);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Suplementy diety', 8);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Zdrowie i uroda - inne', 8);

INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Napoje', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Przetwory', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Słodycze i przekąski', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Nabiał', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Produkty zbożowe', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Przyprawy i dodatki', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Wyroby mięsne', 9);
INSERT INTO `subcategory` (`name`, `category_id`) VALUES ('Żywność - inne', 9);

