package ModelJSON;

import NodeJSON.NodeJSONSewa;

import java.io.File;

public class ModelJSONAdmin {
    public String userf;
    NodeJSONSewa nodeJSONSewa = new NodeJSONSewa(userf, userf, userf, 0, userf);

    public ModelJSONAdmin() {
        // Sesuaikan path file dengan format yang benar
        this.userf = "src/Database/admin.json";
    }

    public boolean cekFile() {
        boolean cek = false;
        File file = new File(this.userf);
        if (file.exists()) {
            cek = true;
        }
        return cek;
    }
}
