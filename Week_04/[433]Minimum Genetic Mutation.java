import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class MinimunGeneMutation {

    class Gene {
        String geneStr;
        int step;

        Gene(String geneStr, int step) {
            this.geneStr = geneStr;
            this.step = step;
        }
    }

    final char[] GENE_CHARS = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null) return -1;

        Set<String> visited = new HashSet<String>();
        Set<String> bankSet = new HashSet<String>();
        for (String validString : bank) {
            bankSet.add(validString);
        }

        if(!bankSet.contains(end)) return -1;

        Queue<Gene> queue = new LinkedList<>();
        queue.add(new Gene(start, 0));
        while (!queue.isEmpty()) {
            Gene currGene = queue.poll();
            if (currGene.geneStr.equals(end)) {
                return currGene.step;
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < GENE_CHARS.length; j++) {
                    String newGene = currGene.geneStr.substring(0, i) + GENE_CHARS[j] + currGene.geneStr.substring(i + 1);
                    if (newGene.equals(end)) {
                        return currGene.step + 1;
                    }
                    if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                        visited.add(newGene);
                        queue.offer(new Gene(newGene, currGene.step + 1));
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MinimunGeneMutation minimunGeneMutation = new MinimunGeneMutation();
        String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int i = minimunGeneMutation.minMutation("AACCGGTT", "AAACGGTA", bank);
        System.out.println(i);
    }
}