import java.util.*;

class PhoneBook
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contact contacts = new Contact();
        
        System.out.println();
        System.out.println("|=======================================|");
        System.out.println("|                                       |");
        System.out.println("|      WELCOME TO PHONE DIRECTORY       |");
        System.out.println("|                                       |");
        System.out.println("|_______________________________________|");
        System.out.println();
         contacts.insertAtFirst("Nishita", "6543210012");
         contacts.insertAtFirst("Saloni","7111110000");
         contacts.insertAtFirst("Yashvi", "800004000");
         contacts.insertAtFirst("Tanvi","9067345612");
         contacts.insertAtFirst("Sangana","7856234590");             
                       
        while(true)
        {
                System.out.println("Enter your choice");
                System.out.println("|=======================================|");
                System.out.println("|                                       |");
                System.out.println("| 1. add contacts                       |");
                System.out.println("| 2. display contacts                   |");
                System.out.println("| 3. search contacts                    |");
                System.out.println("| 4. delete contacts                    |");
                System.out.println("| 5. sort contact by alphabet           |");
                System.out.println("| 6. Make call                          |");
                System.out.println("| 7. display call history               |");
                System.out.println("| 8. favourite contact                  |");
                System.out.println("| 9. clear call history                 |");
                System.out.println("| 10. group call                        |");
                System.out.println("| 11. exit                              |");
                System.out.println("|_______________________________________|");
                int choice = sc.nextInt();
                System.out.println();
                switch(choice)
                {
                    case 1 :
                    {
                        
                        System.out.println("Enter Name");
                        String name = sc.next();
                        Contact first  = null;
                        String mobile_no = "";
                        while (true) {
                            System.out.println("Enter number");
                            mobile_no = sc.next();
                            if (isValidNumber(mobile_no)) {
                                break;
                            } else {
                                System.out.println("Invalid number. Enter a valid 10-digit number or number start with 9,8,7,6.");
                            }
                        }

                        if (contacts.checkIfNumberExists(mobile_no) || contacts.checkIfNameExists(name)) {
                            System.out.println();
                            System.out.println("Contact already exists");
                            System.out.println();
            
                            System.out.println("Do you want to resave or save as another name? (resave/save_as_another_name)");
                            String c = sc.next();
            
                            if (c.equals("resave")) {
                                 contacts.updateContact( name, mobile_no);
                                System.out.println();
                                System.out.println("Contact updated successfully");
                                System.out.println();
                            }
                            
                             else if (c.equals("save_as_another_name")) {
                                System.out.println("Enter new name: ");
                                String newName = sc.next();
            
                                contacts.insertAtFirst( newName,mobile_no);
                                System.out.println();
                                System.out.println("New contact added successfully");
                                System.out.println();
                            }
                        } else {
                            contacts.insertAtFirst( name, mobile_no);
                            System.out.println();
                            System.out.println("Contact added successfully");
                            System.out.println();
                        }

                       

                    }
                    
                    break;
                    case 2 :
                    {
                        System.out.println("1. Show all contacts");
                        System.out.println("2. Show favorite contacts");
                        int displayChoice = sc.nextInt();
                        sc.nextLine(); 
                        if (displayChoice == 1) {
                           contacts.display();; 
                        } else if (displayChoice == 2) {
                           contacts.listFavorites();
                        }
                    }
                    break;
                    case 3 :
                    {
                        System.out.println("Enter name you want to search");
                        String name = sc.next();
                        contacts.SearchContact(name);
                    }
                    break;
                    case 4 :
                    {
                        System.out.println("Enter name you want to delete");
                        String name = sc.next();
                        contacts.deleteContact(name);
                    }
                    break;
                    case 5 :
                    {
                        contacts.sortContacts();
                    }
                    break;
                    case 6 :
                    {
                        contacts.makeCall();
                    }
                    break;
                    case 7 :
                    {
                       contacts.displayCallHistory();
                    }
                    break;
                    case 8 :
                    {
                        System.out.println("Enter the name of the contact to toggle favorite status:");
                        String contactName = sc.next();
                        contacts.markAsFavorite(contactName);
                    }
                    break;
                   case 9 :
                   {
                      contacts.clearHistory();
                   }
                   break;
                  case 10:
                  {
                      contacts.groups();
                  }
                  break;
                   case 11 :
                   {
                    System.out.println("Exiting phone directory...........");
                    System.exit(0);
                   }
                  
                   default:
                   {
                    System.out.println("Enter valid choice");
                   }

                }
        }

    }
    private static boolean isValidNumber(String mobile_no) {
        if (mobile_no.length() != 10) {
            return false;
        }
        
        char firstDigit = mobile_no.charAt(0);
        
        // Check if the first digit is 9, 8, 7, or 6
        if (firstDigit != '9' && firstDigit != '8' && firstDigit != '7' && firstDigit != '6') {
            return false;
        }
        
        for (int i = 0; i < mobile_no.length(); i++) {
            char digit = mobile_no.charAt(i);
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        
        return true;
    }
    
}

