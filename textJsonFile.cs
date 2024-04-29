using System.Text.Json;
using System.Text.Json.Serialization;
class WriteJsonDirectory {
static void Main(string[] args){
        string pathName = @"C:\test\myJsonfile.json";
        
        try { 
            // Check if file already exists. If yes, delete it. 
            if (File.Exists(pathName)) { 
            File.Delete(pathName); 
            }
        }
        catch(Exception e) { 
            Console.WriteLine("Exception: " + e.Message); 
            } 
        finally { 
            Console.WriteLine("Executing finally block."); 
            }  

        // Creates and opens a file to write to, writes 10 people, then automatically closes it when finished
        Console.WriteLine("Writing first 10 people to: " + pathName);
        WriteDataToFile(pathName, 10);
        Console.WriteLine("Finished writing at " + DateTime.Now + ". Closing document.");
        Thread.Sleep(1000);

        // Reopens file and appends 5 more people, then closes file
        Console.WriteLine("Reopening document: " + pathName);
        WriteDataToFile(pathName, 5);
        Console.WriteLine("Finished writing at " + DateTime.Now + ". Closing document.");
        Thread.Sleep(1000);

        // Read data from the file into an array
        List<People> peopleArray = ReadJsonFromFile(pathName);

        // Display the contents of the array
        Console.WriteLine("Data read from JSON file:");
        foreach (People person in peopleArray) {
            Console.WriteLine($"Name: {person.firstName} {person.lastName}. Date of birth: {person.dateOfBirth}. Phone number: {person.phoneNum}. Address: {person.address}. City and State: {person.cityState}. Zip: {person.zip}");
        }
    }

// Reads data from the JSON file into a list of People objects
static List<People> ReadJsonFromFile(string filePath) {
    List<People> peopleList = new List<People>();
    try {
        string jsonString = File.ReadAllText(filePath);
        if (!string.IsNullOrWhiteSpace(jsonString)) {
            var jSon = new JsonSerializerOptions { WriteIndented = true };
            peopleList = System.Text.Json.JsonSerializer.Deserialize<List<People>>(jsonString, jSon);
        }
    }
    catch (Exception ex) {
        Console.WriteLine($"Error reading JSON file: {ex.Message}");
    }
    return peopleList;
}

// Generates random information for People object and writes to the file
static void WriteDataToFile(string filePath, int count) {
    List<People> peopleList = new List<People>();
    // Generate and add the first 10 People objects
    for (int i = 0; i < 10; i++) {
        People randomPeople = GeneratePeopleInfo();
        peopleList.Add(randomPeople);
    }
    try {
        // Use StreamWriter to ensure proper encoding and line endings
        using (StreamWriter streamWriter = new StreamWriter(filePath, false)) {
            var jSon = new JsonSerializerOptions { WriteIndented = true };
            string jsonString = System.Text.Json.JsonSerializer.Serialize(peopleList, jSon);
            streamWriter.Write(jsonString);
        }
        Console.WriteLine($"Finished writing first 10 people to the file.");
    }
    catch (Exception ex) {
        Console.WriteLine($"Error writing to JSON file: {ex.Message}");
        return; // Abort if an error occurs during the first write
    }
    // Clear the list for the next set of People objects
    peopleList.Clear();
    // Generate and add the next 5 People objects
    for (int i = 0; i < 5; i++) {
        People randomPeople = GeneratePeopleInfo();
        peopleList.Add(randomPeople);
    }
    try {
        // Read the existing content of the file
        string existingContent = File.ReadAllText(filePath);
        // Append the new JSON array to the existing content
        var jSon = new JsonSerializerOptions { WriteIndented = true };
        string jsonString = System.Text.Json.JsonSerializer.Serialize(peopleList, jSon);
        string updatedContent = existingContent.TrimEnd(']') + "," + jsonString.TrimStart('[');

        // Write the updated content back to the file
        File.WriteAllText(filePath, updatedContent);
        Console.WriteLine($"Finished writing additional 5 people to the file.");
    }
    catch (Exception ex) {
        Console.WriteLine($"Error writing to JSON file: {ex.Message}");
    }
}

    // Generates random information for People object
    static People GeneratePeopleInfo(){
        // Arrays of strings to be picked from randomly
        string[] firstNames = {"John", "Joe", "Phil", "Mary", "Greg", "Julia", "Madison", "Ryan", "Ed", "Will", "Erin", "Ella", "Abby", "Fred", "Mark"};
        string[] lastNames = {"Smith", "Johnson", "Garcia", "Jones", "Williams", "Davis", "Brown", "Miller", "Rodriguez", "Lee", "Martinez", "Thompson", "Lopez", "Clark", "Robinson"};
        string[] cityStates = {"Detroit,MI", "Los Angeles,CA", "Atlanta,GA", "New York,NY", "Dallas,TX", "Chicago,IL", "Phoenix,AZ", "Philadelphia,PA", "Jacksonville,FL", "Birmingham,AL", "Columbus,OH", "Denver,CO", "Seattle,WA", "Nashville,TN"};

        Random rnd = new Random();

        return new People{

        firstName = firstNames[rnd.Next(0,15)],
        lastName = lastNames[rnd.Next(0,15)],
        dateOfBirth = GenerateDOB(),
        phoneNum = "(" + rnd.Next(200, 899) + ")" + rnd.Next(100, 1000) + "-" + rnd.Next(1000, 10000),
        address = GenerateAddress(),
        cityState = cityStates[rnd.Next(0,cityStates.Length)],
        zip = rnd.Next(10) + "" + rnd.Next(1000, 10000)

        };
    }

    // Generates a date of birth with random numbers
    static string GenerateDOB(){
        Random rnd = new Random();
        string date = rnd.Next(1, 13) + "/";
        date += rnd.Next(1, 28) + "/";
        date += rnd.Next(1950,2020);
        return date;
    }

    // Generates random address
    static string GenerateAddress(){
        Random rnd = new Random();
        string[] firstAddrName = {"Lincoln", "Queens", "Kings", "Oak", "Main", "Station", "Victoria", "London", "Cedar", "Pine", "Maple", "Eagle", "Church", "Washington"};
        string[] secondAddrName = {"Street", "Avenue", "Road", "Park", "Drive"};
        string addressName = rnd.Next(10, 5000) + " ";
        addressName += firstAddrName[rnd.Next(0,firstAddrName.Length)] + " ";
        addressName += secondAddrName[rnd.Next(0,secondAddrName.Length)];
        return addressName;

    }
}

// Person object that stores attributes
class People{
    public string firstName {get; set;}
    public string lastName {get; set;}
    public string dateOfBirth {get; set;}
    public string phoneNum {get; set;}
    public string address {get; set;}
    public string cityState {get; set;}
    public string zip {get; set;}
    
    public People() { 

    }
    
    public People(string fn, string ln, string doe, string pn, string ads, string cs, string zp) {
        firstName = fn;
        lastName = ln;
        dateOfBirth = doe;
        phoneNum = pn;
        address = ads;
        cityState = cs;
        zip = zp;
    }
}
