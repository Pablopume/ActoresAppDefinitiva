package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository

class GetActorIdUseCase {
    operator fun invoke(id: Int) = Repository.getActorId(id)
}