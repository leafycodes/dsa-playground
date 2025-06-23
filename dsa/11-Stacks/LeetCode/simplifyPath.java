class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : folders) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!(str.equals(".") || str.equals(""))) {
                stack.push(str);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        return res.toString().equals("") ? "/" : res.toString();
    }
}