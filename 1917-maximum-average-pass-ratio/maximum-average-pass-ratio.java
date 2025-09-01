class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double averageSum = 0;
        PriorityQueue<StudentClass> sortedClasses = new PriorityQueue<>(Comparator.comparingDouble(StudentClass::getAverageBoost).reversed());
        for (int[] aClass : classes) {
            averageSum += ((double)aClass[0] / aClass[1]);
            if (aClass[0] != aClass[1]) {
                sortedClasses.add(new StudentClass(aClass[0], aClass[1]));
            }
        }
        StudentClass polled;
        if (!sortedClasses.isEmpty()) {
            while (extraStudents > 0) {
                polled = sortedClasses.poll();
                averageSum -= polled.currentAverage;
                averageSum += polled.proposedAverage;
                sortedClasses.add(new StudentClass(++polled.pass, ++polled.total));
                extraStudents--;
            }
        }
        return averageSum / classes.length;
    }

    private static class StudentClass {
        int pass;
        int total;
        double currentAverage;
        double proposedAverage;

        public StudentClass(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.currentAverage = (double)pass / total;
            this.proposedAverage = (double)(pass + 1) / (total + 1);
        }

        public double getAverageBoost() {
            return this.proposedAverage - this.currentAverage;
        }
    }
}