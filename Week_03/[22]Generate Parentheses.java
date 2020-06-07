import java.util.ArrayList;
import java.util.List;

class GenerateParentheses{
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();

        _generate(0, 0, n, "", ret);

        return ret;
    }

    private void _generate(int opened, int closed, int max, String currString, List<String> list){
        System.out.println(opened + " " + closed + " " + currString);

        if(opened == max && closed == max){
            list.add(currString);
            return;
        }

        if(opened < max) {
            _generate(opened+1, closed, max, currString + "(", list);
        }
        if(closed < opened) {
            _generate(opened, closed+1, max, currString + ")", list);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
    }
}