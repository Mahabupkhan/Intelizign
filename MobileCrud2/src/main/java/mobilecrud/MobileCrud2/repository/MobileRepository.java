package mobilecrud.MobileCrud2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilecrud.MobileCrud2.entity.Mobile;
@Repository
public interface MobileRepository extends JpaRepository<Mobile,Integer>{


}
