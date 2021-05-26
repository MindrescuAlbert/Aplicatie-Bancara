package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;
import JDBC.SetUpDataUsingStatement;
import Repository.CarduriRepository;
import Repository.ContRepository;
import Repository.ServiciiRepository;
import Repository.TranzactiiRepository;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        TranzactiiRepository tranzactiiRepository = new TranzactiiRepository();
        // tranzactiiRepository.updateSuma(1000.0, 1);
        // tranzactiiRepository.getAllTranzactions();

        ServiciiRepository serviciiRepository = new ServiciiRepository();
        //   serviciiRepository.createTable();
        //   serviciiRepository.getAllServices();
        //  tranzactiiRepository.insert("Retragere", "18 iulie 2021", 2000);
        // tranzactiiRepository.insert(new Tranzactii(2,"Depunere", "10 iunie 2021", 100));

        ContRepository contRepository = new ContRepository();
        //   contRepository.createTable();
        //   contRepository.getAllAccounts();

        CarduriRepository carduriRepository = new CarduriRepository();
        //   carduriRepository.createTable();
        //  carduriRepository.getAllCards();

        /*

        Scanner scanner = new Scanner(System.in);
        ClasaServiciu clasaServiciu = new ClasaServiciu();

        System.out.println("Bine ați venit!\n");
        ExtrasDeCont extrasDeCont = null;

        Cont contNou = null;
        ContEconomii contNouEconomii = null;
        int contorCont = 0;

        Audit audit = new Audit();

        */

        /*
        try {
            createFolder("My_Folder");

            Tranzactii tranzactii = new Tranzactii(0,"TranzactieDefault", "astazi", 0);

            TranzactiiSingleton.getInstance().createFile("My_Folder/tranzactii.txt");
            TranzactiiSingleton.getInstance().writeFiles("My_Folder/tranzactii.txt", tranzactii);
            TranzactiiSingleton.getInstance().readAndPrintAllLines("My_Folder/tranzactii.txt");

            Servicii servicii = new Servicii("Albert", "20 aprilie");

            ServiciiSingleton.getInstance().createFile("My_Folder/servicii.txt");
            ServiciiSingleton.getInstance().writeFiles("My_Folder/servicii.txt", servicii);
            ServiciiSingleton.getInstance().readAndPrintAllLines("My_Folder/servicii.txt");

            ContEconomii contEconomii = new ContEconomii("Albert", "19283791", extrasDeCont, "10 aprilie", 20000);

            ContEconomiiSingleton.getInstance().createFile("My_Folder/contEconomii.txt");
            ContEconomiiSingleton.getInstance().writeFiles("My_Folder/contEconomii.txt", contEconomii);
            ContEconomiiSingleton.getInstance().readAndPrintAllLines("My_Folder/contEconomii.txt");

            Imprumut imprumut = new Imprumut("Albert", "30 aprilie", 10000, 30);

            ImprumutSingleton.getInstance().createFile("My_Folder/imprumut.txt");
            ImprumutSingleton.getInstance().writeFiles("My_Folder/imprumut.txt", imprumut);
            ImprumutSingleton.getInstance().readAndPrintAllLines("My_Folder/imprumut.txt");

            // deleteFile("generatedFile.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    */
        /*
        while (true) {
            System.out.println("Ce operație doriți să efectuați?");
            System.out.println("1 - Creează un cont bancar");
            System.out.println("2 - Retrage bani");
            System.out.println("3 - Depune bani");
            System.out.println("4 - Afișează toate tranzactiile efectuate");
            System.out.println("5 - Creează un card");
            System.out.println("6 - Afișează detalii card");
          //  System.out.println("7 - Creează un cont de economii");
          //  System.out.println("8 - Retrage bani din contul de economii");
          //  System.out.println("9 - Depune bani în contul de economii");
          //  System.out.println("10 - Calculează dobânda pentru contul de economii");
            System.out.println("11 - Alte servicii");
            System.out.println("12 - Ieșire");

            int numar = scanner.nextInt();
            scanner.nextLine();

            if (numar == 1) {

                System.out.println("Care este numele titularului de cont?");
                String numeTitular = scanner.nextLine();

                System.out.println("Care este IBAN-ul contului?");
                String iban = scanner.nextLine();
                System.out.println();


                contRepository.insert(numeTitular, iban, 0);
                contNou = new Cont (contorCont, numeTitular, iban, 0);
                contorCont += 1;

                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a creat un cont nou");

            }

            else if(numar == 2) {
                if(contorCont != 0) {
                    System.out.println("Ce id are contul din care retrageti banii?");

                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ce sumă doriți să pastrati in contul dumneavoastra?");

                    double sumaRetrasa = scanner.nextInt();
                    scanner.nextLine();


                    if (sumaRetrasa <= contNou.getTotalBaniCont()) {
                        System.out.println("La ce dată doriți să retrageți banii?");
                        String dataRetragere = scanner.nextLine();

                        contRepository.updateSuma(sumaRetrasa, id);
                        tranzactiiRepository.insert("Retragere", "Astazi", sumaRetrasa);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au retras bani din cont");
                    } else
                        System.out.println("Nu aveți destui bani în cont.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 3) {
                if(contNou != null) {
                    System.out.println("Ce id are contul din care retrageti banii?");

                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ce sumă doriți să pastrati in contul dumneavoastra?");

                    double sumaDepusa = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("La ce dată doriți să depuneți banii?");
                    String dataRetragere = scanner.nextLine();

                    contRepository.updateSuma(sumaDepusa, id);
                    tranzactiiRepository.insert("Depunere", "Astazi", sumaDepusa);
                    //contNou.depuneBani(sumaDepusa, dataRetragere);
                    audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au depus bani in cont");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }


            else if(numar == 4) {

                tranzactiiRepository.getAllTranzactions();
                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au afisat toate tranzactiile efectuate.");

            }


            else if(numar == 5) {

                System.out.println("Introduceți numărul cardului:");
                String numarCard = scanner.nextLine();

                System.out.println("Introduceți numele detinatorului:");
                String numeDetinator = scanner.nextLine();

                System.out.println("Introduceți CVV-ul:");
                String cvv = scanner.nextLine();

                System.out.println("Introduceți data de expirare:");
                String dataExpirare = scanner.nextLine();

                System.out.println("Introduceti id-ul contului asociat noului card.");
                int id = scanner.nextInt();

                carduriRepository.insert(numarCard, numeDetinator, cvv, dataExpirare, id);
                //Carduri cardNou = clasaServiciu.creeazaCard(numarCard, cvv, dataExpirare, contNou);
                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a creat un card nou");

            }


            else if(numar == 6) {

                System.out.println("Care este id-ul cardului pentru care doriti afisarea?");
                int id = scanner.nextInt();

                carduriRepository.getById(id);
                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au afisat detaliile cardului");
            }


         */
            /*
            else if(numar == 7) {
                System.out.println("Care este numele titularului de cont?");
                String numeTitular = scanner.nextLine();

                System.out.println("Care este IBAN-ul contului de economii?");
                String iban = scanner.nextLine();

                System.out.println("Începând de la ce dată va fi folosit contul?");
                String data = scanner.nextLine();

                System.out.println("Care este suma maximă pe care o poate deține contul?");
                double sumaMaximaAdmisa = scanner.nextDouble();
                scanner.nextLine();


                extrasDeCont = new ExtrasDeCont();
                contNouEconomii = clasaServiciu.creeazaContEconomii(numeTitular, iban, extrasDeCont, data, sumaMaximaAdmisa);
                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a creat un cont de economii nou");
            }

            else if(numar == 8) {
                if(contNouEconomii != null) {
                    System.out.println("Ce sumă doriți să retrageți?");

                    int sumaRetrasa = scanner.nextInt();
                    scanner.nextLine();

                    if (sumaRetrasa <= contNouEconomii.getTotalBaniCont()) {
                        System.out.println("La ce dată doriți să retrageți banii?");
                        String dataRetragere = scanner.nextLine();

                        contNouEconomii.retrageBani(sumaRetrasa, dataRetragere);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au retras bani din contul de economii");
                    } else
                        System.out.println("Nu aveți destui bani în contul de economii.\n");
                }
                else
                    System.out.println("Nu aveți un cont de economii creat.\n");
            }


            else if(numar == 9) {
                if(contNouEconomii != null) {
                    System.out.println("Ce sumă doriți să depuneți?");

                    int sumaDepusa = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("La ce dată doriți să depuneți banii?");
                    String dataRetragere = scanner.nextLine();

                    contNouEconomii.depuneBani(sumaDepusa, dataRetragere);
                    audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au depus bani in contul de economii");
                }
                else
                    System.out.println("Nu aveți un cont de economii creat.\n");
            }

            else if(numar == 10) {
                if(contNouEconomii != null) {
                    System.out.println("Introduceți numărul de ani care vă interesează pentru calcularea dobânzii:");
                    int ani = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Dobânda este egală cu " + contNouEconomii.calculeazaDobanda(ani) + " lei");
                    audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a calculat dobanda pentru contul de economii");
                }
                else
                    System.out.println("Nu aveți un cont de economii creat.\n");
            }
            */
        /*
            else if(numar == 11) {
                if(contNou != null) {
                    System.out.println("Va rugam sa va introduceti numele: ");
                    String nume = scanner.nextLine();

                    System.out.println("Alege tipul serviciului: Imprumut / ComandaCard");
                    String alegere = scanner.nextLine();

                    serviciiRepository.insert(nume, "Astazi");

                    if (alegere == "Imprumut") {
                        System.out.println("Ce sumă doriți să împrumutați?");
                        double suma = scanner.nextDouble();
                        scanner.nextLine();


                        clasaServiciu.imprumut(suma, contNou);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a cerut un imprumut");
                    }
                    else if (alegere == "ComandaCard") {
                        System.out.println("Ce culoare doriți să fie cardul?");
                        String culoare = scanner.nextLine();

                        clasaServiciu.comandaCard(culoare);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a dat comanda de card");
                    }
                    else
                        System.out.println("Ați introdus greșit tipul serviciului");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 12) {
                System.out.println("Vă mulțumim! O zi bună!");
                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a iesit din program");
                break;
            }


        }
    }

    private static void createFolder(String folderName) throws IOException  {
        Path path = Paths.get(folderName);
        Files.createDirectories(path);
    }

    private static void listContentFolder(String folderName) throws IOException {
        Path path = Paths.get(folderName);
        Files.list(path).forEach(elem -> System.out.println(elem));
    }

    private static void deleteFile(String fileName) throws IOException  {
        Path path = Paths.get(fileName);
        Files.delete(path);
    }
    */
    }

}
