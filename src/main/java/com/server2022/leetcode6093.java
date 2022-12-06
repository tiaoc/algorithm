package com.server2022;

public class leetcode6093 {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        int param_2 = textEditor.deleteText(4);
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
    }

    private static class TextEditor {
        int cursor;
        StringBuilder sb;

        public TextEditor() {
            cursor = 0;
            sb = new StringBuilder();
        }

        public void addText(String text) {
            sb.insert(cursor, text);
            cursor += text.length();
        }

        public int deleteText(int k) {
            int v = Math.max(0, cursor - k);
            sb.delete(v, cursor);
            int ret = cursor - v;
            cursor = v;
            return ret;
        }

        public String cursorLeft(int k) {
            cursor = Math.max(0, cursor - k);
            return sb.substring(Math.max(cursor - 10, 0), cursor);
        }

        public String cursorRight(int k) {
            cursor = Math.min(cursor + k, sb.length());
            return sb.substring(Math.max(cursor - 10, 0), cursor);
        }
    }
    /**
     * Your TextEditor object will be instantiated and called as such:
     * TextEditor obj = new TextEditor();
     * obj.addText(text);
     * int param_2 = obj.deleteText(k);
     * String param_3 = obj.cursorLeft(k);
     * String param_4 = obj.cursorRight(k);
     */
}
