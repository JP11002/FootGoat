package org.footgoat.player;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Page<Player> getPlayers(int page, int size) {
        return playerRepository.findAll(PageRequest.of(page,size));
    }

    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow();
    }
}
