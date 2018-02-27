package br.com.erichhubner.notepadapi.service

import br.com.erichhubner.notepadapi.model.Nota
import br.com.erichhubner.notepadapi.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotaService{
    @Autowired
    lateinit var  notaRepository: NotaRepository

    fun salavar(nota: Nota){
        val aux  = notaRepository.findBytitulo(nota.titulo)
        if (aux != null){
            nota.id  = aux.id
        }
        notaRepository.save(nota)
    }

    fun buscarTodas(): List<Nota>{
        return notaRepository.findAll()
    }

    fun buscar(titulo: String) : Nota {
        return notaRepository.findBytitulo(titulo)
    }
}