package app;

import java.text.DecimalFormat;
import java.util.Map;

class calculator
{
    private double CGPA;
    private double totalCredit;
    private String[] theoryGrades;
    private String[] labGrades;
    private Map<String, Object> gradeSheet = new gradeList().load();

    calculator(String x, String y, boolean xCheck, boolean yCheck)
    {
        this.theoryGrades = x.toUpperCase().split("\\s*,\\s*");
        this.labGrades = y.toUpperCase().split("\\s*,\\s*");

        if(xCheck) {
            this.totalCredit +=
                    this.theoryGrades.length * (double) this.gradeSheet.get("Sub");
            for (String grade : this.theoryGrades)
                this.CGPA +=
                        (double) this.gradeSheet.get(grade) * (double) this.gradeSheet.get("Sub");
        }

        if(yCheck) {
            this.totalCredit +=
                    this.labGrades.length * (double) this.gradeSheet.get("Lab");
            for (String grade : this.labGrades)
                this.CGPA +=
                        (double) this.gradeSheet.get(grade) * (double) this.gradeSheet.get("Lab");
        }

        this.CGPA /= this.totalCredit;
    }

    double getCGPA() {
        return Double.parseDouble(new DecimalFormat("#.##").format(this.CGPA));
    }


}
