package design_pattern;

public class TemplateDemo {
    public static void main(String[] args) {
        Material imageMaterial = new ImageMaterial();
        imageMaterial.insert();
        imageMaterial.insert();
        imageMaterial.push();
        System.out.println();
        Material videoMaterial = new VideoMaterial();
        videoMaterial.insert();
    }
}

interface Material {
    boolean insert();
    boolean inspect();
    boolean push();
}

class ImageMaterial implements Material {

    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public boolean inspect() {
        return false;
    }

    @Override
    public boolean push() {
        return false;
    }
}

class VideoMaterial implements Material {

    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public boolean inspect() {
        return false;
    }

    @Override
    public boolean push() {
        return false;
    }
}
