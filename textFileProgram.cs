class Writedirectory{
    static void Main(string[] args){
        string pathName = @"C:\test\myfile.txt";
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
        using (StreamWriter writer = new StreamWriter(pathName)){
            Console.WriteLine("Writing first 10 people to: " + pathName);
            for(int i = 0; i < 10; i++){
                Person randomPerson = new Person();
                randomPerson = GeneratePersonInfo(randomPerson);
                writer.WriteLine(randomPerson.PrintPerson());
            }
            Console.WriteLine("Finished writing at " + DateTime.Now + ". Closing document.");
            Thread.Sleep(1000);
        }

        // Reopens file and appends 5 more people, then closes file. The true parameter in StreamWriter indicates to not overwrite the file
        using (StreamWriter appender = new StreamWriter(pathName, true)){
            Console.WriteLine("Reopening document: " + pathName);
            for(int i = 0; i < 5; i++){
                Person randomPerson = new Person();
                randomPerson = GeneratePersonInfo(randomPerson);
                appender.WriteLine(randomPerson.PrintPerson());
            }
            Console.WriteLine("Finished writing at " + DateTime.Now + ". Closing document.");
            Thread.Sleep(1000);
        }
    
        List<string> personList = new List<string>();
        //Pass the file path and file name to the StreamReader constructor 
        using (StreamReader sr = new StreamReader(pathName)) {
            //Continue to read until you reach end of file 
            while (!sr.EndOfStream) { //instead of hardcode, read till end
                personList.Add(sr.ReadLine());
            }
        }
        foreach (string person in personList) {
            Console.WriteLine(person);
        };
    }

    // Generates random information for Person object
    static Person GeneratePersonInfo(Person writePerson){
        // Arrays of strings to be picked from randomly
        string[] firstNames = {"John", "Joe", "Phil", "Mary", "Greg", "Julia", "Madison", "Ryan", "Ed", "Will", "Erin", "Ella", "Abby", "Fred", "Mark"};
        string[] lastNames = {"Smith", "Johnson", "Garcia", "Jones", "Williams", "Davis", "Brown", "Miller", "Rodriguez", "Lee", "Martinez", "Thompson", "Lopez", "Clark", "Robinson"};
        string[] cityStates = {"Detroit,MI", "Los Angeles,CA", "Atlanta,GA", "New York,NY", "Dallas,TX", "Chicago,IL", "Phoenix,AZ", "Philadelphia,PA", "Jacksonville,FL", "Birmingham,AL", "Columbus,OH", "Denver,CO", "Seattle,WA", "Nashville,TN"};

        Random rnd = new Random();

        writePerson.firstName = firstNames[rnd.Next(0,15)];
        writePerson.lastName = lastNames[rnd.Next(0,15)];
        writePerson.dateOfBirth = GenerateDOB();
        writePerson.phoneNum = "(" + rnd.Next(200, 899) + ")" + rnd.Next(100, 1000) + "-" + rnd.Next(1000, 10000);
        writePerson.address = GenerateAddress();
        writePerson.cityState = cityStates[rnd.Next(0,cityStates.Length)];
        writePerson.zip = rnd.Next(10) + "" + rnd.Next(1000, 10000);

        return writePerson;
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

// Person object that stores attributes that get printed to a line
class Person{
    public string firstName = "first name";
    public string lastName = "last name";
    public string dateOfBirth = "DOB";
    public string phoneNum = "phone num";
    public string address = "address";
    public string cityState = "city,STATE";

    public string zip = "zip";

    public string PrintPerson(){
        return firstName + "," + lastName + "," + dateOfBirth + "," + phoneNum + "," + address + "," + cityState + "," + zip;
    }
}
