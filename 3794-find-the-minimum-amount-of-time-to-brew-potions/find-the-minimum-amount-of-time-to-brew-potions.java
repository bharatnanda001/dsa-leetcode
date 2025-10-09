import java.util.Arrays;

class Solution {
    public long minTime(int[] skill, int[] mana) {
        long sumSkill = Arrays.stream(skill).sum();         
        long prevWizardDone = sumSkill * (long) mana[0];   

        for (int j = 1; j < mana.length; ++j) {
            long prevPotionDone = prevWizardDone;
            for (int i = skill.length - 2; i >= 0; --i) {
               
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];

                
                prevWizardDone = Math.max(prevPotionDone,
                                          prevWizardDone - (long) skill[i] * mana[j]);
            }
           
            prevWizardDone += sumSkill * (long) mana[j];
        }

        return prevWizardDone;
    }
}

