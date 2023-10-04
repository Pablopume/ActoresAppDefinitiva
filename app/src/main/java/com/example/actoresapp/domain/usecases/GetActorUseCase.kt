package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository

class GetActorUseCase {
    operator fun invoke() = Repository.getActores()
}