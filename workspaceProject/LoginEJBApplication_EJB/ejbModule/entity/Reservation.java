package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name="reservation")
@NamedQueries({
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r"),
@NamedQuery(name="Reservation.checknbrSeat", query="SELECT SUM(a.nbrSeat) FROM Reservation a where a.idArtiste=:idArtiste and a.idSeat=:idSeat and a.userName=:userName")
})
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private int idReservation;
	@Column (name="gain")
	private double gain;

	@Column(name="id_artiste")
	private String idArtiste;

	@Column(name="id_seat")
	private String idSeat;

	@Column(name="nbr_seat")
	private int nbrSeat;
	
	@Column(name="seatCat")
	private String seatCat;

	@Column(name="user_name")
	private String userName;

	public Reservation() {
	}

	public int getIdReservation() {
		return this.idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public double getGain() {
		return this.gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

	public String getIdArtiste() {
		return this.idArtiste;
	}

	public void setIdArtiste(String idArtiste) {
		this.idArtiste = idArtiste;
	}

	public String getIdSeat() {
		return this.idSeat;
	}

	public void setIdSeat(String idSeat) {
		this.idSeat = idSeat;
	}

	public int getNbrSeat() {
		return this.nbrSeat;
	}

	public void setNbrSeat(int nbrSeat) {
		this.nbrSeat = nbrSeat;
	}

	public String getSeatCat() {
		return this.seatCat;
	}

	public void setSeatCat(String seatCat) {
		this.seatCat = seatCat;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}