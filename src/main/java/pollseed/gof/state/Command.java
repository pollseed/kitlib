package src.main.state;

public class Command implements JobState {

    private JobState jobState;

    public Command(JobState jobState) {
        this.jobState = jobState;
    }

    @Override
    public String attack() {
        return this.jobState.attack();
    }

    @Override
    public String deathblow() {
        return this.jobState.deathblow();
    }

}
