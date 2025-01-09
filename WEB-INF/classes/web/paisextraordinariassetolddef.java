package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisextraordinariassetolddef extends GXProcedure
{
   public paisextraordinariassetolddef( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinariassetolddef.class ), "" );
   }

   public paisextraordinariassetolddef( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             byte aP1 ,
                             String aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             String aP5 )
   {
      paisextraordinariassetolddef.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( String aP0 ,
                        byte aP1 ,
                        String aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        String aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( String aP0 ,
                             byte aP1 ,
                             String aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             String aP5 ,
                             String[] aP6 )
   {
      paisextraordinariassetolddef.this.AV12PaiHsPDiaTipTra = aP0;
      paisextraordinariassetolddef.this.AV13PaiHsPDiaDia = aP1;
      paisextraordinariassetolddef.this.AV16PaiHsPDiaDesde = aP2;
      paisextraordinariassetolddef.this.AV15PaiTarifaPDia = aP3;
      paisextraordinariassetolddef.this.AV14PaiTarifaPDRec = aP4;
      paisextraordinariassetolddef.this.AV17PaiTarifaPDCri = aP5;
      paisextraordinariassetolddef.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( AV12PaiHsPDiaTipTra );
      AV8PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( AV13PaiHsPDiaDia );
      AV8PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( AV16PaiHsPDiaDesde );
      AV8PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( AV15PaiTarifaPDia );
      AV8PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( AV14PaiTarifaPDRec );
      AV8PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( AV17PaiTarifaPDCri );
      AV11PaiExtraordOldDefault = AV8PaisExtraOrdinarias_old.toJSonString(false, true) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = paisextraordinariassetolddef.this.AV11PaiExtraordOldDefault;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11PaiExtraordOldDefault = "" ;
      AV8PaisExtraOrdinarias_old = new web.SdtPaisExtraOrdinarias_old(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13PaiHsPDiaDia ;
   private short Gx_err ;
   private java.math.BigDecimal AV15PaiTarifaPDia ;
   private java.math.BigDecimal AV14PaiTarifaPDRec ;
   private String AV12PaiHsPDiaTipTra ;
   private String AV16PaiHsPDiaDesde ;
   private String AV17PaiTarifaPDCri ;
   private String AV11PaiExtraordOldDefault ;
   private web.SdtPaisExtraOrdinarias_old AV8PaisExtraOrdinarias_old ;
   private String[] aP6 ;
}

