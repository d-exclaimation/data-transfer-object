//
//  DTO.swift
//  data-transfer-object
//
//  Created by Vincent on 7/07/21.
//

import Foundation

///
/// Data Transfer Object
///
/// Allowing better JSON Responses that can be easily parsed
///
/// - `TData`  Data response type that conforms to JSON format.
/// - `TError` Error response type that conforms to JSON Format.
///
public struct DTO<TData: Codable, TError: Codable>: Codable {
    public let data: TData?
    public let errors: [TError]?

    /// Regular initialzers
    public init(data: TData?, errors: [TError]?) {
        self.data = data
        self.errors = errors
    }

    /// Ok DTO initialzers
    public init(ok: TData){
        data = ok
        errors = nil
    }

    /// Error DTO initialzers
    public init(error: [TError]) {
        data = nil
        errors = msg
    }

    /// JSON DTO parser
    public init?(json: Data?) {
        guard let json = json else {
            return nil
        }
        if let dto = try? JSONDecoder().decode(DTO<TData, TError>.self, from: json) {
            self = dto
        } else {
            return nil
        }
    }

    /// Enum state for better pattern matching
    public var state: DTOState<TData, TError> {
        if let data = self.data {
            return .succeed(data)
        }
        if let errors = self.errors {
            return .failed(errors)
        }
        return .empty
    }

    /// DTO State Enum for success, failure, or empty state
    public enum DTOState<TData, TError> {
        case empty
        case succeed(TData)
        case failed([TError])
    }
}
