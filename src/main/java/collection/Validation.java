package collection;


import util.ClientOutput;

public interface Validation {

    static boolean validateX(Float x) {
        return x <= 429;
    }

    static boolean validateY(float y) {
        return (y <= 398);
    }

    static boolean validateCoordinates(Coordinates coordinates) {
        boolean resultX = validateX(coordinates.getX());
        boolean resultY = validateY(coordinates.getY());
        if (!resultX) {
            ClientOutput.print("Invalid X!");
            return false;
        }

        if (!resultY) {
            ClientOutput.print("Invalid Y!");
            return false;
        }

        return true;
    }

    static boolean validatePerson(Person person) {
        boolean result;
        String name = person.getName();
        String passportID = person.getPassportID();
        result = (name != null)
                && (!name.equals(""))
                && (person.getBirthday() != null)
                && (person.getHeight() > 0)
                && (person.getWeight() > 0)
                && (passportID.length() <= 40);
        if (!result) {
            ClientOutput.print("Admin's data is invalid!");
            return false;
        } else return true;
    }

    static boolean validateStudyGroup(StudyGroup studyGroup) {
        boolean result;
        Coordinates coordinates = studyGroup.getCoordinates();
        Person admin = studyGroup.getGroupAdmin();
        result = studyGroup.getName() != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: no name.");
            return false;
        }
        result = studyGroup.getId() > 0;
        if (!result) {
            ClientOutput.print("Study Group is invalid: invalid id.");
            return false;
        }
        result = coordinates != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: coordinates are empty.");
            return false;
        }
        result = validateCoordinates(coordinates);
        if (!result) {
            ClientOutput.print("Study Group is invalid: invalid coordinates.");
            return false;
        }
        result = studyGroup.getCreationDate() != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: empty creation date.");
            return false;
        }
        result = studyGroup.getCreationDate() != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: empty creation date.");
            return false;
        }
        result = studyGroup.getStudentsCount() > 0;
        if (!result) {
            ClientOutput.print("Study Group is invalid: invalid students count.");
            return false;
        }
        result = studyGroup.getFormOfEducation() != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: empty form of education.");
            return false;
        }
        result = studyGroup.getSemesterEnum() != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: empty semester.");
            return false;
        }

        result = admin != null;
        if (!result) {
            ClientOutput.print("Study Group is invalid: no admin.");
            return false;
        }
        result = validatePerson(admin);

        return result;
    }
}
