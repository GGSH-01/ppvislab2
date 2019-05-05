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
    private static ArrayList<Hospital> pacients = new ArrayList<>();
    private static Hospital pacient;

    public ArrayList getPacients() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resource/medicina.xml"), handler);

            for (Hospital pacient : pacients)
            System.out.println(String.format("Имя пациента: %s, фамилия пациента: %s, очество пациента: %s, его адресс: %s, его дата рождения: %s, дата последнего приема: %s, имя врача: %s, фамилия врача: %s, отчество врача: %s, заключение: %s", pacient.getName(),pacient.getSecondName(), pacient.getSurname(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedicName(), pacient.getMedicSecondName(), pacient.getMedicSurname(), pacient.getResume()));


        return pacients;
    }

    private static class XMLHandler extends DefaultHandler {

/*
        @Override
        public void startDocument() throws SAXException {
            // Тут будет логика реакции на начало документа
        }

        @Override
        public void endDocument() throws SAXException {
            // Тут будет логика реакции на конец документа
        }*/

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Тут будет логика реакции на начало элемента
            if (pacient == null) {
                if (qName.equals("patient")) {
                    String name = attributes.getValue("name");
                    String secondName = attributes.getValue("secondName");
                    String surname = attributes.getValue("surname");
                    String address = attributes.getValue("address");
                    String DOB = attributes.getValue("DOB");
                    String DER = attributes.getValue("DER");
                    String medicName = attributes.getValue("medicName");
                    String medicSecondName = attributes.getValue("medicSecondName");
                    String medicSurname = attributes.getValue("medicSurname");
                    String resume = attributes.getValue("resume");
                    pacient = new Hospital(name, address, secondName, surname, DOB, DER, medicName, medicSecondName, medicSurname, resume);
                    pacients.add(pacient);
                    pacient = null;
                }
            }

        }
/*
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Тут будет логика реакции на конец элемента
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Тут будет логика реакции на текст между элементами
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
        }*/
    }
}

