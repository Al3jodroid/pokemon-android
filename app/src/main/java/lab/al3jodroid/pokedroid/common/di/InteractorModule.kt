package lab.al3jodroid.pokedroid.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lab.al3jodroid.pokedroid.interactor.PokemonInteractor
import lab.al3jodroid.pokedroid.interactor.PokemonUseCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class InteractorModule {
    @Provides
    @Singleton
    fun providesPokemonUseCase(): PokemonUseCase {
        return PokemonInteractor()
    }
}