# Meoqi_Intern
An android application for a event ticket booking system


**FEACTURES:**

Major points:
● The app consists of event pages,artist page,food page,drinks page,goodies page.
● The app has a profile section and a friends section that has a chat session.
● The app allows users to buy tickets to a particular event.
● A user can chat with a friend and his status changes to online.
● A user can buy a number of tickets and can share the tickets.
● Upon getting the redeem code a user can redeem the code and get his ticket.
● For a particular event there are a fixed number of guest passes.
● A user can share the guest ticket and other users can redeem the guest pass code.
● After a particular number of users have redeemed the initiator user gets a fixed number
of free drinks,food and goodies.
● In the friends sections there is a chat session,favourite session,friend profile section.
● Some particular foods ,drinks and goodies associated with an event are displayed which
are available for rating.
● Foods related to chefs and Drinks related to mixologists are displayed.
● The artist section has links to spotify ,bandchamp,mixcloud and soundcloud webviews.
● The real time notification through which the user receives notification on friends request
approval,chatlist ,tickets purchase and redeemed and guest tickets redeem.


Services:
● Firebase
1. Google, Facebook Authentication
2. Real-time Database
3. Crashalytics, Analytics, Performance Monitoring
4. Firebase Cloud Messaging

● RESTful APIs

Libraries:
● Retrofit [for APIs handling]
● Glide [for handling image events]
● Circle Image View
● Recycler View
● Materials
● QRGenerator
● ButterKnife

Login Flow:
● Firebase authentication or server side authentication will be done
● The userID will be provided by the server.
● A new user has to make his profile and save it.
● The Home Screen of the app comes into view where there are event cards with
date,event name ,artist names and location is shown.
● On clicking a particular card the user is taken to the event page where he is provided
the artist section,map section,ticket section .
● The user can view the ticket passes price of the tickets and check its availability.
● The user can view the guest passes price and the foods ,drinks and the goodies it
comes with.
● The mapview enables him to see the exact location where the event will be held.
● He can view the drinks by mixologists and rate it,similarly with foods and goodies.
● The user can share the guest and the tickets pass.
● On redeem a friend of a user gets his ticket or the guest pass.
● A user can search friends and see their profile.
● He can send a request ,accept a request or reject it.
● As soon as the user accepts a request the friend is added to the chatlist and he can
chat with the friend.
● He can favourite the friend and then the name comes in the favourite section.



Architecture:

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

