package com.kingofraccoon.proforientation

import androidx.lifecycle.MutableLiveData

object AllTests {
    val mutableListTests = mutableListOf(
        Test("Работа, связанная с учетом и контролем, –это довольно скучно."),
        Test("Я предпочту заниматься финансовыми операциями, а не, например, музыкой."),
        Test("Невозможно точно рассчитать, сколько времени уйдет на дорогу до работы, по крайней мере, мне."),
        Test("Я часто рискую."),
        Test("Меня раздражает беспорядок."),
        Test("Я охотно почитал(а) бы на досуге о последних достижениях в различных областях науки."),
        Test("Записи, которые я делаю, не очень хорошо структурированы и организованы."),
        Test("Я предпочитаю разумно распределять деньги, а не тратить все сразу."),
        Test("У  меня  наблюдается,  скорее,  рабочий  беспорядок  на  столе,  чем  расположение  вещей  по  аккуратным «стопочкам»."),
        Test("Меня привлекает работа, где необходимо действовать согласно инструкции или четко заданному алгоритму."),
        Test("Если бы я что-то собирал(а), я бы постарался(ась) привести в порядок коллекцию, все разложить по папочкам и полочкам."),
        Test("Терпеть не могу наводить порядок и систематизировать что бы то ни было."),
        Test("Мне нравится работать на компьютере –оформлять или просто набирать тексты, производить расчеты."),
        Test("Прежде чем действовать, надо продумать все детали."),
        Test("На мой взгляд, графики и таблицы – очень удобный и информативный способ предоставления информации."),
        Test("Мне нравятся игры, в которых я могу точно рассчитать шансы на успех и сделать осторожный, но точный ход."),
        Test("При изучении иностранного языка я предпочитаю начинать с грамматики, а не получать разговорный опыт без знания грамматических основ."),
        Test("Сталкиваясь с какой-либо проблемой, я пытаюсь всесторонне ее изучить (ознакомиться с соответствующей литературой, поискать нужную информацию в интернете, поговорить со специалистами)."),
        Test("Если я выражаю свои мысли на бумаге, мне важнее..."),
        Test("У меня есть ежедневник, в который я записываю важную информацию на несколько дней вперед."),
        Test("Я с удовольствием смотрю новости политики и экономики."),
        Test("Я бы хотел(а), чтобы моя будущая профессия..."),
        Test("Я доделываю работу в последний момент."),
        Test("Взяв книгу, я всегда ставлю ее на место."),
        Test("Когда я ложусь спать, то уже наверняка знаю, что буду делать завтра."),
        Test("В своих словах и поступках я следую пословице «Семь раз отмерь, один –отрежь»."),
        Test("Перед ответственными делами я всегда составляю план их выполнения."),
        Test("После вечеринки мытье посуды я откладываю до утра."),
        Test("Я серьезно отношусь к своему здоровью."),
        Test("Когда у меня что-то не получается, я...")
        )

    var next = false
    var mutableLiveData = MutableLiveData<Boolean>().apply { value = next }

    fun setValueBool(boolean: Boolean){
        next = boolean
        mutableLiveData.value = boolean
    }
}