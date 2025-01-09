package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paistipotrabajosetolddef extends GXProcedure
{
   public paistipotrabajosetolddef( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajosetolddef.class ), "" );
   }

   public paistipotrabajosetolddef( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.math.BigDecimal aP0 ,
                             java.math.BigDecimal aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 )
   {
      paistipotrabajosetolddef.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        java.math.BigDecimal aP1 ,
                        java.math.BigDecimal aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             java.math.BigDecimal aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             String[] aP8 )
   {
      paistipotrabajosetolddef.this.AV11PaiTipoHsDia = aP0;
      paistipotrabajosetolddef.this.AV12PaiTipoHsSem = aP1;
      paistipotrabajosetolddef.this.AV13PaiTipoTarifaXLim = aP2;
      paistipotrabajosetolddef.this.AV14PaiTipoTarifaRec = aP3;
      paistipotrabajosetolddef.this.AV15PaiTipoHsMaxDia = aP4;
      paistipotrabajosetolddef.this.AV18PaiTipoHsMaxSem = aP5;
      paistipotrabajosetolddef.this.AV16PaiTipoHsMaxMes = aP6;
      paistipotrabajosetolddef.this.AV17PaiTipoHsMaxAnu = aP7;
      paistipotrabajosetolddef.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia( AV11PaiTipoHsDia );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohssem( AV12PaiTipoHsSem );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim( AV13PaiTipoTarifaXLim );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec( AV14PaiTipoTarifaRec );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia( AV15PaiTipoHsMaxDia );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem( AV18PaiTipoHsMaxSem );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes( AV16PaiTipoHsMaxMes );
      AV8PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu( AV17PaiTipoHsMaxAnu );
      AV19PaiTipoTraOldDefault = AV8PaisTipoTrabajo_old.toJSonString(false, true) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = paistipotrabajosetolddef.this.AV19PaiTipoTraOldDefault;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19PaiTipoTraOldDefault = "" ;
      AV8PaisTipoTrabajo_old = new web.SdtPaisTipoTrabajo_old(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV11PaiTipoHsDia ;
   private java.math.BigDecimal AV12PaiTipoHsSem ;
   private java.math.BigDecimal AV13PaiTipoTarifaXLim ;
   private java.math.BigDecimal AV14PaiTipoTarifaRec ;
   private java.math.BigDecimal AV15PaiTipoHsMaxDia ;
   private java.math.BigDecimal AV18PaiTipoHsMaxSem ;
   private java.math.BigDecimal AV16PaiTipoHsMaxMes ;
   private java.math.BigDecimal AV17PaiTipoHsMaxAnu ;
   private String AV19PaiTipoTraOldDefault ;
   private web.SdtPaisTipoTrabajo_old AV8PaisTipoTrabajo_old ;
   private String[] aP8 ;
}

