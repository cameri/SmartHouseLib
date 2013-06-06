package smarthouselib;

/**
 * @author cameri
 * @since 6/5/13
 */
public interface IDimmable {
    void setMinimumBrightness(int minBrightness);
    int getMinimumBrightness();
    void setMaximumBrightness(int maxBrightness);
    int getMaximumBrightness();
    void setBrightness(int brightness);
    int getBrightness();
    void decreaseBrightness(int step);
    void increaseBrightness(int step);
}
