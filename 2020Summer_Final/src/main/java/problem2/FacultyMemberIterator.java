package problem2;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyMemberIterator implements Iterator {

  private List<FacultyMember> tenuredFacultyMembers;
  private static final String MAIN_APPOINTMENT = "College of Computer Sciences";
  private static final Integer MIN_ADJUNCT_APPOINTMENT = 2;

  public FacultyMemberIterator(List<FacultyMember> facultyMembers) {
    this.tenuredFacultyMembers = this.getTenuredFacultyMembers(facultyMembers);
  }

  private List<FacultyMember> getTenuredFacultyMembers(List<FacultyMember> facultyMembers){
    return facultyMembers.stream()
        .filter(x -> x.getTenured() && x.getMainUniversityUnit().equals(MAIN_APPOINTMENT) && x.getAdjunctAppointments().size() >= MIN_ADJUNCT_APPOINTMENT)
        .collect(Collectors.toList());
  }

  @Override
  public boolean hasNext() {
    return tenuredFacultyMembers.size() > 0;
  }

  @Override
  public Object next() {
    return tenuredFacultyMembers.remove(0);
  }
}
