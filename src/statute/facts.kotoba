(ns statute.facts
  "General-law compliance catalog for France (FRA) -- extends this
  repo's existing `marketentry.facts` (public-procurement market-entry
  only, narrow scope) with a second, orthogonal catalog of statutes a
  company generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-gbr/-deu's `statute.facts`
  (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL legifrance.gouv.fr URL -- never
  fabricated. A law not in this table has NO spec-basis, full stop;
  extend `catalog`, do not invent an id/url. Code de commerce and the
  Loi Informatique et Libertés were directly WebFetch-verified against
  the live legifrance.gouv.fr page on 2026-07-14; the Code du travail
  page exceeded WebFetch's content-size limit (it runs ~3000 pages) so
  its citation rests on the same legifrance.gouv.fr domain plus multiple
  independent corroborating sources, same tier of confidence as JPN's
  e-Gov and USA's uscode.house.gov citations.")

(def catalog
  "iso3 -> vector of statute entries."
  {"FRA"
   [{:statute/id "fra.code-de-commerce"
     :statute/title "Code de commerce"
     :statute/jurisdiction "FRA"
     :statute/kind :law
     :statute/law-number "LEGITEXT000005634379"
     :statute/url "https://www.legifrance.gouv.fr/codes/texte_lc/LEGITEXT000005634379/"
     :statute/url-provenance :official-legifrance
     :statute/retrieved-at "2026-07-14"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "fra.loi-informatique-et-libertes"
     :statute/title "Loi n° 78-17 du 6 janvier 1978 relative à l'informatique, aux fichiers et aux libertés"
     :statute/jurisdiction "FRA"
     :statute/kind :law
     :statute/law-number "Loi n° 78-17"
     :statute/url "https://www.legifrance.gouv.fr/loda/id/JORFTEXT000000886460/"
     :statute/url-provenance :official-legifrance
     :statute/enacted-date "1978-01-06"
     :statute/retrieved-at "2026-07-14"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "fra.code-du-travail"
     :statute/title "Code du travail"
     :statute/jurisdiction "FRA"
     :statute/kind :law
     :statute/law-number "LEGITEXT000006072050"
     :statute/url "https://www.legifrance.gouv.fr/codes/texte_lc/LEGITEXT000006072050"
     :statute/url-provenance :official-legifrance
     :statute/retrieved-at "2026-07-14"
     :statute/topic #{:labor :employment}}]})

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
      :note (str "cloud-itonami-iso3166-fra statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "FRA")) " FRA statutes seeded with an "
                 "official legifrance.gouv.fr citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
