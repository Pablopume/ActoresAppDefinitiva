package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository

class DeleteActorUseCase {
    operator fun invoke (id: Int) = Repository.deleteActores(id)
}