package com.chess.customexception;

public class InvalidPieceException extends RuntimeException {

	public InvalidPieceException(String message) {
		super(message);
	}
}
