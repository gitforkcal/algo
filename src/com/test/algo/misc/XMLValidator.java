package com.test.algo.misc;

/**
 * @author Rahul
 */
public class XMLValidator {

    // only the sudo code.
    // assumptions:
    // 1. all tags and data in new line.

    /*
    <Tag1>
    <Tag2>
    <Name>
    name
    </Name>
    </Tag2>
    </Tag1>
    */

    /**
     *  StreamTokenizer tokenizer = new StreamTokenizer();
     *  Stack tags = new Stack();
     *
     *  while(tokenizer.hasMoreTokens()) {
     *     Token token = tokenizer.nextToken();
     *     if(token.isStartTag()) {
     *        tags.push(token.getTag());
     *     }
     *     if(token.isEngTag()){
     *        Token current = stack.pop();
     *        if(!current.getTag().equals(token.getTag())) {
     *            throw new XmlWellFormnessException();
     *        }
     *     }
     * }
     *
     **/

}
