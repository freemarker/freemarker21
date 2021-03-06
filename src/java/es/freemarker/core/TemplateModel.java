/*
 * Copyright (c) 2020, Jonathan Revusky revusky@freemarker.es
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and  the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package es.freemarker.core;

public interface TemplateModel {    
//    TemplateModel NOTHING = GeneralPurposeNothing.getInstance();

    /**
     * A singleton value used to represent a java null
     * which comes from a wrapped Java API, for example, i.e.
     * is intentional. A null that comes from a generic container
     * like a map is assumed to be unintentional and a 
     * result of programming error.
     */
    TemplateModel JAVA_NULL = new JavaNull();
    
    /**
     * A singleton value used to represent the result of an 
     * invalid expression, such as 1 - "3"
     */
    
    TemplateModel INVALID_EXPRESSION = new InvalidExpressionModel();
    
    /**
     * The type of the {@link TemplateModel#JAVA_NULL} object. Using a named 
     * class instead of an anonymous one, as it is easier to figure out what's 
     * wrong from an error message when the reported class name is 
     * "TemplateModel$JavaNull" than when it is "TemplateModel$1", also 
     */
    static class JavaNull implements TemplateModel {
        JavaNull() {}
        
        private Object readResolve() {
            return JAVA_NULL;
        }
    };
    
    static class InvalidExpressionModel implements TemplateModel {
    	InvalidExpressionModel() {}
    }
}