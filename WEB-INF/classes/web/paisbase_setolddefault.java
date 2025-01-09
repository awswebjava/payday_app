package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisbase_setolddefault extends GXProcedure
{
   public paisbase_setolddefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisbase_setolddefault.class ), "" );
   }

   public paisbase_setolddefault( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.math.BigDecimal aP0 ,
                             short aP1 ,
                             byte aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             short aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             short aP11 ,
                             short aP12 ,
                             String aP13 )
   {
      paisbase_setolddefault.this.aP14 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        short aP1 ,
                        byte aP2 ,
                        byte aP3 ,
                        short aP4 ,
                        short aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        boolean aP10 ,
                        short aP11 ,
                        short aP12 ,
                        String aP13 ,
                        String[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             short aP1 ,
                             byte aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             short aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             short aP11 ,
                             short aP12 ,
                             String aP13 ,
                             String[] aP14 )
   {
      paisbase_setolddefault.this.AV15PaiBasePlus = aP0;
      paisbase_setolddefault.this.AV28PaiLicDLim = aP1;
      paisbase_setolddefault.this.AV27PaiLicDSeman = aP2;
      paisbase_setolddefault.this.AV26PaiLicDMes = aP3;
      paisbase_setolddefault.this.AV25PaiLicDSemes = aP4;
      paisbase_setolddefault.this.AV24PaiLicDAnual = aP5;
      paisbase_setolddefault.this.AV23PaiLicAdju = aP6;
      paisbase_setolddefault.this.AV22PaiLicAdjuObl = aP7;
      paisbase_setolddefault.this.AV21PaiLicNecAut = aP8;
      paisbase_setolddefault.this.AV16PaiLicIngMot = aP9;
      paisbase_setolddefault.this.AV20PaiLicMotObl = aP10;
      paisbase_setolddefault.this.AV19PaiBasePromCnt1 = aP11;
      paisbase_setolddefault.this.AV17PaiBasePromCnt2 = aP12;
      paisbase_setolddefault.this.AV18PaiBasePromTCnt = aP13;
      paisbase_setolddefault.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Paibaseplus( AV15PaiBasePlus );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdlim( AV28PaiLicDLim );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdseman( AV27PaiLicDSeman );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdmes( AV26PaiLicDMes );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdsemes( AV25PaiLicDSemes );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdanual( AV24PaiLicDAnual );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicadju( AV23PaiLicAdju );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicadjuobl( AV22PaiLicAdjuObl );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicnecaut( AV21PaiLicNecAut );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicingmot( AV16PaiLicIngMot );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Pailicmotobl( AV20PaiLicMotObl );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Paibasepromcnt1( AV19PaiBasePromCnt1 );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Paibasepromcnt2( AV17PaiBasePromCnt2 );
      AV8Paisbase_old.setgxTv_SdtPaisbase_old_Paibasepromtcnt( AV18PaiBasePromTCnt );
      AV14PaiBaseOldDefault = AV8Paisbase_old.toJSonString(false, true) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP14[0] = paisbase_setolddefault.this.AV14PaiBaseOldDefault;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14PaiBaseOldDefault = "" ;
      AV8Paisbase_old = new web.SdtPaisbase_old(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV27PaiLicDSeman ;
   private byte AV26PaiLicDMes ;
   private short AV28PaiLicDLim ;
   private short AV25PaiLicDSemes ;
   private short AV24PaiLicDAnual ;
   private short AV19PaiBasePromCnt1 ;
   private short AV17PaiBasePromCnt2 ;
   private short Gx_err ;
   private java.math.BigDecimal AV15PaiBasePlus ;
   private String AV18PaiBasePromTCnt ;
   private boolean AV23PaiLicAdju ;
   private boolean AV22PaiLicAdjuObl ;
   private boolean AV21PaiLicNecAut ;
   private boolean AV16PaiLicIngMot ;
   private boolean AV20PaiLicMotObl ;
   private String AV14PaiBaseOldDefault ;
   private web.SdtPaisbase_old AV8Paisbase_old ;
   private String[] aP14 ;
}

