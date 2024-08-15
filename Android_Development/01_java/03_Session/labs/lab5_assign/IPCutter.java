import java.util.StringTokenizer;

class IPCutter {
    String IP;

    IPCutter(String ip) {
        IP = ip;
    }

    public void cutWithSubstring() {
        int index1 = IP.indexOf(".");
        int index2 = IP.indexOf(".", index1 + 1);
        int index3 = IP.indexOf(".", index2 + 1);

        System.out.println(IP.substring(0, index1));
        System.out.println(IP.substring(index1 + 1, index2));
        System.out.println(IP.substring(index2 + 1, index3));
        System.out.println(IP.substring(index3 + 1));
    }

    public void cutWithSplit() {
        String[] parts = IP.split("[.]");
        for (String part : parts) {
            System.out.println(part);
        }
    }

    public void cutWithStringTokenizer() {
        StringTokenizer tokenizer = new StringTokenizer(IP, ".");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}

class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java IPCutter <IP address>");
            return;
        }

        IPCutter cutter = new IPCutter(args[0]);
        System.out.println("Using substring and indexOf:");
        cutter.cutWithSubstring();
        
        System.out.println("\nUsing split:");
        cutter.cutWithSplit();
        
        System.out.println("\nUsing StringTokenizer:");
        cutter.cutWithStringTokenizer();
    }
}
