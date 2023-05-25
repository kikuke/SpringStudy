package com.kikuke.toy1.impl;

import com.kikuke.toy1.EnemyGenerator;
import com.kikuke.toy1.Launcher;
import com.kikuke.toy1.intObject.IntObject;
import com.kikuke.toy1.intObject.IntObjectService;
import com.kikuke.toy1.intPlayer.IntClass;
import com.kikuke.toy1.intPlayer.IntPlayer;
import com.kikuke.toy1.intPlayer.IntPlayerRepository;
import com.kikuke.toy1.intPlayer.IntPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DefaultLauncher implements Launcher {
	private final IntPlayerService intPlayerService;
	private final IntObjectService intObjectService;
	private final IntPlayerRepository intPlayerRepository;
	private final EnemyGenerator enemyGenerator;

	@Autowired
	public DefaultLauncher(IntPlayerService intPlayerService, IntObjectService intObjectService, IntPlayerRepository intPlayerRepository, EnemyGenerator enemyGenerator) {
		this.intPlayerService = intPlayerService;
		this.intObjectService = intObjectService;
		this.intPlayerRepository = intPlayerRepository;
		this.enemyGenerator = enemyGenerator;
	}

	@Override
	public void play() {
		boolean isPlay = true;
		long idCnt = 0;
		final float maxHp;
		Scanner scanner = new Scanner(System.in);

		IntPlayer player = createPlayer(idCnt++);
		if(player == null)
			return;
		maxHp = player.getIntObject().getHp();

		//Todo: playerService로직에 넣기
		intPlayerRepository.save(player);
		enemyGenerator.InitGenerator();
		while(isPlay) {
			//Todo: Repository 호출이 아닌 서비스로 만들어서 가져오기
			//	아래 두개 묶어서 restartPlayer()메서드로 전환하기
			player = intPlayerRepository.findById(0L);
			player.getIntObject().setHp(maxHp);
			System.out.println("###캐릭터 로딩 완료!###\n");
			System.out.println(player);
			System.out.println("###게임을 시작합니다!###\n");

			//Todo: 새로운 서비스를 만드는게 나음.
			idCnt = staging((int)idCnt, player.getIntObject());

			System.out.println("###캐릭터 사망!###\n");
			//Todo: 아래 두개 메서드를 deadPlayer()로 묶기
			player.setIntObject(null);
			player = null;
			System.out.println("###부활하시려면 true를 아니라면 false를 입력해주세요.###\n");
			isPlay = scanner.nextBoolean();
		}
	}

	private int staging(int stageNum, IntObject player) {
		IntObject enemy;

		while (!intObjectService.isDead(player)) {
			if(stageNum > enemyGenerator.getLastEnemyNum()) {
				System.out.println("###게임을 클리어했습니다!###");
				return stageNum;
			}
			System.out.printf("###Stage %d!###\n", stageNum);
			enemy = enemyGenerator.generateEnemyById((long)stageNum);

			actionRoutine(player, enemy);

			stageNum++;
		}

		return stageNum-1;
	}

	private void actionRoutine(IntObject player, IntObject enemy) {
		while (!intObjectService.isDead(enemy) && !intObjectService.isDead(player)) {

			try {
				action(player, enemy);
				if(!intObjectService.isDead(enemy)) {
					action(enemy, player);
				}
			} catch (Exception e) {}

			System.out.println("\n#################\n");
			System.out.println("현재 Player Status\n");
			System.out.println(player+"\n");
			System.out.println("현재 Enemy Status\n");
			System.out.println(enemy+"\n");
			System.out.println("\n#################\n");

			try {
				Thread.sleep(2000);
			} catch (Exception e) {}
		}
	}

	private void action(IntObject attack, IntObject defence) throws Exception {
		System.out.println("\n#################\n");

		System.out.printf("%s의 공격\n", attack.getName());

		float damage = intObjectService.attack(attack);
		boolean isAvoid = intObjectService.avoid(attack, defence);
		float defDam = intObjectService.deffence(attack, defence);
		float finalDam;

		System.out.printf("%.1f 피해의 공격!\n", damage);
		Thread.sleep(700);
		if(isAvoid || damage <= 0) {
			System.out.println("회피!");
			Thread.sleep(700);
			return;
		}

		System.out.printf("%s이(가) %.1f 만큼의 방어\n", defence.getName(), defDam);
		Thread.sleep(700);
		finalDam = damage - defDam;
		System.out.printf("%s의 최종 피해: %.1f\n", defence.getName(), finalDam);
		System.out.println("\n#################\n");
		Thread.sleep(700);

		if(finalDam > 0) {
			defence.setHp(defence.getHp() - finalDam);
		}
	}

	private IntPlayer createPlayer(Long id) {

		IntPlayer player = new IntPlayer();
		String name;
		int playerClass;

		Scanner scanner = new Scanner(System.in);
		System.out.println("###캐릭터 이름을 입력하세요.###");
		name = scanner.next();

		System.out.println("###직업을 선택하세요.###");
		for(IntClass intClass : IntClass.values()) {
			System.out.printf("%d. %s\n", intClass.ordinal(), intClass.name());
		}
		playerClass = scanner.nextInt();
		player.setIntClass(IntClass.values()[playerClass]);

		if(intPlayerService.initIntObject(player, id, name) == null) {
			System.out.println("###캐릭터 생성 실패!###");
			return null;
		}

		System.out.println("###캐릭터 생성 성공!###");
		System.out.println(player);
		return player;
	}

}
