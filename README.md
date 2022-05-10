# Database-per-tenant

As the name implies, a tenant (organization) has its own database. Each time a new tenant is added to the system, a new
database is generated for the user. **Every time a new tenant is added, a new schema is generated that creates a
separate database for the tenant**. This structure facilitates customization on tenant level and proper data isolation.

The query speed of this design is relatively okay as the search path to the tenant database is set before queries are
run. Easy data backup, restoration and migration are among the benefits of this design.

While this architecture provides data isolation and speed, it does not scale so well. When the number of
tenants/clients on the app is small, this design is effective but when tenants are larger, resources compromisation is
bound to occur. The number of tables increases, the number of queries increase, so is the size of these tables. Thus,
there is a need for continued scaling of resources as more tenants are added.
