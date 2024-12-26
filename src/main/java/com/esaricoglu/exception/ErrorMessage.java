package com.esaricoglu.exception;

public class ErrorMessage {

    private MessageType messageType;

    private String ofStatic;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();

        builder.append(messageType.getMessage());
        if (ofStatic != null) {
            builder.append(" : " + ofStatic);
        }

        return builder.toString();
    }

    public ErrorMessage(){}

    public ErrorMessage(MessageType messageType, String ofStatic) {
        this.messageType = messageType;
        this.ofStatic = ofStatic;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getOfStatic() {
        return ofStatic;
    }

    public void setOfStatic(String ofStatic) {
        this.ofStatic = ofStatic;
    }
}
