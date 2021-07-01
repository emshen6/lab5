package command;

import collection.StudyGroup;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Parameters {
    Long count;
    int num;
    int id;
    StudyGroup studyGroup;
    String filename;
}
