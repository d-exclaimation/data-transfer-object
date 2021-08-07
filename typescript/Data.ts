//
//  DTO.ts
//  data-transfer-object
//
//  Created by d-exclaimation on 16:35.
//

export type DTO<TData, TError> =
  | { data: TData; errors: null }
  | { data: null; errors: TError[] };
