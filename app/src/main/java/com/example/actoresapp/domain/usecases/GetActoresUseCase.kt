package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository

class GetActoresUseCase {
    operator fun invoke() = Repository.getActores()
}