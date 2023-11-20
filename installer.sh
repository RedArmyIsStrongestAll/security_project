# Проверка наличия Docker и docker-compose на системе
if ! command -v docker &> /dev/null; then
    echo "Ошибка: Docker не установлен. Установите Docker перед запуском приложения."
    exit 1
fi
if ! command -v docker-compose &> /dev/null; then
    echo "Ошибка: Docker Compose не установлен. Установите Docker Compose перед запуском приложения."
    exit 1
fi





DOCKER_CONTAINER_BK="bk_container"
DOCKER_CONTAINER_BD="bd_container"
DOCKER_CONTAINER_FRONT="front_container"
DOCKER_IMAGE_BK="bk_container_image"
DOCKER_IMAGE_BD="bd_container_image"
DOCKER_IMAGE_FRONT="front_container_image"

# Функция для проверки существования контейнера
container_exists() {
    local container_name="$1"
    docker ps -a --format '{{.Names}}' | grep -Eq "^$container_name$"
}

# Функция для проверки существования образа
image_exists() {
    local image_name="$1"
    docker image inspect "$image_name" &> /dev/null
}






# Перезапуск контейнера бд
if container_exists "$DOCKER_CONTAINER_BK"; then
    echo "Перезапуск Docker-контейнера бд..."
    if ! image_exists "$DOCKER_IMAGE_BK"; then
        echo "Сборка Docker-образа бд..."
        docker-compose build
    fi
fi

# Перезапуск контейнера бека
if container_exists "$DOCKER_CONTAINER_BD"; then
    echo "Перезапуск Docker-контейнера бека..."
    if ! image_exists "$DOCKER_IMAGE_BD"; then
        echo "Сборка Docker-образа бека..."
        docker-compose build
    fi
fi

# Перезапуск контейнера фронта
if container_exists "$DOCKER_CONTAINER_FRONT"; then
    echo "Перезапуск Docker-контейнера фронта..."
    if ! image_exists "$DOCKER_IMAGE_FRONT"; then
        echo "Сборка Docker-образа фронта..."
        docker-compose build
    fi
fi


# Запуск контейнеров
yes | docker-compose up -d
echo "Приложение успешно запущено."