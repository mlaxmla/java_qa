package pl.stqa.mla.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import pl.stqa.mla.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


  @Parameter (names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    //    Gson gson = new Gson(); // simple usage without special atributes
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
    //    writer.close(); // will be closed automatically after try
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    //    xstream.alias("contact", ContactData.class);
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
    //    writer.close(); // will be closed automatically after try
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName_td(), contact.getMiddleName_td(), contact.getLastName_td(), contact.getNickName_td(), contact.getTitle_td(), contact.getCompany_td(), contact.getAddress_td()
                , contact.getTelHome_td(), contact.getTelMobile_td(), contact.getEmail_td(), contact.getEmail2_td(), contact.getHomePage_td()
        ));
      }
    }
    //    writer.close(); // will be closed automatically after try
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName_td(String.format("FirstName_TDGen%s", i))
              .withMiddleName_td(String.format("MiddleName_TDGen%s", i))
              .withLastName_td(String.format("LastName_TDGen%s", i))
              .withNickName_td(String.format("Nickname_TDGen%s", i))
              .withTitle_td(String.format("Title_TDGen%s", i))
              .withCompany_td(String.format("Company_TDGen%s", i))
              .withAddress_td(String.format("Address_TDGen%s", i))
              .withTelHome_td(String.format("TelHome_TDGen%s", i))
              .withTelMobile_td(String.format("TelMobile_TDGen%s", i))
              .withEmail_td(String.format("email_TDGen%s@abc.de", i))
              .withEmail2_td(String.format("email2_TDGen%s@abc.de", i))
              .withHomePage_td(String.format("www.Homepage_TDGen%s.de", i))
              );
    }
    return contacts;
  }

}