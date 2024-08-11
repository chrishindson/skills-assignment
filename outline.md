# Initial thoughts

* How much of a team is in place for the project?
  * Who is engaged for requirements? 
    * Is the scope large enough to cover all users
  * Who is responsible for managing project? PM or self-managed 
* Limited information of what is needed to be stored within People and Skills entity
* Is this to use existing database/resources?
  * If so, does this require additional work/migration
  * What is the existing database, additional work for on-prem dB
  * Can it feasibly be migrated to postgreSQL
* How much PII is present? How much is reasonably needed?
  * GDPR considerations on data retention (how much would a skillset/proficiency be required to be kept after someone leaves)
* Security
  * Reasonable to expect internal only?
  * Possibility to allow access to contractors/companies engaged by organisation
  * How to restrict? SSO, password/credential access, generated API key?
  * Who would need access to read, read/write to information
    * Should there be levels of access, returning differing amounts of PII
* Agile ceremonies
  * Every day? Likely depends on make up of squad
  * Attendees
    * BA?
    * Unlikely to need service designer (at least at current scope for API, may be required for front end input control)
    * Testers
    * UR? may be required early for system/project requirements/expectations

As Lead
* Does this project allow for learning opportunities?

Reasonable assumptions
* hosted in AWS
