package bandeau;

import java.util.List;

public class MonThread extends Thread {
    private Bandeau b;
    private List<ScenarioElement> Elements;

    public MonThread(Bandeau b, List<ScenarioElement> Elements){
        this.b = b;
        this.Elements = Elements;
    }

    @Override
    public void run() {
        synchronized(b) {
        for (ScenarioElement element : Elements){
            for (int repeats = 0; repeats < element.repeats; repeats++){
                element.effect.playOn(b);
            }
        }

    }

}}