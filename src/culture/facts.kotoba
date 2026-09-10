(ns culture.facts
  "Country-level regional-culture catalog for France (FRA) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"FRA"
   [{:culture/id "fra.dish.baguette"
     :culture/name "Baguette"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Long, thin bread of French origin whose dough and dimensions are defined by French law; the artisanal know-how and culture of baguette bread was inscribed on the UNESCO Intangible Cultural Heritage Lists in 2022."
     :culture/url "https://en.wikipedia.org/wiki/Baguette"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.dish.coq-au-vin"
     :culture/name "Coq au vin"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "French dish of chicken braised with wine, lardons and mushrooms, traditionally prepared with red Burgundy wine."
     :culture/url "https://en.wikipedia.org/wiki/Coq_au_vin"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.dish.ratatouille"
     :culture/name "Ratatouille"
     :culture/country "FRA"
     :culture/kind :dish
     :culture/summary "Traditional French stewed vegetable dish originating in the Provence region of southern France, particularly associated with Nice."
     :culture/url "https://en.wikipedia.org/wiki/Ratatouille"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.beverage.champagne"
     :culture/name "Champagne"
     :culture/country "FRA"
     :culture/kind :beverage
     :culture/summary "Sparkling wine originated and produced in the Champagne wine region of France under AOC appellation rules requiring in-bottle secondary fermentation."
     :culture/url "https://en.wikipedia.org/wiki/Champagne"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.beverage.bordeaux"
     :culture/name "Bordeaux wine"
     :culture/country "FRA"
     :culture/kind :beverage
     :culture/summary "Wine produced in the Bordeaux region of southwest France; average vintages exceed 700 million bottles, from table wine to some of the world's most prestigious wines."
     :culture/url "https://en.wikipedia.org/wiki/Bordeaux_wine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.product.camembert"
     :culture/name "Camembert"
     :culture/country "FRA"
     :culture/kind :product
     :culture/summary "Moist, soft, creamy surface-ripened cow's milk cheese originating from Normandy; Camembert de Normandie received AOC certification in 1983 and PDO recognition in 1992."
     :culture/url "https://en.wikipedia.org/wiki/Camembert"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.product.roquefort"
     :culture/name "Roquefort"
     :culture/country "FRA"
     :culture/kind :product
     :culture/summary "Sheep-milk blue cheese from southern France with protected designation of origin status, required to age in the natural caves of Roquefort-sur-Soulzon."
     :culture/url "https://en.wikipedia.org/wiki/Roquefort"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.craft.aubusson-tapestry"
     :culture/name "Aubusson tapestry"
     :culture/name-local "Tapisserie d'Aubusson"
     :culture/country "FRA"
     :culture/kind :craft
     :culture/summary "French weaving craft produced in Aubusson, Creuse, in central France, inscribed by UNESCO in 2009 on the Representative List of the Intangible Cultural Heritage of Humanity."
     :culture/url "https://en.wikipedia.org/wiki/Aubusson_tapestry"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.festival.bastille-day"
     :culture/name "Bastille Day"
     :culture/name-local "Fête nationale française"
     :culture/country "FRA"
     :culture/kind :festival
     :culture/summary "French national holiday celebrated annually on 14 July, commemorating the Storming of the Bastille in 1789 and the Fête de la Fédération of 1790."
     :culture/url "https://en.wikipedia.org/wiki/Bastille_Day"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "fra.heritage.mont-saint-michel"
     :culture/name "Mont-Saint-Michel"
     :culture/country "FRA"
     :culture/kind :heritage
     :culture/summary "Tidal island commune in Normandy, France, inscribed on the UNESCO World Heritage list in 1979 and France's most-visited attraction outside Paris."
     :culture/url "https://en.wikipedia.org/wiki/Mont-Saint-Michel"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-fra culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "FRA"))
                 " FRA entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
