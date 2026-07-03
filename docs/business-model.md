# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — France

## Classification

- Repository: `cloud-itonami-iso3166-fra`
- ISO 3166: `FRA` (France)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:eu-single-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a French
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  France for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation and
  now needs public-sector market access

## Offer

- registration walkthrough for PLACE (Plateforme des Achats de l'État,
  marches-publics.gouv.fr), France's official state e-procurement
  platform for electronic bid submission, plus monitoring of BOAMP
  (Bulletin officiel des annonces des marchés publics) for the legally
  required tender-notice publication above the EU threshold
- business/tax registration checklist: a SIREN (9-digit legal-entity
  identifier) and SIRET (14-digit establishment identifier) via INSEE,
  obtained through the Guichet unique single business-formality window
  operated by INPI
- local-content / preferential-procurement navigation: EU-wide open
  tendering above EU thresholds (no national-content quota as an EU
  member state), but a valid SIRET or equivalent national identifier and
  French-language submission are typically required
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to French-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in France).
