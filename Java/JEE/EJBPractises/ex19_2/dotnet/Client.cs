using System;

public class Client {
    public static void Main() {

       Cabin cabin_1 = new Cabin();
       cabin_1.id = 2;
       cabin_1.name = "Jumbo Suite";
       cabin_1.deckLevel = 1;
       cabin_1.shipId = 1;
       cabin_1.bedCount = 2;

       TravelAgentService agent = new TravelAgentService();

       agent.createCabin(cabin_1);

       Cabin cabin_2 = agent.findCabin(2);
       Console.WriteLine(cabin_2.name);
       Console.WriteLine(cabin_2.deckLevel);
       Console.WriteLine(cabin_2.shipId);
       Console.WriteLine(cabin_2.bedCount);
    }
}

