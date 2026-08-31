class Solution {
    public int calPoints(String[] operations) 
    {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++)
        {
            if(operations[i].equals("+"))
            {
                int top1 = stack.peek(); 
                stack.pop();
                int top2 = stack.peek();
                stack.push(top1);
                stack.push(top1 + top2);
            }
            else if(operations[i].equals("D"))
            {
                stack.push(stack.peek() * 2);
            }
            else if(operations[i].equals("C"))
            {
                stack.pop();
            }
            else
            {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        while(!stack.isEmpty())
        {
            sum += stack.peek();
            stack.pop();
        }
        return sum;
    }
}