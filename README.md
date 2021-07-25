# Meoqi_Intern
An android application for a event ticket booking system


**FEACTURES:**

Major points:

1. The app consists of event pages,artist page,food page,drinks page,goodies page.
2. The app has a profile section and a friends section that has a chat session.
3. The app allows users to buy tickets to a particular event.
4. A user can chat with a friend and his status changes to online.
5. A user can buy a number of tickets and can share the tickets.
6. Upon getting the redeem code a user can redeem the code and get his ticket.
7.  For a particular event there are a fixed number of guest passes.
8.  A user can share the guest ticket and other users can redeem the guest pass code.
9.  After a particular number of users have redeemed the initiator user gets a fixed number
of free drinks,food and goodies.
10. In the friends sections there is a chat session,favourite session,friend profile section.
11. Some particular foods ,drinks and goodies associated with an event are displayed which
are available for rating.
12. Foods related to chefs and Drinks related to mixologists are displayed.
13. The artist section has links to spotify ,bandchamp,mixcloud and soundcloud webviews.
14.  The real time notification through which the user receives notification on friends request
approval,chatlist ,tickets purchase and redeemed and guest tickets redeem.


**Services:**
--> Firebase
1. Google, Facebook Authentication
2. Real-time Database
3. Crashalytics, Analytics, Performance Monitoring
4. Firebase Cloud Messaging

--> RESTful APIs

**Libraries:**

1. Retrofit [for APIs handling]
2. Glide [for handling image events]
3. Circle Image View
4. Recycler View
5. Materials
6. QRGenerator
7. ButterKnife

**Login Flow:**

1. Firebase authentication or server side authentication will be done
2. The userID will be provided by the server.
3. A new user has to make his profile and save it.
4. The Home Screen of the app comes into view where there are event cards with
date,event name ,artist names and location is shown.
5. On clicking a particular card the user is taken to the event page where he is provided
the artist section,map section,ticket section .
6. The user can view the ticket passes price of the tickets and check its availability.
7. The user can view the guest passes price and the foods ,drinks and the goodies it
comes with.
8. The mapview enables him to see the exact location where the event will be held.
9. He can view the drinks by mixologists and rate it,similarly with foods and goodies.
10. The user can share the guest and the tickets pass.
11. On redeem a friend of a user gets his ticket or the guest pass.
12. A user can search friends and see their profile.
13. He can send a request ,accept a request or reject it.
14. As soon as the user accepts a request the friend is added to the chatlist and he can
chat with the friend.
15. He can favourite the friend and then the name comes in the favourite section.



**Architecture:**

**MVVM.**

![image](https://user-images.githubusercontent.com/57056324/126899774-42181dea-750a-4baf-87bc-bf357e9697cf.png)

Register Activity

![image](https://user-images.githubusercontent.com/57056324/126899861-031a05cc-a22b-46a7-90a4-5a47b805bc16.png)

Login Activity 

![image](https://user-images.githubusercontent.com/57056324/126899880-c004b8ca-8e48-429e-a84b-029883722b57.png)


Event List Activity

![image](https://user-images.githubusercontent.com/57056324/126899891-b872f58b-c5b3-4190-902b-ea94ea1de461.png)

Even Detail Activity 


![image](https://user-images.githubusercontent.com/57056324/126899923-20b5fc0a-c270-4d4d-b751-1097c3a71fc3.png)

![image](https://user-images.githubusercontent.com/57056324/126899964-a0c79a65-8133-4894-a02f-1b0172eb325c.png)

Artist Activity

![image](https://user-images.githubusercontent.com/57056324/126900050-3df26c5b-9eb1-47b6-b8e1-6f2d9eeca564.png)

![image](https://user-images.githubusercontent.com/57056324/126900060-0e20878e-d7de-4c5a-968e-1420be3b7220.png)

Profile Activity

![image](https://user-images.githubusercontent.com/57056324/126900104-3e603138-d921-4eb1-813d-7ef830098b24.png)

Chat Activity

![image](https://user-images.githubusercontent.com/57056324/126900130-deddca16-3865-4dba-b6d3-638653f8269d.png)

Food ,drinks Activity 

![image](https://user-images.githubusercontent.com/57056324/126900146-421c1e18-2ac8-4058-937c-f79c6b6c96df.png)

Ticket Activity 

![image](https://user-images.githubusercontent.com/57056324/126900179-61a67d7d-99f5-44fc-87c4-69caa3c0951e.png)

Redeem Activity 

![image](https://user-images.githubusercontent.com/57056324/126900194-7a39c89b-d255-49cd-a858-034ae21f65b8.png)

Payment Activity 

![image](https://user-images.githubusercontent.com/57056324/126900213-ef20d288-d38a-4cb9-a00d-79260bd25555.png)

