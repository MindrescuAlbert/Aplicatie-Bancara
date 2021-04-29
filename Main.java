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

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClasaServiciu clasaServiciu = new ClasaServiciu();

        System.out.println("Bine ați venit!\n");
        ExtrasDeCont extrasDeCont = null;

        Cont contNou = null;
        ContEconomii contNouEconomii = null;

        Audit audit = new Audit();

        try {
            createFolder("My_Folder");

            Tranzactii tranzactii = new Tranzactii("TranzactieDefault", "astazi", 0);

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

        while (true) {
            System.out.println("Ce operație doriți să efectuați?");
            System.out.println("1 - Creează un cont bancar");
            System.out.println("2 - Retrage bani");
            System.out.println("3 - Depune bani");
            System.out.println("4 - Afișează extrasul de cont");
            System.out.println("5 - Creează un card");
            System.out.println("6 - Afișează detalii card");
            System.out.println("7 - Creează un cont de economii");
            System.out.println("8 - Retrage bani din contul de economii");
            System.out.println("9 - Depune bani în contul de economii");
            System.out.println("10 - Calculează dobânda pentru contul de economii");
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

                extrasDeCont = new ExtrasDeCont();
                contNou = clasaServiciu.creeazaCont(numeTitular, iban, extrasDeCont);

                audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a creat un cont nou");

            }

            else if(numar == 2) {
                if(contNou != null) {
                    System.out.println("Ce sumă doriți să retrageți?");

                    int sumaRetrasa = scanner.nextInt();
                    scanner.nextLine();

                    if (sumaRetrasa <= contNou.getTotalBaniCont()) {
                        System.out.println("La ce dată doriți să retrageți banii?");
                        String dataRetragere = scanner.nextLine();

                        contNou.retrageBani(sumaRetrasa, dataRetragere);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au retras bani din cont");
                    } else
                        System.out.println("Nu aveți destui bani în cont.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 3) {
                if(contNou != null) {
                    System.out.println("Ce sumă doriți să depuneți?");

                    int sumaDepusa = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("La ce dată doriți să depuneți banii?");
                    String dataRetragere = scanner.nextLine();

                    contNou.depuneBani(sumaDepusa, dataRetragere);
                    audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au depus bani in cont");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 4) {
                if(contNou != null) {
                    if(contNou.getExtrasDeCont().getLastIndex() != 0) {
                        System.out.println("Extrasul de cont cu toate tranzacțiile efectuate:\n");
                        clasaServiciu.afiseazaExtrasulDeCont(contNou);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a afisat extrasul de cont");
                    }
                    else
                        System.out.println("Nu aveți nicio tranzacție efectuată.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 5) {
                if(contNou != null) {
                    if(contNou.getCard() != null)
                        System.out.println("Aveți deja un card creat.\n");
                    else {
                        System.out.println("Introduceți numărul cardului:");
                        String numarCard = scanner.nextLine();

                        System.out.println("Introduceți CVV-ul:");
                        String cvv = scanner.nextLine();

                        System.out.println("Introduceți data de expirare:");
                        String dataExpirare = scanner.nextLine();

                        Carduri cardNou = clasaServiciu.creeazaCard(numarCard, cvv, dataExpirare, contNou);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-a creat un card nou");
                    }
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 6) {
                if(contNou != null) {
                    if(contNou.getCard() != null) {
                        clasaServiciu.afiseazaCard(contNou);
                        audit.writeFiles("My_Folder/operatiiEfectuate.txt", "S-au afisat detaliile cardului");
                    }
                    else
                        System.out.println("Nu aveți un card creat.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

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

            else if(numar == 11) {
                if(contNou != null) {
                    System.out.println("Alege tipul serviciului: Imprumut / ComandaCard");

                    String alegere = scanner.nextLine();

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
}
