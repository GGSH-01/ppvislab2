package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXExample {
    private static ArrayList<Pacient> pacients = new ArrayList<>();
    private static Pacient pacient;
    private static Medic medic;

    public ArrayList getPacients() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resource/medicina.xml"), handler);
        return pacients;
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) /*throws SAXException*/ {
            if (qName.equals("medic")) {
                String medicName = attributes.getValue("medicName");
                String medicSecondName = attributes.getValue("medicSecondName");
                String medicSurname = attributes.getValue("medicSurname");
                medic = new Medic(medicName, medicSecondName, medicSurname);
//                    medics.add(medic);
            }
            if (pacient == null) {
                if (qName.equals("patient")) {
                    String name = attributes.getValue("name");
                    String secondName = attributes.getValue("secondName");
                    String surname = attributes.getValue("surname");
                    String street = attributes.getValue("street");
                    int house = Integer.parseInt(attributes.getValue("house"));
                    String DOB = attributes.getValue("DOB");
                    String DER = attributes.getValue("DER");
                    String resume = attributes.getValue("resume");
                    pacient = new Pacient(name, secondName, surname, street, house, DOB, DER, resume);
                    pacient.setMedic(medic);
                    pacients.add(pacient);
                    pacient = null;

                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("medic")){
                medic = null;
            }
        }
    }
}


