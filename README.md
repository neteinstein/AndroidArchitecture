AndroidAcademy
==============

Android Academy Code Samples

Architecture Skeleton: Contains a sample of what could be a scalable Android Architecture containing:
 - Application Singleton
 - Activities
 - Fragments
 - Services with Binders
 - Managers to handle the business logic
 - BroadcastReceivers
 - Utils
 
This was developed following a near dependecy injection code-base (without using any library just enforcing code standards).

Good code policies regarding module independence are followed with the use of Service Provider Pattern - Factories + Interfaces and a few more things:

- Communication pattern between Activities and Fragments as recommended by Google
- Communication between Activities and Managers via EventBus (Threadling handle like magic)
- Communication between Managers and Services via Binders (Interface)

Give it a look & fork if you want to build your project from this building blocks.


Ps: I've left a couple of libraries already ready to go, which I recommend.
