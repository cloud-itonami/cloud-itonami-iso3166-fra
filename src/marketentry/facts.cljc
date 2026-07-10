(ns marketentry.facts
  "France market-entry regulatory catalog (G2-style).")
(def catalog
  {"FRA" {:name "France"
          :owner-authority "DAJ / PLACE e-procurement (place.achats.gouv.fr)"
          :legal-basis "Code de la commande publique"
          :national-spec "PLACE supplier registration + SIRET/SIREN"
          :provenance "https://www.economie.gouv.fr/daj/commande-publique"
          :required-evidence ["SIRET/SIREN record"
                              "PLACE registration record"
                              "TVA intracommunautaire record"
                              "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / PLACE"
          :rep-legal-basis "EU establishment or authorized representative for many procedures"
          :rep-provenance "https://www.economie.gouv.fr/daj/commande-publique"
          :corporate-number-owner-authority "INSEE / URSSAF"
          :corporate-number-legal-basis "SIRET/SIREN"
          :corporate-number-provenance "https://www.insee.fr/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR"
          :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "DEU" {:name "Germany" :owner-authority "e-Vergabe" :legal-basis "GWB/VgV"
          :national-spec "e-Vergabe" :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract" "e-Vergabe registration record" "USt-IdNr record" "Authorized-representative record"]}
   "GBR" {:name "United Kingdom" :owner-authority "Find a Tender" :legal-basis "PCR 2015"
          :national-spec "Find a Tender" :provenance "https://www.find-tender.service.gov.uk/"
          :required-evidence ["Companies House record" "Find a Tender registration record" "VAT registration record" "Authorized-representative record"]}})
(defn spec-basis [iso3] (get catalog iso3))
(defn coverage ([] (coverage (keys catalog))) ([iso3s] (let [have (filter catalog iso3s) missing (remove catalog iso3s)] {:requested (count iso3s) :covered (count have) :covered-jurisdictions (vec (sort have)) :missing-jurisdictions (vec (sort missing)) :note (str "cloud-itonami-iso3166-fra R0: " (count catalog) " seeded.")})))
(defn required-evidence-satisfied? [iso3 submitted] (when-let [{:keys [required-evidence]} (spec-basis iso3)] (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3] (when-let [sb (spec-basis iso3)] (when (:rep-owner-authority sb) (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3] (when-let [sb (spec-basis iso3)] (when (:corporate-number-owner-authority sb) (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
